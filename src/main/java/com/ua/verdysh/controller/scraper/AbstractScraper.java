package com.ua.verdysh.controller.scraper;

import com.ua.verdysh.controller.parser.Parser;
import com.ua.verdysh.controller.scraper.helper.ScraperHelper;
import com.ua.verdysh.model.Profile;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractScraper implements Scraper {

    @Override
    public String getPageHtml(String url) {
        return ScraperHelper.getDocument(url).html();
    }

    @Override
    public List<Profile> scrapeProfiles(Parser parser, String url) {

        List<Profile> profiles = new ArrayList<>();
        String mainPageHtml = getPageHtml(url);
        List<String> links = parser.getProfilesLinks(mainPageHtml);
        for (String link : links) {
            Profile profile = getProfile(parser, link);
            profiles.add(profile);
        }
        return profiles;
    }

    @Override
    public Profile getProfile(Parser parser, String link) {

        Profile profile = new Profile();
        try {
            String profileHtml = Jsoup.connect(link).get().html();
            profile.setUrl(link);
            profile.setFullName(parser.getFullName(profileHtml));
            profile.setJobTitle(parser.getJobTitle(profileHtml));
            profile.setPhone(parser.getPhone(profileHtml));
            profile.setMail(parser.getMail(profileHtml));
            profile.setAddress(parser.getAddress(profileHtml));
            profile.setDescription(parser.getDescription(profileHtml));
            profile.setPhoto(parser.getPhoto(profileHtml));
            profile.setEducation(parser.getEducation(profileHtml));
            profile.setVcfUrl(parser.getVcfUrl(profileHtml));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(StringUtils.EMPTY);
        }
        return profile;
    }
}
