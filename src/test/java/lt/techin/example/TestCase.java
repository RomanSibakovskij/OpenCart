package lt.techin.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCase {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(3));
        driver.get("http://192.168.88.201/");
    }


    @Test
    void wishListPage() {
        //3 click on a wishlist
        WebElement wishList = driver.findElement(By.id("wishlist-total"));
        wishList.click();

        //4 count / print search boxes' number
        int elementsNumber = (int) driver.findElements(By.tagName("input")).stream()
                .filter(e -> "search".equals(e.getAttribute("name")) && e.isDisplayed())
                .count();
        System.out.println(elementsNumber);
        Assertions.assertEquals(1, elementsNumber);

        //5 find email input field, input "email@email.com"
        WebElement email = driver.findElement(By.cssSelector("#form-login > div:nth-child(3) > #input-email")); //5
        email.sendKeys("email@email.com");
        //email.clear(); //6
    }
        @Test
         void registerCustomer() {
            //8 register a new customer
            WebElement wishList = driver.findElement(By.id("wishlist-total"));
            wishList.click();

            WebElement newCustomer = driver.findElement(By.cssSelector("#content > div > div:nth-child(1) > div > div > a")); //8
            newCustomer.click(); //8

            WebElement inputName = driver.findElement(By.cssSelector("#account > div:nth-child(2) > div > #input-firstname"));
            inputName.sendKeys("Thomas");

            WebElement inputLname = driver.findElement(By.cssSelector("#account > div:nth-child(3) > div > #input-lastname"));
            inputLname.sendKeys("Connor");

            WebElement inputEmail = driver.findElement(By.cssSelector("#account > div:nth-child(4) > div > #input-email"));
            inputEmail.sendKeys("m10@gmail.com");

            WebElement inputPassword = driver.findElement(By.cssSelector("#form-register > fieldset:nth-child(2) > div > div > #input-password"));
            inputPassword.sendKeys("Kanker1125#");

            //9
            if (inputPassword.isDisplayed()) {
                assertTrue(true, String.valueOf(inputPassword.isDisplayed())); //9
                System.out.println("Password field is present");
            } else {
                System.out.println("Password field is not present");
            }

            WebElement agree = driver.findElement(By.cssSelector("#form-register > div > div > input"));
            agree.click();

            WebElement button = driver.findElement(By.cssSelector("#form-register > div > button"));
            button.click();

            //10
            WebElement cartButton = driver.findElement(By.cssSelector("#header-cart > div > button"));
            if (cartButton.isDisplayed()) {
                assertTrue(true, String.valueOf(cartButton.isDisplayed()));
                System.out.println("Cart button is present");
            } else {
                System.out.println("Cart button is not present");
            }

            //11
            if (agree.isDisplayed()) {
                assertTrue(true, String.valueOf(agree.isSelected()));
                System.out.println("Agree button is selected");
            } else {
                System.out.println("Agree button is not selected");
            }

            //12
            WebElement desktopLink = driver.findElement(By.cssSelector("#narbar-menu > ul > li:nth-child(1) > a"));
            desktopLink.click();

            WebElement desktoplink1 = driver.findElement(By.cssSelector("#narbar-menu > ul > li:nth-child(1) > div > a"));
            desktoplink1.click();

            //13
            /*
            Select limitSelect = new Select(driver.findElement(By.name("limit")));
            limitSelect.selectByValue("25");
            WebElement selectedLimit = limitSelect.getFirstSelectedOption();
            System.out.println("Selected limit: " + selectedLimit.getText());
            */

            //14

            WebElement selectedItem = driver.findElement(By.cssSelector("#product-list > div:nth-child(3) > div > div.content > div > h4 > a"));
            selectedItem.click();


            //15 select 4th element from list
                /*
            WebElement selectedFourthItem = driver.findElement(By.cssSelector("#product-list > div:nth-child(4) > div > div.content > div > h4 > a"));
            selectedFourthItem.click();
                    */
            //16 print said option
            System.out.println("Clicked on the 4th product image.");

            //17 close method
            driver.close();



    }
}
