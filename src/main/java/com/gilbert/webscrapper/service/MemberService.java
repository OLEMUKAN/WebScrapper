package com.gilbert.webscrapper.service;

// MemberService.java
import com.gilbert.webscrapper.entity.Member;
import com.gilbert.webscrapper.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberScraperService scraperService;

    @Autowired
    private MemberRepository memberRepository;

    public void scrapeAndSaveMembers() throws IOException {
        List<Member> members = scraperService.scrapeMembers();
        memberRepository.saveAll(members);
    }
}
