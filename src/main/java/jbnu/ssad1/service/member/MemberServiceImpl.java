package jbnu.ssad1.service.member;

import jbnu.ssad1.medel.dto.MemberParameter;
import jbnu.ssad1.medel.entity.Member;
import jbnu.ssad1.repository.member.MemberRepository;

import java.util.List;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public boolean register(String email, String password, String name) {
        if (memberRepository.findByEmail(email) == null) {
            Member member = new Member(email, password, name);
            memberRepository.save(member);
            return true;
        }
        return false;
    }

    @Override
    public boolean login(String email, String password) {
        Member member = memberRepository.findByEmail(email);
        if (member == null) {
            return false;
        }

        return member.getPassword().equals(password);
    }

    @Override
    public Member findMemberById(Long memberId) {
        return this.memberRepository.findById(memberId);
    }

    @Override
    public Member findMemberByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    @Override
    public List<Member> findAllMember() {
        return this.memberRepository.findAll();
    }

    @Override
    public void updateMemberInfo(Long memberId, MemberParameter memberParameter) {
        this.memberRepository.update(memberId, memberParameter);
    }

    @Override
    public void deleteAccount(Long memberId) {
        this.memberRepository.delete(memberId);
    }

    @Override
    public void reset() {
        this.memberRepository.clear();
    }
}
