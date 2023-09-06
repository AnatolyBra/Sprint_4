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
import page.order.OrderPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestCheckError {
    private WebDriver driver;
    private final String message;
    private final int number;

    public TestCheckError(String message, int number) {
        this.message = message;
        this.number = number;
    }

    @Parameterized.Parameters
    public static Object[][] getQuest() {
        return new Object[][]{
                {"Введите корректное имя", 0},
                {"Введите корректную фамилию", 1},
                {"Введите корректный адрес", 2},
                {"Выберите станцию", 3},
                {"Введите корректный номер", 4},
        };
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void checkErrorMessage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/order");

        OrderPage orderPage = new OrderPage(driver);

        orderPage.clickСookButtonSelenium();

        orderPage.clickNextButton();

        assertEquals("Сообщение о подсказке не корректное", message, orderPage.getListErrorMessage().get(number).getText());
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
