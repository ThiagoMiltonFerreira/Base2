package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utils.Utils;

public class DSL {
	public static void selecionarCombo(String id, String valor) {
		WebElement element = Utils.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	public static void escrever(String id , String texto){
		//Utils.getDriver().findElement(By.id(id)).clear();
		Utils.getDriver().findElement(By.id(id)).sendKeys(texto);
	}
}
