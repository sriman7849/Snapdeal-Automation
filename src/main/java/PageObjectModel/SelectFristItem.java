package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFristItem {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='product-desc-rating ']/a[@pogid='634135670073']/p[@class='product-title']")
    WebElement ClickFristIteam;

    public SelectFristItem(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement clickOnFristIteam()
    {
        return ClickFristIteam;
    }
}


