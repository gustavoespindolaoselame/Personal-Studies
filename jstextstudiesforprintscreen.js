const multer = require('multer');
const path = require('path');

// Configure storage
const storage = multer.diskStorage({
  destination: function (req, file, cb) {
    cb(null, 'uploads/'); // This is your destination folder
  },
  filename: function (req, file, cb) {
    // Optional: customize the file name (e.g., add timestamp)
    const uniqueName = Date.now() + '-' + file.originalname;
    cb(null, uniqueName);
  }
});

// Create the upload middleware with that storage
const upload = multer({ storage: storage });

const upload = multer({ storage: multer.memoryStorage() });
