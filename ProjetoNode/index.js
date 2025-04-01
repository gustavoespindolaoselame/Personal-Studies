const uploadSong = require('./uploadSong');
// uploadSong('/home/gustavo/Downloads/teste.mp3');

const downloadSong = require('./downloadSong');
// downloadSong(1).then(result => console.log(result));

const express = require('express');
const app = express();
const port = 3000;

// Define a route that responds with 'Hello, World!' to GET requests at '/'

app.get('', (req, res) => {
	res.send('hello');
});

app.get('/song', (req, res) => {
	downloadSong(req.query.id).then(result => res.send(result));
});

app.post('/song', (req,res) => {
	uploadSong(req.body);
	console.log(res.status(201));
});

// Start the server
app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}`);
});
