package com.algaworks.algamoney.api.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NovoLancamentoPageObject {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public NovoLancamentoPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void criarNovoLancamento(String descricao, String dataPagamento, String vencimento, String valor, String categoria,
			String pessoa, String observacao) {

		WebElement novo_lancamento = driver.findElement(By.name("novo_lancamento"));
		novo_lancamento.click();
		
		wait.until(ExpectedConditions.titleContains("Novo"));
		
		WebElement descricaoField = driver.findElement(By.name("descricao"));
		descricaoField.sendKeys(descricao);

		WebElement valorField = driver.findElement(By.name("valor"));
		valorField.sendKeys(valor);

		WebElement observacaoField = driver.findElement(By.name("observacao"));
		observacaoField.sendKeys(observacao);

//		WebElement categoriaComboField = driver.findElement(By.name("categoria"));
//		Select categoriaCombo = new Select(categoriaComboField);
//		categoriaCombo.selectByVisibleText(categoria);

//		WebElement pessoaComboField = driver.findElement(By.name("pessoa"));
//		Select pessoaCombo = new Select(pessoaComboField);
//		pessoaCombo.selectByVisibleText(categoria);

		Actions actions = new Actions(driver);
    	actions.moveToElement(driver.findElement(By.name("vencimento")));
		actions.click();
		actions.sendKeys(vencimento);
		actions.build().perform();
		
		actions.moveToElement(driver.findElement(By.name("dataPagamento")));
		actions.click();
		actions.sendKeys(dataPagamento);
		actions.build().perform();
		
		WebElement salvar = driver.findElement(By.name("salvar"));
		salvar.click();
		
		wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"toasty\"]/ng2-toast/div/div[2]"),"Lançamento cadastrado com sucesso!"));		
	}
	
	public Boolean cadastradoComSucesso() {
		return driver.getPageSource().contains(String.valueOf("Edição de lançamento"));
	}
	
}
