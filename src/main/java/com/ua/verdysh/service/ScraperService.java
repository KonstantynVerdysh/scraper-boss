package com.ua.verdysh.service;

import com.ua.verdysh.controller.parser.interfaces.Parser;
import com.ua.verdysh.controller.scraper.intefaces.Scraper;
import com.ua.verdysh.model.Profile;

import java.util.List;

public abstract class ScraperService {

    private final Scraper scraper;
    private final Parser parser;
    private final String url;

    public ScraperService(Scraper scraper, Parser parser, String url) {
        this.scraper = scraper;
        this.parser = parser;
        this.url = url;
    }

    public List<Profile> scrape() {
        return scraper.scrapeProfiles(parser, url);
    }
}
