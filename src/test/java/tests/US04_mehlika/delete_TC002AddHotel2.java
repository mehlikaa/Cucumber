package tests.US04_mehlika;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US0004_AddHotel;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class delete_TC002AddHotel2 extends TestBaseRapor {

    TC001Login tc01=new TC001Login();
    US0004_AddHotel addHotel=new US0004_AddHotel();
    //SoftAssert softAssert=new SoftAssert();

    @Test
    public void addHotelTest() throws IOException {

        tc01.TC001login();
        String actualListOfHotelsText=addHotel.listOfHotelsText.getText();
        String expectedListOfHotelsText="LIST OF HOTELS";
        Assert.assertEquals(actualListOfHotelsText,expectedListOfHotelsText,"LISTOFUSERS Sayfasinda degilsiniz.");
        ReusableMethods.waitFor(1);
        addHotel.hotelManagementLink.click();
        //Thread.sleep(1);
        ReusableMethods.waitFor(1);
        addHotel.hotelListLink.click();
        Assert.assertTrue(addHotel.addHotelButton.isDisplayed());
        addHotel.addHotelButton.click();



        //softAssert.assertAll();


    }

}
