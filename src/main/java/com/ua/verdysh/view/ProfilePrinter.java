package com.ua.verdysh.view;

import com.ua.verdysh.model.Profile;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class ProfilePrinter {

    private static final String PROFILE_DELIMITER = "================================================================";

    private ProfilePrinter() {}

    public static void printFields(String website, List<Profile> profiles) {
        print("**********     " + cutWebsiteName(website).toUpperCase() + "     **********");
        print(StringUtils.EMPTY);
        for (Profile profile : profiles) {
            print(profile.toString());
            print(PROFILE_DELIMITER);
        }
        print(StringUtils.EMPTY);
        print(StringUtils.EMPTY);
        print(StringUtils.EMPTY);
    }

    private static String cutWebsiteName(String website) {
        return StringUtils.substringBetween(website, "www.", ".");
    }

    private static void print(String line) {
        System.out.println(line);
    }
}
