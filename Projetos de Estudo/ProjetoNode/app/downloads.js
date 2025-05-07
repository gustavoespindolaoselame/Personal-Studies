const connection = require('./conn')

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
    },
    songDetailsByID:async function(index){
        const [rows] = await connection.promise().execute(
            'SELECT * FROM song WHERE `id` = ?;',
            [index]
        );
        return rows ? rows : [];
    },
    songDetailsByAny:async function(){
        const [rows] = await connection.promise().execute(
            'SELECT * FROM song;',
        );
        return rows ? rows : [];
    },
    songByID: async function(index){
        const [rows] = await connection.promise().execute(
            'SELECT song FROM songStreams WHERE `id` = ?;',
            [index]
        );
        return await rows[0] ? rows[0].song : 0;
    },
    songArtByID: async function(index){
        const [rows] = await connection.promise().execute(
            'SELECT art FROM songArts WHERE `id` = ?;',
            [index]
        );
        return await rows[0] ? rows[0].art : 0;
    },
    songByAny: async function(){
        const [rows] = await connection.promise().execute(
            'SELECT * FROM songStreams;'
        );
        return rows ? rows : [];
    },
    songArraySizeByAny:async function(){
        const [rows] = await connection.promise().execute(
            'SELECT * FROM song;'
        );
        return rows.length ? rows.length : null;
    },
    albumDetailsByID:async function(index){
        const [rows] = await connection.promise().execute(
            'SELECT * FROM album WHERE `id` = ?;',
            [index]
        );
        return rows ? rows : [];
    },
    albumDetailsByAny:async function(){
        const [rows] = await connection.promise().execute(
            'SELECT * FROM album;',
        );
        return rows ? rows : [];
    },
    albumArraySizeByAny:async function(){
        const [rows] = await connection.promise().execute(
            'SELECT * FROM album;'
        );
        return rows.length ? rows.length : null;
    },
    albumArtByID: async function(index){
        const [rows] = await connection.promise().execute(
            'SELECT art FROM albumArts WHERE `id` = ?;',
            [index]
        );
        return await rows[0] ? rows[0].art : 0;
    }
}


module.exports = fetchSong;