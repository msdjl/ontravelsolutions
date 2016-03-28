package com.ontravelsolutions.tutby.util;

import com.codeborne.selenide.Configuration;

public class Config {
    final public static String baseUrl = System.getProperty("selenide.baseUrl", "http://tut.by");
    final public static int timeout = Integer.decode(System.getProperty("selenide.timeout", "10000"));
    final public static String username = System.getProperty("credentials.usename", "somekindofuniqueaddress");
    final public static String password = System.getProperty("credentials.password", "topsecretpassword");

    static {
        initSelenideSettings();
    }

    private static void initSelenideSettings () {
        Configuration.baseUrl = baseUrl;
        Configuration.timeout = timeout;
    }
}