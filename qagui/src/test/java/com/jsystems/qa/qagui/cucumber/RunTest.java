package com.jsystems.qa.qagui.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "classpath:com.jsystems.qa.qagui.cucumber",
        plugin = {"html:target/cucumber-html-report", "rerun:target/target.txt"},
        tags = {
                "@wordpress"
        }
)
public class RunTest {
}
