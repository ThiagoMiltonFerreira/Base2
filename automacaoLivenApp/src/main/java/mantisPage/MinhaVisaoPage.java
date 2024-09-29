package mantisPage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import Base.DSL;
import Base.Propriedades;
import Utils.Utils;

public class MinhaVisaoPage extends DSL {
	public static void validaAcessoTelaLogin(){
		
		try {
			
			WebElement elemento = Utils.aguardarExibicaoComponente("//*[@id='username']", 20);
			if(elemento instanceof WebElement)
				Assert.assertEquals(Propriedades.getUrl()+"/login_page.php",Utils.getDriver().getCurrentUrl());
			
		} catch (Exception e) {
			
			System.out.println("NAO FOI POSSIVEL VALIDAR ACESSO A PAGINA DE LOGIN: " + e.getMessage());
			throw new RuntimeException("NAO FOI POSSIVEL VALIDAR ACESSO A PAGINA DE LOGIN:");
			
		}				    
	}
	public static void clicarBtnCriarTarefa() {
		String mensagemErroCliqueBtnEntrar = "NÃO FOI POSSIVEL ENCONTRAR BOTÃO CRIAR TAREFA";
			try {
				Utils.getDriver().findElement(By.xpath("//*[@id='navbar-container']/div[@class='navbar-buttons navbar-header navbar-collapse collapse']/ul/li")).click();
			} catch (Exception e) {
				 System.out.println(mensagemErroCliqueBtnEntrar + e.getMessage());
				 throw new RuntimeException(mensagemErroCliqueBtnEntrar);
			}			
	}
	public static void selecionarCategoria(String id,String valor) {
		selecionarCombo(id, valor);
	}
	public static void selecionarFrequencia(String id,String valor) {
		selecionarCombo(id, valor);
	}
	public static void selecionarGravidade(String id,String valor) {
		selecionarCombo(id, valor);
	}
	public static void selecionarPrioridade(String id,String valor) {
		selecionarCombo(id, valor);
	}
	public static void clicarBtnCriarNovaTarefa() {

		String mensagemErroCliqueBtnEntrar = "NÃO FOI POSSIVEL ENCONTRAR BOTÃO CRIAR NOVA TAREFA";
			try {
				Utils.getDriver().findElement(By.xpath("//*[@id='report_bug_form']/div/div[2]/div[2]/input")).click();
				} catch (Exception e) {
					 System.out.println(mensagemErroCliqueBtnEntrar + e.getMessage());
					 throw new RuntimeException(mensagemErroCliqueBtnEntrar);
				}			
	}
	
	public static void validarCriacaoDeTarefa() {
		Utils.aguardar(1000);
		Assert.assertEquals(Propriedades.getUrl()+"/bug_report.php?posted=1",Utils.getDriver().getCurrentUrl());
	}
	public static void clicarBtnMinhaVisao() {

		String mensagemErroCliqueBtnEntrar = "NÃO FOI POSSIVEL ENCONTRAR BOTÃO MINHA VISAO";
			try {
				Utils.getDriver().findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[1]/a/span")).click();
				} catch (Exception e) {
					 System.out.println(mensagemErroCliqueBtnEntrar + e.getMessage());
					 throw new RuntimeException(mensagemErroCliqueBtnEntrar);
				}			
	}
	public static void escreveNoCampoDePesquisa(String texto) {
		Utils.getDriver().findElement(By.xpath("//*[@id=\"nav-search\"]/form/span/input")).sendKeys("000"+texto);
		Utils.getDriver().findElement(By.xpath("//*[@id=\"nav-search\"]/form/span/input")).sendKeys(Keys.RETURN);
	}
	public static void ValidaExibicaoDaTarefaPesquisada(String numTask) {
		Assert.assertEquals(Propriedades.getUrl()+"/view.php?id="+numTask,Utils.getDriver().getCurrentUrl());
		String numTarefa = Utils.getDriver().findElement(By.xpath("//table[@class='table table-bordered table-condensed']/tbody/tr[2]/td[1]")).getText();
		Assert.assertEquals("000"+numTask,numTarefa);
	}
	public static void ValidaExibicaoDaMensagemTaskNaoEncontrada() {
		Assert.assertEquals(Propriedades.getUrl()+"/jump_to_bug.php",Utils.getDriver().getCurrentUrl());
		String numTarefa = Utils.getDriver().findElement(By.xpath("//*[@class=\"alert alert-danger\"]/p")).getText();
		Assert.assertEquals("APPLICATION ERROR #203",numTarefa);
	}
}
