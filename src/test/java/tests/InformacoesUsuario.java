package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import suporte.Generator;
import suporte.Screenshot;

// Aponta a classe de test da easy-test
@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "informacoesUsuario.csv")

public class InformacoesUsuario {
    private WebDriver navegador;

    @Before
    public void setUp(){

        navegador.findElement(By.linkText("Sign in")).click();

        WebElement formulario = navegador.findElement(By.id("signinbox"));
        formulario.findElement(By.name("login")).sendKeys("vcampos");
        formulario.findElement(By.name("password")).sendKeys("123");
        formulario.findElement(By.linkText("SIGN IN")).click();
    }


    @Test
    public void testLoginUserCSV(@Param(name="tipo")String tipo,@Param(name="contato")String contato,@Param(name="mensagem")String mensagem){

        // Clicar em um link que possui a classe "me"
        navegador.findElement(By.className("me")).click();
        navegador.findElement(By.linkText("Hi, Victor Campos Silva")).click();

        // Clicar em um link que possui o texto "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        // Clicar no botão através do xpath [addmoredata]
        navegador.findElement(By.xpath("//*[@id=\"moredata\"]/div[2]/button")).click();

        // Indicar a popup onde esta o formulario de id addmoredata
        WebElement pop = navegador.findElement(By.id("addmoredata"));

        // na combo de name "type" escolher a opção "phone"
        WebElement campoType = pop.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo); //antes : "Phone" // hardcode

        // no campo de name "contact" digitar "+55 11834298374"
        pop.findElement(By.xpath("//*[@id=\"addmoredata\"]/div[1]/div[3]/div/input")).sendKeys(contato);

        // clicar no link de text "SAVE" que esta no popup
        pop.findElement(By.linkText("SAVE")).click();

        String toastRounded = navegador.findElement(By.id("toast-container")).getText();
        Assert.assertEquals(mensagem,toastRounded);

        Screenshot.tirar(navegador,"C:\\GitHub\\webdriverJava\\prints\\" + Generator.dataHoraParaArquivo() + "Print.png");
    }

    @Ignore // testes sem o .CSV
    public void testLoginUser(){

        // Clicar em um link que possui a classe "me"
        navegador.findElement(By.className("me")).click();
        navegador.findElement(By.linkText("Hi, Victor Campos Silva")).click();

        // Clicar em um link que possui o texto "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        // Clicar no botão através do xpath [addmoredata]
        navegador.findElement(By.xpath("//*[@id=\"moredata\"]/div[2]/button")).click();

        // Indicar a popup onde esta o formulario de id addmoredata
        WebElement pop = navegador.findElement(By.id("addmoredata"));

        // na combo de name "type" escolher a opção "phone"
        WebElement campoType = pop.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText("Phone");

        // no campo de name "contact" digitar "+55 11834298374"
        pop.findElement(By.xpath("//*[@id=\"addmoredata\"]/div[1]/div[3]/div/input")).sendKeys("+55 1999999999");

        // clicar no link de text "SAVE" que esta no popup
        pop.findElement(By.linkText("SAVE")).click();

        String toastRounded = navegador.findElement(By.id("toast-container")).getText();
        Assert.assertEquals("Your contact has been added!",toastRounded);

        Screenshot.tirar(navegador,"C:\\GitHub\\webdriverJava\\prints\\" + Generator.dataHoraParaArquivo() + "Print.png");
    }

    @After
    public void tearDown(){
       navegador.close();
    }
}