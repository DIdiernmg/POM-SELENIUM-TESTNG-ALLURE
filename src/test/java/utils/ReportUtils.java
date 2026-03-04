package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReportUtils {
   /* esto se modifico con el metodo de abajo para que tome el navegador real que se esta usando en los tests, en vez de ponerlo fijo como "Chrome"
   public static void createEnvironmentFile() {
        Properties properties = new Properties();
        properties.setProperty("Ambiente", "QA - SauceDemo");
        properties.setProperty("Navegador", "Chrome");
        properties.setProperty("Ingeniero", "Didier Marin (Tiko)");
        properties.setProperty("Java.Version", System.getProperty("java.version"));
        properties.setProperty("SO", System.getProperty("os.name"));

        try {
            // Esto lo crea directamente en la carpeta que Allure va a leer
            properties.store(new FileOutputStream("allure-results/environment.properties"), "Allure Environment");
            System.out.println("✅ Environment file creado en allure-results");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
    public static void createEnvironmentFile() {
        Properties properties = new Properties();
        properties.setProperty("Ambiente", "QA - SauceDemo");
        properties.setProperty("Ingeniero", "Didier Marin (Tiko)");
        properties.setProperty("Navegador", System.getProperty("browser", "Chrome")); // Toma el navegador real
        properties.setProperty("SO", System.getProperty("os.name"));

        // Ajustamos la ruta para que caiga dentro de target/allure-results
        try (FileOutputStream out = new FileOutputStream("target/allure-results/environment.properties")) {
            properties.store(out, "Allure Environment Data");
            System.out.println("✅ Archivo de ambiente creado en la ruta de Maven (target).");
        } catch (IOException e) {
            System.out.println("⚠️ No se pudo crear el archivo, pero los tests continúan.");
        }
    }
    @Attachment(value = "Evidencia de fallo: {0}", type = "image/png")
    public static byte[] captureScreenshot(String testName, WebDriver driver) {
        System.out.println("📸 Tomando captura para el test: " + testName);
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}