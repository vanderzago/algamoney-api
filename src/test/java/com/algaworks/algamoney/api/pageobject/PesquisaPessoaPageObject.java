package com.algaworks.algamoney.api.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PesquisaPessoaPageObject {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public PesquisaPessoaPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void navegaTelaPesquisaPessoa() {
		driver.findElement(By.id("linhas_menu")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_lateral")));
		
		driver.findElement(By.linkText("Pessoas")).click();
		
		wait.until(ExpectedConditions.titleIs("Pesquisa de pessoas"));
		
		driver.findElement(By.id("linhas_menu")).click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("menu_lateral")));
	}
}
