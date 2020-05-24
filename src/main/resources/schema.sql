
--Users
create table User
(
    userid          int primary key,
    username        nvarchar(255),
    password        nvarchar(255),
    singupdate      date,
    lastsignin      date
);


--Trip
create table Trip
(
    tripid          int primary key,
    user            int,
    name            nvarchar(255),
    credit          decimal(26,6),
    FOREIGN KEY (user) REFERENCES User(userid)
);
--Persons
create table Persons
(
    personid        int primary key,
    name            nvarchar(255),
    user            int,
    FOREIGN KEY (user) REFERENCES User(userid)
);
--Participants
create table Participants
(
    participantid   int primary key,
    tripid          int,
    name            nvarchar(255),
    iscreditor      boolean,
    FOREIGN KEY (tripid) REFERENCES Trip(tripid)
);



