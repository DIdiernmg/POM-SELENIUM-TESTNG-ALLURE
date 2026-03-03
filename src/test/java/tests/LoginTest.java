package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ReportUtils;
import utils.ConfigReader; // Importante para el Data Driven

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
@Epic("Módulo de Autenticación")
@Feature("Login de Usuarios")
public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test(description = "Validar el acceso exitoso con credenciales estándar")
    @Step("INGRESANDO CON USUARIO ESTÁNDAR")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Ingreso con usuario estándar de SauceDemo")
    @Description("Este test verifica que un usuario con privilegios estándar pueda ingresar correctamente al catálogo de productos.")
    @Owner("Didier Marin (Tiko)")
    @Link(name = "Web SauceDemo", url = "https://www.saucedemo.com/")
    @Issue("QA-123")
    @TmsLink("TMS-456")
/* este metodo era el que solo hacia el login sin validacion, lo comente para agregar la validacion del titulo de la pagina
    public void testValidLogin() {
        loginPage = new LoginPage(driver);

        // Usamos ConfigReader para evitar el Hardcode
        loginPage.login(ConfigReader.get("valid_user"), ConfigReader.get("valid_password"));
    }
*/


    public void testValidLogin() {
        loginPage = new LoginPage(driver);

        // 1. Acción: Login usando ConfigReader
        loginPage.login(ConfigReader.get("valid_user"), ConfigReader.get("valid_password"));

        // 2. Validación: Creamos la página de destino
        InventoryPage inventoryPage = new InventoryPage(driver);

        // 3. Assertion: Comparamos el texto real vs el esperado
        String actualTitle = inventoryPage.getTitleValue();
       // String expectedTitle = "Products";
        String expectedTitle = "titulo erroneo";

        // Si fallan, el tercer parámetro dirá exactamente por qué en el reporte
        Assert.assertEquals(actualTitle, expectedTitle, "❌ El login falló: El título de la página no es el esperado.");
    }


    @AfterSuite
    public void setupReport() {
        ReportUtils.createEnvironmentFile();
    }
}
