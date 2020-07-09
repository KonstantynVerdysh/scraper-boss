package com.ua.verdysh.controller;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class VcfParser {

    private static final String ADDRESS_MATCHER = "ADR;";
    private static final String MAIL_MATCHER = "EMAIL;";
    private static final String PHONE_MATCHER = "TEL;";
    private static final String TITLE_MATCHER = "TITLE:";

    private static final String ADDRESS_SEPARATOR = ":;;";
    private static final String DEFAULT_SEPARATOR = ":";

    private final String vcfUrl;

    public VcfParser(String vcfUrl) {
        this.vcfUrl = vcfUrl;
    }

    public String getPhone() {
        return cutElement(PHONE_MATCHER, DEFAULT_SEPARATOR);
    }

    public String getAddress() {
        return cutElement(ADDRESS_MATCHER, ADDRESS_SEPARATOR);
    }

    public String getMail() {
        return cutElement(MAIL_MATCHER, DEFAULT_SEPARATOR);
    }

    public String getTitle() {
        return cutElement(TITLE_MATCHER, DEFAULT_SEPARATOR);
    }

    private String cutElement(String matcher, String separator) {
        String[] vcfBody = UrlFileReader.readFromUrl(vcfUrl).split("\n");
        return Arrays.stream(vcfBody)
                .filter(v -> v.contains(matcher))
                .map(v -> StringUtils.substringAfterLast(v, separator))
                .findFirst()
                .orElse(StringUtils.EMPTY);
    }
}
