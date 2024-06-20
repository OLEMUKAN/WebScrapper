package com.gilbert.webscrapper.controller;// MemberController.java
import com.gilbert.webscrapper.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/scrape-and-save")
    public String scrapeAndSaveMembers() {
        try {
            memberService.scrapeAndSaveMembers();
            return "Data scraped and saved successfully!";
        } catch (IOException e) {
            return "Error occurred: " + e.getMessage();
        }
    }
}
