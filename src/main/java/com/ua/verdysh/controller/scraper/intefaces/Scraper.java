package com.ua.verdysh.controller.scraper.intefaces;

import com.ua.verdysh.controller.parser.interfaces.Parser;
import com.ua.verdysh.model.Profile;

import java.util.List;

public interface Scraper {
    String getPageHtml(String url);
    List<Profile> scrapeProfiles(Parser parser, String url);
    Profile getProfile(Parser parser, String link);
}
