
-- Création base de donnée / si existe déjà, supprimer !
DROP DATABASE IF EXISTS Bank;
create database Bank;
use Bank;

-- Création table des clients
create table T_Customers(
				IdCust int(4)  PRIMARY KEY AUTO_INCREMENT,
				Name varchar(20),
				FirstName varchar(20)
);


-- Ajouter des clients à votre table
INSERT INTO T_Customers(IdCust,Name,FirstName) VALUES (1,'laude','timothé');
INSERT INTO T_Customers(IdCust,Name,FirstName) VALUES (2,'bousquet','jerome');



-- Création table des comptes
CREATE TABLE T_Counts(
				NumCt    int(4)  PRIMARY KEY AUTO_INCREMENT,
				DateCreation date   NOT NULL,
				Balance   int(4)        NOT NULL,
				IdCust  int(4)        REFERENCES T_Customers(IdCust)
);


-- Ajouter des comptes

INSERT INTO T_Counts(NumCt,DateCreation,Balance,IdCust) VALUES (1,'1996*03*12',3000,1);
INSERT INTO T_Counts(NumCt,DateCreation,Balance,IdCust) VALUES (2,'1999*12*05',2000,1);
INSERT INTO T_Counts(NumCt,DateCreation,Balance,IdCust) VALUES (3,'1995*02*14',5000,2);
INSERT INTO T_Counts(NumCt,DateCreation,Balance,IdCust) VALUES (4,'2000*02*28',7000,2);

-- Création table des opérations
CREATE TABLE T_Operations(
				NumOp  int(4)  NOT NULL PRIMARY KEY AUTO_INCREMENT,
				Amount int(4) NOT NULL,
				NumCt  int(4)  REFERENCES  T_Counts(NumCt)
);


-- Ajouter des opérations
INSERT INTO T_Operations(NumOp,Amount,NumCt) VALUES (1,1000,2);
INSERT INTO T_Operations(NumOp,Amount,NumCt) VALUES (2,1000,2);
INSERT INTO T_Operations(NumOp,Amount,NumCt) VALUES (3,2000,1);
INSERT INTO T_Operations(NumOp,Amount,NumCt) VALUES (4,1000,1);
INSERT INTO T_Operations(NumOp,Amount,NumCt) VALUES (5,2500,3);
INSERT INTO T_Operations(NumOp,Amount,NumCt) VALUES (6,2500,3);
INSERT INTO T_Operations(NumOp,Amount,NumCt) VALUES (7,3000,4);
INSERT INTO T_Operations(NumOp,Amount,NumCt) VALUES (8,4000,4);
--bonus
CREATE TABLE T_CountCurrent(
				NumCt int   REFERENCES T_Counts(NumCt),
				Balance int REFERENCES T_Counts(Balance) 
);
INSERT INTO T_CountCurrent(NumCt) VALUES (1,3000);
INSERT INTO T_CountCurrent(NumCt) VALUES (3,5000);
CREATE TABLE T_CountSaving(
				NumCt int REFERENCES T_Counts(NumCt),
				Balance int UNSIGNED REFERENCES T_Counts(Balance)
);
INSERT INTO T_CountSaving(NumCt) VALUES (2,2000);
INSERT INTO T_CountSaving(NumCt) VALUES (4,7000);
