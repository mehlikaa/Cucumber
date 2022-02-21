package tests.US04_mehlika;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US0004_AddHotel;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.util.Set;
//5- LIST OF HOTELS sayfasindan, yeni hotel eklenip eklenmedigi kontrol edilmeli.

public class TC005AddedDataIsOK extends TestBaseRapor {

    US0004_AddHotel addHotel=new US0004_AddHotel();
    TC003SaveHotel saveHotel=new TC003SaveHotel();
    TC04SaveOK saveOK=new TC04SaveOK();
    //TakesScreenshot tss=(TakesScreenshot) Driver.getDriver();

    @Test
    public void TC05savedSuccessful() throws InterruptedException, IOException {
        saveHotel.TC003saveHotelTest();
        extentTest=extentReports.createTest("saved Hotel Name Check","Otel eklenebilmis mi kontrol edildi");

        Driver.getDriver().get("https://www.hotelmycamp.com/admin/HotelAdmin");
        String firstPageHandle=Driver.getDriver().getWindowHandle();
        extentTest.info(" Birinci sayfa Handle degeri bir stringe atandi");

        Assert.assertTrue(addHotel.listOfHotelsText.isDisplayed());
        extentTest.pass("List Of Hotels Sayfasinda olup olmadigimiz kontrol edildi. ");

        addHotel.listOfHotelsNameSearch.click();
        ReusableMethods.waitFor(2);
        System.out.println("saveHotel.fakerNameText : "+saveHotel.fakerNameText);
        addHotel.listOfHotelsNameSearch.sendKeys(saveHotel.fakerNameText);
        addHotel.listOfHotelsCodeSearch.sendKeys(saveHotel.fakerCodeText);
        extentTest.info("Arama icin Code Name bilgileri girildi");

        addHotel.listOfHotelsSearchButton.click();
        String actualSearchName=addHotel.searchNameTableCell.getText();
        String expectedSearchName=saveHotel.fakerNameText;
        System.out.println("hmcp_us04.searchNameTableCell.getText() : "+actualSearchName+"\nsaveHotel.fakerNameText  : "+expectedSearchName);
           ReusableMethods.waitFor(2);
        addHotel.detailsButton.click();

        Set<String> handleSet=Driver.getDriver().getWindowHandles();
        String secondPageHandle = "";
        for (String each : handleSet
        ) {
            if (!each.equals(firstPageHandle)){
                secondPageHandle=each;
            }
        }
        Driver.getDriver().switchTo().window(secondPageHandle);

        addHotel.generalDataTab.click();

        String actualCodeData=addHotel.savedCodeCheck.getText();
        String expectedCodeData=saveHotel.fakerNameText;
        String actualNameData=addHotel.savedCodeCheck.getText();
        String expectedNameData=saveHotel.fakerNameText;
        System.out.println("------\nactualCodeData : "+addHotel.savedCodeCheck.getText()+
                                 "\nexpectedCodeData : "+saveHotel.fakerCodeText+
                                "\nactualNameData : "+addHotel.savedNameCheck.getText()+
                                "\nexpectedNAmeData : "+saveHotel.fakerNameText);
        Assert.assertEquals(actualCodeData,expectedCodeData,"Yanlis Kayit Code'u ");
        Assert.assertEquals(actualNameData,expectedNameData,"Yanlis Kayit Name'i ");
        extentTest.pass("Eklenen Hotel bilgileri Code ve Name ile kontrol edildi.");

        ReusableMethods.getScreenshot("TC005");
        extentTest.info("Son ekranin fotografi kaydedildi.");

    }
}
