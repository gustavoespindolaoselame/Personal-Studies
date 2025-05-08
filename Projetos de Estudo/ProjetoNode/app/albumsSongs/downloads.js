const connection = require('../conn')

const fetchAlbumsSongsFromDB = {
    songsFromAlbum: async function(index) {
        const [songRows] = await connection.promise().execute(
            'SELECT songId FROM albumSongRelationship WHERE `albumId` = ?;',
            [index]
        );
        const returnArray= []
        for (const row of songRows) {
            const [songData] = await connection.promise().execute(
                'SELECT * FROM song WHERE `id` = ?;',
                [row.songId]
            );
            returnArray.push(songData);
        }
        return returnArray;
    }
};
module.exports = fetchAlbumsSongsFromDB;