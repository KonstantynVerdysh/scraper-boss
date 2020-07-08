package com.ua.verdysh.service;

import com.ua.verdysh.controller.parser.interfaces.Parser;
import com.ua.verdysh.controller.scraper.intefaces.Scraper;

public class KaplanRiceScraperService extends ScraperService {
    public KaplanRiceScraperService(Scraper scraper, Parser parser, String url) {
        super(scraper, parser, url);
    }
}
