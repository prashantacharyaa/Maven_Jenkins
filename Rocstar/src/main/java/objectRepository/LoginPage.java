package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;// pointing towards same addr
		PageFactory.initElements(driver, this);// initilizes @FindBy
	}

	@FindBy(xpath = "//button[text() = 'Sign in']")
	private WebElement Sign_In;
	@FindBy(id = "email-address")
	private WebElement Email;
	@FindBy(id = "password")
	private WebElement Password;
	@FindBy(xpath = "//button[@type = 'submit']")
	private WebElement Sign_In_Btn;
	@FindBy (linkText = "Forgot password?")
	private WebElement ForgotPassword;
	
	public WebElement getSign_In() {
		return Sign_In;
	}
	public WebElement getEmail() {
		return Email;
	}
	public WebElement getPassword() {
		return Password;
	}
	public WebElement getSign_In_Btn() {
		return Sign_In_Btn;
	}
	public WebElement getForgotPassword() {
		return ForgotPassword;
	}
	
	public void Login(String email, String password) {
		Sign_In.click();
		Email.sendKeys(email);
		Password.sendKeys(password);
		Sign_In_Btn.click();
	}
	
	
}
