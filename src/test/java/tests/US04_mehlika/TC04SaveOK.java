package tests.US04_mehlika;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US0004_AddHotel;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.File;
import java.io.IOException;

public class TC04SaveOK extends TestBaseRapor {

    US0004_AddHotel addHotel=new US0004_AddHotel();
    TC003SaveHotel tc003SaveHotel=new TC003SaveHotel();
    TakesScreenshot tss=(TakesScreenshot) Driver.getDriver();

    @Test
    public void TC004saveOK() throws InterruptedException, IOException {

        tc003SaveHotel.TC003saveHotelTest();

        String actualSuccessfullyText=addHotel.insertedSuccessfullyText.getText();
        System.out.println(" actualSuccessfullyText : "+ actualSuccessfullyText);
        String expectedSuccessfullyText="Hotel was inserted successfully";
        Assert.assertTrue(actualSuccessfullyText.contains("successfully"));
        Assert.assertEquals(actualSuccessfullyText,expectedSuccessfullyText,"Successfully yazisi gorulemedi");

        Assert.assertTrue(addHotel.insertedSuccessfullyText.isDisplayed());
//        String expectedSuccessfullyText = "Hotel was inserted successfully";
//        System.out.println("expectedSuccessfullyText : "+expectedSuccessfullyText);
        Thread.sleep(2000);

        addHotel.saveSuccessfullyOkButton.click();

        Thread.sleep(1000);
        //ReusableMethods.waitForVisibility(addHotel.saveSuccessfullyOkButton,8);

        File screenShots=new File("src/images/TC004photo.jpg");
        File geciciResim=tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,screenShots);
        extentTest.info("Son ekranin fotografi kaydedildi.");

    }
}
