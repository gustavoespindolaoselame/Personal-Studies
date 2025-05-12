const connection = require('../conn')

const fetchSongsFromDb = {
    details:async function(index){
        const [rows] = await connection.promise().execute(
            'SELECT * FROM song WHERE `id` = ?;',
            [index]
        );
        return rows ? rows : [];
    },
    detailsAny:async function(){
        const [rows] = await connection.promise().execute(
            'SELECT * FROM song'
        );
        return rows ? rows : [];
    },
    stream: async function(index){
        const [rows] = await connection.promise().execute(
            'SELECT song FROM songStreams WHERE `id` = ?;',
            [index]
        );
        return await rows[0] ? rows[0].song : 0;
    },
    art: async function(index){
        const [rows] = await connection.promise().execute(
            'SELECT art FROM songArts WHERE `id` = ?;',
            [index]
        );
        return await rows[0] ? rows[0].art : 0;
    },
    size:async function(){
        const [rows] = await connection.promise().execute(
            'SELECT * FROM song;'
        );
        return rows.length ? rows.length : null;
    }
}


module.exports = fetchSongsFromDb;