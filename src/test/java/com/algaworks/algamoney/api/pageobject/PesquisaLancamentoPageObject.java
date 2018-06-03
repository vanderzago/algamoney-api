package com.algaworks.algamoney.api.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PesquisaLancamentoPageObject {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public PesquisaLancamentoPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void navegaAcessoNegadoTelaEdicaoLancamento() {
		
		driver.findElement(By.xpath("//*[@id=\"tabela_lancamentos\"]/p-datatable/div/div[1]/table/tbody/tr[1]/td[6]/span[2]/a")).click();
		wait.until(ExpectedConditions.textToBe(By.xpath("/html/body/app-root/ng-component/div/h1"),"Acesso negado!"));		
	}

	public void navegaAcessoNegadoRemocaoLancamento() {
		
		driver.findElement(By.xpath("//*[@id=\"tabela_lancamentos\"]/p-datatable/div/div[1]/table/tbody/tr[1]/td[6]/span[2]/button")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/app-root/p-confirmdialog/div/div[1]/span")));		
	}

	public void pesquisarLancamento(String itemPesquisa, String retornoPesquisaDesejado) {
		
		WebElement descricaoField = driver.findElement(By.name("descricao"));
		descricaoField.sendKeys(itemPesquisa);

		WebElement pesquisar = driver.findElement(By.name("pesquisar"));
		pesquisar.click();

		wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"tabela_lancamentos\"]/p-datatable/div/div[1]/table/tbody/tr/td[2]/span[2]"),retornoPesquisaDesejado));
	}
}
