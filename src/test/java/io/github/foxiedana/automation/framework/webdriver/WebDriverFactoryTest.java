package io.github.foxiedana.automation.framework.webdriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverFactoryTest {

	private WebDriver sut;
	
	@BeforeEach
	void setUp() {

	}

	@ParameterizedTest
	@ValueSource(strings = { "EDGE", "CHROME" })
	void shouldBeAbleToInstantiateAWebDriver(String browser) {
		sut = WebDriverFactory.getWebDriver(Browser.valueOf(browser));
		String expectedCity = "Longueuil";
		assertTrue(sut instanceof WebDriver);
		sut.navigate().to("https://www.meteomedia.com/ca");
		sut.findElement(By.xpath("//input[@id='search']")).sendKeys(expectedCity + Keys.ENTER);
		assertTrue(sut.findElement(By.xpath("//div[@id='searchindex']//h2")).getText().contains(expectedCity)); 
	}
	
	@AfterEach
	void tearDown() {
		sut.quit();
	}
	
	
}
