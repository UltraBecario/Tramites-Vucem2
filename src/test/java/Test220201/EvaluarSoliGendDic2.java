package Test220201;
import java.util.concurrent.TimeUnit;

import ConDBReasigSoliFun.ConDBReasigSolFun;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class EvaluarSoliGendDic2 {
    public WebDriver driver;
    String folioNumber = "1502200200120240301000029";
    String FunSolRFC = "MAVL621207C95";

    @Before
    public void inicializar() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JNoeMC\\IdeaProjects\\Tramites-Vucem2\\src\\test\\resources\\Cargadocumento\\WebD\\chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments(new String[] { "--disablenotifications"});
        chromeOptions.setCapability("acceptInsecureCerts", true);
        driver = new ChromeDriver(chromeOptions);
    }

    @Test
    public void EvaluarSoliGendDic2() throws InterruptedException {
//Inicia la pagina como Funcionario
        driver.get("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();

//Login con firma.
        Test220201.FirmaFun firmaFun = new FirmaFun(driver);
        firmaFun.firmarfuncionario();
        WebElement fileingresar = driver.findElement(By.xpath("//*[@id=\"btnSubmit\"]"));
        fileingresar.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //entramos al gestor de busqueda de folios
        WebElement inicio = driver.findElement(By.xpath("//*[@id=\"tablaMenuLateral\"]/tbody/tr[2]/td/a"));
        inicio.click();

        //ingresar folio para su busqueda
        WebElement folio = driver.findElement(By.xpath("//*[@id=\"idNumFolio\"]"));
        folio.sendKeys(folioNumber);
        //precionamos bton busqueda
        WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"buscarTareasFuncionario\"]"));
        btnBuscar.click();
        //dobldeclick sobre el registro
                dobleClickEnElemento("//*[@id=\"1\"]/td[4]");

        //seleccionar generar dictamen
        WebElement genDic = driver.findElement(By.xpath("//*[@id=\"link_1\"]/label"));
        genDic.click();

        //precionar btn continuar
        WebElement btnCont = driver.findElement(By.xpath("//*[@id=\"acciones\"]/input"));
        btnCont.click();

        //btn siguiente
        WebElement btnSiguiente = driver.findElement(By.xpath("//*[@id=\"acciones\"]/input[1]"));
        btnSiguiente.click();

        //Sentido Dictamen Aceptado
        WebElement Aceptado = driver.findElement(By.xpath("//*[@id=\"Aceptado\"]/input"));
        Aceptado.click();
        WebElement Descripcion = driver.findElement(By.xpath("//*[@id=\"valueTA\"]"));
        Descripcion.sendKeys("PRUEBA QA JOSSUE AUTOMATIZACIÓN");

        //GUARDAR Y FIRMAR
        WebElement btnGyF = driver.findElement(By.xpath("/html/body/main/div[1]/div[4]/div/form/div[2]/input[4]"));
        btnGyF.click();

        firmaFun.firmarfuncionario();
        WebElement firm = driver.findElement(By.xpath("//*[@id=\"btnSubmit\"]"));
        firm.click();

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
        ConDBReasigSolFun CDBRSF = new ConDBReasigSolFun();
        // Llamar al metodo queryByFolio con el parámetro deseado
        CDBRSF.processFolio(folioNumber, FunSolRFC);
        driver.close(); // Cierra el navegador
    }



}
