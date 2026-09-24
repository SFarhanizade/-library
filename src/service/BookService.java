package service;

import entity.Book;
import repository.BookRepository;

public class BookService {

    //    TODO: implement this class
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;

    }

    public void addBook(int id, String author, String title, boolean available) throws IllegalAccessException {
        if (title == null) {
            throw new IllegalAccessException("tile can not");

        }
        Book book = bookRepository.findByTitle(title);
        if (book != null){
            throw new IllegalAccessException("available book");

        }
        Book newbook = new Book();
        newbook.setId(id);
        newbook.setAuthor(author);
        newbook.setTitle(title);
        newbook.setAvailable(available);

        bookRepository.add(newbook);

    }
}
