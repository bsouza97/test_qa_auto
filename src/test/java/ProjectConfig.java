import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class ProjectConfig {
    static WebDriver driver;
    private static Map<String, Object> vars;
    private String url = "https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/";
    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.get(url);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}