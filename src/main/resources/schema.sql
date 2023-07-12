CREATE TABLE IF NOT EXISTS `movie_library` (
  `movie_id` int AUTO_INCREMENT  PRIMARY KEY,
  `movie_name` varchar(100) NOT NULL,
  `collection` varchar(10) NOT NULL
);

