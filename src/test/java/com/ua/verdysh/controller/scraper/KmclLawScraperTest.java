package com.ua.verdysh.controller.scraper;

import com.ua.verdysh.controller.parser.KmclLawParser;
import com.ua.verdysh.model.Profile;
import org.junit.jupiter.api.Test;

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
        String expectedDesc = "Bart's primary practice areas are environmental and toxic tort litigation, as well as " +
                "regulatory compliance. He practices in all areas of environmental law and routinely handles toxic " +
                "tort, hazardous waste, and Superfund litigation along with state and federal enforcement actions. " +
                "In addition, he has substantial experience in defending citizen suits brought under the Clean Water Act, " +
                "Clean Air Act and the Resource Conservation and Recovery Act. He also regularly advises multiple industries " +
                "on environmental compliance, work place exposure, permitting issues before the U.S. EPA, OSHA and the various " +
                "state and local regulatory agencies. Bart has handled numerous compliance and enforcement matters before EPA, " +
                "OSHA, state and local environmental agencies including administrative litigation and the negotiations of " +
                "administrative consent orders. In addition, Bart routinely assists clients in the course of transactions " +
                "concerning environmental risk allocation, post-closing corrective actions, permitting requirements and " +
                "related regulatory approvals.";
        String expectedEducation = "Bart is a former associate and shareholder with Maynard, Cooper & Gale. He played " +
                "Varsity Soccer and was a Pew Grant Research Fellow at Rhodes College before studying Environmental " +
                "Toxicology at UAB. He received his J.D. from the Vermont School of Law where he was an Article Editor " +
                "for the Vermont Law review and a Dean's Fellow.";
        String expectedMail = "bturner@kmcllaw.com";
        String expectedPhone = "205-767-8870";
        String expectedPhoto = "https://www.kmcllaw.com/wp-content/uploads/2019/03/BartRESIZE.jpg";
        String expectedUrl = "https://www.kmcllaw.com/attorney/d-bart-turner/";
        String expectedVcfUrl = "https://www.kmcllaw.com/wp-content/uploads/2019/05/Bart-Turner.vcf";

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

    @Test
    void getProfile_throwExceptionWhenInputStringIsNull() {

        IllegalArgumentException expectedException = assertThrows(IllegalArgumentException.class,
                () -> scraper.getProfile(parser, null));

        assertTrue(expectedException.getMessage().contains("Must supply a valid URL"));
    }
}