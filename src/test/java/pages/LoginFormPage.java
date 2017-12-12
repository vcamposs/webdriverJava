package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends Base{

    protected LoginFormPage(WebDriver navegador) {
        super(navegador);
    }

    // Estrutura --> Public -> proxima pagina -> nome método
    // Quando chamado, ira ser passada a variavel chamada "login"
    public LoginFormPage typeLogin(String login){
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);

        // "this" pois retorna a mesma pagina
        return this;
    }

    public LoginFormPage typePass(String pass){
        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(pass);

        return this;
    }

    public SecretaPage clickSigin(){
        navegador.findElement(By.linkText("SIGN IN")).click();
        // "this" pois retorna a mesma pagina
        return new SecretaPage(navegador);
    }
}
