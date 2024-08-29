package Test220201LG;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.UUID;

import Test220201.FirmaSoli;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GenerarFolio220201LG1 {
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
        WebElement solicitud =driver.findElement(By.id("ui-id-2"));
        solicitud.click();

        WebElement btnNuevoRegister = driver.findElement(By.xpath("//*[@id=\"accordion\"]/div/div[1]/button"));
        btnNuevoRegister.click();

        WebElement selecIngAdua = driver.findElement(By.xpath("//*[@id=\"solicitud.claveAduana\"]"));
        selecIngAdua.sendKeys("ACAPULCO, GRO.");

        WebElement selecOfi = driver.findElement(By.xpath("//*[@id=\"solicitud.oficinaInspeccionAgropecuaria.clave\"]"));
        selecOfi.sendKeys("Acapulco");

        WebElement selecPuntInsp = driver.findElement(By.xpath("//*[@id=\"solicitud.unidadAdministrativaRepresentacionFederal.clave\"]"));
        selecPuntInsp.sendKeys("Acapulco Oficina de Inspección");

        WebElement regimn = driver.findElement(By.xpath("//*[@id=\"solicitud.regimen.clave\"]"));
        regimn.sendKeys("Definitivos");

        WebElement select = driver.findElement(By.name("solicitud.tipoMercancia"));
        select.click();

        WebElement btnAgregar = driver.findElement(By.xpath("//*[@id=\"btnAgregarMercanciasA\"]"));
        btnAgregar.click();

        WebElement tipReq = driver.findElement(By.xpath("//*[@id=\"mercanciaGrid.idTipoRequisito\"]"));
        tipReq.sendKeys("Inspección Ocular");

        WebElement req = driver.findElement(By.xpath("//*[@id=\"requisitos\"]"));
        req.sendKeys("Requisito");

        WebElement nCertInt = driver.findElement(By.xpath("//*[@id=\"numeroCertificado\"]"));
        nCertInt.sendKeys("12356");

        WebElement fracAranc = driver.findElement(By.xpath("//*[@id=\"mercanciaGrid.fraccionArancelaria.clave\"]"));
        fracAranc.sendKeys("01039201");

        WebElement nico = driver.findElement(By.xpath("//*[@id=\"idFraccionNico\"]"));
        nico.sendKeys("00");

        WebElement desc = driver.findElement(By.xpath("//*[@id=\"mostrarDescripcionFraccionUsuario\"]"));
        desc.sendKeys("Esta es una prueba de automatización");

        WebElement umt = driver.findElement(By.xpath("//*[@id=\"cantidadUMT\"]"));
        umt.sendKeys("1000000");

        WebElement umc = driver.findElement(By.xpath("//*[@id=\"cantidadUMC\"]"));
        umc.sendKeys("1000000");

        WebElement espec = driver.findElement(By.xpath("//*[@id=\"mercanciaGrid.idEspecie\"]"));
        espec.sendKeys("Canino");

        WebElement pais = driver.findElement(By.xpath("//*[@id=\"mercanciaGrid.clavesPaisesProcedencia\"]"));
        pais.sendKeys("ANTARTIDA");

        WebElement umC = driver.findElement(By.xpath("//*[@id=\"mercanciaGrid.unidadMedidaComercial.clave\"]"));
        umC.sendKeys("Docenas");

        WebElement Uso = driver.findElement(By.xpath("//*[@id=\"mercanciaGrid.idUso\"]"));
        Uso.sendKeys("Animal");

        WebElement paiS = driver.findElement(By.xpath("//*[@id=\"mercanciaGrid.clavesPaisesOrigen\"]"));
        paiS.sendKeys("ANTARTIDA");

        WebElement btnPorArch = driver.findElement(By.xpath("//*[@id=\"btnAgregarDetalleMasiva\"]"));
        btnPorArch.click();

        WebElement btnCargar = driver.findElement(By.xpath("//*[@id=\"fileBean\"]"));
        btnCargar.sendKeys("C:\\Users\\JNoeMC\\IdeaProjects\\Tramites-Vucem2\\src\\test\\resources\\Cargadocumento\\220201_carga_masiva.txt");

        WebElement btnAgregar2 = driver.findElement(By.xpath("//*[@id=\"uploadFileDetalleM\"]"));
        btnAgregar2.click();

        WebElement btnCerrar = driver.findElement(By.xpath("//*[@id=\"btnCancelarDetalleMercancia\"]"));
        btnCerrar.click();

        WebElement btnAgregarRegi = driver.findElement(By.xpath("//*[@id=\"btnAgregarMercancia\"]"));
        btnAgregarRegi.click();

        WebElement btnGuardParcial = driver.findElement(By.xpath("//*[@id=\"guardarSolicitudParcial\"]"));
        btnGuardParcial.click();

        //selecciona pestaña "Datos para movilización nacional"
        WebElement datMovil =driver.findElement(By.xpath("//*[@id=\"ui-id-3\"]"));
        datMovil.click();

        WebElement transpMetod = driver.findElement(By.xpath("//*[@id=\"solicitud.transporte.ideMedioTransporte\"]"));
        transpMetod.sendKeys("Marítimo");

        WebElement idTransp = driver.findElement(By.xpath("//*[@id=\"tabs-3\"]/div[2]/div[2]/div[2]/input"));
        idTransp.sendKeys("020202");

        WebElement punt = driver.findElement(By.xpath("//*[@id=\"solicitud.transporte.puntoVerificacion.idPuntoVerificacion\"]"));
        punt.sendKeys("Región Norte, El Tepetate en Nuevo León");

        WebElement nomEmpTrans = driver.findElement(By.xpath("//*[@id=\"tabs-3\"]/div[4]/div/div[2]/input"));
        nomEmpTrans.sendKeys("Maersk Line");

        WebElement btnGuardMD = driver.findElement(By.xpath("//*[@id=\"guardarSolicitudParcial\"]"));
        btnGuardMD.click();

        //selecciona pestaña "Terceros Relacionados"
        WebElement terRel =driver.findElement(By.xpath("//*[@id=\"ui-id-4\"]"));
        terRel.click();

        WebElement btnAgrgExport = driver.findElement(By.xpath("//*[@id=\"agregarTercero_TIPERS_EXP\"]"));
        btnAgrgExport.click();

        WebElement selecTipPer = driver.findElement(By.name("terceros.tipoPersona"));
        selecTipPer.click();

        WebElement nomExport = driver.findElement(By.xpath("//*[@id=\"terceros_nombre\"]"));
        nomExport.sendKeys("Miriam");

        WebElement pApell = driver.findElement(By.xpath("//*[@id=\"terceros_apellidoPaterno\"]"));
        pApell.sendKeys("Lopez");

        WebElement segApell = driver.findElement(By.xpath("//*[@id=\"terceros_apellidoMaterno\"]"));
        segApell.sendKeys("Solis");

        WebElement pIs = driver.findElement(By.xpath("//*[@id=\"terceros_selectPais\"]"));
        pIs.sendKeys("ANGOLA (REPUBLICA DE)");

        WebElement domPrueb = driver.findElement(By.xpath("//*[@id=\"terceros_domicilioExtranjero\"]"));
        domPrueb.sendKeys("Este es un domicilio de Prueba");

        WebElement lada = driver.findElement(By.xpath("//*[@id=\"terceros_lada\"]"));
        lada.sendKeys("52");

        WebElement tel = driver.findElement(By.xpath("//*[@id=\"terceros_telefono\"]"));
        tel.sendKeys("2298456543");

        WebElement meil = driver.findElement(By.xpath("//*[@id=\"terceros_correoElec\"]"));
        meil.sendKeys("miriam@gmail.com");

        WebElement btnGuardExpor = driver.findElement(By.xpath("//*[@id=\"btnGuardarFrmDatosTercero\"]"));
        btnGuardExpor.click();

        WebElement btnAgregDest = driver.findElement(By.xpath("//*[@id=\"agregarTercero_TIPERS_DES\"]"));
        btnAgregDest.click();

        WebElement selecTipPerDest = driver.findElement(By.name("terceros.tipoPersona"));
        selecTipPerDest.click();

        WebElement nomDest = driver.findElement(By.xpath("//*[@id=\"terceros_nombre\"]"));
        nomDest.sendKeys("Erick");

        WebElement pApellDest = driver.findElement(By.xpath("//*[@id=\"terceros_apellidoPaterno\"]"));
        pApell.sendKeys("Martinez");

        WebElement segApellDest = driver.findElement(By.xpath("//*[@id=\"terceros_apellidoMaterno\"]"));
        segApell.sendKeys("Lopez");

//        WebElement pIsDest = driver.findElement(By.xpath("//*[@id=\"terceros_selectPais\"]"));
//        pIsDest.sendKeys("MEXICO (ESTADOS UNIDOS MEXICANOS)");

        WebElement cpDest = driver.findElement(By.xpath("//*[@id=\"terceros_codPostal\"]"));
        cpDest.sendKeys("39550");

        WebElement eSt = driver.findElement(By.xpath("//*[@id=\"terceros_selectEstado\"]"));
        eSt.sendKeys("GUERRERO");

        WebElement munAlc = driver.findElement(By.xpath("//*[@id=\"terceros_selectMunicipio\"]"));
        munAlc.sendKeys("ACAPULCO DE JUAREZ");

        WebElement colDest = driver.findElement(By.xpath("//*[@id=\"terceros_selectColonia\"]"));
        colDest.sendKeys("CUAUHTEMOC - CP 39550");

        WebElement callDest = driver.findElement(By.xpath("//*[@id=\"terceros_calle\"]"));
        callDest.sendKeys("#10");

        WebElement nExt = driver.findElement(By.xpath("//*[@id=\"terceros_numExterior\"]"));
        nExt.sendKeys("856");

        WebElement nInt = driver.findElement(By.xpath("//*[@id=\"terceros_numInterior\"]"));
        nInt.sendKeys("1");

        WebElement ladaDest = driver.findElement(By.xpath("//*[@id=\"terceros_lada\"]"));
        ladaDest.sendKeys("52");

        WebElement telDest = driver.findElement(By.xpath("//*[@id=\"terceros_telefono\"]"));
        telDest.sendKeys("2298456543");

        WebElement meilDest = driver.findElement(By.xpath("//*[@id=\"terceros_correoElec\"]"));
        meilDest.sendKeys("miriam@gmail.com");

        WebElement btnGuardDest = driver.findElement(By.xpath("//*[@id=\"btnGuardarFrmDatosTercero\"]"));
        btnGuardDest.click();

        //selecciona pestaña "Pago de Derechos"
        WebElement pagoDer =driver.findElement(By.id("ui-id-5"));
        pagoDer.click();

        WebElement banSelect = driver.findElement(By.xpath("//*[@id=\"solicitud.pago.banco.clave\"]"));
        banSelect.sendKeys("BANAMEX");

        WebElement llavePagoE = driver.findElement(By.xpath("//*[@id=\"solicitud.pago.llaveDePago\"]"));
        llavePagoE.sendKeys(llavePago);

        //Selección de fecha con calendario
        WebElement fechaPago = driver.findElement(By.xpath("//*[@id=\"calendarTo\"]"));
        fechaPago.sendKeys("1/08/2024");
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
