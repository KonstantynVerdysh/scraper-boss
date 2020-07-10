package com.ua.verdysh.controller.parser;

import java.util.List;
import java.util.StringJoiner;

public interface Parser {

    List<String> getProfilesLinks(String html);
    String getFullName(String html);
    String getJobTitle(String html);
    String getPhone(String html);
    String getMail(String html);
    String getAddress(String html);
    String getDescription(String html);
    StringJoiner getPhoto(String html);
    String getEducation(String html);
    String getVcfUrl(String html);
}
