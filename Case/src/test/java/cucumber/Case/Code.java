package cucumber.Case;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Code {
	WebDriver driver;
	@Given("open the testMe Application")
	public void open_the_testMe_Application() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_c2a.05.05\\Desktop\\SeleniumDrivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[2]/a")).click();
	    
	}

	@When("Enter the details")
	public void enter_the_details(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
	       for(int i=0;i<list.size();i++)
	       {
	    	   driver.findElement(By.id("userName")).sendKeys(list.get(i).get("username"));
	    	   driver.findElement(By.name("firstName")).sendKeys(list.get(i).get("firstname"));
	   		   driver.findElement(By.name("lastName")).sendKeys(list.get(i).get("lastname"));
	   		   driver.findElement(By.id("password")).sendKeys(list.get(i).get("password"));
	   		   driver.findElement(By.id("pass_confirmation")).sendKeys(list.get(i).get("conformpsd"));
	   		   driver.findElement(By.xpath("//*[@id='gender']")).click();
	   		   driver.findElement(By.id("emailAddress")).sendKeys(list.get(i).get("mail"));
	   		   driver.findElement(By.id("mobileNumber")).sendKeys(list.get(i).get("mobile"));
	   	       driver.findElement(By.name("dob")).sendKeys("07/18/1997");
	   		   driver.findElement(By.id("address")).sendKeys(list.get(i).get("address"));
	   	       Select question = new Select(driver.findElement(By.id("securityQuestion")));
	   		   question.selectByValue("411011");
	   		driver.findElement(By.id("answer")).sendKeys("red");
	       }
	}

	@And("click the Register Button")
	public void click_the_Register_Button() {
		driver.findElement(By.name("Submit")).click();
	}

	@Then("get the login Page")
	public void get_the_login_Page() {
		Assert.assertEquals(driver.getTitle(),"Login");
		driver.close();
	    
	}
	@Given("Enter to the login Page")
	public void enter_to_the_login_Page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_c2a.05.05\\Desktop\\SeleniumDrivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();
	    
	}

	@When("Enter the username {string}")
	public void enter_the_username(String string) {
	   driver.findElement(By.id("userName")).sendKeys(string);
	}

	@And("Enter the password {string}")
	public void enter_the_password(String string) {
		 driver.findElement(By.id("password")).sendKeys(string);
	}

	@And("Click the Signin button")
	public void click_the_Signin_button() {
		
		 driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[4]/div/input[1]")).click();
	}

	@Then("get the home page")
	public void get_the_home_page() {
		Assert.assertEquals(driver.getTitle(),"Home");
		
	}
	//case 3
	@Given("Enter the {string} and {string}")
	public void enter_the_and(String string, String string2) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_c2a.05.05\\Desktop\\SeleniumDrivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();
		driver.findElement(By.id("userName")).sendKeys(string);
		 driver.findElement(By.id("password")).sendKeys(string2);
		 driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[4]/div/input[1]")).click();
	}

	@When("search the product {string}")
	public void search_the_product(String string) {
		driver.findElement(By.id("myInput")).sendKeys(string);
	}

	@When("click the item")
	public void click_the_item() {
		driver.findElement(By.xpath("/html/body/div[1]/form/input")).click();
		  Assert.assertEquals(driver.getTitle(), "Search");
	    
	}

	@Then("check the product is here")
	public void check_the_product_is_here() {
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).getText(),"Add to cart" );
	  
	}

	
	//case4 Fail
	@Given("Signin the page {string} and {string}")
	public void signin_the_page_and(String string, String string2) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_c2a.05.05\\Desktop\\SeleniumDrivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();
		 driver.findElement(By.id("userName")).sendKeys(string);
		 driver.findElement(By.id("password")).sendKeys(string2);
		 driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[4]/div/input[1]")).click();
	}

	@When("search the products <head>")
	public void search_the_products_head() {
		driver.findElement(By.id("myInput")).sendKeys("head");
		driver.findElement(By.xpath("/html/body/div[1]/form/input")).click();
		
	}

	@When("Try to pay withour add that item")
	public void try_to_pay_withour_add_that_item() {
	
		Assert.assertEquals( driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).getText(),"Cart "+ driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]/b")).getText()+"   ");
		
		
	
	
	
	}

	@Then("Testme didn't display that icon")
	public void testme_didn_t_display_that_icon() {
		
	  
	}
	//case4 pass
	@Given("Signin the pages {string} and {string}")
	public void signin_the_pages_and(String string, String string2) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_c2a.05.05\\Desktop\\SeleniumDrivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();
		 driver.findElement(By.id("userName")).sendKeys(string);
		 driver.findElement(By.id("password")).sendKeys(string2);
		 driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[4]/div/input[1]")).click();
	}

	@When("search the product <head>")
	public void search_the_product_head() {
		driver.findElement(By.id("myInput")).sendKeys("head");
		driver.findElement(By.xpath("/html/body/div[1]/form/input")).click();
	}

	@When("add the product in the cart")
	public void add_the_product_in_the_cart() {
		 driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
	}

	@Then("find the cart icon")
	public void find_the_cart_icon() {
		 Assert.assertEquals( driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).getText(),"Cart "+ driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]/b")).getText()+"   ");
	
	    
	}

	
	   

	
}
	