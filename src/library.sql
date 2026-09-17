CREATE TABLE member
(
    id      int PRIMARY KEY,
    name    varchar(30) NOT NULL,
    tel     varchar(20) NOT NULL,
    address varchar(50),
    email   varchar(50)
);
CREATE TABLE book
(
    id        int PRIMARY KEY,
    title     varchar(25) NOT NULL,
    author    varchar(30) NOT NULL,
    available boolean DEFAULT TRUE
);

CREATE TABLE loan
(
    id        int PRIMARY KEY,
    book_id   int  NOT NULL,
    member_id int  NOT NULL,
    loan_date date NOT NULL,
    return    date NOT NULL,
    FOREIGN KEY (member_id) REFERENCES member (id),
    FOREIGN KEY (book_id) REFERENCES book (id)
);



