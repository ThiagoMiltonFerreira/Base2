package mantisPage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.Propriedades;
import Utils.Utils;

public class LoginPasswordPage {
	public static void validaAcessoTelaLoginPasswordPage() {
		String mensagem = "NÃO FOI POSSIVEL VALIDAR ACESSO A TELA LOGIN_PASSWORD_PAGE";
		try {
			
			WebElement elemento = Utils.aguardarExibicaoComponente("//*[@id='password']", 20);
			if(elemento instanceof WebElement)
				Assert.assertEquals(Propriedades.getUrl()+"/login_password_page.php",Utils.getDriver().getCurrentUrl());
			
		} catch (Exception e) {
			
			System.out.println(mensagem + e.getMessage());
			throw new RuntimeException(mensagem);
			
		}				    
	}
	public static void clicarBtnEntrar() {
		String mensagemErroCliqueBtnEntrar = "NÃO FOI POSSIVEL ENCONTRAR BOTÃO ENTRAR";
			try {
				Utils.getDriver().findElement(By.xpath("//input[@value='Entrar']")).click();
			} catch (Exception e) {
				 System.out.println(mensagemErroCliqueBtnEntrar + e.getMessage());
				 throw new RuntimeException(mensagemErroCliqueBtnEntrar);
			}					
	}
	public static void inserirSenha(String senha) {
		String mensagemErroInserirSenha = "NÃO FOI POSSIVEL ENCONTRAR BOTÃO ENTRAR";
		try {
			Utils.getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys(senha);
		} catch (Exception e) {
			 System.out.println(mensagemErroInserirSenha + e.getMessage());
			 throw new RuntimeException(mensagemErroInserirSenha);
		}			
	}
}
