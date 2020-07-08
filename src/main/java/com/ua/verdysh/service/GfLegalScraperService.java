package com.ua.verdysh.service;

import com.ua.verdysh.controller.parser.interfaces.Parser;
import com.ua.verdysh.controller.scraper.intefaces.Scraper;

public class GfLegalScraperService extends ScraperService {
        public GfLegalScraperService(Scraper scraper, Parser parser, String url) {
            super(scraper, parser, url);
        }
}
