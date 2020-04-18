import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SimpleBingTest {
//    public static void main(String[] args) throws InterruptedException {
//       System.setProperty("webdriver.chrome.driver","E:/学习资料/软件测试/chromedriver.exe");
//       WebDriver driver = new ChromeDriver();
//       driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=13&ct=1587191784&rver=6.7.6631.0&wp=MBI_SSL&wreply=https%3a%2f%2fcn.bing.com%2fsecure%2fPassport.aspx%3frequrl%3dhttps%253a%252f%252fcn.bing.com%252f%253fwlexpsignin%253d1%26sig%3d37B25E7DF13967502AD250CDF0176640&lc=2052&id=264960&CSRFToken=fca2c079-4ef4-425f-a904-f2f6eca91eb0&aadredir=1");
//       SimpleBingTest bing = new SimpleBingTest();
////        System.out.println(bing.noInput(driver));
////       System.out.println(bing.jumpByID("id_l",driver));
////       System.out.println(bing.jumpByCss("#id_l",driver));
////        System.out.println(bing.inputPhone("18370",driver));
//        System.out.println(bing.phoneLoginById("17879834283","i0116",driver));
//       Thread.sleep(10000);
//       driver.quit();
//    }


    //验证点击登录是否有效，获取跳转的标题
    public String jumpByID(String id,WebDriver driver){
        WebElement element=driver.findElement(By.id(id));
        element.click();
        return driver.getTitle();

    }
    public String jumpByCss(String css,WebDriver driver){
        WebElement element=driver.findElement(By.cssSelector(css));
        element.click();
        String test=driver.getTitle();
        return test;

    }
    //不输入，直接下一步
    public String noInput(WebDriver driver){
        WebElement element1=driver.findElement(By.id("idSIButton9"));
        element1.click();
        WebElement element2=driver.findElement(By.id("usernameError"));
        return element2.getText();
    }
    //输入未注册或错误电话号码，验证是否能跳转页面
    public String inputPhone(String account,WebDriver driver) throws InterruptedException {
        //获取输入框
        WebElement element=driver.findElement(By.id("i0116"));
        element.sendKeys(account);
        //下一步
        WebElement element1=driver.findElement(By.id("idSIButton9"));
        element1.click();
        //获取新窗口句柄
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles())
        {
            if (winHandle.equals(winHandleBefore))
            {
                continue;
            }
            driver.switchTo().window(winHandle);
            break;
        }
        //确定电话号码下一步
        WebElement element2=driver.findElement(By.cssSelector("#idSIButton9"));
        element2.click();

        WebElement welement=driver.findElement(By.id("usernameError"));
        return welement.getText();
    }
    //输入已注册电话号，输入错误密码验证
    public String phoneLoginById(String account,String id,WebDriver driver){
        WebElement element=driver.findElement(By.id(id));
        element.sendKeys(account);
        WebElement element1=driver.findElement(By.id("idSIButton9"));
        element1.click();
        WebElement welement=driver.findElement(By.id("i0118"));
        welement.sendKeys("1234");
        WebElement element2=driver.findElement(By.id("idSIButton9"));
        element2.submit();
        WebElement weelement=driver.findElement(By.id("passwordError"));
        return weelement.getText();
    }

}