package com.RestAssured.TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "FeatureFiles",glue="com.RestAssured.StepDefinitionFile",
plugin= {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"},tags= {"@tag2"})
public class testrunner {

} 
