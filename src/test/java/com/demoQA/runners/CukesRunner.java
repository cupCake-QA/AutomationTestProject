package com.demoQA.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                  "html:target/default-html-reports",
                "rerun:target/rerun.txt"},

        features = "src/test/resources/features/",
        glue = "com/demoQA/step_definitions",
        tags = "@test1-2 or @test3",
        dryRun = false

)
public class CukesRunner {


}

