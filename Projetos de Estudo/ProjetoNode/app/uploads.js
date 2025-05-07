const connection = require('./conn')

async function saveSong(songFile, artFile, artistId = [], albumId = [], name, description) {
    try {
        await connection.promise().execute(
            "INSERT INTO songStreams (song) VALUES (?)",
            [songFile]
        );

        await connection.promise().execute(
            "INSERT INTO songArts (art) VALUES (?)",
            [artFile]
        );

        const [songResult] = await connection.promise().execute(
            "INSERT INTO song (name, descrip) VALUES (?, ?)",
            [name, description]
        );

        const songId = songResult.insertId;
        const artistIds = Array.isArray(artistId) ? artistId : artistId.split(',');
        const albumIds = Array.isArray(albumId) ? albumId : albumId.split(',');

        artistIds.forEach(id => {
            connection.promise().execute(
                "INSERT IGNORE INTO artistSongRelationship (artistId, songId) VALUES (?, ?)",
                [id, songId]
            );
        });
        
        albumIds.forEach(id => {
            connection.promise().execute(
                "INSERT IGNORE INTO albumSongRelationship (albumId, songId) VALUES (?, ?)",
                [id, songId]
            );
        });

        console.log('Song saving was successful!');
    } catch (err) {
        throw(err)
    }
}

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
module.exports = {

    uploadSong:{
    bySong: (req) => {
    const { artistId, albumId, name, description } = req.body;
    const songFile = req.files['song']?.[0];
    const artFile = req.files['songArt']?.[0];
    saveSong(songFile.buffer, artFile.buffer, artistId, albumId, name, description);}},

    uploadAlbum:{
    bySong: (req) => {
    const { artistId, songId, name, description } = req.body;
    console.log(req.body);
    const artFile = req.files['albumArt']?.[0];
    saveAlbum(artFile.buffer, artistId, songId, name, description);}}}