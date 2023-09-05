package chrome;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.MainPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestCheckHref {
    private final String expected;
    private final String nameLogo;

    public TestCheckHref(String expected, String nameLogo) {
        this.expected = expected;
        this.nameLogo = nameLogo;
    }

    @Parameterized.Parameters
    public static Object[][] getQuest() {
        return new Object[][]{
                {"https://yandex.ru/", "Yandex"},
                {"https://qa-scooter.praktikum-services.ru/", "Scooter"}
        };
    }

    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void checkHref() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPage = new MainPage(driver);

        assertEquals(expected, mainPage.checkLogo(nameLogo));
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
