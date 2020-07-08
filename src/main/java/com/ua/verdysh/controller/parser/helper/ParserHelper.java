package com.ua.verdysh.controller.parser.helper;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

public class ParserHelper {

    private ParserHelper() {}

    public static Elements getElements(String html, String selector) {
        return Jsoup.parse(html).select(selector);
    }
}
