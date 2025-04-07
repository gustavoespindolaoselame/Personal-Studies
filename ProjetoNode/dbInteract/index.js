const uploadSong = require('./uploadSong');
const downloadSong = require('./downloadSong');
const express = require('express');
const app = express();
const cors = require('cors');
const port = 3007;

app.use(cors({ origin: 'http://localhost:8080' }));

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


app.post('/song', (req,res) => {
	if(req.query.href){
		uploadSong(req.query.href.replace(/^'|'$/g, ''), req.query.artistId, req.query.albumId, req.query.name.replace(/^'|'$/g, ''), req.query.description.replace(/^'|'$/g, ''));
	}
	res.send(req.query.href.replace(/^'|'$/g, ''));
})

app.listen(port, () => {
	console.log(`http://localhost:${port}`);
});
