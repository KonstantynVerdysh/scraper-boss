package com.ua.verdysh;

import com.ua.verdysh.view.ProfilePrinter;
import com.ua.verdysh.controller.ScraperFactory;
import com.ua.verdysh.model.Profile;
import com.ua.verdysh.model.Website;
import com.ua.verdysh.service.ScraperService;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        List<String> websites = Arrays.asList(
                Website.KAPLAN_RICE_URL,
                Website.KMCL_LAW_URL,
                Website.GF_LEGAL_URL);

        ExecutorService executor = Executors.newFixedThreadPool(websites.size());

        for (String website : websites) {
            executor.submit(() -> {
                ScraperService service = ScraperFactory.getScraperService(website);
                List<Profile> profiles = service.scrape();
                ProfilePrinter.printFields(website, profiles);
            });
        }

        executor.shutdown();
    }
}
