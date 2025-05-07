-- DROP TABLE `songDetails`;
-- DROP TABLE `songStreams`;
-- DROP TABLE `songArts`;

CREATE TABLE IF NOT EXISTS `song` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descrip` text,
  `name` text,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `album` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descrip` text,
  `name` text,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `artist` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descrip` text,
  `name` text,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `songStreams` (
  `id` int NOT NULL AUTO_INCREMENT,
  `song` longblob NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `songArts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `art` longblob NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `albumArts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `art` longblob NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `albumSongRelationship` (
  `albumId` INT,
  `songId` INT,
  PRIMARY KEY (albumId, songId)
);

CREATE TABLE IF NOT EXISTS `albumArtistRelationship` (
  `albumId` INT,
  `artistId` INT,
  PRIMARY KEY (albumId, artistId)
);

CREATE TABLE IF NOT EXISTS `artistSongRelationship` (
  `artistId` INT,
  `songId` INT,
  PRIMARY KEY (artistId, songId)
);