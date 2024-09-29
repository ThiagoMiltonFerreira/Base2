package Base;

import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import Utils.Utils;
import mantisPage.LoginPage;
import mantisPage.LoginPasswordPage;

public class BaseConfigsDriver {
	private String webDriverChorme = "webdriver.chrome.driver";
	private String caminhoWebDriver = System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\chromedriver.exe";
	private String usuario = "thiago_ferreira";
	private String senha = "thiago123";
	
	private void realizaLogin() {
		LoginPage.validaAcessoTelaLogin();
		LoginPage.inserirLoginUsuario(this.usuario);
		LoginPage.clicarBtnEntrar();
		LoginPasswordPage.validaAcessoTelaLoginPasswordPage();
		LoginPasswordPage.inserirSenha(this.senha);
		LoginPasswordPage.clicarBtnEntrar();
	}
	
	@Before
	public void configsDriver() {
		// Espera por elemento qualquer elemento na pagina ate 10 segundos para dar timeout enquanto a instancia do chorme estiver aberta
		Utils.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.setProperty(webDriverChorme,caminhoWebDriver);	
		Utils.getDriver().get(Propriedades.getUrl());
		this.realizaLogin();
	}
	
	@After
	public void matarDriver() {
		Utils.matarDriver();
	}

}
