package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Base{

    public LoginPage(WebDriver navegador) {
        super(navegador);
    }

    // LoginFormPage é oq será feito após o click
    public LoginFormPage clickSignIn(){
        navegador.findElement(By.linkText("Sign in")).click();

        // ira chamar uma instancia da proxima pagina
        return new LoginFormPage(navegador);
    }
}
