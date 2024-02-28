package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarLoanPage extends BasePage {
	
	public CarLoanPage(WebDriver driver) 
	{
		super(driver);
	
	}
	
	//finding xpath of car loan button
	@FindBy(xpath="//*[@id='car-loan']")
	WebElement car_loan_button;
	
	
	//finding xpath of car loan amount
	@FindBy(xpath="//*[@id='loanamount']")
	WebElement car_loan_amount;
	
	//finding xpath of car loan interest
	@FindBy(xpath="//*[@id=\"loaninterest\"]")
	WebElement car_loan_interest;
	
	//finding xpath of car loan tenure
	@FindBy(xpath="//*[@id=\"loanterm\"]")
	WebElement car_loan_tenure;
	
	//finding xpath for EMI Scheme
	@FindBy(xpath="//*[@id=\"leschemewrapper\"]/div/div/div/div/label[2]")
	WebElement emi_schemes;
	
	//finding xpath of data table(for scrolling)
	@FindBy(xpath="//*[@id=\"emipaymenttable\"]/table/tbody/tr[1]")
	WebElement data_table;
	
	//finding xpath of +2024 
	@FindBy(xpath="//*[@id=\'year2024\']")
	WebElement plus_button;
	
	//finding xpath principal 
	@FindBy(xpath="//*[@id=\"monthyear2024\"]/td/div/table/tbody/tr[1]/td[2]")
	WebElement principal;
	
	//finding xpath of interest 
	@FindBy(xpath="//*[@id=\"monthyear2024\"]/td/div/table/tbody/tr[1]/td[3]")
	WebElement interest;

	
	
	
	
	public void car_loan_details() 
	{
		//clicking on car loan menu
		car_loan_button.click();
		
		//sending loan amount
		car_loan_amount.clear();
		car_loan_amount.sendKeys("1500000");
		
        //sending interest
		car_loan_interest.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		car_loan_interest.sendKeys(Keys.DELETE);
        car_loan_interest.sendKeys("9.5");
		
		//sending time
		car_loan_tenure.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		car_loan_tenure.sendKeys(Keys.DELETE);
		car_loan_tenure.sendKeys("1");
		
	}
	
	//clicking emi schemes
	public void click_emi_schemes()
	{
		emi_schemes.click();

	}
	
	public void scroll()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",data_table);
		
		
	}
	
	public String monthly_principal() throws InterruptedException
	{
		//clicking on plus button to get monthly data
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",plus_button);
		
		Thread.sleep(2000);
		
		//getting principal for 1 month
		String Month_principal = principal.getText();
		return Month_principal;
	}
	
	public String monthly_interest()
	{
		//getting interest for 1 month
		String Month_interest = interest.getText();
		return Month_interest;
	}

}
