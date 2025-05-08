const genericsDownloads = require('./downloads');

module.exports = (app) => {
	app.get('/tables', (_, res) => {
		genericsDownloads.tableForLogging().then(result => res.send(result));
	});
	
	app.get('/reset', (_, res) => {
		genericsDownloads.resetTables().then(result => res.send(result));
	});	
}