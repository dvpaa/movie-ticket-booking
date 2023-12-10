package jbnu.ssad1.repository.member;

import jbnu.ssad1.medel.dto.MemberParameter;
import jbnu.ssad1.medel.entity.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void update(Long memberId, MemberParameter updateParam) {
        Member findMember = findById(memberId);
        findMember.setEmail(updateParam.getEmail());
        findMember.setPassword(updateParam.getPassword());
        findMember.setName(updateParam.getName());
    }

    @Override
    public void delete(Long memberId) {
        store.remove(memberId);
    }

    @Override
    public void clear() {
        store.clear();
    }
}
