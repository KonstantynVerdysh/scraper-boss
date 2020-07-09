package com.ua.verdysh.view;

import com.ua.verdysh.model.Profile;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class ProfilePrinter {

    private static final String PROFILE_DELIMITER = "================================================================";

    private ProfilePrinter() {}

    public static void printFields(String website, List<Profile> profiles) {
        print("**********     " + StringUtils.substringBetween(website, "www.", ".").toUpperCase() + "     **********");
        print(StringUtils.EMPTY);
        for (Profile profile : profiles) {
            print("Name: " + profile.getFullName());
            print("Job title: " + profile.getJobTitle());
            print("Address: " + profile.getAddress());
            print("Description: " + profile.getDescription());
            print("Education: " + profile.getEducation());
            print("Mail: " + profile.getMail());
            print("Phone: " + profile.getPhone());
            print("Photo: " + profile.getPhoto());
            print("Url: " + profile.getUrl());
            print("VCF url: " + profile.getVcfUrl());
            print(PROFILE_DELIMITER);
        }
        print(StringUtils.EMPTY);
        print(StringUtils.EMPTY);
        print(StringUtils.EMPTY);
    }

    private static void print(String line) {
        System.out.println(line);
    }
}
