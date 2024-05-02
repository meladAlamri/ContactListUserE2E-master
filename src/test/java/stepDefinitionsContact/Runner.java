package stepDefinitionsContact;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {//report plugins
                "pretty",//prints colored logs to the console
                "html:target/reports/html-reports/default-cucumber-reports.html",//plugin used to generate reports in html format
                "json:target/reports/json-reports/cucumber1.json",//plugin used to generate reports in json format
                "junit:target/reports/xml-reports/cucumber1.xml",//plugin used to generate reports in xml format
                "rerun:target/failedRerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" //For Spark report
        },
        features = "src/test/resources/features",
        glue = "stepDefinitionsContact",
        tags = "@Contact",
        dryRun = false

)
public class Runner {}
