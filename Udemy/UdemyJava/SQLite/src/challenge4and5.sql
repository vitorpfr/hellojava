-- rename the band 'Mehitabel' to 'One Kitten'
-- this is an exception to always fully qualify column names: you need to use 'name' instead of 'artists.name'

UPDATE artists SET name='One Kitten' WHERE name = 'Mehitabel';

-- checking that the records were correctly renamed
SELECT *
FROM artists
WHERE artists.name = 'Mehitabel';

-- gives id 3
SELECT *
FROM artists
WHERE artists._id = 3;