
const mysql = require("mysql2");
const fs = require("fs");
const connection = require('./conn')


// const filePath = "/home/gustavo/Downloads/teste.mp3";
function saveSong(filePath){
    const fileData = fs.readFileSync(filePath);

    const query = "INSERT INTO registry (song) VALUES (?)";

    connection.query(query, [fileData], (err, results) => {
        if (err) throw err;
        console.log("MP3 file stored successfully!", results);
        connection.end();
    });
}

module.exports = saveSong;