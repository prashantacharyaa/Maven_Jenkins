package com.rocstar;

import org.testng.Reporter;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class FirstTest extends BaseClass {
	@Test
	public void First_TestCase() throws InterruptedException {
		Reporter.log("First Rocstar Automated Test Case", true);
		Thread.sleep(5000);
	}
}
