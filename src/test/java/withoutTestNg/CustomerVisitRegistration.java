package withoutTestNg;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CustomerVisitRegistration {
	public static void main(String[] args) throws Throwable {
		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.default_content_setting_values.media_stream_camera", 1);
		prefs.put("profile.default_content_setting_values.media_stream_mic", 1);
		prefs.put("profile.default_content_setting_values.geolocation", 1);
		prefs.put("profile.default_content_setting_values.notifications", 1);
		options.setExperimentalOption("prefs", prefs);

		options.addArguments("--use-fake-ui-for-media-stream");
		options.addArguments("--use-fake-device-for-media-stream");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		options.addArguments("--ignore-certificate-errors");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://tayades.softmed.in/uat_billing");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("txtUserName")).sendKeys("su");
		driver.findElement(By.name("txtPassword")).sendKeys("654654");
		WebElement locdropdown = driver.findElement(By.name("ddlUserLocs"));
		Actions act = new Actions(driver);
		act.moveToElement(locdropdown).click().perform();
		Select s = new Select(locdropdown);
		s.selectByVisibleText("Dr. Tayades Pathlab Diagnostics Center");
		driver.findElement(By.name("imgBtnLogin")).click();
		driver.findElement(By.id("Text1")).sendKeys("Customer Visit Registration"+Keys.DOWN+""+Keys.ENTER);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtmobileno")).sendKeys("9948374828");
		WebElement titleDropdown = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlTitle"));
		Select s1 = new Select(titleDropdown);
		s1.selectByVisibleText("Mr");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFirstName")).sendKeys("rajesh2");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtYear")).sendKeys("32");
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$lblphlebo")).click();
		driver.findElement(By.xpath("//table[@id='tbl_DivPhleboData']//tbody/tr[1]")).click();
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtServiceCode_Auto")).sendKeys("TYD27"+Keys.DOWN+""+Keys.ENTER);
		WebElement dueAuthBy = driver.findElement(By.id("lk_btn_ctl00_ContentPlaceHolder1_UCtransaction_UCdueAuthBy"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", dueAuthBy);
		dueAuthBy.click();
		driver.findElement(By.xpath("//table[@class='lk_tbl_body jtblgrid looktbl']//tbody/tr[1]")).click();
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$UCtransaction$txtRemarks")).sendKeys("k");
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$UCHeaderControl$imgbtnSave")).click();
		Alert al = driver.switchTo().alert();
		al.accept();
		Thread.sleep(2000);
		
		al.accept();
		
		}

}
