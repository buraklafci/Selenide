package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class GooglePage {
    public SelenideElement searchBox=$(By.xpath("//textarea[@class='gLFyf']"));

    public SelenideElement resultSection=$(By.xpath("//div[@id='result-stats']"));

    public ElementsCollection getAllSections=$$(By.xpath("//div[@class='g']"));



}
