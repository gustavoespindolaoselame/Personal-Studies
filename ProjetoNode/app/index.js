const uploadSong = require('./uploadSong');
const downloadSong = require('./downloadSong');
const express = require('express');
const app = express();
const cors = require('cors');
const port = 5000;

const multer = require("multer");
const upload = multer({ storage: multer.memoryStorage() });

const fs = require('fs');
const path = require('path');


app.use(cors({ origin: 'http://localhost:5173' }));

app.get('/song', async (req, res) => {
	if(req.query.id){
		await downloadSong.songByID(req.query.id).then(result => {
			res.setHeader('Content-Type', 'audio/mpeg');
			res.send(result);
	});
	} else {
		res.send('404 Song Not Found');
	}
});

app.get('/song/details', (req, res) => {
	if(req.query.id){
		downloadSong.detailsByID(req.query.id).then(result => res.send(result));
	} else {
		downloadSong.detailsByAny().then(result => res.send(result));
	}
});

app.get('/song/arts', (req, res) => {
	if(req.query.id){
		downloadSong.artByID(req.query.id).then(result => res.send(result));
	}
});

app.get('/song/size', (_, res) => {
	downloadSong.arraySizeByAny().then(result => res.send(result));
});

app.get('/tables', (_, res) => {
	downloadSong.tableForLogging().then(result => res.send(result));
});

app.get('/reset', (_, res) => {
	downloadSong.resetTables().then(result => res.send(result));
});

app.post('/song', upload.fields([{ name: 'song', maxCount: 1 },{ name: 'songArt', maxCount: 1 }]), (req,res) => {
	uploadSong.bySong(req);
	res.send("Post to /song Successfull");
})

app.listen(port, () => {
	console.log(`http://localhost:${port}`);
});
