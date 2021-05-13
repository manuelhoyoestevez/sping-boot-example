DROP TABLE IF EXISTS book;

CREATE TABLE book (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  author VARCHAR(250) NOT NULL
);

INSERT INTO book (id, title, author) VALUES
  (100, 'Clean code', 'Robert C. Martin'),
  (200, 'The Lord of the Rings', 'J. R. R. Tolkien'),
  (300, 'Cien años de soledad', 'Gabriel García Márquez');
