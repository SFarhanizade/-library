import java.sql.*;

void main() throws SQLException {

    String url = "jdbc:postgresql://localhost:5432/library_management";
    String user = "postgres";
    String password = "2706";

    Connection connection = DriverManager.getConnection(url, user, password);
    createTable(connection);
}


private static void createTable(Connection connection) throws SQLException {

    String query = "CREATE TABLE IF NOT EXISTS TB_BOOK (" + "id int PRIMARY KEY ," +
            "title varchar(30) NOT NULL, " +
            "author varchar(30) NOT NULL ," +
            "available boolean" +
            ");";

    try (Statement statement = connection.createStatement()) {
        statement.execute(query);
    }

    query = "CREATE TABLE IF NOT EXISTS TB_MEMBER (" + "id int PRIMARY KEY ," +
            "name varchar(30) NOT NULL, " +
            "tel varchar(20) NOT NULL ," +
            "address varchar(30)," +
            "email varchar(50)" +
            ");";

    try (Statement statement = connection.createStatement()) {
        statement.execute(query);
    }


    query = "        CREATE TABLE IF NOT EXISTS loan " +
            "(id SERIAL PRIMARY KEY,           " +
            " loan_date DATE NOT NULL,            " +
            "return_date DATE NOT NULL,            " +
            "member_id INT NOT NULL,            " +
            "book_id INT NOT NULL,           " +
            " CONSTRAINT fk_loan_member FOREIGN KEY (member_id) REFERENCES TB_MEMBER(id), " +
            " CONSTRAINT fk_loan_book FOREIGN KEY (book_id) REFERENCES TB_BOOK(id)      " +
            "  );        ";

    try (Statement statement = connection.createStatement()) {
        statement.execute(query);
    }
}

