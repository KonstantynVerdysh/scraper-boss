package com.ua.verdysh.controller.scraper.helper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ScraperHelper {

    private ScraperHelper() {}

    public static Document getDocument(String url) {
        try {
            return Jsoup.connect(url).get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
