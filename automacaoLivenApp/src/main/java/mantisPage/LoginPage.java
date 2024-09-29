package mantisPage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.Propriedades;
import Utils.Utils;

public class LoginPage {
public static void validaAcessoTelaLogin() {
		
		try {
			
			WebElement elemento = Utils.aguardarExibicaoComponente("//*[@id='username']", 20);
			if(elemento instanceof WebElement)
				Assert.assertEquals(Propriedades.getUrl()+"/login_page.php",Utils.getDriver().getCurrentUrl());
			
		} catch (Exception e) {
			
			System.out.println("NAO FOI POSSIVEL VALIDAR ACESSO A PAGINA DE LOGIN: " + e.getMessage());
			throw new RuntimeException("NAO FOI POSSIVEL VALIDAR ACESSO A PAGINA DE LOGIN:");
			
		}				    
	}
public static void inserirLoginUsuario(String usuario) {
	String mensagemErroUsuario = "NÃO FOI POSSIVEL ESCREVER NO CAMPO DE USARIO";
		try {
			Utils.getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys(usuario);
		} catch (Exception e) {
			 System.out.println(mensagemErroUsuario + e.getMessage());
			 throw new RuntimeException(mensagemErroUsuario);
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

}
