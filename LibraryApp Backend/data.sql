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
INSERT INTO book (name, category, author_id, available_copies, description, cover_url) VALUES
       ('The Alchemist', 'FANTASY', 1, 20,
        'A philosophical book about following your dreams and destiny.',
        'https://images-na.ssl-images-amazon.com/images/I/71aFt4+OTOL.jpg'),

       ('July''s People', 'NOVEL', 2, 5,
        'A novel about apartheid-era South Africa and the struggles of one family.',
        'https://m.media-amazon.com/images/I/71wcIFjokdL._SY522_.jpg'),

       ('The Snowman', 'THRILLER', 3, 11,
        'A chilling crime thriller featuring Detective Harry Hole as he investigates a serial killer.',
        'https://m.media-amazon.com/images/I/81QotpjX80L._UF1000,1000_QL80_.jpg'),

       ('The God of Small Things', 'NOVEL', 4, 14,
        'A story set in Kerala, India, exploring forbidden love and family secrets.',
        'https://m.media-amazon.com/images/I/91saO95VziL._UF1000,1000_QL80_.jpg'),

       ('The Death of Artemio Cruz', 'HISTORY', 5, 7,
        'A Mexican classic novel reflecting on politics, corruption, and power.',
        'https://m.media-amazon.com/images/I/71Hm5G7+BOL._UF1000,1000_QL80_.jpg'),

       ('The Garden Party', 'SHORT_STORY', 6, 8,
        'A short story by Katherine Mansfield exploring class differences and mortality.',
        'https://m.media-amazon.com/images/I/61COsPh04xL._UF1000,1000_QL80_.jpg'),

       ('Palace Walk', 'CLASSICS', 7, 9,
        'The first book of the Cairo Trilogy, depicting family life in Egypt during WWI.',
        'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1333577200i/11446013.jpg'),

       ('Ficciones', 'FANTASY', 8, 6,
        'A collection of short stories by Jorge Luis Borges, blending reality and imagination.',
        'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1621713120i/426504.jpg'),

       ('Flights', 'NOVEL', 9, 12,
        'A novel about travel, human anatomy, and philosophy, winner of the Man Booker International Prize.',
        'https://m.media-amazon.com/images/I/71KcYxVBb8L._UF1000,1000_QL80_.jpg'),

       ('The Vegetarian', 'DRAMA', 10, 10,
        'A South Korean novel about a woman''s decision to stop eating meat and its consequences.',
        'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1728661771i/25489025.jpg');
