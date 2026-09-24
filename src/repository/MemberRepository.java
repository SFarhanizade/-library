package repository;

import entity.Member;
import util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {


    public void save(Member member) {
        String insertQuery = "INSERT INTO member (id, username, tel, address, email) VALUES (?,?,?,?,?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pS = connection.prepareStatement(insertQuery)) {

            pS.setInt(1, member.getId());
            pS.setString(2, member.getName());
            pS.setString(3, member.getTel());
            pS.setString(4, member.getAddress());
            pS.setString(5, member.getEmail());
            pS.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Member findById(int id) {
        String findQuery = "SELECT id, username, tel, address, email FROM member WHERE id = ?";

        try (Connection connection = ConnectionUtil.getConnection()) {

            PreparedStatement pS = connection.prepareStatement(findQuery);

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

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void update(Member member) {
        String updateQuery = "UPDATE member SET username = ?, tel = ?, address = ?, email = ? WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pS = connection.prepareStatement(updateQuery)) {

            pS.setString(1, member.getName());
            pS.setString(2, member.getTel());
            pS.setString(3, member.getAddress());
            pS.setString(4, member.getEmail());
            pS.setInt(5, member.getId());

            pS.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Member> findAll() {
        String findQuery = "SELECT id, username, tel, address, email FROM member";

        try (Connection connection = ConnectionUtil.getConnection();
             Statement pS = connection.createStatement()) {

            ResultSet rs = pS.executeQuery(findQuery);
            var members = new ArrayList<Member>();
            while (rs.next()) {
                int memberId = rs.getInt("id");
                String name = rs.getString("name");
                String tel = rs.getString("tel");
                String address = rs.getString("address");
                String email = rs.getString("email");
                members.add(new Member(memberId, name, tel, address, email));
            }

            return members;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Member member) {
        String deleteQuery = "DELETE FROM member WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pS = connection.prepareStatement(deleteQuery)) {

            pS.setInt(1, member.getId());
            pS.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

