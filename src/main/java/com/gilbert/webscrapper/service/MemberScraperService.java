package com.gilbert.webscrapper.service;// MemberScraperService.java
import com.gilbert.webscrapper.entity.Member;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberScraperService {

    private static final String URL = "https://ugandavetassociation.org/uva-members-list/";

    public List<Member> scrapeMembers() throws IOException {
        List<Member> members = new ArrayList<>();
        Document doc = Jsoup.connect(URL).get();
        Element table = doc.selectFirst("#tablepress-1");
        Elements rows = table.select("tbody > tr");

        for (Element row : rows) {
            Elements cols = row.select("td");
            Member member = new Member();
            member.setTitle(cols.get(0).text());
            member.setFirstName(cols.get(1).text());
            member.setLastName(cols.get(2).text());
            member.setOrganizationName(cols.get(3).text());
            member.setPostalAddress(cols.get(4).text());
            member.setServiceType(cols.get(5).text());
            member.setGender(cols.get(6).text());
            member.setCountryRegion(cols.get(7).text());
            member.setMobilePhone(cols.get(8).text());
            members.add(member);
        }

        return members;
    }
}
