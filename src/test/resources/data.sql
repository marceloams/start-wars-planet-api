INSERT INTO planet (name, climate, movie_appearances_number) VALUES ('Tattoine', 'arid', 5);
INSERT INTO planet (name, climate, movie_appearances_number) VALUES ('Alderaan', 'temperate', 2);

INSERT INTO terrain (name) VALUES ('desert');
INSERT INTO terrain (name) VALUES ('grasslands');

INSERT INTO planet_terrains (planet_id, terrain_id) VALUES (1, 1);
INSERT INTO planet_terrains (planet_id, terrain_id) VALUES (2,2);