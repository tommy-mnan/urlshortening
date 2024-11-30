package com.test.urlshortening.util;

public class ShorteningUtil {

    public static final String ALPHABET = "xuzdra316OMheo9PI2qNs5Q4YKGLS7lmRbtCyFjkDVUZpXHvwAEWJigf80TBnc";
    public static final int BASE = ALPHABET.length();


    /**
     * @param num Base10 number of type Long
     * @return base62 encoded string representation of input Long
     */
    public static String idToStr(Long num) {
        StringBuilder str = new StringBuilder();
        while (num > 0) {
            str.insert(0, ALPHABET.charAt((int) (num % BASE)));
            num = num / BASE;
        }
        return str.toString();
    }

}
