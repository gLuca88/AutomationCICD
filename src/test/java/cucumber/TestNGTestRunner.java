package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber", glue = "gianluca.stepDefinition", monochrome = true,
tags="@Regression",plugin = {
		"html:target/cucumber.html" }) // dato che cucumeber da dei log non leggibili con monochrome gli rendiamo // leggibili										
public class TestNGTestRunner extends AbstractTestNGCucumberTests { // poi abbiamo aggiinto il plugin per un report
																	// formato html
	// estende questa classe per integrare i metodi testNG

}
