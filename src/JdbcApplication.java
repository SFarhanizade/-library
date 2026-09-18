import java.sql.*;

void main() throws SQLException {

    String url = "jdbc:postgresql://localhost:5432/library_management";
    String user = "postgres";
    String password = "2706";

    Connection connection = DriverManager.getConnection(url, user, password);
    createTable(connection);
}


    private static void createTable (Connection connection) throws SQLException {

        String query = "CREATE TABLE IF NOT EXISTS TB_BOOK (" + "id SERIAL PRIMARY KEY ," +
                "title varchar(30) NOT NULL, " +
                "author varchar(30) NOT NULL ,"+
                "available boolean" +
                ");" ;

        try (Statement statement = connection.createStatement()) {
                statement.execute(query);
            }

        query = "CREATE TABLE IF NOT EXISTS TB_MEMBER (" + "id SERIAL PRIMARY KEY ," +
                "name varchar(30) NOT NULL, " +
                "tel varchar(20) NOT NULL ,"+
                "address varchar(30)," +
                "email varchar(50)" +
                ");" ;

        try (Statement statement = connection.createStatement()) {
                statement.execute(query);
            }

        query = "CREATE TABLE IF NOT EXISTS loan (" + "id SERIAL PRIMARY KEY ," +
                "loan_date date NOT NULL, " +
                "return_date date NOT NULL ,"+
                "book_id int REFERENCES book," +
                "member_id int REFERENCES member" +
                ");" ;

        try (Statement statement = connection.createStatement()) {
                statement.execute(query);
            }
        }

