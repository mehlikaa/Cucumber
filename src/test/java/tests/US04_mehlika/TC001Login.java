package tests.US04_mehlika;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import pages.US0004_AddHotel;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.io.File;
import java.io.IOException;

//1- Yonetici; 'https://www.hotelmycamp.com/'  URL adresinden yonetici girisi yapip
// LIST OF HOTELS sayfasina ulasabilmeli
public class TC001Login extends TestBaseRapor {
    public US0004_AddHotel addHotel=new US0004_AddHotel();
    TakesScreenshot tss=(TakesScreenshot) Driver.getDriver();

    @Test
    public void TC001login() throws IOException {
        extentTest=extentReports.createTest("TC001 Login","Otel eklenebilmicin Login olundu");

        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest.info("Driver yuklendi.");

        addHotel.hotelLoginButton.click();
        addHotel.managerUsername.clear();
        addHotel.managerUsername.sendKeys("Manager");
        addHotel.managerPassword.clear();
        addHotel.managerPassword.sendKeys("Manager1!");
        addHotel.managerLogin.click();
        extentTest.info("Manager, username ve password bilgisi ile giris yapti.");

        addHotel.hotelManagementLink.click();
        addHotel.hotelListLink.click();
        extentTest.info("Add Hotel buttonu gorundu.");

        File screenShots=new File("src/images/TC001photos");
        File geciciResim=tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,screenShots);
        extentTest.info("Son ekranin fotografi kaydedildi.");

    }

}
