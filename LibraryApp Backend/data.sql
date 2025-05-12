-- Insert Countries

INSERT INTO country (id, name, continent) VALUES
      (1, 'Brazil', 'South America'),
      (2, 'South Africa', 'Africa'),
      (3, 'Norway', 'Europe'),
      (4, 'India', 'Asia'),
      (5, 'Mexico', 'North America'),
      (6, 'New Zealand', 'Oceania'),
      (7, 'Egypt', 'Africa'),
      (8, 'Argentina', 'South America'),
      (9, 'Poland', 'Europe'),
      (10, 'South Korea', 'Asia');

-- Insert Authors
INSERT INTO author (id, name, surname, country_id) VALUES
       (1, 'Paulo', 'Coelho', 1),
       (2, 'Nadine', 'Gordimer', 2),
       (3, 'Jo', 'Nesbø', 3),
       (4, 'Arundhati', 'Roy', 4),
       (5, 'Carlos', 'Fuentes', 5),
       (6, 'Katherine', 'Mansfield', 6),
       (7, 'Naguib', 'Mahfouz', 7),
       (8, 'Jorge', 'Borges', 8),
       (9, 'Olga', 'Tokarczuk', 9),
       (10, 'Han', 'Kang', 10);

-- Insert Books
INSERT INTO book (name, category, author_id, available_copies) VALUES
       ('The Alchemist', 'FANTASY', 1, 20),
       ('July''s People', 'NOVEL', 2, 5),
       ('The Snowman', 'THRILLER', 3, 11),
       ('The God of Small Things', 'NOVEL', 4, 14),
       ('The Death of Artemio Cruz', 'HISTORY', 5, 7),
       ('The Garden Party', 'SHORT_STORY', 6, 8),
       ('Palace Walk', 'CLASSICS', 7, 9),
       ('Ficciones', 'FANTASY', 8, 6),
       ('Flights', 'NOVEL', 9, 12),
       ('The Vegetarian', 'DRAMA', 10, 10);
