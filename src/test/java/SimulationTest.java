import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertTrue;

public class SimulationTest extends ProjectConfig {

    @Test
    public void simpleSimulation() {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.findElement(By.id("valorAplicar")).sendKeys("200,00");
        driver.findElement(By.id("valorInvestir")).sendKeys("50,00");
        driver.findElement(By.id("tempo")).sendKeys("5");
        driver.findElement(By.cssSelector(".btSelect > .btn")).click();
        driver.findElement(By.linkText("Anos")).click();
        driver.findElement(By.cssSelector(".btnSimular")).click();

        WebElement finalResult = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/div[2]/span[2]"));
        wait.until(ExpectedConditions.visibilityOfAllElements(finalResult));
        assertTrue(finalResult.getText().contains("R$ 3.604"));
    }

    @Test
    public void errorSimulation() {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.findElement(By.id("valorAplicar")).sendKeys("10,00");
        driver.findElement(By.id("valorInvestir")).sendKeys("50,00");
        driver.findElement(By.id("tempo")).sendKeys("5");
        driver.findElement(By.cssSelector(".btSelect > .btn")).click();
        driver.findElement(By.linkText("Anos")).click();
        driver.findElement(By.cssSelector(".btnSimular")).click();

        WebElement finalResult = driver.findElement(By.id("valorAplicar-error"));
        wait.until(ExpectedConditions.visibilityOfAllElements(finalResult));
        assertTrue(finalResult.getText().contains("Valor mínimo de 20.00"));
    }
}