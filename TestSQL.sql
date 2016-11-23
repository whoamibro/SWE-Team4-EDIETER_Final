DROP TABLE PowerUsage;
DROP TABLE OwnProduct;
DROP TABLE CrawlingProduct;
DROP TABLE User;

CREATE TABLE User (
uid VARCHAR(20),
password VARCHAR(20),
name VARCHAR(10),
space INT,
currentPowerUsage DOUBLE,
PRIMARY KEY(uid)
);

CREATE TABLE PowerUsage (
uid VARCHAR(20),
month1 DOUBLE,
month2 DOUBLE,
month3 DOUBLE,
month4 DOUBLE,
month5 DOUBLE,
month6 DOUBLE,
PRIMARY KEY(uid),
FOREIGN KEY(uid) REFERENCES User(uid) ON DELETE CASCADE
);

CREATE TABLE CrawlingProduct (
pcode INT,
pname VARCHAR(20),
model VARCHAR(20),
power DOUBLE,
grade INT,
PRIMARY KEY(pcode)
);

CREATE TABLE OwnProduct (
code INT,
uid VARCHAR(20),
pcode INT,
nickName VARCHAR(20),
usingTime INT,
availableTime INT,
PRIMARY KEY(code),
FOREIGN KEY(uid) REFERENCES User(uid) ON DELETE CASCADE,
FOREIGN KEY(pcode) REFERENCES CrawlingProduct(pcode) ON DELETE CASCADE
);

INSERT INTO User VALUES (1, 1, 1, 1, 1);
INSERT INTO PowerUsage VALUES (1, 10, 20, 30, 40, 50, 60);
INSERT INTO CrawlingProduct VALUES (1, '³ÃÀå°í', '¸ðµ¨¸í', 32, 1);
INSERT INTO OwnProduct VALUES (1, 1, 1, '´Ð³×ÀÓ', 10, 10);