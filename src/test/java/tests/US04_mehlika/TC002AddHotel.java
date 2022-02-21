package tests.US04_mehlika;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US0004_AddHotel;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.File;
import java.io.IOException;

public class TC002AddHotel extends TestBaseRapor {
    TakesScreenshot tss=(TakesScreenshot) Driver.getDriver();
    TC001Login tc01=new TC001Login();
    US0004_AddHotel addHotel=new US0004_AddHotel();

    @Test
    public void TC002addHotelTest() throws IOException {
        extentTest=extentReports.createTest("Add Hotel buttonu gorunuyor mu?","Otel eklenebilmicin add Hotel buttonuna gelindi");

        tc01.TC001login();

        String actualListOfHotelsText=addHotel.listOfHotelsText.getText();
        System.out.println(" actualListOfHotelsText : "+ actualListOfHotelsText);
        String expectedListOfHotelsText="LIST OF HOTELS";
        Assert.assertEquals(actualListOfHotelsText,expectedListOfHotelsText,"LISTOFUSERS Sayfasinda degilsiniz.");
        extentTest.pass("List Of Hotel sayfasinda olunduugu test edildi.");

        ReusableMethods.waitFor(1);
        addHotel.hotelManagementLink.click();

        addHotel.hotelListLink.click();
        Assert.assertTrue(addHotel.addHotelButton.isDisplayed(),"add hotel gorunmuyor");
        extentTest.pass("Add Hotel buttonu gorunuyor mu kontrol edildi.");

        addHotel.addHotelButton.click();
        extentTest.info("Add Hotel buttonu tiklandi.");
        File screenShots=new File("src/test-outputs/images/TC002photo.jpg");
        File geciciResim=tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,screenShots);
        extentTest.info("Son ekranin fotografi kaydedildi.");

    }
}
