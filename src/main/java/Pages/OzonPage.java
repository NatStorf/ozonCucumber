package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OzonPage {
    public static final String URL = "https://www.ozon.ru/";

    public static SelenideElement closeCookiesMessage() {
        return $(By.xpath("//button[@class='close']"));
    }
    public static SelenideElement chooseLocation() {
        return $(By.xpath("//button/span[@class='c11d10']"));
    }
    public static SelenideElement locationInputField() {
        return $(By.xpath("//div/input[@autofocus]"));
    }
    public static SelenideElement getCatalog() {
        return $(By.xpath("//button[@value='Каталог']"));
    }
    public static SelenideElement getBooks() {
        return $(By.xpath("//span[contains(text(), 'Книги')]"));
    }
    public static SelenideElement getComputerTechnologies() {
        return $(By.xpath("//span[contains(text(), 'Компьютерные технологии')]"));
    }
    public static SelenideElement getSportingGoods() {
        return $(By.xpath("//span[contains(text(), 'Спортивные товары')]"));
    }
    public static SelenideElement getSnowboardAndAccessories() {
        return $(By.xpath("//span[contains(text(), 'Сноуборды и аксессуары')]"));
    }
    public static SelenideElement getCart() {
        return $(byText("Корзина"));
    }

    public static class ProductPage{
        public static int rndProduct=0;
        public static String tileName=null;
        public static List<SelenideElement> productList(){
           return  $$(By.xpath("//*[@class='tile-wrapper']"));
        }
        public static List<SelenideElement> addToCartButtonList() {
            return $$(By.xpath("//button/*[contains(text(),'В корзину')]"));
        }
        public static List<SelenideElement> tileNameList() {
            return $$(By.xpath("//span[@data-test-id='tile-name']"));
        }
    }

    public static class CartPage {
        public static SelenideElement cartTileName() {
            return $(By.xpath("//a[@class='title']/span"));
        }
    }


    public static class BooksPage {
        public static void selectBestseller() {
            SelenideElement bestseller = $(By.xpath("//span[contains(text(),'Бестселлеры')]"));
            if (!bestseller.isSelected()) {
                bestseller.click();
            }
        }
        public static void selectProgrammingLanguages() {
            SelenideElement PL = $(By.xpath("//span[contains(text(),'Языки программирования')]"));
            if (!PL.isSelected()) {
                PL.click();
            }
        }
    }

    public static class SnowBoardPage {
        public static SelenideElement getSnowboard() {
            return $(By.xpath("//div/div/div/a[contains(text(),'Сноуборды')]"));
        }
        public static SelenideElement getStartingPrice(){
            return $(By.xpath("//input[@data-test-id='range-filter-from-input']"));
        }
        public static void selectForBeginners(){
            SelenideElement forBeginners = $(byText("Для начинающих"));
            if (!forBeginners.isSelected()) {
                forBeginners.click();
            }
        }
    }

}

