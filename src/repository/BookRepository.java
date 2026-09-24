package repository;

import entity.Book;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class BookRepository {
    public void add(Book book) throws SQLException {
        try(Connection connection = ConnectionUtil.getConnection()){
            String addQuery = "insert into book(id, titel , author, available)Values? "


        }
    }
}
