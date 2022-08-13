package com.nttdata.stepsdefinitions;
import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.LinioLoginSteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

public class LinioStepsDef {


    private WebDriver driver;
    private Scenario scenario;
    private LinioLoginSteps linioSteps;


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

    @Dado("que me encuentro en la página de login de Linio")
    public void queMeEncuentroEnLaPáginaDeLoginDeLinio() {
        driver.get("https://www.linio.com.pe/account/login");
        screenShot();
    }

    @Cuando("inicio sesión con las credenciales email: {string} y contraseña: {string}")
    public void inicioSesiónConLasCredencialesEmailYContraseña(String user, String password) {
        linioSteps = new LinioLoginSteps(driver);
        linioSteps.typeUser(user);
        linioSteps.typePassword(password);
        screenShot();
    }

    @Y("hago click en el botón Iniciar Sesión Segura")
    public void hagoClickEnElBotónIniciarSesiónSegura() {
        linioSteps.login();
        screenShot();
    }

 



    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }


    @Entonces("valido que debería aparecer mi username {string} en el icono de user profile")
    public void validoQueDeberíaAparecerMiUsernameEnElIconoDeUserProfile(String username) {
        String nombre =  inventorySteps(driver).getUsername();
        //prueba: validamos el nombre del perfil
        Assertions.assertEquals(username, nombre);
        screenShot();
    }

    @Y("hago click en mejores calificados")
    public void hagoClickEnMejoresCalificados() {
        linioSteps.mejoresCalificados();
        screenShot();
    }

    @Y("selecciono cualquier producto")
    public void seleccionoCualquierProducto() {
        linioSteps.Producto();
        screenShot();
    }

    @Y("añado al carrito")
    public void añadoAlCarrito() {
        linioSteps.añadirProducto();
        screenShot();
    }

        @Y("valido que debia aparecerme este mensaje: {string}")
    public void validoQueDebiaAparecermeEsteMensaje(String etiqueta) {
        try {
            String mensaje =  inventorySteps(driver).getmensaje();
            //prueba: validamos el mensaje final
            Assertions.assertEquals(etiqueta,mensaje) ;
            screenShot();

        }catch (Exception e){

        }

    }
}
