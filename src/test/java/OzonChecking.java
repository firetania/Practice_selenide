import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.openqa.selenium.By;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OzonChecking {
    private WebDriver driver;

    /*@BeforeClass
    public void setup() {
        // устанавливаем зависимость, определяющую путь к chomedriver
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        // создаем объект драйвера
        driver = new ChromeDriver();
        // если элемент не найден,
        // то драйвер будет ждать его появления в течении
        // заданного времени (3 секунды) и шагом в 500 мс
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // передаем драйверу адрес страницы
        driver.get("https://www.ozon.ru/");
    }*/

    // некорректно заполнить поле с номером телефона и проверить, что регистрация провалилась
    @Test
    public void testSignIn(){

        // устанавливаем зависимость, определяющую путь к chomedriver
        System.setProperty("webdriver.chrome.driver", "D:\\Универ\\5 семестр\\Тестирование ПО\\chromedriver_win32\\chromedriver.exe");
        // создаем объект драйвера
        driver = new ChromeDriver();
        // если элемент не найден,
        // то драйвер будет ждать его появления в течении
        // заданного времени (3 секунды) и шагом в 500 мс
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // передаем драйверу адрес страницы
        driver.get("https://www.ozon.ru");

        //находим кнопку, при нажатии на которую вылезает анкета и кликаем
        WebElement regButton = driver.findElement(By.xpath(".//span[text()='Вход или регистрация']"));
        regButton.click();
        // находим поле для номера телефона и заполняем его 8
        WebElement phoneNumberField = driver.findElement(By.name("phone"));
        phoneNumberField.sendKeys("8");
        // находим кнопку "получить код" и кликаем
        WebElement codeButton = driver.findElement(By.xpath(".//span[text()='Получить код']"));
        codeButton.click();
        // проверяем, что эта кнопка никуда не делась, потому что номер некорректный
        Assert.assertTrue(codeButton.isEnabled());
        //Assert.assertTrue(true);
    }

    // проверить текст тултипа
    @Test
    public void testCheckTooltip(){
        // устанавливаем зависимость, определяющую путь к chomedriver
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        // создаем объект драйвера
        WebDriver driver = new ChromeDriver();
        // если элемент не найден,
        // то драйвер будет ждать его появления в течении
        // заданного времени (3 секунды) и шагом в 500 мс
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // передаем драйверу адрес страницы
        driver.get("https://www.ozon.ru/product/dyrokol-figurnyy-mishka-diametr-vyreznoy-figury-16-mm-ostrov-sokrovishch-227159-160270940/?asb=q8sWqjasOdF%252FqAFRWaBshRR4tTOznTJBxbu96077NH5qJG%252Fri6LBPvcg8i9P0iUk&asb2=Gi8iEJOmh8ve0Q7insI26yvM8knofO9xGXJA337QQvG27hclp5vaaM-UAWh93bat76CwDg6l5k1qgZCs615MobkclkX46BevKppi5YY3tpk&sh=sSFXjamr");

    }

    // отфильтровать товары по цене и проверить, что все товары соответствуют фильтру
    /*@Test
    public void testCheckFilter(){
        // устанавливаем зависимость, определяющую путь к chomedriver
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        // создаем объект драйвера
        WebDriver driver = new ChromeDriver();
        // если элемент не найден,
        // то драйвер будет ждать его появления в течении
        // заданного времени (3 секунды) и шагом в 500 мс
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // передаем драйверу адрес страницы
        driver.get("https://www.ozon.ru/category/lenty-dlya-skrapbukinga-30795/");

        // находим поле верхней границы цены

        // передаем туда значение 100

        // какую кнопку после этого нажать?
        WebElement higherBorder = driver.findElement(By.name(""));
        higherBorder.sendKeys("100");
        higherBorder.sendKeys(Keys.ENTER);

        // создаем список имеющихся элементов
        List<WebElement> scrapbookingInstruments = driver.findElements(By.xpath());

        // проходим по списку и проверяем цену
        int countInstrumentsWithPriceBefore100 = 0;  // счетчик элементов с ценой до 100
        // проверка элементов из списка - если цена меньше 100, увеличиваем счетчик
        for (WebElement instr: scrapbookingInstruments){
            instr.findElement(By.xpath());
        }

        // проверяем на равенство количество элементов с нужной ценой и количество элементов в массиве
        Assert.assertTrue(countInstrumentsWithPriceBefore100 == scrapbookingInstruments.size());
    }*/
}
