package tests.US04_mehlika;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US04_HotelEkle;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class delete_TC002AddHotel2 extends TestBaseRapor {

    TC001Login tc01=new TC001Login();
    US04_HotelEkle hmcp_us04=new US04_HotelEkle();
    //SoftAssert softAssert=new SoftAssert();

    @Test
    public void addHotelTest() throws IOException {

        tc01.TC001login();
        String actualListOfHotelsText=hmcp_us04.listOfHotelsText.getText();
        String expectedListOfHotelsText="LIST OF HOTELS";
        Assert.assertEquals(actualListOfHotelsText,expectedListOfHotelsText,"LISTOFUSERS Sayfasinda degilsiniz.");
        ReusableMethods.waitFor(1);
        hmcp_us04.hotelManagementLink.click();
        //Thread.sleep(1);
        ReusableMethods.waitFor(1);
        hmcp_us04.hotelListLink.click();
        Assert.assertTrue(hmcp_us04.addHotelButton.isDisplayed());
        hmcp_us04.addHotelButton.click();



        //softAssert.assertAll();


    }

}
