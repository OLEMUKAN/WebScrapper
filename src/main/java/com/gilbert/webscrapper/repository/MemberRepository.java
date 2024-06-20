package com.gilbert.webscrapper.repository;

import com.gilbert.webscrapper.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
