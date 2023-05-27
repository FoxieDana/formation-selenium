package io.github.foxiedana.automation.framework.webdriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverFactoryTest {

	private WebDriver sut;
	
	@BeforeEach
	void setUp() {
		sut = WebDriverFactory.getWebDriver();
	}
	
	@Test
	void shouldBeAbleToInstantiateAEdgeDriver() {
		String expectedCity = "Longueuil";
		assertTrue(sut instanceof EdgeDriver);
		sut.navigate().to("https://www.meteomedia.com/ca");
		sut.findElement(By.xpath("//input[@id='search']")).sendKeys(expectedCity + Keys.ENTER);
		assertTrue(sut.findElement(By.xpath("//div[@id='searchindex']//h2")).getText().contains(expectedCity)); 
	}
	
	@AfterEach
	void tearDown() {
		sut.quit();
	}
	
	
}
