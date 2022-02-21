package tests.US04_mehlika;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US0004_AddHotel;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.File;
import java.io.IOException;

public class TC003SaveHotel extends TestBaseRapor {

    US0004_AddHotel addHotel=new US0004_AddHotel();
    TC002AddHotel addHotel002=new TC002AddHotel();
    SoftAssert softAssert=new SoftAssert();
    Faker faker=new Faker();
    Actions actions=new Actions(Driver.getDriver());
    TakesScreenshot tss=(TakesScreenshot) Driver.getDriver();

    public String fakerCodeText;
    public String fakerNameText;
    public String fakerAddressText;
    public String fakerPhoneText;
    public String fakerEmailText;

    @Test
    public void TC003saveHotelTest() throws InterruptedException, IOException {
        addHotel002.TC002addHotelTest();

        extentTest=extentReports.createTest("Yeni Hotel ekleme","Otel eklemasi yapildi.");

        softAssert.assertTrue(addHotel.codeTextBox.isDisplayed() &&
                addHotel.nameTextBox.isDisplayed() &&
                addHotel.addressTextBox.isDisplayed() &&
                addHotel.phoneTextBox.isDisplayed() &&
                addHotel.emailTextBox.isDisplayed()  &&
                addHotel.idgroupDropBox.isDisplayed());

        extentTest.pass("Textbox'lar gorunuyor mu? kontrol edildi.");

        fakerCodeText=faker.number().digit()+faker.number().digit()+faker.number().digit();
        fakerNameText=faker.name().fullName();
        fakerAddressText=faker.address().fullAddress();
        fakerPhoneText=faker.phoneNumber().phoneNumber();
        fakerEmailText=faker.internet().emailAddress();
        extentTest.info("Faker class'i yardimi ile random bilgiler uretildi");

        addHotel.codeTextBox.clear();
        addHotel.codeTextBox.sendKeys(fakerCodeText);
        ReusableMethods.waitFor(1);
        addHotel.nameTextBox.clear();
        addHotel.nameTextBox.sendKeys(fakerNameText);
        addHotel.addressTextBox.clear();
        addHotel.addressTextBox.sendKeys(fakerAddressText);
        addHotel.phoneTextBox.clear();
        addHotel.phoneTextBox.sendKeys(fakerPhoneText);
        addHotel.emailTextBox.clear();
        addHotel.emailTextBox.sendKeys(fakerEmailText);
        Select select=new Select(addHotel.idgroupDropBox);
        select.selectByIndex(1);
        extentTest.info("Faker class'i yardimi ile uretilen random bilgiler girildi");

        softAssert.assertTrue(addHotel.saveButton.isDisplayed());
        extentTest.pass("Save buttonu gorunuyor mu? kontrol edildi");

        addHotel.saveButton.click();
        File screenShots=new File("src/images/TC003photo.jpg");
        File geciciResim=tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,screenShots);
        extentTest.info("Son ekranin fotografi kaydedildi.");

        softAssert.assertAll();
    }
}
