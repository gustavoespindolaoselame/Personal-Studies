const albumsDownloads = require('./downloads');
const uploadAlbums = require('./uploads');

module.exports = (app, memStorage) => {

    app.post('/album/stream', memStorage.fields([{ name: 'albumArt', maxCount: 1 }]), (req,res) => {
        uploadAlbums(req);
        res.send("Post to /album Successfull");
    }),

    app.get('/album/details', (req, res) => {
        albumsDownloads.details(req.query.id).then(result => res.send(result));
    });

    app.get('/album/size', (_, res) => {
        albumsDownloads.size().then(result => res.send(result));
    });

    app.get('/album/art', (req, res) => {
        albumsDownloads.art(req.query.id).then(result => res.send(result));
    });

}