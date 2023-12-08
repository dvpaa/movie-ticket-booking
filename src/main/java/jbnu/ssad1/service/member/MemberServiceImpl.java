package jbnu.ssad1.service.member;

import jbnu.ssad1.medel.dto.MemberParameter;
import jbnu.ssad1.medel.entity.Member;
import jbnu.ssad1.repository.MemberRepository;

import java.util.List;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void register(Member member) {
        this.memberRepository.save(member);
    }

    @Override
    public Member findMemberById(Long memberId) {
        return this.memberRepository.findById(memberId);
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
