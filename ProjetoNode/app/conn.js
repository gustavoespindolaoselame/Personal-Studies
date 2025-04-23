const mysql = require("mysql2");

const dbConfig = {
  multipleStatements: true,
  host: 'db',      // your MySQL host
  user: 'root',  // your MySQL username
  password: '745231968', // your MySQL password
  database: 'nodeprojeto',
  multipleStatements: true  // your database name
};

const connection = () =>{
  let returnConnection = mysql.createConnection(dbConfig);

  returnConnection.connect(err => {
    if (err) {
      console.error("DB connection failed, retrying in 1 seconds...", err.message);
      setTimeout(connection, 1000);
    } else {
      console.log("Connected to DB!");
    }
  });

  return returnConnection;
}

module.exports = connection();