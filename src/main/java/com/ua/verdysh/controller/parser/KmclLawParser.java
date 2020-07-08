package com.ua.verdysh.controller.parser;

import com.ua.verdysh.controller.VcfParser;
import com.ua.verdysh.controller.parser.interfaces.Parser;
import org.jsoup.nodes.TextNode;

import java.util.List;
import java.util.StringJoiner;

import static com.ua.verdysh.controller.parser.helper.ParserHelper.getElements;

public class KmclLawParser implements Parser {

    private static final String PROFILES_LINKS_SELECTOR = "a.attorney-thumb-image:nth-child(7)";
    private static final String FULL_NAME_SELECTOR = "h1.fl-heading > span.fl-heading-text";
    private static final String PHONE_SELECTOR = "div.phone-wrap > a";
    private static final String MAIL_SELECTOR = "div.email-wrap > a";
    private static final String ADDRESS_SELECTOR = "div[class*='uabb-dual-color-heading'] span.uabb-second-heading-text";
    private static final String DESCRIPTION_SELECTOR = " div.fl-module.fl-module-rich-text.fl-node-5e4495912d5aa " +
            "div.fl-module-content.fl-node-content div.fl-rich-text > p";
    private static final String PHOTO_SELECTOR = "div.attorney-single-image > img";
    private static final String EDUCATION_SELECTOR = "div.pp-accordion-item.pp-accordion-item-active div.pp-accordion-content.fl-clearfix div > p";
    private static final String VCF_URL_SELECTOR = "div.fl-button-wrap.fl-button-width-auto.fl-button-left > a.fl-button";

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
        return getVcfParser(html).getTitle();
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
        StringBuilder sb = new StringBuilder();
        for (TextNode s : getElements(html, ADDRESS_SELECTOR).textNodes()) {
            sb.append(s).append(",");
        }
        return sb.toString();
    }

    @Override
    public String getDescription(String html) {
        return getElements(html, DESCRIPTION_SELECTOR).text();
    }

    @Override
    public StringJoiner getPhoto(String html) {
        return new StringJoiner(" : ").add(getElements(html, PHOTO_SELECTOR).attr("src"));
    }

    @Override
    public String getEducation(String html) {
        return getElements(html, EDUCATION_SELECTOR).text();
    }

    @Override
    public String getVcfUrl(String html) {
        return getElements(html, VCF_URL_SELECTOR).attr("href");
    }

    private VcfParser getVcfParser(String html) {

        if (vcfParser != null) {
            return vcfParser;
        }
        return new VcfParser(getVcfUrl(html));
    }
}
