package Test220502;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirmaSoli {
    public WebDriver driver;

    public FirmaSoli(WebDriver driver) {
        this.driver = driver;
    }
    @Before
    public void inicializar() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jozz1\\Desktop\\Practica Selenium\\PJ3\\TramitesVucem\\SELENIUM_TESTING\\src\\test\\resources\\Cargadocumento\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public void firmarsolicitante() {
        WebElement fileCertificadofinal = driver.findElement(By.id("certificate"));
        fileCertificadofinal.sendKeys("C:\\Users\\jozz1\\Desktop\\Practica Selenium\\PJ3\\TramitesVucem\\SELENIUM_TESTING\\src\\test\\resources\\Cargadocumento\\CredSoli\\aal0409235e6.cer");
        WebElement filellavefinal = driver.findElement(By.id("privateKey"));
        filellavefinal.sendKeys("C:\\Users\\jozz1\\Desktop\\Practica Selenium\\PJ3\\TramitesVucem\\SELENIUM_TESTING\\src\\test\\resources\\Cargadocumento\\CredSoli\\AAL0409235E6_1012231310.key");
        WebElement filepasswordfinal = driver.findElement(By.id("privateKeyPassword"));
        filepasswordfinal.sendKeys("delfin40");
    }
}
