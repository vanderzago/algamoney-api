package com.algaworks.algamoney.api.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public LoginPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void entraComUsuarioESenha(String usuario, String senha) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("usuario")));

		WebElement usuarioField = driver.findElement(By.name("usuario"));
		usuarioField.sendKeys(usuario);

		WebElement senhaField = driver.findElement(By.name("senha"));
		senhaField.sendKeys(senha);

		WebElement login = driver.findElement(By.name("login"));
		login.click();
	}
	
	public void falhaLogar(String usuario, String senha) {
		entraComUsuarioESenha(usuario,senha);
		
		wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"toasty\"]/ng2-toast/div/div[2]"),"Usuário ou senha inválida!"));
	}
	
	public void logar(String usuario, String senha) {
		entraComUsuarioESenha(usuario,senha);
		
		wait.until(ExpectedConditions.titleIs("Pesquisa de lançamentos"));
	}
	
	public Boolean estaNaTelaLancamentos() {
		return driver.getPageSource().contains(String.valueOf("Lançamentos"));
	}
}
