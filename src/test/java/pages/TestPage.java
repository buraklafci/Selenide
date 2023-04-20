package pages;


import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.*;

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

    //Locating Checkboxes
    public SelenideElement checkbox1=$(By.id("box1"));

    public SelenideElement checkbox2=$(By.id("box2"));

    //Locations Radios
    public  SelenideElement red=$(By.id("red"));

    public  SelenideElement yellow=$(By.id("yellow"));

    public  SelenideElement football=$(By.id("football"));

    //Locating Deopdown Elements
    public SelenideElement year=$(By.id("year"));

    public SelenideElement month=$(By.id("month"));

    public SelenideElement day=$(By.id("day"));

    public ElementsCollection listOfStates=$$(By.xpath("//select[@id='state']//option"));

  //Alert Elements
    public SelenideElement jsPromptButton=$(By.xpath("//button[@onclick='jsPrompt()']"));

    public SelenideElement resultAlert=$(By.id("result"));

    //Frame Elements
    public SelenideElement pageHeader=$(By.xpath("//h3"));

    public SelenideElement backToTechpro=$(By.xpath("//a[@class='btn btn-primary btn-lg']"));

    //Actions
    public SelenideElement source = $(By.id("draggable"));

    public SelenideElement target = $(By.id("droppable"));

    //Explicit wait
    public SelenideElement startButton=$(By.xpath("//button[.='Start']"));

    public SelenideElement resultExplicitWait=$(By.xpath("//h4[.='Hello World!']"));

    //Screenshot
    public SelenideElement upcomingPrograms= $( By.xpath("//div[@data-id='6f475f3']"));

    //File upload
    public SelenideElement chooseFile= $( By.id("file-upload"));

    public SelenideElement upload= $( By.id("file-submit"));

    public SelenideElement resultFileUpload=$(By.xpath("//h3"));



}
