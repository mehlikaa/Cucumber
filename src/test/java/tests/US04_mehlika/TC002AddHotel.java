package tests.US04_mehlika;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US04_HotelEkle;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.File;
import java.io.IOException;

public class TC002AddHotel extends TestBaseRapor {
    TakesScreenshot tss=(TakesScreenshot) Driver.getDriver();
    TC001Login tc01=new TC001Login();
    public US04_HotelEkle hmcp_us04=new US04_HotelEkle();

    @Test
    public void TC002addHotelTest() throws IOException {
        extentTest=extentReports.createTest("Add Hotel buttonu gorunuyor mu?","Otel eklenebilmicin add Hotel buttonuna gelindi");

        tc01.TC001login();
        String actualListOfHotelsText=hmcp_us04.listOfHotelsText.getText();
        System.out.println(" actualListOfHotelsText : "+ actualListOfHotelsText);
        String expectedListOfHotelsText="LIST OF HOTELS";
        Assert.assertEquals(actualListOfHotelsText,expectedListOfHotelsText,"LISTOFUSERS Sayfasinda degilsiniz.");
        extentTest.pass("List Of Hotel sayfasinda olunduugu test edildi.");
        ReusableMethods.waitFor(1);
        hmcp_us04.hotelManagementLink.click();
        //Thread.sleep(1);
        //ReusableMethods.waitFor(1);
        hmcp_us04.hotelListLink.click();
        Assert.assertTrue(hmcp_us04.addHotelButton.isDisplayed(),"add hotel gorunmuyor");
        extentTest.pass("Add Hotel buttonu gorunuyor mu kontrol edildi.");

        hmcp_us04.addHotelButton.click();
        extentTest.info("Add Hotel buttonu tiklandi.");
        File screenShots=new File("src/test-outputs/images/TC002photo.jpg");
        File geciciResim=tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,screenShots);
        extentTest.info("Son ekranin fotografi kaydedildi.");

    }

}
