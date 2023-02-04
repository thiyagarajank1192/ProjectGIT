package org.stepdefinition;

import org.junit.Assert;
import org.utilities.BaseClass;
import org.utilities.FBPojo;
import io.cucumber.java.en.*;
public class LoginStepDefinition extends BaseClass{

	@When("Input the invalid username and password in their respective fields")
	public void input_the_invalid_username_and_password_in_their_respective_fields() {
		FBPojo pojo=new FBPojo();
		setValues(pojo.getUsrName(),getData(1, 0) );
		setValues(pojo.getUsrPswrd(), getData(1, 1));
	}

	@When("Click the Login button")
	public void click_the_Login_button() {
		FBPojo pojo=new FBPojo();
		clickElement(pojo.getLoginBtn());
	}

	@Then("Invaid login credentials page should open")
	public void invaid_login_credentials_page_should_open() throws InterruptedException {
		FBPojo pojo=new FBPojo();
		try {
			explictWaitTitle(pojo.getWaitElement(), 25);
		}catch (Exception e) {
		}
		Assert.assertTrue("Error with login cretinals", pageTitle().startsWith("Log"));
		System.out.println("Successfully redirected to error page");
	}
	@When("Input the invalid username and valid password in their respective fields")
	public void input_the_invalid_username_and_valid_password_in_their_respective_fields() {
		FBPojo pojo=new FBPojo();
		setValues(pojo.getUsrName(),getData(2, 0) );
		setValues(pojo.getUsrPswrd(), getData(2, 1));
	}

	@When("Input the valid username and invalid password in their respective fields")
	public void input_the_valid_username_and_invalid_password_in_their_respective_fields() {
		FBPojo pojo=new FBPojo();
		setValues(pojo.getUsrName(),getData(3, 0) );
		setValues(pojo.getUsrPswrd(), getData(3, 1));
	}
}
