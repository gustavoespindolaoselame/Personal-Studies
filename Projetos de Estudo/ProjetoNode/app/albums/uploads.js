const connection = require('../conn')

async function saveAlbum(artFile, artistId = [], songId = [], name, description) {
    try {
        await connection.promise().execute(
            "INSERT INTO albumArts (art) VALUES (?)",
            [artFile]
        );

        const [albumResult] = await connection.promise().execute(
            "INSERT INTO album (name, descrip) VALUES (?, ?)",
            [name, description]
        );

        const albumId = albumResult.insertId;
        const artistIds = Array.isArray(artistId) ? artistId : artistId.split(',');
        const songIds = Array.isArray(songId) ? songId : songId.split(',');

        artistIds.forEach(id => {
            connection.promise().execute(
                "INSERT IGNORE INTO albumArtistRelationship (albumId, artistId) VALUES (?, ?)",
                [id, albumId]
            );
        });
        
        songIds.forEach(id => {
            connection.promise().execute(
                "INSERT IGNORE INTO albumSongRelationship (albumId, songId) VALUES (?, ?)",
                [id, albumId]
            );
        });

        console.log('Album saving was successful!');
    } catch (err) {
        throw(err)
    }
}
module.exports = (req) => {
    const { artistId, songId, name, description } = req.body;
    console.log(req.body);
    const artFile = req.files['albumArt']?.[0];
    saveAlbum(artFile.buffer, artistId, songId, name, description);
}
