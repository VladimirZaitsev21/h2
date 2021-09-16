INSERT INTO AUTHORS (FirstName, LastName, Age) VALUES
  ('Dan', 'Vega', 45),
  ('Jen', 'Bork', 60),
  ('Bella', 'Newton', 100);

INSERT INTO GENRES (Title) VALUES
  ('Detective'),
  ('Thriller'),
  ('Comedy');

INSERT INTO BOOKS (Title, Recommended_price, Authors_id, Genres_id) VALUES
  ('Deep Lake', 1500, 1, 2),
  ('Neighbour', 1000, 2, 1),
  ('Local theater', 1250, 3, 3);