package com.ua.verdysh.controller.scraper;

import com.google.common.io.Resources;
import com.ua.verdysh.controller.parser.KutakRockParser;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static com.ua.verdysh.HashGenerator.generateHash;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class KutakRockScraperTest {

    private final KutakRockParser parser = new KutakRockParser();

    @Test
    void getProfile_returnFieldsWhenInputIsHtmlOfProfile() throws IOException {

        URL url = Resources.getResource("kutakrocktest.html");
        String html = Resources.toString(url, StandardCharsets.UTF_8);

        String expectedAddress = "234 East Millsap Road, Suite 200 Fayetteville, Arkansas 72703-4099 ";
        String expectedDesc = "Eric represents healthcare clients in connection with transactional, regulatory, and operational matters.";
        String expectedEducation = "1E669D095ACA9B0EC03A340D3F7D9A54";
        String expectedPhoto = "https://www.kutakrock.com/people/-/media/images/people/j/jackson-eric-d/highresolutionimagenew/ericjackson.jpg";
        String expectedUrl = "https://www.kutakrock.com/people/j/jackson-eric-d";

        assertTrue(html.contains(expectedUrl));
        assertEquals(expectedAddress, parser.getAddress(html));
        assertEquals(expectedDesc, parser.getDescription(html));
        assertEquals(expectedEducation, generateHash(parser.getEducation(html)));
        assertEquals(expectedPhoto, parser.getPhoto(html).toString());
    }
}
