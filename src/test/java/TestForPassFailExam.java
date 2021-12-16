import com.codeborne.selenide.ElementsCollection;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        SelenideElement signInButton = $x(".//html/body/section/div/div/form/div[5]/div[2]/input");
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
        SelenideElement error = $x(".//html/body/section/div/div/form/p");
        String requiredError = "Укажите номер контактного телефона с кодом города";
        Assert.assertEquals(error.shouldBe(Condition.visible).getText(), requiredError);
    }

    @Test
    public void testFilter(){
        String currentPage = "https://sunduchok64.ru/store/kvilling/";
        open(currentPage);
        SelenideElement priceMinField = $x(".//*[@id=\"filter\"]/ul/li/div[2]/div[1]/input[1]");
        priceMinField.setValue("91").pressEnter();
        SelenideElement priceMaxField = $x(".//*[@id=\"filter\"]/ul/li/div[2]/div[1]/input[2]");
        priceMaxField.setValue("99").pressEnter();

        int count = 0;
        ElementsCollection filteredElements = $$x("./html/body/section/div[1]/div[2]/article/div");

        for (SelenideElement elem: filteredElements){
            String currentElement = elem.shouldBe(Condition.visible).getText();
            System.out.println(currentElement);
            String currentPrice = currentElement.substring(0, 2);
            if (Integer.parseInt(currentPrice) > 91 && Integer.parseInt(currentPrice) < 99){
                count++;
            }
        }

        Assert.assertTrue(count == filteredElements.size());
    }
}
