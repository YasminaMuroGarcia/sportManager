DROP TABLE IF EXISTS sports;

CREATE TABLE sports(
  id VARCHAR(36)  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);



INSERT INTO sports(id, name) values ('fc257c80-f1fd-4beb-9cff-592e059e7a5d', 'League of Legends');
INSERT INTO sports(id, name) values ('79909c0a-c527-45e1-bf46-0e1f90a12bac', 'Snooker');


CREATE TABLE tournaments(
  id VARCHAR(36)  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  contestant_type VARCHAR(250),
  number_players INT,
  game_reference VARCHAR(36)
);