public class SQLite {
    // sqlite is a lightweight relational database - all data is stored in a file
    // sqlite is installed on mac by default
    // sqlite does not enforce column types, although you need to specify it
    // sqlite can be accessed through java code using JDBC-sqlite driver (in fact all databases can be accessed using jdbc)
    // the program 'DB Browser for SQLite' can be used to visualize data inside a SQLite file/database

    // key commands:
    // to start console:
    // sqlite3: starts sqlite with in-memory db
    // sqlite test.db: startes sqlite using test.db database

    // inside sqlite:
    // .help
    // .headers on -> shows column names with data
    // .tables
    // .schema
    // .schema contacts
    // .dump
    // .exit
    // .backup testbackup
    // .restore testbackup

    // create table contacts (name text, phone integer, email text);
    // CREATE TABLE songs (_id INTEGER PRIMARY KEY, track INTEGER, title TEXT NOT NULL, album INTEGER);
    // CREATE TABLE albums (_id INTEGER PRIMARY KEY, name TEXT NOT NULL, artist INTEGER);
    // CREATE TABLE artists (_id INTEGER PRIMARY KEY, name TEXT NOT NULL);

    // drop table artists;

    // insert into contacts (name, phone, email) values ('Tim', 6545678, 'tim@email.com');
    // insert into contacts (name, phone) values ('Steve', 12345);
    // insert into contacts values("Brian", 1234, "brian@myemail.com");

    // update contacts set email='steve@hisemail.com' where name = 'Steve';

    // select * from contacts;
    // select name, email from contacts;
    // select phone from contacts where name = 'Brian';
    // select * from songs where track <> 71;
    // select * from songs where name like '%doctor%';
    // select * from songs where name like 'doctor%';
    // select * from artists inner join albums on artists._id = albums.artist where artists.name = 'Metallica'
    // select * from songs join albums on songs.album = albums._id join artists on albums.artist = artists._id where artists.name = 'Metallica';
    // select count(*) from songs;

    // delete from contacts where phone = '1234';

    // sqlite doesn't have alter table (to change column types), but other sqls do

    // stored procedures: a way to store a SQL query and execute it whenever you want
    // sqlite doesn't have stored procedure
    // however, it has views

    // create view album_list as select name from albums order by name collate nocase;
    // drop view album_list;
    // create view artist_list as
    //   ...> select artists.name, albums.name as album_name, songs.track, songs.title from songs
    //   ...> inner join albums on songs.album = albums._id
    //   ...> inner join artists on albums.artist = artists._id
    //   ...> order by artists.name, albums.name, songs.track;

    // then it can be queried as a table normally

    // sql challenges: all of them use the music.db available in the resources section of the course

}
