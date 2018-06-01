package com.algaworks.algamoney.api.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NovaPessoaPageObject {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public NovaPessoaPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		
		WebElement nova_pessoa = driver.findElement(By.name("nova_pessoa"));
		nova_pessoa.click();
		
		wait.until(ExpectedConditions.titleIs("Nova pessoa"));
	}

	public void criarNovaPessoa(String nome, String logradouro, String numero, String bairro, String cep,
			String cidade, String estado) {
	
		WebElement nomeField = driver.findElement(By.name("nome"));
		nomeField.sendKeys(nome);

		WebElement logradouroField = driver.findElement(By.name("logradouro"));
		logradouroField.sendKeys(logradouro);

		WebElement numeroField = driver.findElement(By.name("numero"));
		numeroField.sendKeys(numero);
	
		WebElement bairroField = driver.findElement(By.name("bairro"));
		bairroField.sendKeys(bairro);

		Actions actions = new Actions(driver);
    	actions.moveToElement(driver.findElement(By.name("cep")));
		actions.click();
		actions.sendKeys(cep);
		actions.build().perform();

		WebElement cidadeField = driver.findElement(By.name("cidade"));
		cidadeField.sendKeys(cidade);
	
    	actions.moveToElement(driver.findElement(By.name("estado")));
		actions.click();
		actions.sendKeys(estado);
		actions.build().perform();

		WebElement salvar = driver.findElement(By.name("salvar"));
		salvar.click();
		
		wait.until(ExpectedConditions.titleContains("Edição de pessoa"));
		
	}
	
	public void validaMensagemEstadoInvalido(String estado) {
		Actions actions = new Actions(driver);
    	actions.moveToElement(driver.findElement(By.name("estado")));
		actions.click();
		actions.sendKeys(estado);
		actions.build().perform();
		
    	actions.moveToElement(driver.findElement(By.name("cidade")));
		actions.click();
		actions.build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"msg_erro_estado\"]/div"))); 
	}

	public Boolean cadastradoComSucesso() {	
		return driver.getPageSource().contains(String.valueOf("Edição de pessoa"));
	}
	

}
