package jbnu.ssad1.repository.member;

import jbnu.ssad1.medel.dto.MemberParameter;
import jbnu.ssad1.medel.entity.Member;

import java.util.List;

public interface MemberRepository {

    Member save(Member member);

    Member findById(Long memberId);

    Member findByEmail(String email);

    List<Member> findAll();

    void update(Long memberId, MemberParameter updateParam);

    void delete(Long memberId);

    void clear();
}
