package ozon;

import Pages.OzonPage;
import io.cucumber.java.ru.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {
    @Когда("открыта главная страница")
    public void открытаГлавнаяСтраница() {
        open(OzonPage.URL);
        OzonPage.closeCookiesMessage().click();
    }

    @Также("выбрана локация {string}")
    public void выбранаЛокация(String arg0) throws InterruptedException {
        OzonPage.chooseLocation().click();
        OzonPage.locationInputField().click();
        OzonPage.locationInputField().sendKeys(arg0);
        Thread.sleep(2000);
        OzonPage.locationInputField().pressEnter();
    }

    @Когда("нажата кнопка Каталог")
    public void нажатаКнопкаКаталог() {
        OzonPage.getCatalog().click();
    }

    @И("выбрана категория Книги - Компьютерные технологии")
    public void выбранаКатегорияКнигиКомпьютерныеТехнологии() {
        OzonPage.getBooks().hover();
        OzonPage.getComputerTechnologies().click();
    }

    @И("выбраны чекбоксы Бестселлеры и Языки програмирования")
    public void выбраныЧекбоксыБестселлерыИЯзыкиПрограмирования() {
        OzonPage.BooksPage.selectBestseller();
        OzonPage.BooksPage.selectProgrammingLanguages();
    }

    @И("выбран рандомный товар и нажата кнопка В корзину")
    public void выбранРандомныйТоварИНажатаКнопкаВКорзину() throws InterruptedException {
        Random rnd = new Random();
        OzonPage.ProductPage.rndProduct = rnd.nextInt(OzonPage.ProductPage.productList().size() + 1);
        System.out.println(OzonPage.ProductPage.productList().size());
        Thread.sleep(4000);
        if (OzonPage.ProductPage.addToCartButtonList().get(OzonPage.ProductPage.rndProduct).exists()) {
            OzonPage.ProductPage.addToCartButtonList().get(OzonPage.ProductPage.rndProduct).click();
        } else {
            System.out.println("Кнопки нет");
        }
        OzonPage.ProductPage.tileName = OzonPage.ProductPage.tileNameList().get(OzonPage.ProductPage.rndProduct).getText();
    }

    @И("открыта страница корзина")
    public void открытаСтраницаКорзина() throws InterruptedException {
        OzonPage.getCart().click();
        Thread.sleep(4000);
    }

    @То("выбранный товар отображается в корзине")
    public void выбранныйТоварОтображаетсяВКорзине() {
        Assert.assertEquals(OzonPage.ProductPage.tileName, OzonPage.CartPage.cartTileName().getText());
    }

    @И("выбрана категория Спортивные товары - Сноуборды и акссесуары")
    public void выбранаКатегорияСпортивныеТоварыСноубордыИАкссесуары() {
        OzonPage.getSportingGoods().hover();
        OzonPage.getSnowboardAndAccessories().click();
    }

    @И("выбрана категория Сноуборды")
    public void выбранаКатегорияСноуборды() {
        OzonPage.SnowBoardPage.getSnowboard().click();
    }

    @И("установлена цена от {int}")
    public void установленаЦенаОт(int sum) throws InterruptedException {
        OzonPage.SnowBoardPage.getStartingPrice().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        OzonPage.SnowBoardPage.getStartingPrice().sendKeys(String.valueOf(sum));
        Thread.sleep(6000);
    }

    @И("выбран чекбокс Для начинающих")
    public void выбранЧекбоксДляНачинающих() throws InterruptedException {
        OzonPage.SnowBoardPage.selectForBeginners();
        Thread.sleep(6000);
    }


}
