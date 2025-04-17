const uploadSong = require('./uploadSong');
const downloadSong = require('./downloadSong');
const express = require('express');
const app = express();
const cors = require('cors');
const port = 5000;

const multer = require("multer");
const upload = multer({ storage: multer.memoryStorage() });

app.use(cors({ origin: 'http://localhost:5173' }));

app.get('/song', (req, res) => {
	if(req.query.id){
		downloadSong.songByID(req.query.id).then(result => res.send(result));
	} else {
		downloadSong.songByAny().then(result => res.send(result));
	}
});

app.get('/song/details', (req, res) => {
	if(req.query.id){
		downloadSong.detailsByID(req.query.id).then(result => res.send(result));
	} else {
		downloadSong.detailsByAny().then(result => res.send(result));
	}
});

app.get('/song/size', (req, res) => {
	downloadSong.arraySizeByAny().then(result => res.send(result));
});


app.post('/song', upload.single("song"), (req,res) => {
	uploadSong.bySong(req);
	res.send("Post to /song Successfull");
})

app.listen(port, () => {
	console.log(`http://localhost:${port}`);
});
