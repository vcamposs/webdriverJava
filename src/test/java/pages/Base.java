package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Base {
    protected WebDriver navegador;
    public Base(WebDriver navegador){
        this.navegador = navegador;
    }

    public String capturarTextoToast(){
        return navegador.findElement(By.id("toast-container")).getText();
    }
}
