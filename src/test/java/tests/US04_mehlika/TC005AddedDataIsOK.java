package tests.US04_mehlika;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US04_HotelEkle;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.util.Set;
//5- LIST OF HOTELS sayfasindan, yeni hotel eklenip eklenmedigi kontrol edilmeli.

public class TC005AddedDataIsOK extends TestBaseRapor {

    US04_HotelEkle hmcp_us04=new US04_HotelEkle();
    TC003SaveHotel saveHotel=new TC003SaveHotel();
    TC04SaveOK saveOK=new TC04SaveOK();
    //TakesScreenshot tss=(TakesScreenshot) Driver.getDriver();

    @Test
    public void TC05savedSuccessful() throws InterruptedException, IOException {
        saveHotel.TC003saveHotelTest();
        extentTest=extentReports.createTest("saved Hotel Name Check","Otel eklenebilmis mi kontrol edildi");

        //TC001Login login=new TC001Login();
        //login.login();
        Driver.getDriver().get("https://www.hotelmycamp.com/admin/HotelAdmin");
        String firstPageHandle=Driver.getDriver().getWindowHandle();
        extentTest.info(" Birinci sayfa Handle degeri bir stringe atandi");

        Assert.assertTrue(hmcp_us04.listOfHotelsText.isDisplayed());
        extentTest.pass("List Of Hotels Sayfasinda olup olmadigimiz kontrol edildi. ");

        hmcp_us04.listOfHotelsNameSearch.click();
        System.out.println("saveHotel.fakerNameText : "+saveHotel.fakerNameText);
        hmcp_us04.listOfHotelsNameSearch.sendKeys(saveHotel.fakerNameText);
        hmcp_us04.listOfHotelsCodeSearch.sendKeys(saveHotel.fakerCodeText);
        extentTest.info("Arama icin Code Name bilgileri girildi");

        hmcp_us04.listOfHotelsSearchButton.click();
        String actualSearchName=hmcp_us04.searchNameTableCell.getText();
        String expectedSearchName=saveHotel.fakerNameText;
        System.out.println("hmcp_us04.searchNameTableCell.getText() : "+actualSearchName+"\nsaveHotel.fakerNameText  : "+expectedSearchName);
           ReusableMethods.waitFor(2);
        hmcp_us04.detailsButton.click();

        Set<String> handleSet=Driver.getDriver().getWindowHandles();
        String secondPageHandle = "";
        for (String each : handleSet
        ) {
            if (!each.equals(firstPageHandle)){
                secondPageHandle=each;
            }
        }
        Driver.getDriver().switchTo().window(secondPageHandle);

        hmcp_us04.generalDataTab.click();

        String actualCodeData=hmcp_us04.savedCodeCheck.getText();
        String expectedCodeData=saveHotel.fakerNameText;
        String actualNameData=hmcp_us04.savedCodeCheck.getText();
        String expectedNameData=saveHotel.fakerNameText;
        System.out.println("------\nactualCodeData : "+hmcp_us04.savedCodeCheck.getText()+
                                 "\nexpectedCodeData : "+saveHotel.fakerCodeText+
                                "\nactualNameData : "+hmcp_us04.savedNameCheck.getText()+
                                "\nexpectedNAmeData : "+saveHotel.fakerNameText);
        Assert.assertEquals(actualCodeData,expectedCodeData,"Yanlis Kayit Code'u ");
        Assert.assertEquals(actualNameData,expectedNameData,"Yanlis Kayit Name'i ");
        extentTest.pass("Eklenen Hotel bilgileri Code ve Name ile kontrol edildi.");

//        File screenShots=new File("src/images/TC005photos");
//        File geciciResim=tss.getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(geciciResim,screenShots);
        ReusableMethods.getScreenshot("TC005");
        extentTest.info("Son ekranin fotografi kaydedildi.");

    }
}
