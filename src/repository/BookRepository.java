package repository;

import entity.Book;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    public void add(Book book) {

        String addQuery = "INSERT INTO book (id, title , author, available) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConnectionUtil.getConnection()) {

            PreparedStatement pS = connection.prepareStatement(addQuery);

            pS.setInt(1, book.getId());
            pS.setString(2, book.getTitle());
            pS.setString(3, book.getAuthor());
            pS.setBoolean(4, book.isAvailable());

            pS.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Book findByTitle(String title) {

        String updateQuery = "SELECT (id, title, author, available) FROM book WHERE title = ? ";

        try (Connection connection = ConnectionUtil.getConnection()) {

            PreparedStatement pS = connection.prepareStatement(updateQuery);

            pS.setString(1, title);

            ResultSet resultSet = pS.executeQuery();

            if (resultSet.next()) {

                int id = resultSet.getInt("id");
                String titleBook = resultSet.getString("title");
                String author = resultSet.getString("author");
                boolean available = resultSet.getBoolean("available");

                return new Book(id, titleBook, author, available);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return null;
    }

    public void deleteById(int id) {
        String deleteQuary = "Delete from books where id=?";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement((deleteQuary));
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }


    }
    public List<Book> findALL(){
        List<Book> books=new ArrayList<>();
        String findAllBooks="SELECT * FROM book";
        try(Connection connection=ConnectionUtil.getConnection()){
            PreparedStatement statement= connection.prepareStatement(findAllBooks);
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()){
                Book book=new Book(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("auther"),
                        resultSet.getBoolean("avalable"));
                books.add(book);

            }
            return books;

        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
}
