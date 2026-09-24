CREATE TABLE IF NOT EXISTS member
(
    id       SERIAL PRIMARY KEY,
    username varchar(30) NOT NULL UNIQUE,
    tel      varchar(20) NOT NULL,
    address  varchar(50),
    email    varchar(50)
);

CREATE TABLE IF NOT EXISTS book
(
    id        SERIAL PRIMARY KEY,
    title     varchar(25) NOT NULL,
    author    varchar(30) NOT NULL,
    available BOOLEAN     NOT NULL DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS loan
(
    id          SERIAL PRIMARY KEY,
    book_id     int  NOT NULL,
    member_id   int  NOT NULL,
    loan_date   date NOT NULL,
    return_date date,
    FOREIGN KEY (member_id) REFERENCES member (id),
    FOREIGN KEY (book_id) REFERENCES book (id)
);




