const connection = require('./conn')

async function saveSong(songFile, artFile, artistId, albumId, name, description) {
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

        await connection.promise().execute(
            "INSERT INTO artistSongRelationship (artistId, songId) VALUES (?, ?)",
            [artistId, songId]
        );

        await connection.promise().execute(
            "INSERT INTO albumSongRelationship (albumId, songId) VALUES (?, ?)",
            [albumId, songId]
        );

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