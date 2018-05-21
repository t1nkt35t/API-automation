package main.java.com.grfc.expert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestData {
	public static String createCard () throws InterruptedException {
		String ip = "192.168.71.65";
		System.setProperty("webdriver.chrome.driver", "c:/_java/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		driver.manage().window().maximize();
		driver.get("http://" + ip);	
		driver.findElement(By.id("id_username")).sendKeys("s.plekhanov");
		driver.findElement(By.id("id_password")).sendKeys("qwerty123");
		driver.findElement(By.className("btn-primary")).click();
		driver.get("http://" + ip + "/operator");
		driver.findElement(By.id("register")).click();
		driver.findElement(By.id("fileupload")).sendKeys("C:\\Users\\psi\\Pictures\\technology-programming-code-wallpaper-hd-1920x1080.jpg");;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html//div[@class=\"row ui-sortable-handle screenshot_form\"]/div[2]/button[1]")));
		driver.findElement(By.xpath("//html//div[@class=\"row ui-sortable-handle screenshot_form\"]/div[2]/button[1]")).click();
		Select dropdownRes = new Select(driver.findElement(By.id("resource")));
		dropdownRes.selectByVisibleText("Печать");
		Select dropdownMat = new Select(driver.findElement(By.id("material")));
		dropdownMat.selectByVisibleText("Статья");
		Select dropdownDat = new Select(driver.findElement(By.id("data_type")));
		dropdownDat.selectByVisibleText("Текст");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_source")));
		Select dropdownIdSource = new Select(driver.findElement(By.id("id_source")));
		dropdownIdSource.selectByIndex(8);
		String name = "TEST" + Tools.timeStamp("yyyyMMddHHmmss");
		driver.findElement(By.id("id_article_title")).sendKeys(name);
		driver.findElement(By.id("id_issue")).sendKeys("lil");
		driver.findElement(By.id("id_author")).sendKeys("lil");
		driver.findElement(By.id("id_pages")).sendKeys("lil");
		driver.findElement(By.className("trumbowyg-editor")).sendKeys("lil");
		driver.findElement(By.className("multiselect")).click();
		driver.findElement(By.xpath("//li/a/label[contains(text(), 'Детская порнография')]")).click();
		driver.findElement(By.className("glyphicon-check")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html//div[@class=\"modal-dialog\"]//div/button[contains(text(), 'Закрыть')]")));
		driver.findElement(By.xpath("//html//div[@class=\"modal-dialog\"]//div/button[contains(text(), 'Закрыть')]")).click();
		Thread.sleep(1000);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Новые')]")));
		element.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td/a[contains(text(), '"+ name + "')]")));
		driver.findElement(By.xpath("//td/a[contains(text(), '"+ name + "')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html//div[@id='lifeCircleButtonPanel']//a[@class='b-status-button btn btn-success has-spinner']")));
		driver.findElement(By.xpath("//html//div[@id='lifeCircleButtonPanel']//a[@class='b-status-button btn btn-success has-spinner']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/a[contains(text(), 'Экспертиза')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[contains(text(), 'Экспертиза')]")));
		driver.findElement(By.xpath("//li/a[contains(text(), 'Экспертиза')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sendExpressExpertReviewRequest")));
		driver.findElement(By.id("sendExpressExpertReviewRequest")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//button[@id='submitExpertReviewRequest']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-content']//button[@id='submitExpertReviewRequest']")));
		driver.findElement(By.xpath("//div[@class='modal-content']//button[@id='submitExpertReviewRequest']")).click();
		driver.close();
		return name;
	}
}
