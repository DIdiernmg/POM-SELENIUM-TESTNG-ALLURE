package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.qameta.allure.Step;
import utils.ConfigReader;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    @Step("Iniciando el navegador y navegando a la URL")
    public void setUp() {
        // Selenium 4 detecta automáticamente el driver del sistema
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Aquí es donde entra el Data Driven
        driver.get(ConfigReader.get("url"));
    }

    @AfterMethod
    @Step("Cerrando sesión del navegador")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}