package jbnu.ssad1.service.member;

import jbnu.ssad1.medel.dto.MemberParameter;
import jbnu.ssad1.medel.entity.Member;

import java.util.List;

public interface MemberService {

    boolean register(String email, String password, String name);

    boolean login(String email, String password);

    Member findMemberByEmail(String email);
}
