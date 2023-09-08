package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage {
    public MainPage(String url) {
        Selenide.open(url);
    }

    public MainPage(WebDriver driver) {
        BasePage.driver = driver;
    }

    public MainPage(){

    }

    //Selenide
    private final SelenideElement nameMenu = $x(".//div[text()='Вопросы о важном']");
    private final SelenideElement cookButton = $(byId("rcc-confirm-button"));
    private final ElementsCollection listMenu = $$x(".//div[@class='accordion__item']");

    //Selenium
    private final By nameMenuSelenium = By.xpath(".//div[text()='Вопросы о важном']");
    private final By cookButtonSelenium = By.id("rcc-confirm-button");
    private final By orderButton = By.xpath(".//*[text()='Заказать']");
    //список вопросов
    private final By listMenuSelenium = By.xpath(".//div[@class='accordion__item']");
    //коллекция из двух кнопок Заказать
    private final By orderButtonsSelenium = By.xpath(".//*[contains(@class,'ra12g') and text()='Заказать']");

    public String checkLogo(String logo) {
        return driver.findElement(By.xpath(".//img[@alt='" + logo + "']/parent::a")).getAttribute("href");
    }

    //Selenide
    //спуститься к списку вопросов
    public void scrollToHeader() {
        nameMenu.scrollTo();
    }

    //принять куки
    public void acceptCook() {
        if (cookButton.isDisplayed()) {
            cookButton.click();
        }
    }

    //получить список вопросов
    public ElementsCollection getListMenu() {
        return listMenu;
    }

    //Selenium
    public List<WebElement> getElementsHeaderBy() {
        return driver.findElements(listMenuSelenium);
    }

    public List<WebElement> getElementsBy() {
        return driver.findElements(By.xpath(".//div[@class='accordion__item']//p"));
    }

    public void scrollToByHeader() {
        WebElement element = driver.findElement(nameMenuSelenium);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public List<WebElement> getOrderButtonsSelenium() {
        return driver.findElements(orderButtonsSelenium);
    }

    public void scrollToByOrder(int number) {
        WebElement element = driver.findElements(orderButtonsSelenium).get(number);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void acceptByCook() {
        driver.findElement(cookButtonSelenium).click();
    }

    public void clickOrder(){
        driver.findElement(orderButton).click();
    }

    public void waitElementOfList(int number){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(getElementsBy().get(number)));
    }
}
