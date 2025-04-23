const connection = require('./conn')

const fetchSong = {
    tableForLogging:async function(){
        const returnClass = {
            songDetails:await connection.promise().execute(
                'SELECT * FROM songDetails'
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
            'DROP TABLE IF EXISTS songDetails',
            'DROP TABLE IF EXISTS songStreams',
            'DROP TABLE IF EXISTS songArts',
            `CREATE TABLE IF NOT EXISTS songDetails (
                id INT NOT NULL AUTO_INCREMENT,
                artistId INT NOT NULL,
                albumId INT NOT NULL,
                descrip TEXT,
                name TEXT,
                PRIMARY KEY (id)
            )`,
            `CREATE TABLE IF NOT EXISTS songStreams (
                id INT NOT NULL AUTO_INCREMENT,
                song LONGBLOB NOT NULL,
                PRIMARY KEY (id)
            )`,
            `CREATE TABLE IF NOT EXISTS songArts (
                id INT NOT NULL AUTO_INCREMENT,
                art LONGBLOB NOT NULL,
                PRIMARY KEY (id)
            )`
        ];
    
        for (const query of queries) {
            await connection.promise().execute(query);
        }
    
        return {};
    },
    detailsByID:async function(index){
        const [rows] = await connection.promise().execute(
            'SELECT * FROM songDetails WHERE `id` = ?;',
            [index]
        );
        return rows ? rows : [];
    },
    detailsByAny:async function(){
        const [rows] = await connection.promise().execute(
            'SELECT * FROM songDetails;',
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
    artByID: async function(index){
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
    arraySizeByAny:async function(){
        const [rows] = await connection.promise().execute(
            'SELECT * FROM songStreams;'
        );
        return rows.length ? rows.length : null;
    }
}


module.exports = fetchSong;