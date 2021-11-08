-- select the titles of all the songs on the album 'Forbidden'

SELECT songs.title
FROM songs
INNER JOIN albums ON albums._id = songs.album
WHERE albums.name = 'Forbidden';
