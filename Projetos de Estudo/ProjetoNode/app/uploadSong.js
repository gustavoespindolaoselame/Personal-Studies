const connection = require('./conn')

async function saveSong(songFile, artFile, artistId = [], albumId, name, description) {
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
                "INSERT INTO artistSongRelationship (artistId, songId) VALUES (?, ?)",
                [id, songId]
            );
        });
        
        albumIds.forEach(id => {
            connection.promise().execute(
                "INSERT INTO albumSongRelationship (albumId, songId) VALUES (?, ?)",
                [id, songId]
            );
        });

        console.log('✅ Song saving was successful!');
    } catch (err) {
        throw(err)
    }
}

const uploadSong = {bySong: (req) => {
    const { artistId, albumId, name, description } = req.body;
    const songFile = req.files['song']?.[0];
    const artFile = req.files['songArt']?.[0];
    saveSong(songFile.buffer, artFile.buffer, artistId, albumId, name, description);
}};

module.exports = uploadSong;