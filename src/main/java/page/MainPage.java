package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    public MainPage(String url) {
        Selenide.open(url);
    }

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Selenide
    private final SelenideElement nameMenu = $x(".//div[text()='Вопросы о важном']");
    private final SelenideElement cookButton = $(byId("rcc-confirm-button"));
    private final ElementsCollection elements = $$x(".//div[@class='accordion__item']");

    //Selenium
    private final By nameByMenu = By.xpath(".//div[text()='Вопросы о важном']");
    private final By cookByButton = By.id("rcc-confirm-button");

    private final ElementsCollection orderButtons = $$x(".//button[text()='Заказать']");

    //Selenide
    public void scrollToHeader() {
        nameMenu.scrollTo();
    }

    public void scrollToOrder(int number) {
        orderButtons.get(number).scrollTo();
    }

    public void acceptCook() {
        if (cookButton.isDisplayed()) {
            cookButton.click();
        }
    }
    public ElementsCollection getElements() {
        return elements;
    }
    //Selenium
    public List<WebElement> getElementsHeaderBy() {
        return driver.findElements(By.xpath("//div[@class='accordion__item']"));
    }

    public List<WebElement> getElementsBy() {
        return driver.findElements(By.xpath(".//div[@class='accordion__item']//p"));
    }


    public void scrollToByHeader() {
        WebElement element = driver.findElement(nameByMenu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void acceptByCook() {
        driver.findElement(cookByButton).click();
    }
}
