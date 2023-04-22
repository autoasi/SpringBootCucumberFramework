package com.autoasi.springselenium.tests.propertiesTest;

import com.autoasi.springselenium.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class PropertiesLoaderTest extends SpringBaseTestNGTest {

    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    public void readPropertyValueTest() throws IOException {
        Properties properties = PropertiesLoaderUtils.loadProperties(resourceLoader.getResource("users.properties"));
        System.out.println(properties.getProperty("username"));
    }
}
