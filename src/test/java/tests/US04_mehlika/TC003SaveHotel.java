package tests.US04_mehlika;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US04_HotelEkle;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.io.File;
import java.io.IOException;

public class TC003SaveHotel extends TestBaseRapor {

    US04_HotelEkle hmcp_us04=new US04_HotelEkle();
    TC002AddHotel addHotel=new TC002AddHotel();
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
        addHotel.TC002addHotelTest();
        extentTest=extentReports.createTest("Yeni Hotel ekleme","Otel eklemasi yapildi.");

        softAssert.assertTrue(hmcp_us04.codeTextBox.isDisplayed() &&
                hmcp_us04.nameTextBox.isDisplayed() &&
                hmcp_us04.addressTextBox.isDisplayed() &&
                hmcp_us04.phoneTextBox.isDisplayed() &&
                hmcp_us04.emailTextBox.isDisplayed()  &&
                hmcp_us04.idgroupDropBox.isDisplayed());

        extentTest.pass("Textbox'lar gorunuyor mu? kontrol edildi.");

        fakerCodeText=faker.number().digit()+faker.number().digit()+faker.number().digit();
        fakerNameText=faker.name().fullName();
        fakerAddressText=faker.address().fullAddress();
        fakerPhoneText=faker.phoneNumber().phoneNumber();
        fakerEmailText=faker.internet().emailAddress();
        extentTest.info("Faker class'i yardimi ile random bilgiler uretildi");

        hmcp_us04.codeTextBox.clear();
        hmcp_us04.codeTextBox.sendKeys(fakerCodeText);
        hmcp_us04.nameTextBox.clear();
        hmcp_us04.nameTextBox.sendKeys(fakerNameText);
        hmcp_us04.addressTextBox.clear();
        hmcp_us04.addressTextBox.sendKeys(fakerAddressText);
        hmcp_us04.phoneTextBox.clear();
        hmcp_us04.phoneTextBox.sendKeys(fakerPhoneText);
        hmcp_us04.emailTextBox.clear();
        hmcp_us04.emailTextBox.sendKeys(fakerEmailText);
        Select select=new Select(hmcp_us04.idgroupDropBox);
        select.selectByIndex(1);
        extentTest.info("Faker class'i yardimi ile uretilen random bilgiler girildi");

        softAssert.assertTrue(hmcp_us04.saveButton.isDisplayed());
        extentTest.pass("Save buttonu gorunuyor mu? kontrol edildi");

        hmcp_us04.saveButton.click();
        File screenShots=new File("src/images/TC003photo.jpg");
        File geciciResim=tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,screenShots);
        extentTest.info("Son ekranin fotografi kaydedildi.");

        softAssert.assertAll();
    }
}
