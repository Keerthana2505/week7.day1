package stepDefs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadPage extends ProjectSpecificMethod{
	
	@Given("Click CRMSFA Link")
	public void clickCrmSfa() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	
	@And("Click Leads Tab")
	public void clickLeadsTab() {
		driver.findElement(By.linkText("Leads")).click();
	}
	
	@And("Click Create Leads Link")
	public void clickLeadsLink() {
		driver.findElement(By.linkText("Create Lead")).click();
		
	}
	
	@When("Type the company name as (.*)$")
	public void typeCompanyName(String companyName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		
	}

	@And("Type the first name as (.*)$")
	public void typeFirstName(String firstName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		
	}

	@And("Type the last name as (.*)$")
	public void typeLastName(String lastName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
	}

	@And("Click Create Leads Button")
	public void clickCreateLeadsButton() {
		driver.findElement(By.name("submitButton")).click();
	}
	
	@Then("Verify the View Leads Page")
	public void verifyViewLeads() {
		String title = driver.getTitle();
		if(title.contains("View Leads")) {
			System.out.println("Create Lead Page Verified !!");
		}
	}
	

}