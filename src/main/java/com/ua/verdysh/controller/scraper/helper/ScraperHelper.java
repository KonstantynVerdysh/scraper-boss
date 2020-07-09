package com.ua.verdysh.controller.scraper.helper;

import com.ua.verdysh.controller.exceptions.InvalidURLException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ScraperHelper {

    private ScraperHelper() {}

    public static Document getDocument(String url) throws InvalidURLException {
        try {
            if (url != null) {
                return Jsoup.connect(url).get();
            } else
                throw new InvalidURLException("Invalid URL");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
