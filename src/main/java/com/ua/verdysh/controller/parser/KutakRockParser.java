package com.ua.verdysh.controller.parser;

import com.ua.verdysh.controller.scraper.helper.ScraperHelper;

import java.util.ArrayList;
import java.util.List;

import java.util.StringJoiner;

import static com.ua.verdysh.controller.parser.helper.ParserHelper.getElements;

public class KutakRockParser implements Parser {

    private static final String ADDRESS_SELECTOR = "div.hero__column > a.hero__link.link--white-to-clear.link:nth-child(1)";
    private static final String DESCRIPTION_SELECTOR = "h2.hero__paragraph";
    private static final String PHOTO_SELECTOR = "div.svg__canvas svg image";
    private static final String EDUCATION_SELECTOR = "div.side-accordion:nth-child(1)  ul li";

    @Override
    public List<String> getProfilesLinks(String html) {
        return new ArrayList<>();
    }

    @Override
    public String getFullName(String html) {
        return null;
    }

    @Override
    public String getJobTitle(String html) {
        return null;
    }

    @Override
    public String getPhone(String html) {
        return null;
    }

    @Override
    public String getMail(String html) {
        return null;
    }

    @Override
    public String getAddress(String html) {

        StringBuilder result = new StringBuilder();
        String addressInnerSelector = "div.hero__column > a p";

        for (String reUrl : getElements(html, ADDRESS_SELECTOR).eachAttr("href")) {
            String absUrl = "https://www.kutakrock.com/" + reUrl;
            String innerHtml = ScraperHelper.getDocument(absUrl).html();
            getElements(innerHtml, addressInnerSelector).eachText()
                    .forEach(v -> result.append(v).append(" "));
        }

        return result.toString();
    }

    @Override
    public String getDescription(String html) {
        return getElements(html, DESCRIPTION_SELECTOR).text();
    }

    @Override
    public StringJoiner getPhoto(String html) {
        return new StringJoiner(" : ").add("https://www.kutakrock.com/people" + getElements(html, PHOTO_SELECTOR).attr("xlink:href"));
    }

    @Override
    public String getEducation(String html) {
        StringBuilder result = new StringBuilder();
        for (String s : getElements(html, EDUCATION_SELECTOR).eachText()) {
            result.append(s);
        }
        return result.toString();
    }

    @Override
    public String getVcfUrl(String html) {
        return null;
    }
}
