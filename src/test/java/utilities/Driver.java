package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.time.Duration;

public class Driver {
  private Driver(){
//boylece herhangi bi class dan obje uretilemez -> Singleton  Pattern
      //cunku default constructor vardi ve biz onu kill yaptik ve artik sadece bizim urettigimiz
      //constructor var.
    }
   private static WebDriver driver;

   public static WebDriver getDriver(){

      if (driver==null){// bu if sayesinde kod calisirken bir kere driver olusturacak ve her seferinde yeni
          // sayfa acmayacak
          switch (ConfigReader.getProperty("browser")){
              case "chrome":
                  WebDriverManager.chromedriver().setup();
                  driver=new ChromeDriver();
                  break;
              case "firefox":
                  WebDriverManager.firefoxdriver().setup();
                  driver=new FirefoxDriver();
                  break;
              case "opera":
                  WebDriverManager.operadriver().setup();
                  driver=new OperaDriver();
                  break;
              case "edge":
                  WebDriverManager.edgedriver().setup();
                  driver=new EdgeDriver();
                  break;
              default:
                  WebDriverManager.chromedriver().setup();
                  driver=new ChromeDriver();
          }
      }
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       return driver;
    }

    public static void closeDriver(){
       if (driver!=null){
           driver.quit();
           driver=null;
       }

    }



}
