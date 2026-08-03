CREATE TABLE book (
  id BIGSERIAL PRIMARY KEY,

  title VARCHAR(255) NOT NULL,

  price NUMERIC(10,2),

  author_id BIGINT NOT NULL,

  CONSTRAINT fk_book_author
      FOREIGN KEY(author_id)
          REFERENCES author(id)
);