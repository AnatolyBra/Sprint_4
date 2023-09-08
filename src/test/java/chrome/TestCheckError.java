package chrome;

import core.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.MainPage;
import page.order.OrderPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestCheckError extends BaseTest {
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

    @Test
    public void checkErrorMessage() {
        MainPage mainPage = new MainPage();
        mainPage.acceptByCook();
        mainPage.clickOrder();

        OrderPage orderPage = new OrderPage();
        orderPage.clickNextButton();

        assertEquals("Сообщение о подсказке не корректное", message, orderPage.getListErrorMessage().get(number).getText());
    }

//    @After
//    public void teardown() {
//        // Закрой браузер
//        driver.quit();
//    }
}
