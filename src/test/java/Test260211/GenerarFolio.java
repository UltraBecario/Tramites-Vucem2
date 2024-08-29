package Test260211;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenerarFolio {
    public WebDriver driver;
    String uuid = UUID.randomUUID().toString();
    int longitudDeseada = 16;
    String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
    String urlLog = "https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=";

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
        driver.get(urlLog);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();

//Login con firma.
        Test260211.FirmaSoli firmaSoli = new FirmaSoli(driver);
        firmaSoli.firmarsolicitante();
        WebElement fileingresar = driver.findElement(By.className("btn-primary"));
        fileingresar.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //selecciona el tipo de persona por rol.
        WebElement tipopersona = driver.findElement(By.id("claveRol"));
        WebElement tipopersonarol = tipopersona.findElement(By.xpath("//*[@value= 'PersonaMoral']"));
        tipopersonarol.click();
        WebElement fileingresarmoral = driver.findElement(By.className("btn-primary"));
        fileingresarmoral.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

//selecciona que tipo de tramite ya sea nuevo oh subsecuente
        WebElement tramite = driver.findElement(By.id("Trámites"));
        tramite.click();

        WebElement solicitudesnuevas = driver.findElement(By.xpath("//*[@id=\"subenlaces\"]/ul/li[5]/ul/li[3]/a"));
        solicitudesnuevas.click();

//selecciona que catalogo
        WebElement cofePris = driver.findElement(By.xpath("//*[@id=\"workingArea\"]/form/a[3]/img"));
        cofePris.click();

//selecciona el apartado de los tramites ah eleguir
        WebElement CerLicPer = driver.findElement(By.xpath("//*[@id=\"servicios\"]/ul/li/a"));
        CerLicPer.click();

//subcatalogo
        WebElement PerSanImpInsSal = driver.findElement(By.xpath("//*[@id=\"servicios\"]/ul/li/ul/li[2]/a"));
        PerSanImpInsSal.click();

//seleccion de tramite
        WebElement tramite_260211 = driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[2]/ul/li[11]/a"));
        tramite_260211.click();

//selecciona pestaña "Datos de la Solicitud"
        WebElement solicitud = driver.findElement(By.id("ui-id-2"));
        solicitud.click();

//flujo corto
//dar Dobleclick sobre un registro para cargar los datos de uno previo
        dobleClickEnElemento("//*[@id=\"3\"]/td[5]");

//selecciona pestaña "Pago de Derecho
        WebElement pagoD = driver.findElement(By.id("ui-id-4"));
        pagoD.click();

        WebElement btnBorrarDP = driver.findElement(By.xpath("//*[@id=\"borrarDatosPago\"]"));
        btnBorrarDP.click();

        WebElement ClavRef = driver.findElement(By.xpath("//*[@id=\"solicitud.pago.claveDeReferencia\"]"));
        ClavRef.sendKeys("XZVXCNGHJ");

        WebElement CadDep = driver.findElement(By.xpath("//*[@id=\"solicitud.pago.cadenaPagoDependencia\"]"));
        CadDep.sendKeys("XZCVZD323E");

        WebElement n = driver.findElement(By.xpath("//*[@id=\"solicitud.pago.banco.clave\"]"));
        n.sendKeys("BBVA BANCOMER");

        WebElement llavePagoE = driver.findElement(By.xpath("//*[@id=\"solicitud.pago.llaveDePago\"]"));
        llavePagoE.sendKeys(llavePago);

        //Selección de fecha con calendario
        WebElement fechaPago = driver.findElement(By.xpath("//*[@id=\"calendarTo\"]"));
        fechaPago.sendKeys("14/08/2024");
        llavePagoE.click();

        WebElement Import = driver.findElement(By.xpath("//*[@id=\"solicitud.pago.impPago\"]"));
        Import.sendKeys("1000");

        // una vez cargados los datos daremos continuar
        WebElement btnCont = driver.findElement(By.xpath("//*[@id=\"guardarSolicitud\"]"));
        btnCont.click();

        //selecionar solo los necesarios
        WebElement checkDoc = driver.findElement(By.xpath("//*[@id=\"cb_jqgridDoctosEspecificos\"]"));
        checkDoc.click();

        WebElement checkNoElim1 = driver.findElement(By.xpath("//*[@id=\"jqg_jqgridDoctosEspecificos_0\"]"));
        checkNoElim1.click();

        WebElement checkNoElim2 = driver.findElement(By.xpath("//*[@id=\"jqg_jqgridDoctosEspecificos_1\"]"));
        checkNoElim2.click();

        WebElement checkNoElim3 = driver.findElement(By.xpath("//*[@id=\"jqg_jqgridDoctosEspecificos_2\"]"));
        checkNoElim3.click();

        WebElement btnElim = driver.findElement(By.xpath("//*[@id=\"deleteButton\"]"));
        btnElim.click();

        WebElement btnConti = driver.findElement(By.xpath("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]"));
        btnConti.click();

// Crea un WebDriverWait directamente con duración
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
// Espera hasta que el elemento sea clickeable
        WebElement btnAdD = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Adjuntar documentos']")));

// Realiza la acción deseada
        btnAdD.click();

        WebElement doc1 = driver.findElement(By.xpath("//*[@id=\"solicitud_0\"]/table/tbody/tr[1]/td[4]/input"));
        doc1.sendKeys("C:\\Users\\JNoeMC\\IdeaProjects\\Tramites-Vucem2\\src\\test\\resources\\Cargadocumento\\Lorem_ipsum.pdf");

        WebElement doc2 = driver.findElement(By.xpath("//*[@id=\"solicitud_1\"]/table/tbody/tr[1]/td[4]/input"));
        doc2.sendKeys("C:\\Users\\JNoeMC\\IdeaProjects\\Tramites-Vucem2\\src\\test\\resources\\Cargadocumento\\Lorem_ipsum.pdf");

        WebElement doc3 = driver.findElement(By.xpath("//*[@id=\"solicitud_2\"]/table/tbody/tr[1]/td[4]/input"));
        doc3.sendKeys("C:\\Users\\JNoeMC\\IdeaProjects\\Tramites-Vucem2\\src\\test\\resources\\Cargadocumento\\Lorem_ipsum.pdf");

        WebElement doc4 = driver.findElement(By.xpath("//*[@id=\"solicitud_3\"]/table/tbody/tr[1]/td[4]/input"));
        doc4.sendKeys("C:\\Users\\JNoeMC\\IdeaProjects\\Tramites-Vucem2\\src\\test\\resources\\Cargadocumento\\Lorem_ipsum.pdf");

        WebElement doc5 = driver.findElement(By.xpath("//*[@id=\"solicitud_4\"]/table/tbody/tr[1]/td[4]/input"));
        doc5.sendKeys("C:\\Users\\JNoeMC\\IdeaProjects\\Tramites-Vucem2\\src\\test\\resources\\Cargadocumento\\Lorem_ipsum.pdf");

        WebElement btnDoc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Adjuntar']")));
        btnDoc.click();

        WebElement btnCer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnCerrar")));
        btnCer.click();

        WebElement btnContinuar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Continuar']")));
        btnContinuar.click();

//Firma final del tramite
        firmaSoli.firmarsolicitante();
        WebElement btnFirmar = driver.findElement(By.xpath("//*[@id=\"btnSubmit\"]"));
        btnFirmar.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Obtener Folio
        WebElement folioElement = driver.findElement(By.xpath("//*[@id=\"notification\"]/div/ul/li"));
        String folioText = folioElement.getText();
        Pattern pattern = Pattern.compile("<([^>]*)>");
        Matcher matcher = pattern.matcher(folioText);
        String folioNumber = null;

        if (matcher.find()) {
            folioNumber = matcher.group(1);
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
