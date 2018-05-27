package com.algaworks.algamoney.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlgamoneyApiApplicationTests {

	@Test
	public void contextLoads() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("no-sandbox");
		System.setProperty(
                "webdriver.chrome.driver",
                "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.bing.com/");
		WebElement q = driver.findElement(By.name("q"));
		q.sendKeys("Caelum");
		q.submit();
	}

}
