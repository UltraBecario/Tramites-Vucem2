package Test220201;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class GenerarFolio {
    public WebDriver driver;
    String uuid = UUID.randomUUID().toString();
    int longitudDeseada = 16;
    String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);

    @Before
    public void inicializar() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JNoeMC\\IdeaProjects\\Tramites-Vucem2\\src\\test\\resources\\Cargadocumento\\chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments(new String[] { "--disablenotifications"});
        chromeOptions.setCapability("acceptInsecureCerts", true);
        driver = new ChromeDriver(chromeOptions);

    }

    @Test
    public void GenerarFolio() throws InterruptedException {
//Inicia la pagina.
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();

//Login con firma.
        Test220201.FirmaSoli firmaSoli = new FirmaSoli(driver);
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
        WebElement rDocumental =driver.findElement(By.xpath("//*[@id=\"servicios\"]/ul/li/ul/li[2]/a"));
        rDocumental.click();

//seleccion de tramite
        WebElement tramite_220201 =driver.findElement(By.xpath("//*[@id=\"servicios\"]/ul/li/ul/li[2]/ul/li[1]/a"));
        tramite_220201.click();

//selecciona pestaña "Datos de la Solicitud"
        WebElement solicitud =driver.findElement(By.xpath("//*[@id=\"ui-id-2\"]"));
        solicitud.click();

//flujo corto
//dar Dobleclick sobre un registro para cargar los datos de uno previo
        dobleClickEnElemento("//*[@id=\"5\"]/td[5]");

//con los datos precargados pasamos a continuar
        WebElement btnContinuar = driver.findElement(By.xpath("//*[@id=\"guardarSolicitud\"]"));
        btnContinuar.click();

        WebElement llavePagoE = driver.findElement(By.xpath("//*[@id=\"solicitud.pago.llaveDePago\"]"));
                llavePagoE.sendKeys(llavePago);

        //Selección de fecha con calendario
        WebElement fechaPago = driver.findElement(By.xpath("//*[@id=\"calendarTo\"]"));
        fechaPago.sendKeys("14/08/2024");
        llavePagoE.click();
        // una vez cargados los datos daremos continuar
        WebElement btnCont = driver.findElement(By.xpath("//*[@id=\"guardarSolicitud\"]"));
        btnCont.click();

        //seleccione tipo de documento
        WebElement tipoDoc = driver.findElement(By.id("selectDoctosEspecificos"));
        tipoDoc.sendKeys("Certificado de Control de Calidad");

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
//        driver.close(); // Cierra el navegador
    }
}
