package com.algaworks.algamoney.api;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.algaworks.algamoney.api.pageobject.LoginPageObject;
import com.algaworks.algamoney.api.pageobject.NovaPessoaPageObject;
import com.algaworks.algamoney.api.pageobject.NovoLancamentoPageObject;
import com.algaworks.algamoney.api.pageobject.PesquisaLancamentoPageObject;
import com.algaworks.algamoney.api.pageobject.PesquisaPessoaPageObject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlgamoneyApiApplicationTests {

	public static final String ADMIN_USER = "admin@algamoney.com";
	public static final String ADMIN_PASS = "admin";
	public static final String RESTRICT_USER = "maria@algamoney.com";
	public static final String RESTRICT_PASS = "maria";
	
	private WebDriver driver;
	private WebDriverWait wait;
	private LoginPageObject login;
	private PesquisaPessoaPageObject pesquisaPessoas;
	private PesquisaLancamentoPageObject pesquisaLancamentos;
	
	@Before
	public void inicializa() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("no-sandbox");
		System.setProperty(
                "webdriver.chrome.driver",
                "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/");		
		wait = new WebDriverWait(driver, 10);
		login = new LoginPageObject(driver,wait);
	}
	
	public void logarNaAplicacao(String usuario, String senha) {
		login.logar(usuario,senha);
	}
	
	public void navegaTelaPesquisaPessoas() {
		pesquisaPessoas = new PesquisaPessoaPageObject(driver,wait);
		pesquisaPessoas.navegaTelaPesquisaPessoa();
	}
	
	public void navegaAcessoNegadoTelaEdicaoLancamento() {
		pesquisaLancamentos = new PesquisaLancamentoPageObject(driver,wait);
		pesquisaLancamentos.navegaAcessoNegadoTelaEdicaoLancamento();
	}

	public void navegaAcessoNegadoRemocaoLancamento() {
		pesquisaLancamentos = new PesquisaLancamentoPageObject(driver,wait);
		pesquisaLancamentos.navegaAcessoNegadoRemocaoLancamento();
	}

	@Test
	public void deveOcorrerLogin() {
		logarNaAplicacao(ADMIN_USER,ADMIN_PASS);
		assertTrue(login.estaNaTelaLancamentos());
	}
	
	@Test(expected=TimeoutException.class)
	public void deveFalharLogin() {
		logarNaAplicacao(ADMIN_USER,"123");
	}

	@Test
	public void devePesquisarUmLancamento()
	{
		logarNaAplicacao(ADMIN_USER,ADMIN_PASS);

		PesquisaLancamentoPageObject pesquisaLancamento = new PesquisaLancamentoPageObject(driver,wait);
		pesquisaLancamento.pesquisarLancamento("chante");
		assertTrue(pesquisaLancamento.encontrouItemPesquisado("Despachante"));
	}
	
//	@Test
	public void deveCadastrarUmLancamento()
	{
		logarNaAplicacao(ADMIN_USER,ADMIN_PASS);

		NovoLancamentoPageObject novoLancamento = new NovoLancamentoPageObject(driver,wait);
		novoLancamento.criarNovoLancamento("Taxa venda imovel","31/05/2018","02/06/2018","1500","Lazer","Vander","Teste Selenium");
		assertTrue(novoLancamento.cadastradoComSucesso());
	}

	@Test
	public void deveCadastrarUmaPessoa()
	{
		logarNaAplicacao(ADMIN_USER,ADMIN_PASS);
		navegaTelaPesquisaPessoas();

		NovaPessoaPageObject novaPessoa = new NovaPessoaPageObject(driver,wait);
		novaPessoa.criarNovaPessoa("Luiza","Avenida Indaia","450","Planalto","38400000","Uberlândia","MG");
		assertTrue(novaPessoa.cadastradoComSucesso());
	}

	@Test(expected=TimeoutException.class)
	public void deveRetornarExcecaoParaEstadoValido() {
		logarNaAplicacao(ADMIN_USER,ADMIN_PASS);
		navegaTelaPesquisaPessoas();

		NovaPessoaPageObject novaPessoa = new NovaPessoaPageObject(driver,wait);
		novaPessoa.validaMensagemEstadoInvalido("SP");
	}
	
	@Test
	public void deveRetornarMensagemParaInformarEstado_SemEstado() {
		logarNaAplicacao(ADMIN_USER,ADMIN_PASS);
		navegaTelaPesquisaPessoas();

		NovaPessoaPageObject novaPessoa = new NovaPessoaPageObject(driver,wait);
		novaPessoa.validaMensagemEstadoInvalido("");
	}
	
	@Test
	public void deveRetornarMensagemParaInformarEstado_EstadoInvalido() {
		logarNaAplicacao(ADMIN_USER,ADMIN_PASS);
		navegaTelaPesquisaPessoas();

		NovaPessoaPageObject novaPessoa = new NovaPessoaPageObject(driver,wait);
		novaPessoa.validaMensagemEstadoInvalido("S1");
	}
	
	@Test
	public void deveRetornarRestricaoDeAcessoParaEditarLancamento() {
		logarNaAplicacao(RESTRICT_USER,RESTRICT_PASS);
		navegaAcessoNegadoTelaEdicaoLancamento();
	}
	
	@Test(expected=TimeoutException.class)
	public void deveRetornarRestricaoDeAcessoParaRemoverLancamento() {
		logarNaAplicacao(RESTRICT_USER,RESTRICT_PASS);
		navegaAcessoNegadoRemocaoLancamento();
	}
	
	@After
	public void finaliza() {
		this.driver.close();
	}
}
