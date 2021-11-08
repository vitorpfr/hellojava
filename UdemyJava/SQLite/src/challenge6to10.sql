-- select the titles of all the songs by Aerosmith in alphabetical order. Include only the title in the output

SELECT songs.title
FROM songs
INNER JOIN albums ON albums._id = songs.album
INNER JOIN artists ON artists._id = albums.artist
WHERE artists.name = 'Aerosmith';

-- get the count of songs: 151

SELECT count(songs.title)
FROM songs
INNER JOIN albums ON albums._id = songs.album
INNER JOIN artists ON artists._id = albums.artist
WHERE artists.name = 'Aerosmith';

-- get the list above without any duplicates
SELECT DISTINCT songs.title
FROM songs
INNER JOIN albums ON albums._id = songs.album
INNER JOIN artists ON artists._id = albums.artist
WHERE artists.name = 'Aerosmith';

-- get count without duplicates: 128
SELECT count(DISTINCT songs.title)
FROM songs
INNER JOIN albums ON albums._id = songs.album
INNER JOIN artists ON artists._id = albums.artist
WHERE artists.name = 'Aerosmith';

-- get number of artists and albums
SELECT count(DISTINCT artists.name)
FROM songs
INNER JOIN albums ON albums._id = songs.album
INNER JOIN artists ON artists._id = albums.artist
WHERE artists.name = 'Aerosmith';

SELECT count(DISTINCT albums.name)
FROM songs
INNER JOIN albums ON albums._id = songs.album
INNER JOIN artists ON artists._id = albums.artist
WHERE artists.name = 'Aerosmith';