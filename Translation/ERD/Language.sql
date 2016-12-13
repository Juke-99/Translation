SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS English;
DROP TABLE IF EXISTS Pert_of_speech;
DROP TABLE IF EXISTS Language;
DROP TABLE IF EXISTS Phrase;




/* Create Tables */

CREATE TABLE English
(
	spell varchar(30) NOT NULL,
	meaning text CHARACTER SET utf8 NOT NULL,
	x,
	pert_of_speechID int(2) unsigned NOT NULL,
	PRIMARY KEY (spell, pert_of_speechID)
);


CREATE TABLE Language
(
	languageID int(3) unsigned NOT NULL,
	language varchar(10) NOT NULL,
	PRIMARY KEY (languageID),
	UNIQUE (languageID),
	UNIQUE (language)
);


CREATE TABLE Pert_of_speech
(
	pert_of_speechID int(2) unsigned NOT NULL AUTO_INCREMENT,
	pert_of_speechname varchar(10) CHARACTER SET utf8 NOT NULL,
	languageID int(3) unsigned NOT NULL,
	PRIMARY KEY (pert_of_speechID),
	UNIQUE (pert_of_speechID),
	UNIQUE (pert_of_speechname)
);


CREATE TABLE Phrase
(
	phraseID int(10) unsigned NOT NULL AUTO_INCREMENT,
	spell varchar(30) NOT NULL,
	meaning text CHARACTER SET utf8 NOT NULL,
	PRIMARY KEY (phraseID),
	UNIQUE (phraseID)
);



/* Create Foreign Keys */

ALTER TABLE Pert_of_speech
	ADD FOREIGN KEY (languageID)
	REFERENCES Language (languageID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE English
	ADD FOREIGN KEY (pert_of_speechID)
	REFERENCES Pert_of_speech (pert_of_speechID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



