const uploads = require('./uploads');
const downloads = require('./downloads');
const express = require('express');
const app = express();
const cors = require('cors');
const port = 5000;

const multer = require("multer");
const memStorage = multer({ storage: multer.memoryStorage() });

app.use(cors({ origin: 'http://localhost:'+ process.env.WEB_PORT }));

app.get('/song', async (req, res) => {
	if(req.query.id){
		await downloads.songByID(req.query.id).then(result => {
			res.setHeader('Content-Type', 'audio/mpeg');
			res.send(result);
	});
	} else {
		res.send('404 Song Not Found');
	}
});

app.get('/song/details', (req, res) => {
	if(req.query.id){
		downloads.songDetailsByID(req.query.id).then(result => res.send(result));
	} else {
		downloads.songDetailsByAny().then(result => res.send(result));
	}
});

app.get('/song/arts', (req, res) => {
	if(req.query.id){
		downloads.songArtByID(req.query.id).then(result => res.send(result));
	}
});

app.get('/song/size', (_, res) => {
	downloads.songArraySizeByAny().then(result => res.send(result));
});

app.get('/tables', (_, res) => {
	downloads.tableForLogging().then(result => res.send(result));
});

app.get('/reset', (_, res) => {
	downloads.resetTables().then(result => res.send(result));
});

app.post('/song', memStorage.fields([{ name: 'song', maxCount: 1 },{ name: 'songArt', maxCount: 1 }]), (req,res) => {
	uploads.uploadSong.bySong(req);
	res.send("Post to /song Successfull");
})

app.post('/album', memStorage.fields([{ name: 'albumArt', maxCount: 1 }]), (req,res) => {
	console.log("Album Upload Started");
	uploads.uploadAlbum.bySong(req);
	res.send("Post to /album Successfull");
})

app.get('/album/details', (req, res) => {
	if(req.query.id){
		downloads.albumDetailsByID(req.query.id).then(result => res.send(result));
	} else {
		downloads.albumDetailsByAny().then(result => res.send(result));
	}
});

app.get('/album/size', (_, res) => {
	downloads.albumArraySizeByAny().then(result => res.send(result));
});

app.get('/album/arts', (req, res) => {
	if(req.query.id){
		downloads.albumArtByID(req.query.id).then(result => res.send(result));
	}
});

app.listen(port, '0.0.0.0', () => {
	console.log(`http://localhost:${port}`);
});
