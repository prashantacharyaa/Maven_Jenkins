package maven;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Maven_Test {
	@Test(groups = "smoke")
	public void demo_Test() {
		Reporter.log("Hi", true);
	}

	@Test(groups = "Regression")
	public void create_Test() {
		Reporter.log("Good Morning", true);
	}

	@Test(groups = "Functional")
	public void delete_Test() {
		Reporter.log("Deleted");
	}

	@Test(groups = {"smoke","Regression"})
	public void modify_Test() {
		Reporter.log("Modified");
	}
}
