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

        await connection.promise().execute(
            "INSERT INTO songDetails (artistId, albumId, name, descrip) VALUES (?, ?, ?, ?)",
            [artistId, albumId, name, description]
        );
        console.log('Song Saving was Successful!!!!!!')
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