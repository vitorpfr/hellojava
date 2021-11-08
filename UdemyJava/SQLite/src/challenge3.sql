-- display all songs from the band 'Deep Purple'

SELECT *
FROM songs
INNER JOIN albums ON songs.album = albums._id
INNER JOIN artists ON albums.artist = artists._id
WHERE artists.name = 'Deep Purple';