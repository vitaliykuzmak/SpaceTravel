INSERT INTO client (name) VALUES
('Andrey'), ('Sergey'), ('ivan'), ('Diana'), ('Stepan'),
('Franko'), ('Grisha'), ('Anna'), ('Vitaliy'), ('Nazar');

INSERT INTO planet (id, name) VALUES
('MARS', 'Mars'),
('VEN', 'Venus'),
('EARTH', 'Earth'),
('JUP', 'Jupiter'),
('SAT', 'Saturn');

INSERT INTO ticket (client_id, from_planet_id, to_planet_id) VALUES
(1, 'EARTH', 'MARS'),
(2, 'MARS', 'VEN'),
(3, 'VEN', 'EARTH'),
(4, 'EARTH', 'JUP'),
(5, 'SAT', 'EARTH'),
(6, 'VEN', 'MARS'),
(7, 'JUP', 'SAT'),
(8, 'EARTH', 'VEN'),
(9, 'MARS', 'EARTH'),
(10, 'SAT', 'JUP');
