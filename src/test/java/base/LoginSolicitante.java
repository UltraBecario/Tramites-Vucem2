//package base;
//import java.util.concurrent.TimeUnit;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class LoginSolicitante {
//	public WebDriver driver;
//
//	@Before
//	public void inicializar() {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jozz1\\Desktop\\Practica Selenium\\PJ3\\TramitesVucem\\SELENIUM_TESTING\\src\\test\\resources\\Cargadocumento\\chromedriver.exe");
//		driver = new ChromeDriver();
//	}
//
//
//	@Test
//
//	public void login() throws InterruptedException {
//
//		driver.get("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=");
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//
//		WebElement fileCertificado = driver.findElement(By.id("certificate"));
//		fileCertificado.sendKeys("C:\\Users\\jozz1\\Desktop\\Practica Selenium\\PJ3\\TramitesVucem\\SELENIUM_TESTING\\src\\test\\resources\\Cargadocumento\\aal0409235e6.cer");
//		WebElement filellave = driver.findElement(By.id("privateKey"));
//		filellave.sendKeys("C:\\Users\\jozz1\\Desktop\\Practica Selenium\\PJ3\\TramitesVucem\\SELENIUM_TESTING\\src\\test\\resources\\Cargadocumento\\AAL0409235E6_1012231310.key");
//		WebElement filepassword = driver.findElement(By.id("privateKeyPassword"));
//		filepassword.sendKeys("delfin40");
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
//		WebElement gafete =driver.findElement(By.xpath("//*[@id=\"servicios\"]/ul/li[10]/a"));
//		gafete.click();
//		WebElement transportistas =driver.findElement(By.xpath("//*[@id=\"servicios\"]/ul/li[10]/ul/li[2]/a"));
//		transportistas.click();
//		WebElement devoluciongafete =driver.findElement(By.xpath("//*[@id=\"servicios\"]/ul/li[10]/ul/li[2]/ul/li[3]/a"));
//		devoluciongafete.click();
//		WebElement pagingresardatos =driver.findElement(By.xpath("//*[@id=\"ui-id-2\"]"));
//		pagingresardatos.click();
//		WebElement numerogafete =driver.findElement(By.xpath("//*[@id=\"numGafete\"]"));
//		numerogafete.sendKeys("SATGN2021120101000104444");
//		WebElement curp = driver.findElement(By.xpath("//*[@id=\"curp\"]"));
//		curp.sendKeys("EIVG790905HDFSZB02");
//		WebElement rfc = driver.findElement(By.xpath("//*[@id=\"rfc\"]"));
//		rfc.sendKeys("EIVG790905QA1");
//		WebElement nombre = driver.findElement(By.xpath("//*[@id=\"nombre\"]"));
//		rfc.sendKeys("GABRIEL ARIOC");
//		WebElement apellidopaterno = driver.findElement(By.xpath("//*[@id=\"apellidoPaterno\"]"));
//		apellidopaterno.sendKeys("ESPINOSA");
//		WebElement apellidomaterno = driver.findElement(By.xpath("//*[@id=\"apellidoMaterno\"]"));
//		apellidomaterno.sendKeys("VAZQUEZ");
//		WebElement buscargafete =driver.findElement(By.xpath("//*[@id=\"botonBuscar\"]"));
//		buscargafete.click();
//
//	}
//
//	@After
//	public void finalizar()
//
//	{
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		//driver.close();
//	}
//}
