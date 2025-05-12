const connection = require('../conn')

const fetchAlbumsFromDB = {
    details:async function(index){
        const [rows] = await connection.promise().execute(
            'SELECT * FROM album WHERE `id` = ?;',
            [index]
        );
        return rows ? rows : [];
    },
    detailsAny:async function(){
        const [rows] = await connection.promise().execute(
            'SELECT * FROM album'
        );
        return rows ? rows : [];
    },
    size:async function(){
        const [rows] = await connection.promise().execute(
            'SELECT * FROM album;'
        );
        return rows.length ? rows.length : null;
    },
    art: async function(index){
        const [rows] = await connection.promise().execute(
            'SELECT art FROM albumArts WHERE `id` = ?;',
            [index]
        );
        return await rows[0] ? rows[0].art : 0;
    }
}


module.exports = fetchAlbumsFromDB;