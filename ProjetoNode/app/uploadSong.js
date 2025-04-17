const connection = require('./conn')

async function saveSong(buffer, artistId, albumId, name, description) {
    console.log({
        buffer:buffer,
        artistId:artistId,
        albumId:albumId,
        name:name,
        description:description
    })
    try {
        connection.execute(
            "INSERT INTO songStreams (song) VALUES (?)",
            [buffer]
        );

        connection.execute(
            "INSERT INTO songDetails (artistId, albumId, name, descrip) VALUES (?, ?, ?, ?)",
            [artistId, albumId, name, description]
        );
    } catch (err) {
        throw(err)
    }
}

const uploadSong = {bySong: (req) => {
    const { artistId, albumId, name, description } = req.body;
    const songBuffer = req.file.buffer;
    saveSong(songBuffer, artistId, albumId, name, description);
}};

module.exports = uploadSong;