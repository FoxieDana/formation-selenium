package io.github.foxiedana.automation.framework.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
	
	public static WebDriver getWebDriver(Browser browser) {
		if (browser.equals(Browser.EDGE)) {
			return new EdgeDriver();
		}
		return new ChromeDriver();
	}
	
}
