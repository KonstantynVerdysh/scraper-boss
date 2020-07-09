package com.ua.verdysh;

import org.apache.commons.codec.digest.DigestUtils;

public class HashGenerator {

    private HashGenerator() {}

    public static String generateHash(String text) {
        return DigestUtils.md5Hex(text).toUpperCase();
    }
}
