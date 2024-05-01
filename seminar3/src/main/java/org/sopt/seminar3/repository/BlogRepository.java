package org.sopt.seminar3.repository;

import org.sopt.seminar3.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Member, Long> {

}
