const connection = require('../conn')

const fetchSong = {
    tableForLogging:async function(){
        const returnClass = {
            song:await connection.promise().execute(
                'SELECT * FROM song'
            ),
            songArts: await connection.promise().execute(
                'SELECT id, SUBSTRING(art, 1, 50) AS art_preview FROM songArts'
            ),
            songStreams: await connection.promise().execute(
                'SELECT id, SUBSTRING(song, 1, 50) AS song_preview FROM songStreams'
            )
        }
        return returnClass ? returnClass : {};
    },
    resetTables: async function () {
        const queries = [
            `DROP TABLE albumSongRelationship`,
            `DROP TABLE artistSongRelationship`,   
            `DROP TABLE albumArtistRelationship`,           
            `DROP TABLE song`,
            `DROP TABLE artist`,
            `DROP TABLE album`,
            `DROP TABLE songStreams`,
            `DROP TABLE songArts`,
            `DROP TABLE albumArts`,

            `CREATE TABLE IF NOT EXISTS song (
            id int NOT NULL AUTO_INCREMENT,
            descrip text,
            name text,
            PRIMARY KEY (id)
            )`,

            `CREATE TABLE IF NOT EXISTS album (
            id int NOT NULL AUTO_INCREMENT,
            descrip text,
            name text,
            PRIMARY KEY (id)
            )`,

            `CREATE TABLE IF NOT EXISTS artist (
            id int NOT NULL AUTO_INCREMENT,
            descrip text,
            name text,
            PRIMARY KEY (id)
            )`,

            `CREATE TABLE IF NOT EXISTS songStreams (
            id int NOT NULL AUTO_INCREMENT,
            song longblob NOT NULL,
            PRIMARY KEY (id)
            )`,

            `CREATE TABLE IF NOT EXISTS songArts (
            id int NOT NULL AUTO_INCREMENT,
            art longblob NOT NULL,
            PRIMARY KEY (id)
            )`,

            `CREATE TABLE IF NOT EXISTS albumArts (
            id int NOT NULL AUTO_INCREMENT,
            art longblob NOT NULL,
            PRIMARY KEY (id)
            )`,

            `CREATE TABLE IF NOT EXISTS albumSongRelationship (
            albumId INT,
            songId INT,
            PRIMARY KEY (albumId, songId)
            )`,

            `CREATE TABLE IF NOT EXISTS albumArtistRelationship (
            albumId INT,
            artistId INT,
            PRIMARY KEY (albumId, artistId)
            )`,

            `CREATE TABLE IF NOT EXISTS artistSongRelationship (
            artistId INT,
            songId INT,
            PRIMARY KEY (artistId, songId)
            )`,
        ];
    
        for (const query of queries) {
            await connection.promise().execute(query);
        }
    
        return {};
    }
}


module.exports = fetchSong;