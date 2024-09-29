package automacaoLivenEcommerce;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import Base.BaseConfigsDriver;
import Utils.Utils;
import mantisPage.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PontaApontaCompraLivenEcommerce extends BaseConfigsDriver {

	@Test
	public void A_criarTarefa(){
		MinhaVisaoPage.clicarBtnCriarTarefa();
		MinhaVisaoPage.selecionarCategoria("category_id", "[Todos os Projetos] categoria teste");
		MinhaVisaoPage.selecionarFrequencia("reproducibility", "sempre");
		MinhaVisaoPage.selecionarGravidade("severity", "pequeno");
		MinhaVisaoPage.selecionarPrioridade("priority", "imediato");
		MinhaVisaoPage.escrever("summary", "Apos realizar login deve acessa a tela 'minha visão'.");
		MinhaVisaoPage.escrever("description", "Dado acesso a tela de login quando informo usuario e senha corretos então deve acessar a tela minha visão.");
		MinhaVisaoPage.escrever("steps_to_reproduce", "Pre-condição: 1. Empresa cadastrada no mantis. 2. Possuir usuario e senha ativo e vinculado a empresa. ");
		Utils.getDriver().findElement(By.id("steps_to_reproduce")).sendKeys(Keys.RETURN);
		MinhaVisaoPage.escrever("steps_to_reproduce", "Passos para execução: 1. Acessar o URL do mantis pertencente a empresa https://mantis-prova.base2.com.br/ 2. Informar nome de usuario valido 3. Clicar no botão 'Entrar' 4. Informar senha valida pertencente ao usuario 5. Clicar no botão 'Entrar'");
		Utils.getDriver().findElement(By.id("steps_to_reproduce")).sendKeys(Keys.RETURN);
		MinhaVisaoPage.escrever("steps_to_reproduce", "Resultado Esperado : Acessar tela tela 'minha visão' como pagina inicial do sistema exibindo relatorio de tarefas. ");
		MinhaVisaoPage.escrever("additional_info", "Dado acesso a tela de login quando informo usuario e senha corretos então deve acessar a tela minha visão e exibir informaçoes sobre as tarefas relacionadas ao usuario.");
	    MinhaVisaoPage.clicarBtnCriarNovaTarefa();
	    MinhaVisaoPage.validarCriacaoDeTarefa();
	}
	
	@Test
	public void B_PesquisarTarefa(){
		String numTesk = "1721";
		MinhaVisaoPage.clicarBtnMinhaVisao();
		MinhaVisaoPage.escreveNoCampoDePesquisa(numTesk);
		MinhaVisaoPage.ValidaExibicaoDaTarefaPesquisada(numTesk);
	}
	
	@Test
	public void B_PesquisarTarefaInvalida(){
		String numTesk = "99999";
		MinhaVisaoPage.clicarBtnMinhaVisao();
		MinhaVisaoPage.escreveNoCampoDePesquisa(numTesk);
		MinhaVisaoPage.ValidaExibicaoDaTarefaPesquisada(numTesk);
		MinhaVisaoPage.ValidaExibicaoDaMensagemTaskNaoEncontrada();
	}
}
