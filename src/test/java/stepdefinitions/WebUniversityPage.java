package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;
import utilities.ReusableMethods;

public class WebUniversityPage {
//1."http://webdriveruniversity.com/" adresine gidin
//2."Login Portal" a  kadar asagi inin
//3."Login Portal" a tiklayin
//4.Diger window'a gecin
//5."username" ve  "password" kutularina deger yazdirin
//6."login" butonuna basin
//7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
//8.Ok diyerek Popup'i kapatin
//9.Ilk sayfaya geri donun
//10.Ilk sayfaya donuldugunu test edin

    WebUniversityPage webUniversityPage=new WebUniversityPage();

    @Given("Login Portala  kadar asagi iner")
    public void login_portala_kadar_asagi_iner() {
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

    }
    @Given("Login Portala tiklar")
    public void login_portala_tiklar() {
        // webUniversityPage.
    }
    @Then("Acilan diger window'a gecer")
    public void acilan_diger_window_a_gecer() {
        ReusableMethods.switchToWindow("WebDriver | Login Portal");
    }
    @Then("{string} ve  {string} kutularina deger yazdirir")
    public void ve_kutularina_deger_yazdirir(String string, String string2) {
        webUniversityPage.
    }
    @Then("WebUniversity Login butonuna basar")
    public void web_university_login_butonuna_basar() {
        webUniversityPage.
    }
    @Then("Popup'ta cikan yazinin {string} oldugunu test eder")
    public void popup_ta_cikan_yazinin_oldugunu_test_eder(String string) {

    }
    @Then("Ok diyerek Popup'i kapatir")
    public void ok_diyerek_popup_i_kapatir() {

    }
    @Then("Ilk sayfaya geri doner")
    public void ilk_sayfaya_geri_doner() {

    }
    @Then("Ilk sayfaya donuldugunu test eder")
    public void ilk_sayfaya_donuldugunu_test_eder() {

    }
}
