import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TakeScreenshot {

    public static void loginGmail(String emailLogin, String emailPass)
			throws InterruptedException, IOException {
		driver.get("https://accounts.google.com/ServiceLogin");

		Thread.sleep(5000);

		/* Gmail experience login page. */
		try {
			if (driver
					.findElement(
							By.xpath("//div[contains(@class, 'flex-container__content')]/div[contains(@class, 'gmail-devices__copy')]/h2"))
					.getText().contains("Experience Gmail on any device")) {
				System.out.println("Visited to experience login page");
				driver.findElement(
						By.xpath("//div[contains(@class, 'gmail-nav__nav-links-wrap')]/a[2]"))
						.click();
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			System.out.println("Not visited to experience login page");
		}

		driver.findElement(By.id("identifierId")).sendKeys(emailLogin);
		System.out.println("Email filled");
		getScreenshot("email_filled");
		Thread.sleep(1000);

		driver.findElement(By.id("identifierNext")).click();
		System.out.println("Next clicked");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys(emailPass);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Password filled");
		getScreenshot("password_filled");
		Thread.sleep(1000);
		driver.findElement(By.id("passwordNext")).click();
		System.out.println("Next clicked");
		Thread.sleep(5000);
		System.out.println("Username and password filled");
		// //td[4][contains(@class, 'a8X')]/div[1]/div[1]/div/div/div
		getScreenshot("Login_window");
		// Checking if verify option is asked..
		try {
			if (driver
					.findElement(By.xpath("//h1[contains(@class, 'sfYUmb')]"))
					.getText().contains("Verify it's you")) {
				try {
					if (driver
							.findElement(
									By.xpath("//div[contains(@class, 'vdE7Oc')]/span[contains(text(), 'Standard rates apply')]"))
							.getText().contains("Standard rates apply")) {
						driver.findElement(
								By.xpath("//div[contains(@class, 'vdE7Oc')]/span[contains(text(), 'Standard rates apply')]"))
								.click();
						System.out
								.println("Mobile verification is asked, check your sms and type here:");
						getScreenshot("verify_sms");
						String sms = input.nextLine();
						driver.findElement(
								By.xpath("//input[contains(@name, 'idvPin')]"))
								.sendKeys(sms);
						driver.findElement(
								By.xpath("//div[contains(@id, 'idvPreregisteredPhoneNext')]"))
								.click();
						Thread.sleep(4000);
						System.out.println("Verification done");
					}
				} catch (Exception e) {
					System.out.println("No mobile number verification present");
				}
				try {
					if (driver
							.findElement(
									By.xpath("//div[contains(@class, 'vdE7Oc') and contains(text(), 'Enter the city you usually sign in from')]"))
							.getText()
							.contains("Enter the city you usually sign in from")) {
						driver.findElement(
								By.xpath("//div[contains(@class, 'vdE7Oc') and contains(text(), 'Enter the city you usually sign in from')]"))
								.click();
						System.out
								.println("City name verification is asked here, type your city name here:");
						getScreenshot("verify_city");
						String city = input.nextLine();
						driver.findElement(
								By.xpath("//input[contains(@name, 'knowledgeLoginLocationInput')]"))
								.sendKeys(city);
						driver.findElement(
								By.xpath("//div[contains(@id, 'next')]"))
								.click();
						System.out.println("Verification done");
					}
				} catch (Exception e) {
					System.out.println("No city option is present");
				}
			}
		} catch (Exception e) {
			System.out.println("No verify option is asked");
		}
		Thread.sleep(5000);

		// driver.get("https://mail.google.com/mail/?ui=html&zy=h");
		driver.get("https://mail.google.com/mail/u/0/");

		// try{
		// if(driver.findElement(By.xpath("//div[contains(@class, 'kKkU3d')]/p")).getText().contains("To continue, first verify it's you")){
		// driver.findElement(By.xpath("//input[contains(@name, 'password')]")).sendKeys(emailPass);
		// driver.findElement(By.xpath("//div[contains(@id, 'passwordNext')]")).click();
		// Thread.sleep(5000);
		// driver.get("https://mail.google.com/mail/u/0/");
		// }
		// }catch(Exception e){
		// System.out.println("Again verification password option is not asked");
		// }

		Thread.sleep(5000);
		getScreenshot("Email_main_page_inbox");

		// try{
		// if(driver.findElement(By.xpath("//h1[contains(text(), 'Do you really want to use HTML Gmail?')]")).getText().contains("Do you really want to use HTML Gmail?")){
		// Thread.sleep(4000);
		// driver.findElement(By.xpath("//input[contains(@class, 'maia-button-secondary')]")).click();
		// driver.get("https://mail.google.com/mail/?ui=html&zy=h");
		// Thread.sleep(5000);
		// }
		// }catch(Exception e){
		// System.out.println("Basic html option button not offered!");
		// }
	}

    public static void main(String[] args) {

        String[] emailLogin = new String[]{
				"your email address 1",
                "your email address 2"
		};
		
		String[] emailPass = new String[]{
			"your pass1",
            "your pass2"
		};

        ChromeOptions chromeOptions = new ChromeOptions();
		File chromeDriver = new File("your chrome drive path location");
		System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--disable-gpu");
		chromeOptions.addArguments("--window-size=1024, 768");
		
		driver = new ChromeDriver(chromeOptions);
		driver.get("https://www.gmail.com");
		Thread.sleep(5000);

        for(int i=0; i<emailLogin.length; i++){
			
			loginGmail(emailLogin[i], emailPass[i]);
        }
        driver.quit();
    }
}