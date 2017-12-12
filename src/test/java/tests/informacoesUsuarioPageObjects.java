package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suporte.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "informacoesUsuarioPageObjects.csv")

public class informacoesUsuarioPageObjects {
    private WebDriver navegador;

    @Before
    public void setUp(){
        navegador = Web.createChrome();
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(
            @Param(name="login")String login,
            @Param(name="senha")String senha,
            @Param(name="tipo")String tipo,
            @Param(name="contato")String contato,
            @Param(name="mensagem")String mensagem
            ){
        // Primeiro passo Login
        String textoToast = new LoginPage(navegador)
                                .clickSignIn()
                                .typeLogin(login)
                                .typePass(senha)
                                .clickSigin()
                                .clickMe()
                                .clickAbaMoreDataAboutYou()
                                .clickBotaoMoreDataAboutYou()
                                .escolherTipoContato(tipo)
                                .digitarContato(contato)
                                .clickSave()
                                .capturarTextoToast();

        Assert.assertEquals(mensagem,textoToast);
    }

    @After
    public void tearDown(){
        // Fecha o navegador
        navegador.close();

    }
}
