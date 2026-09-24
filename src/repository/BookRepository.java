package repository;

import entity.Book;

import java.util.List;

public interface BookRepository {

    void save(Book book);

    Book findByTitle(String title);

    void update(Book book);

    List<Book> findAll();

    void delete(Book book);

    void deleteById(int id);
}
