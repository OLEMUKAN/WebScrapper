package com.gilbert.webscrapper.controller;

import com.gilbert.webscrapper.service.BeefPriceScraperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class BeefPriceController {

    private final BeefPriceScraperService beefPriceScraperService;

    public BeefPriceController(BeefPriceScraperService beefPriceScraperService) {
        this.beefPriceScraperService = beefPriceScraperService;
    }

    @GetMapping("/beef-prices")
    public String getBeefPrices() throws IOException {
        String priceRange = beefPriceScraperService.scrapeBeefPrices();
        if (priceRange != null) {
            // Return the data in the desired format
            return "The retail price range in Uganda Shilling for beef is between " + priceRange;
        } else {
            return "Unable to scrape beef price data";
        }
    }
}
