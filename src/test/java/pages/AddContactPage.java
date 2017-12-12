package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddContactPage extends Base{

    public AddContactPage(WebDriver navegador) {
        super(navegador);
    }

    public AddContactPage escolherTipoContato(String tipo){
        WebElement campoType = navegador.findElement(By.id("addmoredata")).findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo);

        return this;
    }

    public AddContactPage digitarContato(String contato){
        navegador.findElement(By.xpath("//*[@id=\"addmoredata\"]/div[1]/div[3]/div/input")).sendKeys(contato);

        return this;
    }

    public MePage clickSave(){
        navegador.findElement(By.linkText("SAVE")).click();
        return new MePage(navegador);
    }
}
