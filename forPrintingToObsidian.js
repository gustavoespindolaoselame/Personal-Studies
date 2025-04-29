const express = require('express');
const app = express();

// Define a basic route
app.get('/', (req, res) => {
  res.send('Hello, world!');
});

// Start the server
const PORT = 3000;
app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});