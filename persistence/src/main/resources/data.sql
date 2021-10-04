DROP TABLE IF EXISTS sports;

CREATE TABLE sports(
  id LONG AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

INSERT INTO sports (name) VALUES
  ('Billiard/Pool'),
  ('Snooker'),
  ('FIFA'),
  ('Valorant'),
  ('League of Legends');