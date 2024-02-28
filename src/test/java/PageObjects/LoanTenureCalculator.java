package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoanTenureCalculator extends BasePage 
{

	public LoanTenureCalculator(WebDriver driver) 
	{
		super(driver);
		
	}
	
	//finding xpath for loan Amount Calculator button
	@FindBy(xpath="//*[@id=\"loan-tenure-calc\"]/a[1]")
	WebElement loan_tenure_calc_button;
	
	//finding xpath of  loan amount
	@FindBy(xpath="//*[@id=\"loanamount\"]")
	WebElement loan_tenure_amount;
	
	//finding xpath of  loan interest
	@FindBy(xpath="//*[@id=\"loaninterest\"]")
	WebElement loan_tenure_interest;
	
	//finding xpath of  loan tenure
	@FindBy(xpath="//*[@id=\"loanemi\"]")
	WebElement loan_tenure_emi;
	
	//finding xpath of  loan fees and charges
	@FindBy(xpath="//*[@id=\"loanfees\"]")
	WebElement loan_tenure_fees;
	
	//finding xpath of  loan fees and charges
	@FindBy(xpath="//*[@id=\"loanamountslider\"]")
	WebElement loan_tenure_amount_slider;
	
	//finding xpath of  loan fees and charges
	@FindBy(xpath="//*[@id=\"loaninterestslider\"]")
	WebElement loan_tenure_interest_slider;
	
	//finding xpath of  loan fees and charges
	@FindBy(xpath="//*[@id=\"loanemislider\"]/span")
	WebElement loan_tenure_emi_slider;
	
	//finding xpath of  loan fees and charges
	@FindBy(xpath="//*[@id=\"loanfeesslider\"]")
	WebElement loan_tenure_fees_slider;
	
	
	//scrolling up till loan tenure calculator is visible
	public void scroll5()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",loan_tenure_calc_button);
		
	}
	
	//clicking loan tenure calculator
	public void click_loan_tenure_calc()
	{
		loan_tenure_calc_button.click();
	}
	
	//UI check for loan amount text box 
		public boolean amount_ui_check_loantenure()
		{
			boolean amount1 = loan_tenure_amount.isEnabled();
			return amount1;
		}	
		
		//UI check for loan tenure text box 
		public boolean tenure_ui_check_loantenure()
		{
			boolean tenure1 = loan_tenure_emi.isEnabled();
			return tenure1;
		}	
		
		
		//UI check for loan interest text box 
		public boolean interest_ui_check_loantenure()
		{
			boolean interest1 = loan_tenure_interest.isEnabled();
			return interest1;
		}	
		

		//UI check for loan fees & charges text box 
		public boolean fees_ui_check_loantenure()
		{
			boolean fees1 = loan_tenure_fees.isEnabled();
			return fees1;
		}	
		
		
		
		//scale check/verification
		public boolean amount_slider_ui_check_loantenure() 
		{
				Actions act = new Actions(driver);
				String amount1=loan_tenure_amount.getAttribute("value");
				act.dragAndDropBy(loan_tenure_amount_slider, 10, 0).build().perform();
				String amount2 = loan_tenure_amount.getAttribute("value");
				boolean amount = amount1.equals(amount2);
				return amount;
				
		}

		
		//scale check/verification
		public boolean interest_slider_ui_check_loantenure() 
		{
				Actions act = new Actions(driver);
				String amount1=loan_tenure_interest.getAttribute("value");
				act.dragAndDropBy(loan_tenure_interest_slider, 5, 0).build().perform();
				String amount2 = loan_tenure_interest.getAttribute("value");
				boolean amount = amount1.equals(amount2);
				return amount;
				
		}
		
		//scale check/verification
		public boolean emi_slider_ui_check_loantenure()  
		{
				Actions act = new Actions(driver);
				String amount1=loan_tenure_emi.getAttribute("value");
				act.dragAndDropBy(loan_tenure_emi_slider, 10, 0).build().perform();
				String amount2 = loan_tenure_emi.getAttribute("value");
				boolean amount = amount1.equals(amount2);
				return amount;
				
		}
		
		//scale check/verification
		public boolean fees_slider_ui_check_loantenure() 
		{
				Actions act = new Actions(driver);
				String amount1=loan_tenure_fees.getAttribute("value");
				act.dragAndDropBy(loan_tenure_fees_slider, 50, 0).build().perform();
				String amount2 = loan_tenure_fees.getAttribute("value");
				boolean amount = amount1.equals(amount2);
				return amount;
				
		}
		

}
