package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
  //private WebDriver driver; no se pone porque se puso en el BasePage y se hereda , si lo ponemos aquí , no se inicializa y da error de null pointer exception
  // se cambia el localizador para que falle y hacer el debug , quitamos una letra , la e
  @FindBy(id = "user-name")
  private WebElement usernameInput;

  @FindBy(id = "password")
  private WebElement passwordInput;

  @FindBy(id = "login-button")
  private WebElement loginButton;

  //@FindBy(css = ".error-message-container")
  //private WebElement errorContainer;

  public LoginPage(WebDriver driver) {
    //this.driver = driver; no se usa ya con this. se usa super() para llamar al constructor de la clase padre BasePage que es donde se inicializa el driver y los @FindBy
    super(driver);
    //PageFactory.initElements(driver, this); // Inicializa los @FindBy ya no aca porque se puso en el BasePage y se hereda , si lo ponemos aquí , se inicializa dos veces y da error de StaleElementReferenceException
  }

  public void login(String user, String pass) {
    //usernameInput.sendKeys(user);
   // passwordInput.sendKeys(pass);
    //loginButton.click();
    // 1. Usamos el método heredado que espera a que sea visible
    sendKeys(usernameInput, user);

    // 2. Lo mismo para el password
    sendKeys(passwordInput, pass);

    // 3. Usamos el método que espera a que sea clicable
    click(loginButton);
  }
}
