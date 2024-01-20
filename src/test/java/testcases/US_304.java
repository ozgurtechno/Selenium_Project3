package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

public class US_304 extends BaseDriver {
    @Test
    public void test4(){

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement ebook= driver.findElement(By.linkText("Ebook"));
        ebook.click();

        WebElement ebookAddToCart= driver.findElement(By.xpath("//button[@class='view_product']"));
        ebookAddToCart.click();

        WebElement iframe= driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe);

        WebElement payDebitCard= driver.findElement(By.xpath("//button[@class='Payment-Button CC']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='Payment-Button CC']")));
        payDebitCard.click();

        WebElement email = driver.findElement(By.cssSelector("input[placeholder=\"Email\"]"));
        email.sendKeys("test@gmail.com");

        WebElement emailConfirm = driver.findElement(By.cssSelector("input[placeholder=\"Confirm Email\"]"));
        emailConfirm.sendKeys("test@gmail.com");

        WebElement nameOnCard = driver.findElement(By.cssSelector("input[placeholder=\"Name On Card\"]"));
        nameOnCard.sendKeys("Andrey Jackson");

        WebElement phone= driver.findElement(By.cssSelector("p[class=\"Billing-Phone Inline\"] input"));
        phone.sendKeys("123456789");

        WebElement company =driver.findElement(By.cssSelector("p[class=\"Billing-Company\"] input"));
        company.sendKeys("Techno Study");

        WebElement frameChild= driver.findElement(By.xpath("//iframe[@title='Secure card payment input frame']"));
        driver.switchTo().frame(frameChild);

        WebElement cardNumber= driver.findElement(By.cssSelector("[name='cardnumber']"));
        cardNumber.sendKeys("4242 4242 4242 4242");

        WebElement expiryDate= driver.findElement(By.xpath("//input[@name='exp-date']"));
        expiryDate.sendKeys("1224");

        WebElement securityCode= driver.findElement(By.xpath("//input[@name='cvc']"));
        securityCode.sendKeys("000");

        driver.switchTo().parentFrame();

        WebElement payButton= driver.findElement(By.xpath("//button[@class='Pay-Button']"));
        payButton.click();

        wait.until(ExpectedConditions.urlContains("https://www.fatfreecartpro.com/"));

        WebElement confirmationMessage= driver.findElement(By.xpath("//span[@class='green_text_margin']"));
        Assert.assertTrue( confirmationMessage.getText().contains("your order is confirmed. Thank you!"), "Success Message");

        quitDriver();
    }
}
