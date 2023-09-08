package page.order;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OrderPage extends BasePage {

    public OrderPage(WebDriver driver) {
        BasePage.driver = driver;
    }

    public OrderPage(){}

    private final By name = By.xpath(".//input[@placeholder='* Имя']");
    private final By surname = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metro = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By phone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    private final By date = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By rentalPeriod = By.xpath(".//div[@class='Dropdown-placeholder']");
    private final By blackScooter = By.id("black");

    private final By nextButton = By.xpath(".//button[text()='Далее']");
    //кнопка Заказать
    private final By orderFinalButton = By.xpath(".//button[text()='Назад']/parent::div/button[text()='Заказать']");
    //кнопка Да - в модальном окне
    private final By okButton = By.xpath(".//button[text()='Да']");

    private final By orderIsProcessed = By.xpath(".//div[text()='Заказ оформлен']");
    private final By listErrorMessage = By.xpath(".//div[contains(@class,'Form')]//div[contains(@class,'ErrorMessage') or contains(@class,'MetroError')]");

    //принять куки
    private final By cookButtonSelenium = By.id("rcc-confirm-button");

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void clickOkButton() {
        driver.findElement(okButton).click();
    }

    public void clickOrderButton() {
        driver.findElement(orderFinalButton).click();
    }

    public void setName(String name) {
        driver.findElement(this.name).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(this.surname).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(this.address).sendKeys(address);
    }

    public void setStationMetro(String station) {
        driver.findElement(metro).sendKeys(station);
        waitMetroIsVisible(station);
        containsText(station).click();
    }

    public void setPhone(String phone) {
        driver.findElement(this.phone).sendKeys(phone);
    }

    public void setDate(String date) {
        driver.findElement(this.date).sendKeys(date);
        containsText("5").click();
    }

    public void setRentalPeriod(String period) {
        driver.findElement(rentalPeriod).click();
        containsText(period).click();
    }

    public void checkBoxBlackScooterSelenium() {
        driver.findElement(blackScooter).click();
    }

    public boolean orderIsProcessedIsVisible() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(orderIsProcessed));
        return driver.findElement(orderIsProcessed).isDisplayed();
    }

    public List<WebElement> getListErrorMessage() {
        return driver.findElements(listErrorMessage);
    }

    private WebElement containsText(String text) {
        return driver.findElement(By.xpath(".//*[contains(text(),'" + text + "')]"));
    }

    private void waitMetroIsVisible(String station) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[contains(text(),'" + station + "')]")));
    }
}
