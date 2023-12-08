package jbnu.ssad1.service.member;

import jbnu.ssad1.medel.dto.MemberParameter;
import jbnu.ssad1.medel.entity.Member;

import java.util.List;

public interface MemberService {

    void register(Member member);

    Member findMemberById(Long memberId);

    List<Member> findAllMember();

    void updateMemberInfo(Long memberId, MemberParameter memberParameter);

    void deleteAccount(Long memberId);

    void reset();
}
