package main.java.com.grfc.expert;

import java.io.IOException;

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
	
	public static void createCP () throws IOException, InterruptedException {
		HttpRequest.sendPostRequest("http://192.168.71.63:15672/api/exchanges/eais/amq.default/publish",
				"", "Basic ZWFpczplYWlzMTIz",  Settings.httpContType("JSON"),"{\"vhost\":\"eais\",\"name\":\"amq.default\",\"properties\":{\"delivery_mode\":1,\"headers\":{}},\"routing_key\":\"eais_messages_boy\",\"delivery_mode\":\"1\",\"payload\":\"{\\\"message_type\\\":\\\"review_inquiry\\\",\\\"send_datetime\\\":\\\"06.04.2018 14:59:55\\\",\\\"message\\\":{\\\"id\\\":10109990,\\\"id_expertise_type\\\":\\\"child_porn\\\",\\\"expertise_type\\\":\\\"child_porn\\\",\\\"media_type\\\":\\\"2\\\",\\\"direction_date_time\\\":\\\"06.04.2018 14:51\\\",\\\"resource_url\\\":\\\"https:\\\\/\\\\/e621.net\\\\/post\\\\/show\\\\/389071\\\\/breasts-cub-duo-female-friendship_is_magic-fuchs-h\\\",\\\"access_information\\\":\\\"dfbdfbdfbdfbdfbdfbdfbdfbdfbdfbdfb\\\",\\\"comment\\\":\\\"dfbdfbdfbdrtgtrgrtgrfbdfbdfbdfbdfbdf\\\",\\\"comment_for_rework\\\":\\\"dfdfbdfbdfbdfbdfbdfbdfbfd\\\",\\\"comment_from_monitoring\\\":\\\"dfdvfvdfvdvdfvdfvdvdf\\\",\\\"files\\\":{\\\"content_type\\\":\\\"image\\\",\\\"format\\\":\\\"png\\\",\\\"encoding\\\":\\\"base64\\\",\\\"name\\\":\\\"scr_msgid_164791_5ac75f19718e7.png\\\",\\\"body\\\":\\\"iVBORw0KGgoAAAANSUhEUgAAAIAAAACACAMAAAD04JH5AAAAA3NCSVQICAjb4U\\\\/gAAAACXBIWXMAADddAAA3XQEZgEZdAAAAGXRFWHRTb2Z0d2FyZQB3d3cuaW5rc2NhcGUub3Jnm+48GgAAAFFQTFRF\\\\/\\\\/\\\\/\\\\/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAALIimcAAAABp0Uk5TAAEHCBgZJi1JcH+AhJeYs7XByNrj5vLz9fYIbGB4AAABb0lEQVR42u3byW6DQBAE0AYbG9IsZof6\\\\/w\\\\/NIZGDrUjjRIPLsqrOrenHcoJuswdy8mYcGz\\\\/Zg\\\\/lrfSBJsQIAsBbJHvXB8y645pLErw+mwCZF\\\\/Prg81y3B66n2PXBfOAmHrs+mOb2wCZ2fTDj7YFj7PpgcJfY9QIIIMArAdK8bvsZO2fu2zpPf2mfVROelqnK7tofygVPzVIetv2PHZ6e7vjT\\\\/zyAkOF8vX5Kf2D4vgeHDqR0X+9BCVpKM7Ns4QGWzMwqEFOZpRMTMKWWg5rcai6gtpYLaK3nAnqbuYDZQI4AAggggACvB7CdI4AAAgggwNsA\\\\/L\\\\/wSAAHF+DgAhxcgIMLcHABDi7AwQU4uAAHF+DgAhxcgIMLcHABDi7AQQbE+kEpgAACCCCAAAIIIIAAAgggwPsA9LleAAEEEOB9APSBRvpIJ32olT7WSx9spo9204fb+eP99AUH\\\\/ooHfcmFv+bDX3Tir3oZfdnNjLXu9wn8HYQI7nJIFwAAAABJRU5ErkJggg==\\\"}}}\",\"headers\":{},\"props\":{},\"payload_encoding\":\"string\"}");
	}
}
