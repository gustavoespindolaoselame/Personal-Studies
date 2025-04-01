const connection = require('./conn')

async function fetchSong(index){
    const [rows] = await connection.promise().execute(
        'SELECT song FROM registry WHERE `index` = 1',
        [index]
    );
    return rows;
}

module.exports = fetchSong;