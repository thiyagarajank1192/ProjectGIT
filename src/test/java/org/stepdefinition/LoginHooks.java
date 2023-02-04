package org.stepdefinition;

import java.io.IOException;

import org.utilities.BaseClass;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class LoginHooks extends BaseClass {
	@Before
	public void beforeMethod() throws IOException {
		setSheet("E:\\KTR\\Git project\\target\\Test data\\cuc.xlsx", "FB");
		launchChromeBrowser();
		launchURL("https://www.facebook.com/");
	}
	@After
	public void afterMethod(Scenario s) throws IOException {
		if(s.isFailed())
			s.embed(ScreenShot(), s.getName());
			
		closeWindow();
	}
}