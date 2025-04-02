
const mysql = require("mysql2");
const fs = require("fs");
const connection = require('./conn')


// const filePath = "/home/gustavo/Downloads/teste.mp3";
function saveSong(filePath = "no song linked", artistId = 0, albumId = 0, name = "No name defined", description = "No description defined"){
    const fileData = fs.readFileSync(filePath);
    const query = "INSERT INTO songStreams (song) VALUES (?); insert into songDetails (artistId, albumId, name, descrip) values (?,?,?,?);";
    connection.query(query, [fileData, artistId, albumId, name, description]);
}

module.exports = saveSong;