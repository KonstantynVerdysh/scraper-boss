package com.ua.verdysh.controller.scraper.helper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ScraperHelper {

    private ScraperHelper() {}

    public static Document getDocument(String url) {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid URL");
        }
    }
}
