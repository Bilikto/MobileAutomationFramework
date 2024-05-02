package com.automation.steps;

import com.automation.utils.ConfigReaderUtils;
import com.automation.utils.DriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;

public class Hooks {

    @Before
    public void setUp() throws MalformedURLException {
        ConfigReaderUtils.initProperties();

        //Jenkins parameter
        String environment = System.getProperty("execution.platform");

        // if we do not get parameters from Jenkins, consider config file parameter
        if(environment == null) {
            environment = ConfigReaderUtils.getProperty("execution.platform");
        }

        if(environment.equals("local")) {
            DriverUtils.createLocalDriver();
        } else {
            DriverUtils.createBrowserStackDriver();
        }
    }

    @After
    public void tearDown() {
//        DriverUtils.getDriver().quit();
    }

}
