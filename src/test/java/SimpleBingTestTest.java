import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


public class SimpleBingTestTest {
    SimpleBingTest bing = new SimpleBingTest();

    @Test
    public void jumpByID() {
        System.setProperty("webdriver.chrome.driver","E:/学习资料/软件测试/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://cn.bing.com/");
        String test=bing.jumpByID("id_l",driver);
        assertEquals("微软 Bing 搜索 - 国内版",test);
    }

    @Test
    public void jumpByCss() {
        System.setProperty("webdriver.chrome.driver","E:/学习资料/软件测试/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://cn.bing.com/");
        String test=bing.jumpByCss("#id_l",driver);
        assertEquals("微软 Bing 搜索 - 国内版",test);
    }

    @Test
    public void noInput() {
        System.setProperty("webdriver.chrome.driver","E:/学习资料/软件测试/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=13&ct=1587191784&rver=6.7.6631.0&wp=MBI_SSL&wreply=https%3a%2f%2fcn.bing.com%2fsecure%2fPassport.aspx%3frequrl%3dhttps%253a%252f%252fcn.bing.com%252f%253fwlexpsignin%253d1%26sig%3d37B25E7DF13967502AD250CDF0176640&lc=2052&id=264960&CSRFToken=fca2c079-4ef4-425f-a904-f2f6eca91eb0&aadredir=1");
        String test=bing.noInput(driver);
        assertEquals("请输入有效的电子邮件地址、电话号码或 Skype 用户名。",test);
    }

    @Test
    public void inputPhone() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:/学习资料/软件测试/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=13&ct=1587191784&rver=6.7.6631.0&wp=MBI_SSL&wreply=https%3a%2f%2fcn.bing.com%2fsecure%2fPassport.aspx%3frequrl%3dhttps%253a%252f%252fcn.bing.com%252f%253fwlexpsignin%253d1%26sig%3d37B25E7DF13967502AD250CDF0176640&lc=2052&id=264960&CSRFToken=fca2c079-4ef4-425f-a904-f2f6eca91eb0&aadredir=1");
        String test=bing.inputPhone("18370",driver);
        assertEquals("此电话号码看起来不正确，请检查国家/地区代码和电话号码。",test);
    }

    @Test
    public void phoneLoginById() {
        System.setProperty("webdriver.chrome.driver","E:/学习资料/软件测试/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=13&ct=1587191784&rver=6.7.6631.0&wp=MBI_SSL&wreply=https%3a%2f%2fcn.bing.com%2fsecure%2fPassport.aspx%3frequrl%3dhttps%253a%252f%252fcn.bing.com%252f%253fwlexpsignin%253d1%26sig%3d37B25E7DF13967502AD250CDF0176640&lc=2052&id=264960&CSRFToken=fca2c079-4ef4-425f-a904-f2f6eca91eb0&aadredir=1");
        String test=bing.phoneLoginById("17879834283","i0116",driver);
        assertEquals("帐户或密码不正确。请重试。",test);
    }
}
