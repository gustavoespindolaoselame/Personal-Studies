const albumsSongsDownloads = require('./downloads');

module.exports = (app) => {

    app.get('/albumssongs/name', (req, res) => {
        albumsSongsDownloads.songsFromAlbum(req.query.id).then(result => res.send(result));
    });

}