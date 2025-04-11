const mysql = require("mysql2");

const dbConfig = {
  multipleStatements: true,
  host: 'db',      // your MySQL host
  user: 'root',  // your MySQL username
  password: '745231968', // your MySQL password
  database: 'nodeprojeto'  // your database name
};

function connectWithRetry() {
  const connection = mysql.createConnection(dbConfig);

  connection.connect(err => {
    if (err) {
      console.error("DB connection failed, retrying in 3 seconds...", err.message);
      setTimeout(connectWithRetry, 3000); // Retry after 3 seconds
    } else {
      console.log("Connected to DB!");
      // do your setup here
    }
  });

  module.exports = connection;
}

connectWithRetry();