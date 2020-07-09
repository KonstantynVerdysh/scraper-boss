package com.ua.verdysh.controller.scraper;

import com.ua.verdysh.controller.parser.KaplanRiceParser;
import com.ua.verdysh.model.Profile;
import org.junit.jupiter.api.Test;

import static com.ua.verdysh.HashGenerator.generateHash;
import static org.junit.jupiter.api.Assertions.*;

public class KaplanRiceScraperTest {

    private final KaplanRiceScraper scraper = new KaplanRiceScraper();
    private final KaplanRiceParser parser = new KaplanRiceParser();

    @Test
    void getProfile_returnProfileWithFilledFieldsWhenInputStringIsProfileUrl() {
        String profilePage = "lawyers/anne-boken.html";
        Profile profile = scraper.getProfile(parser, profilePage);

        String expectedName = "Anne M. Boken";
        String expectedJobTitle = "Lawyers ";
        String expectedAddress = "142 West 57th Street\\nSuite 4A;New York;NY;10019;Unite";
        String expectedDesc = "E28ED4D6E6DA9ABBABD62448211953BE";
        String expectedEducation = "541ADA3C5EA52F43D68892F655ADFFBB";
        String expectedMail = "aboken@kaplanrice.com";
        String expectedPhone = "(212) 333-0266";
        String expectedPhoto = "null";
        String expectedUrl = "lawyers/anne-boken.html";
        String expectedVcfUrl = "http://www.kaplanrice.com/vcards/Anne%20M-%20Boken.vcf";

        assertEquals(expectedName, profile.getFullName());
        assertEquals(expectedJobTitle, profile.getJobTitle());
        assertEquals(expectedAddress, profile.getAddress());
        assertEquals(expectedDesc, generateHash(profile.getDescription()));
        assertEquals(expectedEducation, generateHash(profile.getEducation()));
        assertEquals(expectedMail, profile.getMail());
        assertEquals(expectedPhone, profile.getPhone());
        assertEquals(expectedPhoto, profile.getPhoto().toString());
        assertEquals(expectedUrl, profile.getUrl());
        assertEquals(expectedVcfUrl, profile.getVcfUrl());
    }
}
