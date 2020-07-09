package com.ua.verdysh.model;

import lombok.Getter;
import lombok.Setter;

import java.util.StringJoiner;

@Getter
@Setter
public class Profile {
    private String url;
    private String fullName;
    private String jobTitle;
    private String phone;
    private String mail;
    private String address;
    private String description;
    private StringJoiner photo;
    private String education;
    private String vcfUrl;

    @Override
    public String toString() {
        return  "Name: " + getFullName() + "\n" +
                "Job title: " + getJobTitle() + "\n" +
                "Address: " + getAddress() + "\n" +
                "Description: " + getDescription() + "\n" +
                "Education: " + getEducation() + "\n" +
                "Mail: " + getMail() + "\n" +
                "Phone: " + getPhone() + "\n" +
                "Photo: " + getPhoto() + "\n" +
                "Url: " + getUrl() + "\n" +
                "VCF url: " + getVcfUrl();
    }
}
