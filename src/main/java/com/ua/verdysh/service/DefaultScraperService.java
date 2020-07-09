package com.ua.verdysh.service;

import com.ua.verdysh.controller.parser.Parser;
import com.ua.verdysh.controller.scraper.Scraper;

public class DefaultScraperService extends ScraperService {
    public DefaultScraperService(Scraper scraper, Parser parser, String url) {
        super(scraper, parser, url);
    }
}
