const express = require("express");
const multer = require("multer");
const upload = multer();
const app = express();
const connection = require('./conn')

async function saveSong(buffer, artistId, albumId, name, description) {
    try {
        await connection.promise.execute(
            "INSERT INTO songStreams (song) VALUES (?)",
            [buffer]
        );

        await connection.promise.execute(
            "INSERT INTO songDetails (artistId, albumId, name, descrip) VALUES (?, ?, ?, ?)",
            [artistId, albumId, name, description]
        );
    } catch (err) {
        throw new Error("Erro ao salvar no banco: " + err.message);
    }
}

app.post("/song", upload.single("song"), (req, res) => {
    const songBuffer = req.file.buffer;
    const { artistId, albumId, name, description } = req.body;

    saveSong(songBuffer, artistId, albumId, name, description);
    res.json({ success: true });
});
