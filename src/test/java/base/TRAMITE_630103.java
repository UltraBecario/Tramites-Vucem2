//package base;
//import java.time.Duration;
//import java.util.concurrent.TimeUnit;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//
//public class TRAMITE_630103 {
//	public WebDriver driver;
//
//	@Before
//	public void inicializar() {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jozz1\\Desktop\\Practica Selenium\\PJ3\\TramitesVucem\\SELENIUM_TESTING\\src\\test\\resources\\Cargadocumento\\chromedriver.exe");
//		driver = new ChromeDriver();
//	}
//
//	@Test
//
//	public void login() throws InterruptedException {
//
//		driver.get("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=");
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		firmarsolicitante();
//		WebElement fileingresar = driver.findElement(By.className("btn-primary"));
//		fileingresar.click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		WebElement tipopersona = driver.findElement(By.id("claveRol"));
//		WebElement tipopersonarol =tipopersona.findElement(By.xpath("//*[@value= 'PersonaMoral']"));
//		tipopersonarol.click();
//		WebElement fileingresarmoral = driver.findElement(By.className("btn-primary"));
//		fileingresarmoral.click();
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		WebElement tramite = driver.findElement(By.id("Trámites"));
//		tramite.click();
//		WebElement solicitudesnuevas =driver.findElement(By.xpath("//*[@id=\"subenlaces\"]/ul/li[5]/ul/li[3]/a"));
//		solicitudesnuevas.click();
//		WebElement hacienda =driver.findElement(By.xpath("//*[@id=\"workingArea\"]/form/a[1]/img"));
//		hacienda.click();
//		WebElement importacion =driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[6]/ul/li[16]/a"));
//		importacion.click();
//		WebElement autorizacion =driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[6]/ul/li[16]/ul/li[1]/a"));
//		autorizacion.click();
//		WebElement tramite_630103 =driver.findElement(By.xpath("//*[@id=\"servicios\"]/ul/li[16]/ul/li[1]/ul/li[3]/a"));
//		tramite_630103.click();
//		WebElement solicitud =driver.findElement(By.xpath("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a"));
//		solicitud.click();
//		WebElement aduanaingreso = driver.findElement(By.id("datosImportacionTemporal.cveAduana"));
//		WebElement aduanaingresoopcion =aduanaingreso.findElement(By.xpath("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[3]/div[2]/div[1]/div/select/option[2]"));
//		aduanaingresoopcion.click();
//		WebElement fechaingreso = driver.findElement(By.xpath("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[4]/div[2]/div[1]/div[2]/input"));
//		fechaingreso.sendKeys("02/04/2024");
//		WebElement propietario = driver.findElement(By.id("ddlTipoPropietario"));
//		WebElement propietarioopcion =propietario.findElement(By.xpath("//*[@id=\"ddlTipoPropietario\"]/option[2]"));
//		propietarioopcion.click();
//		WebElement descripcionmercancia = driver.findElement(By.id("tramite.descMercancia"));
//		descripcionmercancia.sendKeys("MercanciaPrueba");
//		WebElement descripcionmotivo = driver.findElement(By.id("tramite.descMotivo"));
//		descripcionmotivo.sendKeys("MotivoPrueba");
//		WebElement listadetallada = driver.findElement(By.id("tramite.descCkeckList"));
//		listadetallada.sendKeys("ListaDetalladaPrueba");
//		WebElement checkboxmanifiesto =propietario.findElement(By.xpath("//*[@id=\"declaracion[0]\"]"));
//		checkboxmanifiesto.click();
//		WebElement guardarsolicitud =propietario.findElement(By.xpath("//*[@id=\"guardarSolicitud\"]"));
//		guardarsolicitud.click();
//		WebElement continuarrequisitos =driver.findElement(By.xpath("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]"));
//		continuarrequisitos.click();
//		WebElement adjuntardocumentos =driver.findElement(By.xpath("//*[@id=\"docs\"]/tbody/tr[6]/td[2]/div/input[2]"));
//		adjuntardocumentos.click();
//		WebElement cargadocumentootro =driver.findElement(By.xpath("//*[@id=\"solicitud_0\"]/table/tbody/tr[1]/td[4]/input"));
//		cargadocumentootro.sendKeys("C:\\Users\\jozz1\\Desktop\\Practica Selenium\\PJ3\\TramitesVucem\\SELENIUM_TESTING\\src\\test\\resources\\Cargadocumento\\Lorem_ipsum.pdf");
//		WebElement cargadocumentosoportefotografico =driver.findElement(By.xpath("//*[@id=\"solicitud_1\"]/table/tbody/tr[1]/td[4]/input"));
//		cargadocumentosoportefotografico.sendKeys("C:\\Users\\jozz1\\Desktop\\Practica Selenium\\PJ3\\TramitesVucem\\SELENIUM_TESTING\\src\\test\\resources\\Cargadocumento\\Lorem_ipsum.pdf");
//		WebElement cargadocumentocartacompromiso =driver.findElement(By.xpath("//*[@id=\"solicitud_2\"]/table/tbody/tr[1]/td[4]/input"));
//		cargadocumentocartacompromiso.sendKeys("C:\\Users\\jozz1\\Desktop\\Practica Selenium\\PJ3\\TramitesVucem\\SELENIUM_TESTING\\src\\test\\resources\\Cargadocumento\\Lorem_ipsum.pdf");
//		WebElement adjuntar =driver.findElement(By.id("btnAnexar"));
//		adjuntar.click();
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		WebElement documentosanexos =driver.findElement(By.xpath("//*[@id=\"uploadDocumentos\"]/form/div[1]/div/div[1]/h3"));
//		wait.until(ExpectedConditions.visibilityOf(documentosanexos));
//		WebElement cerrarcargadocumento =driver.findElement(By.id("btnCerrar"));
//		wait.until(ExpectedConditions.elementToBeClickable(cerrarcargadocumento));
//		cerrarcargadocumento.click();
//		WebElement continuarafirma =driver.findElement(By.id("siguienteButton"));
//		continuarafirma.click();
//		firmarsolicitante();
//		WebElement firmar =driver.findElement(By.id("btnSubmit"));
//		firmar.click();
//	}
//	private void firmarsolicitante() {
//		WebElement fileCertificadofinal = driver.findElement(By.id("certificate"));
//		fileCertificadofinal.sendKeys("C:\\Users\\jozz1\\Desktop\\Practica Selenium\\PJ3\\TramitesVucem\\SELENIUM_TESTING\\src\\test\\resources\\Cargadocumento\\aal0409235e6.cer");
//		WebElement filellavefinal = driver.findElement(By.id("privateKey"));
//		filellavefinal.sendKeys("C:\\Users\\jozz1\\Desktop\\Practica Selenium\\PJ3\\TramitesVucem\\SELENIUM_TESTING\\src\\test\\resources\\Cargadocumento\\AAL0409235E6_1012231310.key");
//		WebElement filepasswordfinal = driver.findElement(By.id("privateKeyPassword"));
//		filepasswordfinal.sendKeys("delfin40");
//
//	}
//
//
//	@After
//	public void finalizar()
//
//	{
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		//driver.close();
//	}
//}