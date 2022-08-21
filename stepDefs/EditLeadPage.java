package stepDefs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditLeadPage extends ProjectSpecificMethod {
	@Given ("Click CRM SFA Link")
	public void click_On_crm_link() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	@And ("Click on Leads Tab")
	public void click_on_leads_Tab() {
		driver.findElement(By.linkText("Leads")).click();
	}

	@And ("Click Find Leads Link")
	public void clickFindleadsLink() {
		driver.findElement(By.linkText("Find Leads")).click();
	}

	@When ("Enter the First Name as (.*)$")
	public void enter_f_name(String fName) {
		driver.findElement(By.xpath("(//label[text()='First name:'])[3]/following::input")).sendKeys(fName);
	}

	@And ("Click Find Leads Button")
	public void clickFindleadsButton() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And ("Click First Resulting Lead")
	public void clickFirstResutingLead() {
		boolean staleElement = true; 
		while(staleElement){
			try{
				driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();
				staleElement = false;
			} catch(StaleElementReferenceException e){
				staleElement = true;
			}
		}
	}

	@When ("CLick Edit Button")
	public void clickEditButton() {
		driver.findElement(By.xpath("//a[text()='Edit']")).click();  
	}

	@And ("Clear and Type Company Name as (.*)$")
	public void ClearAndEnterCompanyName(String cName) {
		WebElement n = driver.findElement(By.id("updateLeadForm_companyName"));
		n.clear();
		n.sendKeys(cName);	
	}

	@And ("Click Update Button")
	public void ClickUpdateButton() {
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
	}

	@Then ("Verify the View Lead Opentaps CRM Page")
	public void VerifyPage() {
		String title = driver.getTitle();
		if(title.contains("View Leads")) {
			System.out.println("Edit Lead Page Verified !!");
		}
	}

}
