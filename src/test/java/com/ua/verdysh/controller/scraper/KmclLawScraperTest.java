package com.ua.verdysh.controller.scraper;

import com.ua.verdysh.controller.parser.KmclLawParser;
import com.ua.verdysh.model.Profile;
import org.junit.jupiter.api.Test;

import static com.ua.verdysh.HashGenerator.generateHash;
import static org.junit.jupiter.api.Assertions.*;

class KmclLawScraperTest {

    private final DefaultScraper scraper = new DefaultScraper();
    private final KmclLawParser parser = new KmclLawParser();

    @Test
    void getProfile_returnProfileWithFilledFieldsWhenInputStringIsProfileUrl() {
        String profilePage = "https://www.kmcllaw.com/attorney/d-bart-turner/";
        Profile profile = scraper.getProfile(parser, profilePage);

        String expectedName = "D. Bart Turner";
        String expectedJobTitle = "Partner";
        String expectedAddress = "3008 7th Avenue South  Birmingham, AL 35233";
        String expectedDesc = "3B0A4268F0140961C9185D22864724FA";
        String expectedEducation = "1E3267706C72D29B4EF1097235D2A69A";
        String expectedMail = "bturner@kmcllaw.com";
        String expectedPhone = "205-767-8870";
        String expectedPhoto = "https://www.kmcllaw.com/wp-content/uploads/2019/03/BartRESIZE.jpg";
        String expectedUrl = "https://www.kmcllaw.com/attorney/d-bart-turner/";
        String expectedVcfUrl = "https://www.kmcllaw.com/wp-content/uploads/2019/05/Bart-Turner.vcf";

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