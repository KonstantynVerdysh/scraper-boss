package com.ua.verdysh.controller.parser;

import com.ua.verdysh.controller.VcfParser;

import java.util.List;
import java.util.StringJoiner;

import static com.ua.verdysh.controller.parser.helper.ParserHelper.getElements;

public class KaplanRiceParser implements Parser {

    private static final String PROFILES_LINKS_SELECTOR = "#interior-sidebar p.sidebar-heading2 a";
    private static final String FULL_NAME_SELECTOR = "h2";
    private static final String JOB_TITLE_SELECTOR = "h1";
    private static final String DESCRIPTION_SELECTOR = "div:nth-child(3) > p:nth-child(3)";
    private static final String EDUCATION_SELECTOR = "div:nth-child(3) > p:nth-child(4)";
    private static final String VCF_URL_SELECTOR = "a:nth-child(3)";

    private VcfParser vcfParser;

    @Override
    public List<String> getProfilesLinks(String html) {
        return getElements(html, PROFILES_LINKS_SELECTOR).eachAttr("href");
    }

    @Override
    public String getFullName(String html) {
        return getElements(html, FULL_NAME_SELECTOR).text();
    }

    @Override
    public String getJobTitle(String html) {
        return getElements(html, JOB_TITLE_SELECTOR).textNodes().get(0).getWholeText();
    }

    @Override
    public String getPhone(String html) {
        return getVcfParser(html).getPhone();
    }

    @Override
    public String getMail(String html) {
        return getVcfParser(html).getMail();
    }

    @Override
    public String getAddress(String html) {
        return getVcfParser(html).getAddress();
    }

    @Override
    public String getDescription(String html) {
        return getElements(html, DESCRIPTION_SELECTOR).textNodes().get(0).getWholeText();
    }

    @Override
    public StringJoiner getPhoto(String html) {
        return new StringJoiner(" : ").add(null);
    }

    @Override
    public String getEducation(String html) {
        return getElements(html, EDUCATION_SELECTOR).outerHtml();
    }

    @Override
    public String getVcfUrl(String html) {
        return replaceWhitespaces("http://www.kaplanrice.com/" + getElements(html, VCF_URL_SELECTOR).attr("href").substring(3));
    }

    private String replaceWhitespaces(String str) {
        return str.replace(" ", "%20");
    }

    private VcfParser getVcfParser(String html) {

        if (vcfParser != null) {
            return vcfParser;
        } else
            vcfParser = new VcfParser(getVcfUrl(html));

        return vcfParser;
    }
}
