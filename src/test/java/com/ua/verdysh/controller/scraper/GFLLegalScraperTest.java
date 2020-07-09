package com.ua.verdysh.controller.scraper;

import com.ua.verdysh.controller.parser.GFLegalParser;
import com.ua.verdysh.model.Profile;
import org.junit.jupiter.api.Test;

import static com.ua.verdysh.HashGenerator.generateHash;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GFLLegalScraperTest {

    private final DefaultScraper scraper = new DefaultScraper();
    private final GFLegalParser parser = new GFLegalParser();

    @Test
    void getProfile_returnProfileWithFilledFieldsWhenInputStringIsProfileUrl() {
        String profilePage = "https://www.gflegal.com/Attorneys/Ronald-E-Burton.html";
        Profile profile = scraper.getProfile(parser, profilePage);

        String expectedName = "Ronald E. Burton";
        String expectedJobTitle = null;
        String expectedAddress = "560 Lexington Avenue, 6th FloorNew YorkNY10022";
        String expectedDesc = "C1947DF426F89814E8A92F2C581D11BA";
        String expectedEducation = "Columbia Law School, J.D. 1991 Columbia College, B.A. 1987";
        String expectedMail = "rburton@gflegal.com";
        String expectedPhone = "212-891-9121";
        String expectedPhoto = "https://www.gflegal.com/images/2579187_1.jpg";
        String expectedUrl = "https://www.gflegal.com/Attorneys/Ronald-E-Burton.html";
        String expectedVcfUrl = null;

        assertEquals(expectedName, profile.getFullName());
        assertEquals(expectedJobTitle, profile.getJobTitle());
        assertEquals(expectedAddress, profile.getAddress());
        assertEquals(expectedDesc, generateHash(profile.getDescription()));
        assertEquals(expectedEducation, profile.getEducation());
        assertEquals(expectedMail, profile.getMail());
        assertEquals(expectedPhone, profile.getPhone());
        assertEquals(expectedPhoto, profile.getPhoto().toString());
        assertEquals(expectedUrl, profile.getUrl());
        assertEquals(expectedVcfUrl, profile.getVcfUrl());
    }
}
