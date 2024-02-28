package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoanAmountCalculator extends BasePage 
{

	public LoanAmountCalculator(WebDriver driver) 
	{
		super(driver);
	}
	
	
	//finding xpath for loan Amount Calculator button
	@FindBy(xpath="//*[@id=\"loan-amount-calc\"]/a[1]")
	WebElement loan_amount_calc_button;
	
	//finding xpath of  loan amount
	@FindBy(xpath="//*[@id=\"loanemi\"]")
	WebElement loan_amount_emi;
	
	//finding xpath of  loan interest
	@FindBy(xpath="//*[@id=\"loaninterest\"]")
	WebElement loan_amount_interest;
	
	//finding xpath of  loan tenure
	@FindBy(xpath="//*[@id=\"loanterm\"]")
	WebElement loan_amount_tenure;
	
	//finding xpath of  loan fees and charges
	@FindBy(xpath="//*[@id=\"loanfees\"]")
	WebElement loan_amount_fees;
	
	//finding xpath of  loan emi slider
	@FindBy(xpath="//*[@id=\"loanemislider\"]/div")
	WebElement loan_amount_emi_slider;
	
	//finding xpath of  loan interest slider
	@FindBy(xpath="//*[@id=\"loaninterestslider\"]")
	WebElement loan_amount_interest_slider;
	
	//finding xpath of  loan tenure slider
	@FindBy(xpath="//*[@id=\"loantermslider\"]")
	WebElement loan_amount_tenure_slider;
	
	//finding xpath of  loan fees and charges slider
	@FindBy(xpath="//*[@id=\"loanfeesslider\"]")
	WebElement loan_amount_fees_slider;
	
	//finding xpath of  year button
	@FindBy(xpath="//*[@id=\"ltermwrapper\"]/div[1]/div/div/div/div/div/label[1]")
	WebElement loan_amount_year;
	
	//finding xpath of  month button
	@FindBy(xpath="//*[@id='ltermwrapper']/div[1]/div/div/div/div/div/label[2]")
	WebElement loan_amount_month;
	
	//scrolling up till loan amount calculator is visible
	public void scroll4()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",loan_amount_calc_button);
		
		
	}
	
	public void click_loan_amount_calc()
	{
		loan_amount_calc_button.click();
	}
	
	//UI check for loan amount text box 
		public boolean amount_ui_check_loanamount()
		{
			boolean amount1 = loan_amount_emi.isEnabled();
			return amount1;
		}	
		
		//UI check for loan interest text box 
		public boolean interest_ui_check_loanamount()
		{
			boolean interest1 = loan_amount_interest.isEnabled();
			return interest1;
		}	
		
		//UI check for loan tenure text box 
		public boolean tenure_ui_check_loanamount()
		{
			boolean tenure1 = loan_amount_tenure.isEnabled();
			return tenure1;
		}	
		
		//UI check for loan fees & charges text box 
		public boolean fees_ui_check_loanamount()
		{
			boolean fees1 = loan_amount_fees.isEnabled();
			return fees1;
		}	
		
		
		
		//UI check for slider of loan amount text box 
		public boolean amount_slider_ui_check_loanamount()
		{
			Actions act = new Actions(driver);
			String amount1=loan_amount_emi.getAttribute("value");
			act.dragAndDropBy(loan_amount_emi_slider, 10, 0).build().perform();
			String amount2 = loan_amount_emi.getAttribute("value");
			boolean amount = amount1.equals(amount2);
			return amount;
		}	
		
		//UI check for slider of loan interest text box 
		public boolean interest_slider_ui_check_loanamount()
		{
			Actions act = new Actions(driver);
			String amount1=loan_amount_interest.getAttribute("value");
			act.dragAndDropBy(loan_amount_interest_slider, 10, 0).build().perform();
			String amount2 = loan_amount_interest.getAttribute("value");
			boolean amount = amount1.equals(amount2);
			return amount;
		}	
		
		//UI check for slider of loan tenure text box 
		public boolean tenure_slider_ui_check_loanamount()
		{
			Actions act = new Actions(driver);
			String amount1=loan_amount_tenure.getAttribute("value");
			act.dragAndDropBy(loan_amount_tenure_slider, 10, 0).build().perform();
			String amount2 = loan_amount_tenure.getAttribute("value");
			boolean amount = amount1.equals(amount2);
			return amount;
		}	
		
		//UI check for slider of loan fees & charges text box 
		public boolean fees_slider_ui_check_loanamount()
		{
			Actions act = new Actions(driver);
			String amount1=loan_amount_fees.getAttribute("value");
			act.dragAndDropBy(loan_amount_fees_slider, 10, 0).build().perform();
			String amount2 = loan_amount_fees.getAttribute("value");
			boolean amount = amount1.equals(amount2);
			return amount;
		}
		
		//filling the details in tenure
		public void fill_tenure_details_loanamount()
		{
			//sending time
			loan_amount_tenure.sendKeys(Keys.chord(Keys.CONTROL,"a"));
			loan_amount_tenure.sendKeys(Keys.DELETE);
			loan_amount_tenure.sendKeys("4");
		}
		
		//getting tenure in year(text)   
		public String get_tenure_loanamount()
		{
			String tenure_year_amount = loan_amount_tenure.getAttribute("value"); 
			return tenure_year_amount;
		}
		
		//clicking year in tenure 
		public void click_year_loanamount()
		{
			loan_amount_year.click();
				
		}
		
		//clicking month in tenure 
		public void click_month_loanamount()
		{
//			loan_amount_month.click();
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",loan_amount_month);
				
		}	
		
		

}
