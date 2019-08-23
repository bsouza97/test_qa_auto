import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertTrue;

public class SimulationTest extends ProjectConfig {

    @Test
    public void testCorrectSimulation() {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.findElement(By.id("valorAplicar")).sendKeys("200,00");
        driver.findElement(By.id("valorInvestir")).sendKeys("50,00");
        driver.findElement(By.id("tempo")).sendKeys("5");
        driver.findElement(By.cssSelector(".btSelect > .btn")).click();
        driver.findElement(By.linkText("Meses")).click();
        driver.findElement(By.cssSelector(".btnSimular")).click();

        WebElement finalResult = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/div[2]/span[2]"));
        wait.until(ExpectedConditions.visibilityOfAllElements(finalResult));
        assertTrue(finalResult.getText().contains("R$ 456"));
    }

    @Test
    public void testValueErrorSimulation() {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.findElement(By.id("valorAplicar")).sendKeys("10,00");
        driver.findElement(By.id("valorInvestir")).sendKeys("50,00");
        driver.findElement(By.id("tempo")).sendKeys("5");
        driver.findElement(By.cssSelector(".btSelect > .btn")).click();
        driver.findElement(By.linkText("Meses")).click();
        driver.findElement(By.cssSelector(".btnSimular")).click();

        WebElement valueError = driver.findElement(By.id("valorAplicar-error"));
        wait.until(ExpectedConditions.visibilityOfAllElements(valueError));
        assertTrue(valueError.getText().contains("Valor mínimo de 20.00"));
    }

    @Test
    public void testAllErrors() {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.findElement(By.id("valorAplicar")).sendKeys("10,00");
        driver.findElement(By.id("valorInvestir")).sendKeys("50,00");
        driver.findElement(By.id("tempo")).sendKeys("5");
        driver.findElement(By.xpath("//*[@id=\"formInvestimento\"]/div[5]/ul/li[1]/a")).click();

        WebElement valueError = driver.findElement(By.id("valorAplicar-error"));
        wait.until(ExpectedConditions.visibilityOfAllElements(valueError));
        assertTrue(valueError.getText().contains("Valor mínimo de 20.00"));

        WebElement valueInvestError = driver.findElement(By.id("valorInvestir-error"));
        wait.until(ExpectedConditions.visibilityOfAllElements(valueInvestError));
        assertTrue(valueInvestError.getText().contains("Valor mínimo de 20.00"));

        WebElement requiredField = driver.findElement(By.id("tempo-error"));
        wait.until(ExpectedConditions.visibilityOfAllElements(requiredField));
        assertTrue(requiredField.getText().contains("Obrigatório"));
    }
}