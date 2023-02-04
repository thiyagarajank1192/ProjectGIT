package org.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class FBPojo {
	public FBPojo() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	@FindBy(id="email")
	private WebElement usrName;
	@FindBy(id="pass")
	private WebElement usrPswrd;
	@FindBy(xpath="//button[@name='login']")
	private WebElement loginBtn;
	@FindBy(xpath="(//a[@role='button'])[2]")
	private WebElement createBtn;
	@FindBy(xpath="//a[contains(text(),'Forgotten')]")
	private WebElement forgetBTn;
	@FindBy(xpath = "//div[contains(text(),'Facebook')]")
	private WebElement waitElement;
	@FindBy(id="identify_email")
	private WebElement resetOptn;
	@FindBy(id="did_submit")
	private WebElement submitBtn;
	@FindBy(xpath="(//h2[text()='Reset Your Password'])[2]")
	private WebElement waitElementpss;
	public WebElement getResetOptn() {
		return resetOptn;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public WebElement getWaitElementpss() {
		return waitElementpss;
	}
	public WebElement getWaitElement() {
		return waitElement;
	}
	public WebElement getUsrName() {
		return usrName;
	}
	public WebElement getUsrPswrd() {
		return usrPswrd;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public WebElement getCreateBtn() {
		return createBtn;
	}
	public WebElement getForgetBTn() {
		return forgetBTn;
	}
	
}
