package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	WebDriver driver;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;// pointing towards same addr
		PageFactory.initElements(driver, this);// initilizes @FindBy
	}

	@FindBy(id = "headlessui-menu-button-:r2:")
	private WebElement User_Icon;

	@FindBy(xpath = "//button[text() = 'Sign out']")
	private WebElement Sign_Out;

	public WebElement getUser_Icon() {
		return User_Icon;
	}

	public WebElement getSign_Out() {
		return Sign_Out;
	}

	public void Logout() {
		User_Icon.click();
		Sign_Out.click();
	}
}
