package service;

import entity.Member;
import repository.MemberRepository;

public class MemberService {
    //    TODO: implement this class
    private final MemberRepository memberRepository;
    private static final int LIBRARY_CAPACITY = 100;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void register(String name, String tel, String address, String email) {
        if (memberRepository.count() >= LIBRARY_CAPACITY)
            throw new LibraryFullException();

        validateNonNull(name, "name");
        validateNonNull(tel, "tel");
        validateNonNull(address, "address");
        validateNonNull(email, "email");

        var member = new Member();
        member.setUsername(name);
        member.setTel(tel);
        member.setAddress(address);
        member.setEmail(email);

        memberRepository.save(member);
    }

    private void validateNonNull(String value, String valueName) {
//TODO: implement this
    }

    public void deleteAccount(int id) {

    }
}
