package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {

    public static final String USERNAME = "victorcampossilv1";
    public static final String AUTOMATE_KEY = "SGwmCMC5AtcTfBciFxtG";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createChrome(){
        //Abre o navegador
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vcampos\\chromeDriver\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Navega pela pagina "~taskit/"
        navegador.get("http://www.juliodelima.com.br/taskit/");

        //Mazimiza o navegador
        navegador.manage().window().maximize();

        return navegador;
    }

    public static WebDriver createBrowserStack(){

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "62.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1680x1050");

        WebDriver navegador = null;

        try {
            navegador = new RemoteWebDriver(new URL(URL), caps);
            navegador.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

            navegador.get("http://www.juliodelima.com.br/taskit/");

        } catch (MalformedURLException e ) {
            System.out.println("Hove problema com a URL : " + e.getMessage());
        }

        // Maximiza a tela no navegador
        navegador.manage().window().maximize();

        return navegador;

    }
}
