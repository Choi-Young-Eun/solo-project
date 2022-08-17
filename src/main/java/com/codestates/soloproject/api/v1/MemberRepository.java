package com.codestates.soloproject.api.v1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {
    public List<Member> findAllByCompanyType(Long type);
}
