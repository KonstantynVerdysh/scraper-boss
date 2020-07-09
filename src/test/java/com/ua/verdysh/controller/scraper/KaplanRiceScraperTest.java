package com.ua.verdysh.controller.scraper;

import com.ua.verdysh.controller.parser.KaplanRiceParser;
import com.ua.verdysh.model.Profile;
import org.junit.jupiter.api.Test;

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
        String expectedDesc = "Anne Boken’s practice focuses on complex commercial litigation. She has represented individuals, corporations and financial institutions in a range of civil and commercial matters involving breach of contract, breach of fiduciary duty, securities, fraud, trade secrets, partnership rights, professional liability, and product liability.";
        String expectedEducation = "<p>Ms. Boken is a graduate of Vanderbilt University Law School and Saint Louis University. Prior to joining Kaplan Rice, Ms. Boken was an associate at a litigation boutique in New York, where her practice included complex civil and commercial litigation and cross-border disputes.</p>";
        String expectedMail = "aboken@kaplanrice.com";
        String expectedPhone = "(212) 333-0266";
        String expectedPhoto = "null";
        String expectedUrl = "lawyers/anne-boken.html";
        String expectedVcfUrl = "http://www.kaplanrice.com/vcards/Anne%20M-%20Boken.vcf";

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
