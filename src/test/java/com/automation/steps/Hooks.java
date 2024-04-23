package com.automation.steps;

import com.automation.utils.ConfigReaderUtils;
import com.automation.utils.DriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        DriverUtils.createDriver();
        ConfigReaderUtils.initProperties();
    }

    @After
    public void tearDown() {
        DriverUtils.getDriver().quit();
    }

}
