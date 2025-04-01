const mysql = require("mysql2");

const dbConfig = {
  host: 'localhost',      // your MySQL host
  user: 'root',  // your MySQL username
  password: '745231968', // your MySQL password
  database: 'nodeprojeto'  // your database name
};

module.exports = mysql.createConnection(dbConfig);