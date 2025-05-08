const express = require('express');
const app = express();

const cors = require('cors');
const port = 5000;

app.listen(port, '0.0.0.0', () => {
	console.log(`http://localhost:${port}`);
});

const multer = require("multer");
const memStorage = multer({storage: multer.memoryStorage()});

console.log("corsd: " + 'http://localhost:'+ process.env.WEB_PORT);
app.use(cors({origin: 'http://localhost:'+ process.env.WEB_PORT}));

const albumEndpoints = require('./albums/endpoints');
albumEndpoints(app, memStorage);

const songEndpoints = require('./songs/endpoints');
songEndpoints(app, memStorage);

const genericEndpoints = require('./generic/endpoints');
genericEndpoints(app);

const albumsSongsEndpoints = require('./albumsSongs/endpoints');
albumsSongsEndpoints(app);

