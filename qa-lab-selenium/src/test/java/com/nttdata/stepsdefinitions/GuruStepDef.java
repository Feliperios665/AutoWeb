package com.nttdata.stepsdefinitions;

import com.nttdata.steps.GuruLoginSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GuruStepDef {

    private WebDriver driver;
    private Scenario scenario;
    private GuruLoginSteps loginSteps;

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
    @Given("que estoy en la pagina de inicio de guru")
    public void queEstoyEnLaPaginaDeInicioDeGuru() {
        driver.get("https://demo.guru99.com/V4/");
        screenShot();
    }

    @When("ingreso mis credenciales de usuario {string} y contraseña {string}")
    public void ingresoMisCredencialesDeUsuarioYContraseña(String user, String password) {
        loginSteps = new GuruLoginSteps(driver);
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);

    }

    @And("hago click en login")
    public void hagoClickEnLogin() {
        loginSteps.login();
        screenShot();
    }

    @And("valido que estoy logueado correctamente")
    public void validoQueEstoyLogueadoCorrectamente() {
    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }

}
