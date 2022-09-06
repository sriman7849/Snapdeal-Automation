package PageObjectModel;

import com.opencsv.CSVWriter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SaveFristFiveItems {
    WebDriver driver;

    public SaveFristFiveItems(WebDriver driver) {
        this.driver = driver;
    }

    public void CsvReaderNdWriter() throws IOException {
        List<WebElement> List =
                driver.findElements(By.xpath("//div[@class='product-tuple-description ']"));


        CSVWriter csvWriter = new CSVWriter(new FileWriter("StoreItem.csv"));
        for (int i = 0; i < 5; i++) {
            String p_name = List.get(i).getText();
            String set[] = {p_name};
            //String Set1[] = {p_name};
            csvWriter.writeNext(set);
            //csvWriter.writeNext(Set1);
        }

        csvWriter.close();
    }

}

      /*  List<WebElement> products = driver.findElements(By.xpath("//div[@class='product-tuple-description ']"));
        for (int i = 0; i < 5; i++) {
            System.out.println(products.get(i).getText()); */

