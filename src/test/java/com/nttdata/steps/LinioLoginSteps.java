package com.nttdata.steps;

import com.nttdata.page.LinioLoginPage;
import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LinioLoginSteps {

    private WebDriver driver;

    //constructor
    public LinioLoginSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Escribir el usuario
     * @param user el usuario
     */
    public void typeUser(String user){
        WebElement userInputElement = driver.findElement(LinioLoginPage.userInputlinio);
        userInputElement.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LinioLoginPage.loginButtonlinio));


    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        this.driver.findElement(LinioLoginPage.passInputlinio).sendKeys(password);
    }


    public void login(){
        try {
            this.driver.findElement(LinioLoginPage.loginButtonlinio).click();
        }catch (Exception e){
        }

    }
    public void mejoresCalificados(){
        try {
            this.driver.findElement(LinioLoginPage.mejoresCaliButtonlinio).click();
        }catch (Exception e){

        }

    }
    public void Producto(){
        try {
            this.driver.findElement(LinioLoginPage.spanProductolinio).click();
        }catch (Exception e){

        }

    }
    public void añadirProducto(){
        try {
            this.driver.findElement(LinioLoginPage.añadirbuttonlinio).click();
        }catch (Exception e){

        }

    }


}
