package service;

import entity.Book;
import repository.BookRepository;

import java.util.List;

public class BookService {

    //    TODO: implement this class
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;

    }

    public void addBook(int id, String author, String title, boolean available) throws IllegalAccessException {
        if (title == null) {
            throw new IllegalAccessException("title can not empty");

        }
        Book book = bookRepository.findByTitle(title);
        if (book != null) {
            throw new IllegalAccessException("available book");

        }
        Book newbook = new Book();
        newbook.setId(id);
        newbook.setAuthor(author);
        newbook.setTitle(title);
        newbook.setAvailable(available);

        bookRepository.save(newbook);

    }

    public void updateBook(int id, String author, String title, boolean available) throws IllegalAccessException {
        Book book = bookRepository.findByTitle(title);
        if (book == null) {
            throw new IllegalAccessException("Book not found");
        }
        if (title == null) {
            throw new IllegalAccessException("title can not empty");
        }
        book.setAuthor(author);
        book.setTitle(title);
        book.setAvailable(available);
        bookRepository.update(book);
    }

    public void deleteBook(int id) throws IllegalAccessException {
        Book book = bookRepository.findById(id);
        if (book == null) {
            throw new IllegalAccessException("Book not found");
        }
        bookRepository.deleteById(id);
    }

    public Book findById(int id)throws  IllegalAccessException{
        Book book=bookRepository.findById(id);
        if(book==null){
            throw new IllegalAccessException("Book not found");
        }
        return book;
    }
    public List<Book> findAll(){
        return bookRepository.findAll();
    }
    public void delete(Book book){
        bookRepository.delete(book);
    }
}
