CREATE TABLE IF NOT EXISTS `songDetails` (
  `id` int NOT NULL AUTO_INCREMENT,
  `artistId` int NOT NULL,
  `albumId` int NOT NULL,
  `descrip` text,
  `name` text,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `songStreams` (
  `id` int NOT NULL AUTO_INCREMENT,
  `song` longblob NOT NULL,
  PRIMARY KEY (`id`)
);