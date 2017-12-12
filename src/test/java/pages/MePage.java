package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MePage extends Base {

    public MePage(WebDriver navegador) {
        super(navegador);
    }

    public MePage clickAbaMoreDataAboutYou(){
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        return this;
    }

    public AddContactPage clickBotaoMoreDataAboutYou(){
        navegador.findElement(By.xpath("//*[@id=\"moredata\"]/div[2]/button")).click();

        return new AddContactPage(navegador);
    }
}
