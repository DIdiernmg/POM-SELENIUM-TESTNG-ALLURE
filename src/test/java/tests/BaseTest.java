package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.qameta.allure.Step;
import utils.ConfigReader;
import utils.ReportUtils;

public class BaseTest {
    protected WebDriver driver;
// se va amodificar el metodo para que sea modo headless, es decir sin abrir el navegador, para eso se agrega la siguiente linea: options.addArguments("--headless=new");
 /*   @BeforeMethod
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
*/

    @BeforeMethod
    public void setUp() {
        // 1. LEER LA VARIABLE
        String headless = System.getProperty("headless");

        // 2. IMPRIMIR EN CONSOLA PARA VER QUÉ LLEGA (DEBUG)
        System.out.println("DEBUG: El valor de headless es: [" + headless + "]");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // 3. LOGICA REFORZADA
        boolean isHeadless = headless != null && headless.equalsIgnoreCase("true");
        if (isHeadless) {
            System.out.println("👻 ACTIVANDO MODO INVISIBLE...");
            // setHeadless(true) was removed because it's not available in this Selenium version
            // Para compatibilidad con distintas versiones de Chrome
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--disable-gpu");
        } else {
            System.out.println("🖥️ EJECUTANDO EN MODO VISIBLE");
            // en modo visible podemos maximizar la ventana más tarde
        }

        driver = new ChromeDriver(options);

        // Evitar maximizar cuando estamos en headless (puede abrir UI en algunas plataformas)
        if (!isHeadless) {
            driver.manage().window().maximize();
        } else {
            System.out.println("✅ Headless activo: se omite maximize(), se usará el tamaño de ventana configurado.");
        }

        driver.get(ConfigReader.get("url"));
    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        // 🔍 DEBUG: Esto DEBE aparecer en consola siempre
        System.out.println("DEBUG: Finalizando test: " + result.getName());

        // 🚨 Verificamos si el estado es FAILURE (2)
        if (!result.isSuccess()) {
            System.out.println("❌ TEST FALLIDO detectado en BaseTest");
            try {
                ReportUtils.captureScreenshot(result.getName(), driver);
                System.out.println("📸 Llamada a captureScreenshot ejecutada con éxito.");
            } catch (Exception e) {
                System.out.println("⚠️ Error al intentar tomar la captura: " + e.getMessage());
            }
        }

        if (driver != null) {
            driver.quit();
            System.out.println("🔌 Driver cerrado correctamente.");
        }
    }
}