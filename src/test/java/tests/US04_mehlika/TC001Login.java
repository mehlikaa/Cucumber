package tests.US04_mehlika;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import pages.US04_HotelEkle;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.io.File;
import java.io.IOException;

//1- Yonetici; 'https://www.hotelmycamp.com/'  URL adresinden yonetici girisi yapip
// LIST OF HOTELS sayfasina ulasabilmeli
public class TC001Login extends TestBaseRapor {
    public US04_HotelEkle hmcp_us04=new US04_HotelEkle();
    TakesScreenshot tss=(TakesScreenshot) Driver.getDriver();

    @Test
    public void TC001login() throws IOException {
        extentTest=extentReports.createTest("TC001 Login","Otel eklenebilmicin Login olundu");

        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest.info("Driver yuklendi.");

        hmcp_us04.hotelLoginButton.click();
        hmcp_us04.managerUsername.clear();
        hmcp_us04.managerUsername.sendKeys("Manager");
        hmcp_us04.managerPassword.clear();
        hmcp_us04.managerPassword.sendKeys("Manager1!");
        hmcp_us04.managerLogin.click();
        extentTest.info("Manager, username ve password bilgisi ile giris yapti.");

        hmcp_us04.hotelManagementLink.click();
        hmcp_us04.hotelListLink.click();
        extentTest.info("Add Hotel buttonu gorundu.");

        File screenShots=new File("src/images/TC001photos");
        File geciciResim=tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,screenShots);
        extentTest.info("Son ekranin fotografi kaydedildi.");

    }

}
