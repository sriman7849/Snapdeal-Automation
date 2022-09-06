package SetUpClass;

import com.opencsv.CSVWriter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FiveItemNdPrice {
    WebDriver driver;

    @Test
    public void check() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.snapdeal.com/search?keyword=Bluetooth%20Headphone&santizedKeyword=Bluetooth+Headphone&catId=0&categoryId=0&suggested=false&vertical=p&noOfResults=20&searchState=&clickSrc=go_header&lastKeyword=&prodCatId=&changeBackToAll=false&foundInAll=false&categoryIdSearched=&cityPageUrl=&categoryUrl=&url=&utmContent=&dealDetail=&sort=plrty&q=Price%3A700%2C3000%7C");

        List<WebElement> Title_List = driver.findElements(By.xpath("//p[@class='product-title']"));
        List<WebElement> Price_List = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));

        CSVWriter csvWriter = new CSVWriter(new FileWriter("item.csv"));
        int n = 5;
        for (int i = 0; i <= n; i++) {
            String title_name = Title_List.get(i).getText();
            try {
                System.out.println(i + " " + title_name);
                String set[] = {title_name};
                csvWriter.writeNext(set);
                for (int j = 0; j <= 5; j++) {
                    if (j == i) {
                        String price_value = Price_List.get(j).getText();
                        System.out.println(j + " " + price_value);
                        String set1[] = {price_value};
                        csvWriter.writeNext(set1);
                    } else {
                        continue;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("The Index you have return is invalid");
            }
        }
    }
}
