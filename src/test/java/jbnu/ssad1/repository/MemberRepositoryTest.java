package jbnu.ssad1.repository;

import jbnu.ssad1.medel.dto.MemberParameter;
import jbnu.ssad1.medel.entity.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberRepositoryTest {
    MemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    void afterEach() {
        memberRepository.clear();
    }

    @Test
    void save() {
        Member member = new Member("kgo0926@jbnu.ac.kr", "qwerty", "geonu");

        Member saved = memberRepository.save(member);

        Member findMember = memberRepository.findById(member.getId());

        assertThat(findMember).isEqualTo(saved);
    }

    @Test
    void findAll() {
        Member member1 = new Member("1@jbnu.ac.kr", "qwerty", "geonu1");
        Member member2 = new Member("2@jbnu.ac.kr", "qwerty", "geonu2");
        Member member3 = new Member("3@jbnu.ac.kr", "qwerty", "geonu3");

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        List<Member> result = memberRepository.findAll();

        assertThat(result.size()).isEqualTo(3);
        assertThat(result).contains(member1, member2, member3);
    }

    @Test
    void updateMember() {
        Member member = new Member("kgo0926@jbnu.ac.kr", "qwerty", "geonu");
        Member saved = memberRepository.save(member);
        Long memberId = saved.getId();

        MemberParameter memberParameter = new MemberParameter("kgo0926@jbnu.ac.kr", "1q2w3e", "geonu");
        memberRepository.update(memberId, memberParameter);

        Member findMember = memberRepository.findById(memberId);
        assertThat(findMember.getEmail()).isEqualTo(memberParameter.getEmail());
        assertThat(findMember.getPassword()).isEqualTo(memberParameter.getPassword());
        assertThat(findMember.getName()).isEqualTo(memberParameter.getName());
    }

}
