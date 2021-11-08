-- repeat the previous query but display songs in track order. include track number in the output

SELECT songs.track, songs.title
FROM songs
INNER JOIN albums ON albums._id = songs.album
WHERE albums.name = 'Forbidden'
ORDER BY songs.track;