--Users
INSERT INTO User (userid, username, password, singupdate, lastsignin) VALUES (1, 'Kevin', 'kjhsdfjkhuisdfg', '2020-02-14', '2020-02-14');

--Trip
INSERT INTO Trip (tripid, user, name, credit) VALUES (1, 1, 'Flug', 349.99);
INSERT INTO Trip (tripid, user, name, credit) VALUES (2, 1, 'Hotel', 600.00);
INSERT INTO Trip (tripid, user, name, credit) VALUES (3, 1, 'Bar', 80.00);
INSERT INTO Trip (tripid, user, name, credit) VALUES (4, 1, 'Ausflug', 320.00);

--Persons
INSERT INTO Persons(personid,user, name) VALUES (1,1,'Kevin');
INSERT INTO Persons(personid,user, name) VALUES (2,1,'Joey');
INSERT INTO Persons(personid,user, name) VALUES (3,1,'Felix');
INSERT INTO Persons(personid,user, name) VALUES (4,1,'Joshua');

--Participants
INSERT INTO Participants(participantid,tripid,name, iscreditor) VALUES (1,1,'Kevin', false);
INSERT INTO Participants(participantid,tripid,name, iscreditor) VALUES (2,1,'Joey', false);
INSERT INTO Participants(participantid,tripid,name, iscreditor) VALUES (3,1,'Felix', true);
INSERT INTO Participants(participantid,tripid,name, iscreditor) VALUES (4,1,'Joshua', false);

INSERT INTO Participants(participantid,tripid,name, iscreditor) VALUES (5,2,'Kevin', true);
INSERT INTO Participants(participantid,tripid,name, iscreditor) VALUES (6,2,'Joey', false);
INSERT INTO Participants(participantid,tripid,name, iscreditor) VALUES (7,2,'Felix', false);
INSERT INTO Participants(participantid,tripid,name, iscreditor) VALUES (8,2,'Joshua', false);

INSERT INTO Participants(participantid,tripid,name, iscreditor) VALUES (9,3,'Kevin', false);
INSERT INTO Participants(participantid,tripid,name, iscreditor) VALUES (10,3,'Joey', true);
INSERT INTO Participants(participantid,tripid,name, iscreditor) VALUES (11,3,'Felix', false);
INSERT INTO Participants(participantid,tripid,name, iscreditor) VALUES (12,3,'Joshua', false);

INSERT INTO Participants(participantid,tripid,name, iscreditor) VALUES (13,4,'Kevin', false);
INSERT INTO Participants(participantid,tripid,name, iscreditor) VALUES (14,4,'Felix', false);
INSERT INTO Participants(participantid,tripid,name, iscreditor) VALUES (15,4,'Joshua', true);
