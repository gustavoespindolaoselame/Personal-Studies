const songsDownloads = require('./downloads');
const songsUploads = require('./uploads');

module.exports = (app, memStorage) => {
	app.get('/song/stream', async (req, res) => {
		await songsDownloads.stream(req.query.id).then(result => {
			res.setHeader('Content-Type', 'audio/mpeg');
			res.send(result);
		});
	});

	app.get('/song/details', (req, res) => {
		req.query.id?
		songsDownloads.details(req.query.id).then(result => res.send(result)):
		songsDownloads.detailsAny().then(result => res.send(result));
	});

	app.get('/song/art', (req, res) => {
		songsDownloads.art(req.query.id).then(result => res.send(result));
	});

	app.get('/song/size', (_, res) => {
		songsDownloads.size().then(result => res.send(result));
	});

	app.post('/song/stream', memStorage.fields([{ name: 'song', maxCount: 1 },{ name: 'songArt', maxCount: 1 }]), (req,res) => {
		songsUploads(req);
		res.send("Post to /song Successfull");
	});
}