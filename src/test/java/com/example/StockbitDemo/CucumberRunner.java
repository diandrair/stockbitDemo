package com.example.StockbitDemo;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        strict = true,
        features = "classpath:feature",
        glue = "com.example.StockbitDemo.StepDefinitions",
        tags = { "@loginEmail"},
        plugin = {
                "pretty",
                "html:/Users/diandrair/Documents/demo/"
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
