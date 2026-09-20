import repository.MemberRepository;

import java.sql.SQLException;

static void main(String[] args) throws SQLException {

    MemberRepository memberRepository = new MemberRepository();

    IO.println(memberRepository.findById(1));
    }
