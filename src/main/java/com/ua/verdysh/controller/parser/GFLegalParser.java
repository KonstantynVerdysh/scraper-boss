package com.ua.verdysh.controller.parser;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static com.ua.verdysh.controller.parser.helper.ParserHelper.getElements;

public class GFLegalParser implements Parser {

    private static final String PROFILES_LINKS_SELECTOR = "div#content a[itemprop='Name']";
    private static final String FULL_NAME_SELECTOR = "#pageTitle";
    private static final String PHONE_SELECTOR = " div.attorneyProfilePhone";
    private static final String MAIL_SELECTOR = "div.attorneyProfileFax > a";
    private static final String ADDRESS_SELECTOR = "span.address > span.adr span";
    private static final String DESCRIPTION_SELECTOR = "div.attorneyProfileNarrative > p:nth-child(5)";
    private static final String PHOTO_SELECTOR = "img.attorneyProfilePhoto";
    private static final String EDUCATION_SELECTOR = "div.attorneyProfileNarrative > ul:nth-child(4) li";

    @Override
    public List<String> getProfilesLinks(String html) {
        return getElements(html, PROFILES_LINKS_SELECTOR).eachAttr("href").stream()
                .map(v -> "https://www.gflegal.com" + v)
                .collect(Collectors.toList());
    }

    @Override
    public String getFullName(String html) {
        return getElements(html, FULL_NAME_SELECTOR).text();
    }

    @Override
    public String getJobTitle(String html) {
        return null;
    }

    @Override
    public String getPhone(String html) {
        return getElements(html, PHONE_SELECTOR).text();
    }

    @Override
    public String getMail(String html) {
        return getElements(html, MAIL_SELECTOR).text();
    }

    @Override
    public String getAddress(String html) {
        StringBuilder result = new StringBuilder();
        getElements(html, ADDRESS_SELECTOR)
                .eachText()
                .forEach(result::append);
        return result.toString();
    }

    @Override
    public String getDescription(String html) {
        return getElements(html, DESCRIPTION_SELECTOR).text();
    }

    @Override
    public StringJoiner getPhoto(String html) {
        return new StringJoiner(" : ").add("https://www.gflegal.com" + getElements(html, PHOTO_SELECTOR).attr("src"));
    }

    @Override
    public String getEducation(String html) {
        return getElements(html, EDUCATION_SELECTOR).text();
    }

    @Override
    public String getVcfUrl(String html) {
        return null;
    }
}
