package org.stepdefinition;

import org.junit.Assert;
import org.utilities.BaseClass;
import org.utilities.FBPojo;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class ResetStepDefinition extends BaseClass{
	@When("User input the valid phone number")
	public void userInputTheValidPhoneNumber() {
		FBPojo pojo=new FBPojo();
		clickElement(pojo.getForgetBTn());
		setValues(pojo.getResetOptn(),"1234567890");
	}

	@When("Click the search button")
	public void clickTheSearchButton() {
		FBPojo pojo=new FBPojo();
		clickElement(pojo.getSubmitBtn());
	}

	@Then("Reset password page should open")
	public void resetPasswordPageShouldOpen() {
		FBPojo pojo=new FBPojo();
		explictWaitTitle(pojo.getWaitElementpss(), 25);
		Assert.assertTrue("Error occurecd", pageURL().contains("initiate"));
		System.out.println("Reset password page opened successfully");
	}

	@When("User input the valid Email id")
	public void userInputTheValidEmailId() {
		FBPojo pojo=new FBPojo();
		clickElement(pojo.getForgetBTn());
		setValues(pojo.getResetOptn(),"thiyagarajank1192@gmail.com");
	}
}
