package com.ua.verdysh.controller;

import com.ua.verdysh.controller.parser.GFLegalParser;
import com.ua.verdysh.controller.parser.KaplanRiceParser;
import com.ua.verdysh.controller.parser.KmclLawParser;
import com.ua.verdysh.controller.scraper.DefaultScraper;
import com.ua.verdysh.controller.scraper.KaplanRiceScraper;
import com.ua.verdysh.service.*;

import static com.ua.verdysh.model.Website.*;

public class ScraperFactory {

    private ScraperFactory() {}

    public static ScraperService getScraperService(String url) {

        switch (url) {
            case KAPLAN_RICE_URL:
                return new DefaultScraperService(new KaplanRiceScraper(), new KaplanRiceParser(), url);
            case KMCL_LAW_URL:
                return new DefaultScraperService(new DefaultScraper(), new KmclLawParser(), url);
            case GF_LEGAL_URL:
                return new DefaultScraperService(new DefaultScraper(), new GFLegalParser(), url);

            default:
                return new DefaultScraperService(null, null ,null);
        }
    }
}
