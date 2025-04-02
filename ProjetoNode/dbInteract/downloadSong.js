const connection = require('./conn')

const fetchSong = {
    detailsByID:async function(index){
        const [rows] = await connection.promise().execute(
            'SELECT * FROM songDetails WHERE `id` = ?;',
            [index]
        );
        return rows;
    },
    detailsByAny:async function(){
        const [rows] = await connection.promise().execute(
            'SELECT * FROM songDetails;',
        );
        return rows;
    },
    songByID: async function(index){
        const [rows] = await connection.promise().execute(
            'SELECT song FROM songStreams WHERE `id` = ?;',
            [index]
        );
        return rows[0].song;
    },
    songByAny: async function(){
        const [rows] = await connection.promise().execute(
            'SELECT * FROM songStreams;'
        );
        return rows;
    },
    arraySizeByAny:async function(){
        const [rows] = await connection.promise().execute(
            'SELECT * FROM songStreams;'
        );
        return rows.length ? rows.length : null;
    }
}


module.exports = fetchSong;