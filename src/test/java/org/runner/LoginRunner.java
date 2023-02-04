package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.utilities.JVMReport;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources",
				 glue = "org.stepdefinition",
				 dryRun = false,
				 tags= {"@Login"},
				 plugin= {"json:target\\Reports\\login.json" })

public class LoginRunner {
	@AfterClass
	public static void methid() {
		JVMReport r=new JVMReport();
		r.generateReport(System.getProperty("user.dir")+"\\target\\Reports\\login.json");	
	}
	
}