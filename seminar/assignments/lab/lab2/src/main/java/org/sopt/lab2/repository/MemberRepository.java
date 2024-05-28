package org.sopt.lab2.repository;

import org.sopt.lab2.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
