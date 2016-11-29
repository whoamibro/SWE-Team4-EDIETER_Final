DROP TABLE PowerUsage;
DROP TABLE OwnProduct;
DROP TABLE CrawlingProduct;
DROP TABLE User;

CREATE TABLE User (
num INT,
id VARCHAR(20),
password VARCHAR(20),
name VARCHAR(10),
space INT,
currentPowerUsage DOUBLE,
PRIMARY KEY(num)
) DEFAULT CHARSET=UTF8;

CREATE TABLE PowerUsage (
num INT,
month1 DOUBLE,
month2 DOUBLE,
month3 DOUBLE,
month4 DOUBLE,
month5 DOUBLE,
month6 DOUBLE,
PRIMARY KEY(num),
FOREIGN KEY(num) REFERENCES User(num) ON DELETE CASCADE
);

CREATE TABLE CrawlingProduct (
pcode INT,
pname VARCHAR(20),
model VARCHAR(20),
power DOUBLE,
grade INT,
PRIMARY KEY(pcode)
) DEFAULT CHARSET=UTF8;

CREATE TABLE OwnProduct (
code INT,
num INT,
pcode INT,
nickName VARCHAR(20),
usingTime INT,
availableTime INT,
PRIMARY KEY(code),
FOREIGN KEY(num) REFERENCES User(num) ON DELETE CASCADE,
FOREIGN KEY(pcode) REFERENCES CrawlingProduct(pcode) ON DELETE CASCADE
) DEFAULT CHARSET=UTF8;