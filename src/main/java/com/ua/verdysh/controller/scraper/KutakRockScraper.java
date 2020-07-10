package com.ua.verdysh.controller.scraper;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ua.verdysh.controller.parser.Parser;
import com.ua.verdysh.model.Profile;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class KutakRockScraper extends DefaultScraper {

    @Override
    public List<Profile> scrapeProfiles(Parser parser, String url) {

        List<Profile> profiles = new ArrayList<>();

        try {
            String json = getJSONBody();

            List<String> links = getJSONField(json, "url");
            List<String> names = getJSONField(json, "fullName");
            List<String> jobTitle = getJSONField(json, "title");
            List<String> mails = getJSONField(json, "emailAddress");
            List<String> phones = getJSONField(json, "phoneNumber");

            for (int count = 0; count < links.size(); count++) {
                Profile profile = getProfile(parser, links.get(count));
                profile.setFullName(names.get(count));
                profile.setJobTitle(jobTitle.get(count));
                profile.setMail(mails.get(count));
                profile.setPhone(phones.get(count));
                profiles.add(profile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return profiles;
    }

    @Override
    public Profile getProfile(Parser parser, String link) {

        Profile profile = new Profile();
        String url = "https://www.kutakrock.com" + link;

        try {
            String profileHtml = Jsoup.connect(url).get().html();
            profile.setUrl(url);
            profile.setPhoto(parser.getPhoto(profileHtml));
            profile.setDescription(parser.getDescription(profileHtml));
            profile.setAddress(parser.getAddress(profileHtml));
            profile.setEducation(parser.getEducation(profileHtml));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error");
        }
        return profile;
    }

    private static String getJSONBody() throws IOException {

        OkHttpClient.Builder client = new OkHttpClient().newBuilder();
        client.readTimeout(30, TimeUnit.SECONDS);

        Request request = new Request.Builder()
                .url("https://www.kutakrock.com/sitecore/api/ssc/webapi/peoplesearch/1/search?page=1000000")
                .method("GET", null)
                .addHeader("Connection", "keep-alive")
                .addHeader("Accept", "application/json, text/plain, */*")
                .build();

        ResponseBody response = client.build().newCall(request).execute().body();

        if (response != null) {
            return response.string();
        }

        return StringUtils.EMPTY;
    }

    private static List<String> getJSONField(String json, String field) {
        List<String> result = new ArrayList<>();

        JsonElement jElem = new JsonParser().parse(json);
        JsonObject jObj = jElem.getAsJsonObject();
        JsonArray jArr = jObj.getAsJsonArray("results");
        for (JsonElement element : jArr) {
            JsonObject iObj = element.getAsJsonObject();

            if (field.equals("phoneNumber")) {
                result.add(iObj.get(field).toString().replace("\"", ""));
            } else
                result.add(iObj.get(field).getAsString());
        }
        return result;
    }
}
