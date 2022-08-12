package com.nttdata.steps;

import com.nttdata.page.GuruLoginPage;
import com.nttdata.page.LinioLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LinioSteps {

    private WebDriver driver;

    //constructor
    public LinioSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Escribir el usuario
     * @param user el usuario
     */
    public void typeUser(String user){
        WebElement userInputElement = driver.findElement(LinioLoginPage.userInput);
        userInputElement.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LinioLoginPage.loginButton));


    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        this.driver.findElement(LinioLoginPage.passInput).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login(){
        this.driver.findElement(LinioLoginPage.loginButton).click();
    }
    /**
     * Hacer click en el botón Mejores Calificados
     */
    public void Mejores() { this.driver.findElement(LinioLoginPage.mejoresCalificados).click(); }

    public void Producto() { this.driver.findElement(LinioLoginPage.producto).click(); }
    public void buy() { this.driver.findElement(LinioLoginPage.buy).click(); }


}
