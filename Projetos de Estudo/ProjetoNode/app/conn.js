const mysql = require("mysql2");

const dbConfig = {
  multipleStatements: true,
  host: 'db',
  user: 'root',
  password: process.env.MYSQL_ROOT_PASSWORD,
  database: process.env.MYSQL_DATABASE,
  multipleStatements: true 
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