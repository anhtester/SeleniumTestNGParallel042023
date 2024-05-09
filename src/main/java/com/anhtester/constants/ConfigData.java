package com.anhtester.constants;

import com.anhtester.helpers.PropertiesHelper;

public class ConfigData {
//    public static String URL = "https://crm.anhtester.com/admin/authentication";
//    public static String EMAIL = "admin@example.com";
//    public static String PASSWORD = "123456";

    public static String URL = PropertiesHelper.getValue("URL");
    public static String EMAIL = PropertiesHelper.getValue("EMAIL");
    public static String PASSWORD = PropertiesHelper.getValue("PASSWORD");
}
