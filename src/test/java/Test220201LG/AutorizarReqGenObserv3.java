package Test220201LG;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class AutorizarReqGenObserv3 {
    public WebDriver driver;
    String folioGenerado = "1502200200120240301000015";


    @Before
    public void inicializar() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JNoeMC\\IdeaProjects\\Tramites-Vucem2\\src\\test\\resources\\Cargadocumento\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void AutorizarReqGenObserv3() throws InterruptedException {
//Inicia la pagina como Funcionario
        driver.get("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();

//Login con firma.
        Test220201LG.FirmaFun firmaFun = new FirmaFun(driver);
        firmaFun.firmarfuncionario();
        WebElement fileingresar = driver.findElement(By.xpath("//*[@id=\"btnSubmit\"]"));
        fileingresar.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //entramos al gestor de busqueda de folios
        WebElement inicio = driver.findElement(By.xpath("//*[@id=\"tablaMenuLateral\"]/tbody/tr[2]/td/a"));
        inicio.click();

        //ingresar folio para su busqueda
        WebElement folio = driver.findElement(By.xpath("//*[@id=\"idNumFolio\"]"));
        folio.sendKeys(folioGenerado);

        //precionamos bton busqueda
        WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"buscarTareasFuncionario\"]"));
        btnBuscar.click();

        //dobldeclick sobre el registro
        dobleClickEnElemento("//*[@id=\"1\"]/td[4]");


        //precionar btn observar
        WebElement btnObs = driver.findElement(By.xpath("//*[@id=\"acciones\"]/input[1]"));
        btnObs.click();

        WebElement textJust = driver.findElement(By.xpath("//*[@id=\"requerimientoSolicitud\"]/div[4]/div/textarea"));
        textJust.sendKeys("Esto es una justificacion de preuba de automatización");

        //Gen Observ
        WebElement btnObserv = driver.findElement(By.xpath("//*[@id=\"acciones\"]/input[2]"));
        btnObserv.click();

    }

    public void dobleClickEnElemento(String xpath) {
        // Encuentra el elemento usando el XPath proporcionado
        WebElement cargaDatos = driver.findElement(By.xpath(xpath));

        // Crea una instancia de Actions
        Actions actions = new Actions(driver);

        // Realiza un doble clic en el elemento
        actions.doubleClick(cargaDatos).perform();
    }

    @After
    public void finalizar() {
        try {
            Thread.sleep(5000); // Espera 10 segundos (10,000 milisegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close(); // Cierra el navegador
    }
}
