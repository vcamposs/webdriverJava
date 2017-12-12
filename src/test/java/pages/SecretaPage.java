package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecretaPage extends Base{

    public SecretaPage(WebDriver navegador) {
        super(navegador);
    }

    public MePage clickMe(){
        navegador.findElement(By.className("me")).click();
        navegador.findElement(By.linkText("Hi, Victor Campos Silva")).click();

        return new MePage(navegador);
    }
}
