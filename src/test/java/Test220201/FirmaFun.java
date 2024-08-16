package Test220201;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirmaFun {
    public WebDriver driver;

    public FirmaFun(WebDriver driver) {
        this.driver = driver;
    }
    @Before
    public void inicializar() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jozz1\\Desktop\\Practica Selenium\\PJ3\\TramitesVucem\\SELENIUM_TESTING\\src\\test\\resources\\Cargadocumento\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public void firmarfuncionario() {
        WebElement fileCertificadofinal = driver.findElement(By.id("certificate"));
        fileCertificadofinal.sendKeys("C:\\Users\\jozz1\\Desktop\\Practica Selenium\\PJ3\\TramitesVucem\\SELENIUM_TESTING\\src\\test\\resources\\Cargadocumento\\CredFunc\\mavl621207c95.cer");
        WebElement filellavefinal = driver.findElement(By.id("privateKey"));
        filellavefinal.sendKeys("C:\\Users\\jozz1\\Desktop\\Practica Selenium\\PJ3\\TramitesVucem\\SELENIUM_TESTING\\src\\test\\resources\\Cargadocumento\\CredFunc\\MAVL621207C95_1012241424.key");
        WebElement filepasswordfinal = driver.findElement(By.id("privateKeyPassword"));
        filepasswordfinal.sendKeys("delfin40");

    }
}
