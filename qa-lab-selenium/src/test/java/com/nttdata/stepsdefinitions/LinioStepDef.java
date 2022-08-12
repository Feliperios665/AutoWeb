package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LinioSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import com.nttdata.steps.InventorySteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinioStepDef {

    private WebDriver driver;
    private Scenario scenario;
    private LinioSteps loginSteps;

    private InventorySteps inventorySteps(WebDriver driver){
        return new InventorySteps(driver);
    }

    @Before(order = 0)
    public void setUp(){
        //setUp
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        //crear el driver
        driver = new ChromeDriver();
        //max
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }
    @Given("que estoy en la pagina de inicio de sesion Linio")
    public void queEstoyEnLaPaginaDeInicioDeSesionLinio() {
        driver.get("https://www.linio.com.co/account/login");
        screenShot();
    }

    @When("ingreso mis datos de usuario {string} y contraseña {string}")
    public void ingresoMisDatosDeUsuarioYContraseña(String user, String password) {
        loginSteps = new LinioSteps(driver);
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        screenShot();
    }

    @And("hago click en inisiar secion segura")
    public void hagoClickEnInisiarSecionSegura() {
        loginSteps = new LinioSteps(driver);
        loginSteps.login();
    }

    @And("valido que estoy en la pagina principal")
    public void validoQueEstoyEnLaPaginaPrincipal() {
        screenShot();
    }

    @And("hago click en mejores calificados")
    public void hagoClickEnMejoresCalificados() {
        loginSteps = new LinioSteps(driver);
        loginSteps.Mejores();
    }

    @And("seleccion un producto")
    public void seleccionUnProducto() {
        loginSteps = new LinioSteps(driver);
        loginSteps.Producto();
        screenShot();
    }

    @And("añado al carrito")
    public void añadoAlCarrito() {
        loginSteps = new LinioSteps(driver);
        loginSteps.buy();
        screenShot();
    }
    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }


}
