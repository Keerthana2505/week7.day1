package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import stepDefs.ProjectSpecificMethod;

@CucumberOptions(features = "src/test/java/features", 
				 glue = "stepDefs",
				 monochrome = true,
				 publish = true)
public class RunCucumberTest extends ProjectSpecificMethod {

}