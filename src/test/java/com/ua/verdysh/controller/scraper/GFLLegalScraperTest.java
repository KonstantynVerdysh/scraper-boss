package com.ua.verdysh.controller.scraper;

import com.ua.verdysh.controller.parser.GFLegalParser;
import com.ua.verdysh.controller.parser.KaplanRiceParser;
import com.ua.verdysh.model.Profile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GFLLegalScraperTest {

    private final DefaultScraper scraper = new DefaultScraper();
    private final GFLegalParser parser = new GFLegalParser();

    @Test
    void getProfile_returnProfileWithFilledFieldsWhenInputStringIsProfileUrl() {
        String profilePage = "https://www.gflegal.com/Attorneys/Ronald-E-Burton.html";
        Profile profile = scraper.getProfile(parser, profilePage);

        System.out.println(profile);

        String expectedName = "Ronald E. Burton";
        String expectedJobTitle = null;
        String expectedAddress = "560 Lexington Avenue, 6th FloorNew YorkNY10022";
        String expectedDesc = "Ronald E. Burton has been with the firm since 1992 and became a partner in 2000. His practice emphasizes commercial leasing, acquisitions, and financings on behalf of such clients as Kaplan, Inc., L&M Development Partners, Inc. and Marmon Realty, LLC. Ron established and now manages the firm's telecommunications practice area. He is also responsible for overseeing the resolution of clients' landlord-tenant disputes. Ron is the immediate past President of the Westchester Jewish Council, the Jewish Community Relations Council of Westchester County. He also serves on the board of Solomon Schechter Westchester. Back in the day, Ron was the radio play-by-play announcer for the Columbia sports teams.";
        String expectedEducation = "Columbia Law School, J.D. 1991 Columbia College, B.A. 1987";
        String expectedMail = "rburton@gflegal.com";
        String expectedPhone = "212-891-9121";
        String expectedPhoto = "https://www.gflegal.com/images/2579187_1.jpg";
        String expectedUrl = "https://www.gflegal.com/Attorneys/Ronald-E-Burton.html";
        String expectedVcfUrl = null;

        assertEquals(expectedName, profile.getFullName());
        assertEquals(expectedJobTitle, profile.getJobTitle());
        assertEquals(expectedAddress, profile.getAddress());
        assertEquals(expectedDesc, profile.getDescription());
        assertEquals(expectedEducation, profile.getEducation());
        assertEquals(expectedMail, profile.getMail());
        assertEquals(expectedPhone, profile.getPhone());
        assertEquals(expectedPhoto, profile.getPhoto().toString());
        assertEquals(expectedUrl, profile.getUrl());
        assertEquals(expectedVcfUrl, profile.getVcfUrl());
    }
}
