package com.ua.verdysh.controller.scraper;

import com.ua.verdysh.controller.parser.Parser;
import com.ua.verdysh.model.Profile;
import com.ua.verdysh.model.Website;
import org.apache.commons.lang3.StringUtils;

public class KaplanRiceScraper extends AbstractScraper {

    @Override
    public Profile getProfile(Parser parser, String link){

        Profile profile = new Profile();
        String profileHtml = getPageHtml(assignUrl(Website.KAPLAN_RICE_URL, link, "lawyers.html"));

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

        return profile;
    }

    public static String assignUrl(String mainUrl, String assignUrl, String separator) {
        return StringUtils.substringBefore(mainUrl, separator) + assignUrl;
    }
}
