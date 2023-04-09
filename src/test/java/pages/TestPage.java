package pages;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.By;

public class TestPage {
    //    This is my TestCenter page class
    //    All objects in TestCenter page will go here
    //    LOCATION THE ELEMETNT USING FUNCTION
   //public SelenideElement username(){
     //   return $(By.id("exampleInputEmail1"));
   // }
    //    OR ALTERNATIVELY
  //    WebElement -> SelenideElement
    public SelenideElement username=$(By.id("exampleInputEmail1"));

    public SelenideElement password=$(By.id("exampleInputPassword1"));

    public SelenideElement submitButton=$(By.xpath("//button[@type='submit']"));

    public SelenideElement logout=$(By.partialLinkText("Logout"));
}
