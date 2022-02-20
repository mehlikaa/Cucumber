package tests.US04_mehlika;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.US04_HotelEkle;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.io.File;
import java.io.IOException;

public class TC04SaveOK extends TestBaseRapor {

    US04_HotelEkle hmcp_us04=new US04_HotelEkle();
    TC003SaveHotel tc003SaveHotel=new TC003SaveHotel();
    TakesScreenshot tss=(TakesScreenshot) Driver.getDriver();

    @Test
    public void TC004saveOK() throws InterruptedException, IOException {

        tc003SaveHotel.TC003saveHotelTest();

        String actualSuccessfullyText=hmcp_us04.insertedSuccessfullyText.getText();
                                    //Driver.getDriver().switchTo().alert().getText();
        System.out.println(" actualSuccessfullyText : "+ actualSuccessfullyText);
        String expectedSuccessfullyText="Hotel was inserted successfully";
        WebElement tiklaKapat=Driver.getDriver().findElement(By.xpath("//button[@type='button'])[5]')"));
        tiklaKapat.click();
        //Driver.getDriver().switchTo().alert().dismiss();
        //Assert.assertEquals(actualSuccessfullyText,expectedSuccessfullyText,"Dogru kayit yapilamamistir.");
        //Assert.assertTrue(hmcp_us04.saveSuccessfullyOkButton.isDisplayed(),"Successfully Ok tiklanamadi");


        hmcp_us04.saveSuccessfullyOkButton.click();

        File screenShots=new File("src/images/TC004photo.jpg");
        File geciciResim=tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,screenShots);
        extentTest.info("Son ekranin fotografi kaydedildi.");
    }


}
