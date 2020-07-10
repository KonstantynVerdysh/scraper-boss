package com.ua.verdysh;

import com.ua.verdysh.view.ProfilePrinter;
import com.ua.verdysh.controller.ScraperFactory;
import com.ua.verdysh.model.Profile;
import com.ua.verdysh.controller.ScraperService;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.ua.verdysh.model.Website.*;

public class Main {
    public static void main(String[] args) {

        List<String> websites = Arrays.asList(
//                KAPLAN_RICE_URL,
//                KMCL_LAW_URL,
//                GF_LEGAL_URL,
                KUTAK_ROCK_URL);

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
