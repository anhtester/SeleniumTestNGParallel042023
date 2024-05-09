package com.anhtester.Bai27_ReadPropertiesFile;

import com.anhtester.constants.ConfigData;
import com.anhtester.helpers.PropertiesHelper;
import org.testng.annotations.Test;

public class DemoReadProperties {
    @Test
    public void testReadPropertiesFile() {
        PropertiesHelper.loadAllFiles();

        System.out.println(ConfigData.URL);
        System.out.println(PropertiesHelper.getValue("EMAIL"));
        System.out.println(PropertiesHelper.getValue("PASSWORD"));

        //Gộp nhiều file
        System.out.println(PropertiesHelper.getValue("key1"));
        System.out.println(PropertiesHelper.getValue("key2"));

        //Set file
        PropertiesHelper.setFile("src/test/resources/configs/configs.properties");
        PropertiesHelper.setValue("message", "Add customer successfully");
    }
}
