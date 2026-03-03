package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage {

    // El título principal que aparece arriba a la izquierda: "Products"
    @FindBy(css = ".title")
    private WebElement titleText;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    // Usamos el método seguro 'getText' que acabamos de crear en la BasePage
    public String getTitleValue() {
        return getText(titleText);
    }
}