package io.github.foxiedana.automation.framework.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverFactory {
	
	public static WebDriver getWebDriver() {
		return new EdgeDriver();
	}
	
}
