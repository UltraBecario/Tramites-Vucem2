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
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JNoeMC\\IdeaProjects\\Tramites-Vucem2\\src\\test\\resources\\Cargadocumento\\chromedriver.exe");
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

//Nueva Captura
        WebElement mas = driver.findElement(By.xpath("//*[@id=\"accordion\"]/div/div[1]/button"));
        mas.click();

//llenar info
        WebElement NumAutorizacion = driver.findElement(By.id("solicitud.numAutorizacion"));
        NumAutorizacion.sendKeys("23039012024000197");
        Thread.sleep(5000);
        NumAutorizacion.sendKeys("23039012024000197");

//        WebElement NumAutorizacionSol = NumAutorizacion.findElement(By.xpath("//*[@id=\"solicitud.numAutorizacion\"]/option[2]"));
//        NumAutorizacionSol.isEnabled();

        WebElement FechaInspeccion = driver.findElement(By.xpath("//*[@id=\"solicitud.fechaInspeccion\"]"));
        FechaInspeccion.click();
        WebElement fecha = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[5]/a"));
        fecha.click();

        WebElement body = driver.findElement(By.xpath("/html/body"));
        body.click();

        WebElement hora = driver.findElement(By.xpath("//*[@id=\"horaInspeccion\"]"));
        hora.sendKeys("03:30");
        body.click();

        WebElement cantidad = driver.findElement(By.xpath("//*[@id=\"solicitud.numeroTotalCarros\"]"));
        cantidad.sendKeys("1");
        body.click();

        WebElement check = driver.findElement(By.xpath("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[14]/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[2]/input"));
        check.click();

        WebElement btnModi = driver.findElement(By.xpath("//*[@id=\"btnSaldoMercancia\"]"));
        btnModi.click();

        WebElement UMT = driver.findElement(By.xpath("//*[@id=\"frmSaldos\"]/div[5]/div/div/input"));
        UMT.sendKeys("1");

        WebElement btnAcep = driver.findElement(By.xpath("//*[@id=\"frmSaldos\"]/div[6]/div[3]/div/input[2]"));
        btnAcep.click();

        WebElement btnContinue = driver.findElement(By.xpath("//*[@id=\"guardarSolicitud\"]"));
        btnContinue.click();

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
