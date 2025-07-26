package StepDefs;

import java.util.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class one11stepDefs {
	WebDriver driver;
	
	@Given("Chrome browser is launched")
	public void chrome_browser_is_launched() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		System.out.println("browser launched");
	}

	@When("Navigate to OrangeHRM page")
	public void navigate_to_orange_hrm_page() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Navigate to OrangeHRM page");
	}

	@And("Enter username and password")
	public void enter_username_and_password() {
		System.out.println("Enter username and password");
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
		System.out.println("User clicks on Login button");
	}

	@Then("User navigated to OrangeHRM Home page")
	public void user_navigated_to_orange_hrm_home_page() {
		System.out.println("User navigated to OrangeHRM Home page");
	}
	
	@When("Navigate to flipkart site")
	public void navigate_to_flipkart_site() {
	    driver.get("https://www.flipkart.com/");
	}

	@When("User enter {string} in search box in flipkart site")
	public void user_enter_in_search_box_in_flipkart_site(String Item) throws InterruptedException {
	    WebElement searchBox=driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
//	    searchBox.sendKeys(Item);
//	    searchBox.sendKeys(Keys.ENTER);
//	    Thread.sleep(4000);
	    Actions action = new Actions(driver);
	    action.click(searchBox).sendKeys(Item).sendKeys(Keys.ENTER).perform();
	    Thread.sleep(4000);
		System.out.println("Adding ::");
	}
	    

	@And("User stores all the {string} in a list")
	public void user_stores_all_the_in_a_list(String Item)
	{
//		List<WebElement> listMobile=new ArrayList<>();
//		List<WebElement> listPrice=new ArrayList<>();
//		listPrice=driver.findElements(By.xpath("//*[@class='Nx9bqj _4b5DiR']"));
////		listMobile=driver.findElements(By.xpath("//*[@class='KzDlHZ']"));
////		for(WebElement ele:listMobile) {
////			System.out.println(ele.getText());
////		}
//		for(WebElement ele1:listPrice) {
//			String priceInText=ele1.getText();
//			String a=priceInText.replace("₹","").replaceAll(",", "");		
//			int price=Integer.parseInt(a);
//			if(price<7000) {
//				System.out.println("Inside for loop");
////				listMobile=driver.findElements(By.xpath("//*[@class='Nx9bqj _4b5DiR']/ancestor::div[@class='col col-5-12 BfVC2z']/preceding-sibling::div/div[@class='KzDlHZ']"));
////				String str=((WebElement) listMobile).getText();
////				for(WebElement e:listMobile) {
////					String str=e.getText();
////					System.out.println(str);
////				}
//				//----------------------
//				WebElement nameElement = ele1.findElement(By.xpath("//*[@class='Nx9bqj _4b5DiR']/ancestor::div[@class='col col-5-12 BfVC2z']/preceding-sibling::div/div[@class='KzDlHZ']"));
//                String mobileName = nameElement.getText();
//////				String str=driver.findElement(By.xpath("//*[@class='Nx9bqj _4b5DiR']/ancestor::div[@class='col col-5-12 BfVC2z']/preceding-sibling::div/div[@class='KzDlHZ']")).getText();
////				System.out.println(str+" : "+price);
//////				System.out.println("Price less than 7000:"+price);
//				
//			}
//		}
		
		//-------------------------------------------------------------------------------------------
//		List<WebElement> priceElements = driver.findElements(By.xpath("//*[@class='Nx9bqj _4b5DiR']"));
//
//	    for (WebElement priceElement : priceElements) {
//	        try {
//	            // Get price text and clean it
//	            String priceText = priceElement.getText(); // e.g., ₹6,999
//	            String cleanedPrice = priceText.replace("₹", "").replace(",", "");
//	            int price = Integer.parseInt(cleanedPrice);
//
//	            // Check condition: price < 7000
//	            if (price < 7000) {
//	                // Go up to product card, then find mobile name
//	                WebElement nameElement = priceElement.findElement(By.xpath("//*[@class='Nx9bqj _4b5DiR']/ancestor::div[@class='col col-5-12 BfVC2z']/preceding-sibling::div/div[@class='KzDlHZ']"));
//	                String mobileName = nameElement.getText();
//
//	                System.out.println("Mobile under ₹7000: " + mobileName + " — ₹" + price);
//	            }
//
//	        } catch (Exception e) {
//	            System.out.println("Error handling price element: " + e.getMessage());
//	        }
//	    }
		
		//---------------------###########################################################################
		// Loop over product containers that contain both name and price
		List<WebElement> products = driver.findElements(By.xpath("//*[@class='tUxRFH']"));
		for (WebElement product : products) {
			// Get mobile name
			try {
        WebElement nameElement = product.findElement(By.xpath(".//div[@class='KzDlHZ']"));
        String name = nameElement.getText();
 //       System.out.println(name);

        // Get price
        WebElement priceElement = product.findElement(By.xpath(".//div[@class='Nx9bqj _4b5DiR']"));
        String priceText = priceElement.getText().replace("₹", "").replace(",", "");
        int price = Integer.parseInt(priceText);
//        System.out.println(price);
        // Filter
        if (price < 7000) {
            System.out.println("Mobile under ₹7000: " + name + " — ₹" + price);
        }
		
	   
	}
			catch(Exception e) {
				continue;
			}
		}
	}	
		
		
	}
//	@Then("User can see all mobile")
//	public void user_can_see_all_mobile() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

