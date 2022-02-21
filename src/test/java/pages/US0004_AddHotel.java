package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US0004_AddHotel {

    public US0004_AddHotel(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[text()='Hotelmycamp'])")
    public WebElement homePageText;

    @FindBy(linkText = "Log in")
    public WebElement hotelLoginButton;

    @FindBy(id="UserName")      ////input[@id='UserName']
    public WebElement managerUsername;

    @FindBy(id="Password")
    public WebElement managerPassword;

    @FindBy(id="btnSubmit")
    public WebElement managerLogin;

    @FindBy(xpath = "//span[text()='System Management']")
    public WebElement systemManagementLink;

    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagementLink;

    @FindBy(linkText = "Hotel List")
    public WebElement hotelListLink;
    //(//a/i[@class='icon-calendar'])[3]

    @FindBy(xpath = "//span[text()='List Of Hotels']")
    public WebElement listOfHotelsText;

    @FindBy(xpath = "//span[text()='Add Hotel ']")
    public WebElement addHotelButton;

    @FindBy(xpath = "//input[@id='Code']")
    public WebElement codeTextBox;

    @FindBy(xpath = "//input[@id='Name']")
    public WebElement nameTextBox;

    @FindBy(xpath = "//input[@id='Address']")
    public WebElement addressTextBox;

    @FindBy(xpath = "//input[@id='Phone']")
    public WebElement phoneTextBox;

    @FindBy(xpath = "//input[@id='Email']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//select[@id='IDGroup']")
    public WebElement idgroupDropBox;

    @FindBy(xpath = "//button[@id='btnSubmit']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[text()='Hotel was inserted successfully']")
   // @FindBy(xpath = "//div[@class='bootbox-body']")    //Hotel was inserted successfully
    public WebElement insertedSuccessfullyText;

    @FindBy(xpath = "(//button[text()='OK'])")
    //@FindBy(xpath = "(//button[@type='button'])[6]")
    public WebElement saveSuccessfullyOkButton;

    // Eklendigini kontrol icin List Of Hotels alninda bulunan Code kismindan arama
    @FindBy(xpath = "//input[@name='Code']")
    public WebElement listOfHotelsCodeSearch;

    @FindBy(xpath = "//input[@name='Name']")
    public WebElement listOfHotelsNameSearch;


    @FindBy(xpath = "//button[text()='Search']")
    public WebElement listOfHotelsSearchButton;

    @FindBy(xpath = "//tbody/tr/td[3]")
    public WebElement searchNameTableCell;

    @FindBy(xpath = "//a[@target='_blank']")      //a[text()=' Details']")
    public WebElement detailsButton;

    //                 firstPageHandle
    //new Page Handle secondPageHandle
    // Saved Data Check
    @FindBy(xpath = "//input[@id='Code']")
    public WebElement savedCodeCheck;

    @FindBy(xpath ="//*[@id=\"Name\"]")           //form//input[@id='Name']")      //"//input[@id='Name']")
    public WebElement savedNameCheck;

    @FindBy(xpath = "//a[text()='General Data']")
    public WebElement generalDataTab;

}
