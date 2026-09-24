import repository.JdbcMemberRepository;

import java.sql.SQLException;

static void main(String[] args) throws SQLException {

    JdbcMemberRepository memberRepository = new JdbcMemberRepository();

    IO.println(memberRepository.findById(1));
    }
