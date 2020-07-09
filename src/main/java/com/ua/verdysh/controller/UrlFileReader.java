package com.ua.verdysh.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlFileReader {

    private UrlFileReader() {}

    public static String readFromUrl(String urlStr) {

        StringBuilder result = new StringBuilder();
        URL url = getURL(urlStr);

        if (url != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line).append("\n");
                }
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        return result.toString();
    }

    private static URL getURL(String urlStr) {
        URL url = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        return url;
    }
}
