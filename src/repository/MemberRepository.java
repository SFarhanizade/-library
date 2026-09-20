package repository;

import entity.Member;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRepository {


    public void save(Member member) throws SQLException {

        try (Connection connection = ConnectionUtil.getConnection()) {

            String insertQuery = "INSERT INTO member (id, name, tel, address, email) VALUES (?,?,?,?,?)";

            try (PreparedStatement pS = connection.prepareStatement(insertQuery)) {
                pS.setInt(1, member.getId());
                pS.setString(2, member.getName());
                pS.setString(3, member.getTel());
                pS.setString(4, member.getAddress());
                pS.setString(5, member.getEmail());
                pS.executeUpdate();
            }

        }
    }

    public Member findById(int id) throws SQLException {

        try (Connection connection = ConnectionUtil.getConnection()) {

            String findQuery = "SELECT id, name, tel, address, email FROM member WHERE id = ?";

            try (PreparedStatement pS = connection.prepareStatement(findQuery)) {
                pS.setInt(1, id);

                ResultSet rs = pS.executeQuery();

                if (rs.next()) {
                    int memberId = rs.getInt("id");
                    String name = rs.getString("name");
                    String tel = rs.getString("tel");
                    String address = rs.getString("address");
                    String email = rs.getString("email");
                    return new Member(memberId, name, tel, address, email);
                }
            }
        }
        return null;
    }

}

