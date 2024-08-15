package Test220502;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class GenerarFolioTMT220502 {
    public WebDriver driver;

    @Before
    public void inicializar() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JNoeMC\\Desktop\\Practica Selenium\\PJ3\\TramitesVucem\\SELENIUM_TESTING\\src\\test\\resources\\Cargadocumento\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void GenerarFolioTMT220502() throws InterruptedException {
//Inicia la pagina.
        driver.get("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();

//Login con firma.
        Test220502.FirmaSoli firmaSoli = new FirmaSoli(driver);
        firmaSoli.firmarsolicitante();
        WebElement fileingresar = driver.findElement(By.className("btn-primary"));
        fileingresar.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //selecciona el tipo de persona por rol.
        WebElement tipopersona = driver.findElement(By.id("claveRol"));
        WebElement tipopersonarol =tipopersona.findElement(By.xpath("//*[@value= 'PersonaMoral']"));
        tipopersonarol.click();
        WebElement fileingresarmoral = driver.findElement(By.className("btn-primary"));
        fileingresarmoral.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

//selecciona que tipo de tramite ya sea nuevo oh subsecuente
        WebElement tramite = driver.findElement(By.id("Trámites"));
        tramite.click();
        WebElement solicitudesnuevas =driver.findElement(By.xpath("//*[@id=\"subenlaces\"]/ul/li[5]/ul/li[3]/a"));
        solicitudesnuevas.click();

//selecciona que catalogo
        WebElement agricultura =driver.findElement(By.xpath("//*[@id=\"workingArea\"]/form/a[10]/img"));
        agricultura.click();

//selecciona el apartado de los tramites ah eleguir
        WebElement CerSoliReq =driver.findElement(By.xpath("//*[@id=\"servicios\"]/ul/li/a"));
        CerSoliReq.click();

//subcatalogo
        WebElement rDocumental =driver.findElement(By.xpath("//*[@id=\"servicios\"]/ul/li/ul/li[4]/a"));
        rDocumental.click();

//seleccion de tramite
        WebElement tramite_220502 =driver.findElement(By.xpath("//*[@id=\"servicios\"]/ul/li/ul/li[4]/ul/li[2]/a"));
        tramite_220502.click();

//selecciona pestaña "Datos de la Solicitud"
        WebElement solicitud =driver.findElement(By.xpath("//*[@id=\"ui-id-2\"]"));
        solicitud.click();

//flujo corto
//dar Dobleclick sobre un registro para cargar los datos de uno previo
        dobleClickEnElemento("//*[@id=\"3\"]/td[5]");

//con los datos precargados pasamos a continuar
        WebElement btnContinuar = driver.findElement(By.xpath("//*[@id=\"guardarSolicitud\"]"));
        btnContinuar.click();
        Thread.sleep(3000);

        WebElement metodoTrans = driver.findElement(By.xpath("//*[@id=\"solicitud.transporte.ideMedioTransporte\"]"));
        metodoTrans.sendKeys("Terrestre");
        Thread.sleep(3000);

        WebElement sI = driver.findElement(By.xpath("//*[@id=\"SiSolicitudFerros\"]"));
        sI.click();
        Thread.sleep(3000);

        WebElement check = driver.findElement(By.xpath("//*[@id=\"jqg_gridSagarpa2205_3\"]"));
        check.click();
        Thread.sleep(3000);

        WebElement btnModificar = driver.findElement(By.xpath("//*[@id=\"btnSaldoMercancia\"]"));
        btnModificar.click();
        Thread.sleep(3000);

        WebElement UMT = driver.findElement(By.xpath("//*[@id=\"frmSaldos\"]/div[5]/div/div/input"));
        UMT.sendKeys("1");
        Thread.sleep(3000);

        WebElement btnContMod = driver.findElement(By.xpath("//*[@id=\"frmSaldos\"]/div[6]/div[3]/div/input[2]"));
        btnContMod.click();
        Thread.sleep(3000);

        WebElement btnContinuar2 = driver.findElement(By.xpath("//*[@id=\"guardarSolicitud\"]"));
        btnContinuar2.click();

        WebElement btnConti = driver.findElement(By.xpath("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]"));
        btnConti.click();

//Firma final del tramite
        firmaSoli.firmarsolicitante();
        WebElement btnFirmar = driver.findElement(By.xpath("//*[@id=\"btnSubmit\"]"));
        btnFirmar.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//Obtener Folio
        // Encuentra el elemento
        WebElement folioElement = driver.findElement(By.xpath("//*[@id=\"notification\"]/div/ul/li"));

        // Obtén el texto del elemento
        String folioText = folioElement.getText();

        // Usa una expresión regular para extraer el texto entre los símbolos <>
        Pattern pattern = Pattern.compile("<([^>]*)>");
        Matcher matcher = pattern.matcher(folioText);

        if (matcher.find()) {
            String folioNumber = matcher.group(1);
            System.out.println("Número de folio: " + folioNumber);

        } else {
            System.out.println("No se encontró el número de folio.");
        }



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
            Thread.sleep(10000); // Espera 10 segundos (10,000 milisegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close(); // Cierra el navegador
   }

}
