package selenide;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.MainPage;

@RunWith(Parameterized.class)
public class TestSuccessfulOrder {
    private final int number;

    public TestSuccessfulOrder(int number) {
        this.number = number;
    }
    @Parameterized.Parameters
    public static Object[][] getQuest() {
        return new Object[][]{
                {0},
                {1}
        };
    }

    @Test
    public void orderTest() {
        MainPage mainPage = new MainPage("https://qa-scooter.praktikum-services.ru/");

        mainPage.acceptCook();

        mainPage.scrollToOrder(number);

        mainPage.getListMenu().get(number).click();

        mainPage.getListMenu().get(number).click();
    }

}
