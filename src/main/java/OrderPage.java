import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
public class OrderPage {

    private final SelenideElement name = $x(".//input[@placeholder='* Имя']");
    private final SelenideElement surname = $x(".//input[@placeholder='* Фамилия']");
    private final SelenideElement address = $x(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final SelenideElement stationMetro = $x(".//input[@placeholder='* Станция метро']");
    private final SelenideElement phone = $x(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    private final SelenideElement date = $x(".//input[@placeholder='* Когда привезти самокат']");
    private final SelenideElement rentalPeriod = $x(".//div[@class='Dropdown-placeholder']");
    private final SelenideElement oneDay = $x(".//div[text()='сутки']");
    private final SelenideElement blackScooter = $x(".//input[@id='black']");

    private final SelenideElement nextButton = $x(".//button[text()='Далее']");
    private final SelenideElement orderButton = $x(".//div[text()='Про аренду']/parent::div//button[text()='Заказать']");

}
