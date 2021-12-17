import com.codeborne.selenide.ElementsCollection;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class TestForPassFailExam {
    @Test
    public void testSignIn(){
        String currentPage = "https://sunduchok64.ru/profile/?register";
        open(currentPage);
        SelenideElement nameField = $x(".//*[@id=\"input_name\"]");
        nameField.setValue("Петров Пётр Петрович");//.pressEnter();
        SelenideElement emailField = $x(".//*[@id=\"input_email\"]");
        emailField.setValue("petrovpp@mail.ru");//.pressEnter();
        SelenideElement signInButton = $x(".//*[@value=\"Зарегистрироваться\"]");
        signInButton.click();
        Assert.assertTrue(signInButton.exists());
    }

    @Test
    public void testCheckTooltip(){
        String currentPage = "https://sunduchok64.ru/profile/?register";
        open(currentPage);
        SelenideElement nameField = $x(".//*[@id=\"input_name\"]");
        nameField.setValue("Петров Пётр Петрович");//.pressEnter();
        SelenideElement emailField = $x(".//*[@id=\"input_email\"]");
        emailField.setValue("petrovpp@mail.ru").pressEnter();
        SelenideElement error = $x(".//*[@class=\"error\"]");
        String requiredError = "Укажите номер контактного телефона с кодом города";
        Assert.assertEquals(error.shouldBe(Condition.visible).getText(), requiredError);
    }

    @Test
    public void testFilter(){
        String currentPage = "https://sunduchok64.ru/store/kvilling/";
        open(currentPage);
        SelenideElement priceMinField = $x(".//*[@name=\"price[min]\"]");
        priceMinField.setValue("91").pressEnter();
        SelenideElement priceMaxField = $x(".//*[@name=\"price[max]\"]");
        priceMaxField.setValue("99").pressEnter();

        int count = 0;
        ElementsCollection filteredElements = $$x(".//*[@class=\"store-items-container\"]");

        for (SelenideElement elem: filteredElements){
            String currentElement = elem.shouldBe(Condition.visible).getText();
            String currentPrice = currentElement.substring(0, 2);
            if (Integer.parseInt(currentPrice) > 91 && Integer.parseInt(currentPrice) < 99){
                count++;
            }
        }

        Assert.assertTrue(count == filteredElements.size());
    }
}
