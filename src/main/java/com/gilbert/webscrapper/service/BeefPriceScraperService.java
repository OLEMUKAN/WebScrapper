package com.gilbert.webscrapper.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

@Service
public class BeefPriceScraperService {

    public String scrapeBeefPrices() throws IOException {
        String url = "https://www.selinawamucii.com/insights/prices/uganda/beef/#retail-prices";
        Document doc = Jsoup.connect(url).get();

        // Identify the element containing the UGX beef price range
        Elements priceElements = doc.select("p"); // Adjust selector based on actual HTML structure
        String text = null;
        for (org.jsoup.nodes.Element priceElement : priceElements) {
            String currentText = priceElement.text().trim();
            if (currentText.contains("retail price range") && currentText.contains("Uganda Shilling")) {
                text = currentText;
                break;
            }
        }

        if (text != null) {
            // Split the text and return only the first occurrence of the desired phrase
            String[] parts = text.split("The retail price range in Uganda Shilling for beef is between", 2);
            if (parts.length > 1) {
                return parts[1].trim();
            }
        }

        return null;
    }
}




