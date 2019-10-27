package ozon;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

import Pages.OzonPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Before
    public void startTest(){
        System.out.println("----------------------------------Начало теста----------------------------------");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        Configuration.timeout = 6000;
        Configuration.startMaximized = true;
        open(OzonPage.URL);
        OzonPage.closeCookiesMessage().click();
        WebDriverRunner.driver();
    }

    @Test
    public void buyRandomBook()
    {
        OzonPage.getCatalog().click();
        OzonPage.getBooks().hover();
        OzonPage.getComputerTechnologies().click();
        OzonPage.BooksPage.selectBestseller();
        OzonPage.BooksPage.selectProgrammingLanguages();
        Random rnd = new Random();
        int i = rnd.nextInt(OzonPage.ProductPage.addToCartButtonList().size()+1) ;
        String buyTitle = OzonPage.ProductPage.tileNameList().get(i).getText();
        OzonPage.ProductPage.addToCartButtonList().get(i).click();
        Assert.assertTrue("Книга не добавлена в корзину", !(OzonPage.ProductPage.addToCartButtonList().get(i)==visible));
        OzonPage.getCart().click();
        Assert.assertTrue("Названия книг не совбадают", buyTitle.equalsIgnoreCase(OzonPage.CartPage.cartTileName().getText()));
    }

    @After
    public void closeTest(){
        WebDriverRunner.closeWebDriver();
        System.out.println("----------------------------------Конец теста----------------------------------");
    }
}

