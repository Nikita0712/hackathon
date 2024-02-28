package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoanPage extends BasePage
{
	public LoanPage(WebDriver driver) 
	{
		super(driver);
	}
	
	//Finding xpath for scroll up action
	@FindBy(xpath="//*[@id=\"menu-item-dropdown-2696\"]")
	WebElement menu;
	
	//Finding xpath for loan calculator button
	@FindBy(xpath="//*[@id=\"menu-item-2423\"]/a")
	WebElement loan_calculator_button;
	
	//Finding xpath for loan calculator button
	@FindBy(xpath="//*[@id=\"emi-calc\"]/a[1]")
	WebElement emi_calculator;
	
	//finding xpath of  loan amount
	@FindBy(xpath="//*[@id=\"loanamount\"]")
	WebElement loan_amount;
	
	//finding xpath of  loan interest
	@FindBy(xpath="//*[@id=\"loaninterest\"]")
	WebElement loan_interest;
	
	//finding xpath of  loan tenure
	@FindBy(xpath="//*[@id='loanterm']")
	WebElement loan_tenure;
	
	//finding xpath of  loan fees and charges
	@FindBy(xpath="//*[@id=\"loanfees\"]")
	WebElement loan_fees;
	
	//finding xpath of  loan fees and charges
	@FindBy(xpath="//*[@id=\"loanamountslider\"]/span")
	WebElement loan_amount_slider;
	
	//finding xpath of  loan fees and charges
	@FindBy(xpath="//*[@id=\"loaninterestslider\"]/span")
	WebElement loan_interest_slider;
	
	//finding xpath of  loan fees and charges
	@FindBy(xpath="//*[@id=\"loantermslider\"]/span")
	WebElement loan_tenure_slider;
	
	//finding xpath of  loan fees and charges
	@FindBy(xpath="//*[@id=\"loanfeesslider\"]/span")
	WebElement loan_fees_slider;
	
	
	//finding xpath of  month button
	@FindBy(xpath="//*[@id=\"ltermwrapper\"]/div[1]/div/div/div/div/div/label[2]")
	WebElement month;

	//public static String tenure_year;
	
	
	
	//srolling up
	public void scroll3()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",menu);
	}
	
	//clicking menu
	public void click_menu()
	{
		menu.click();
		
	}
	
	//clicking loan calculator button
	public void click_loan_calculator()
	{
		loan_calculator_button.click();
	}
	
	//clicking emi calculator 
	public void click_emi_calculator()
	{
		emi_calculator.click();
		
	}	
	
	//UI check for loan amount text box 
	public boolean amount_ui_check()
	{
		boolean amount1 = loan_amount.isEnabled();
		return amount1;
	}	
	
	//UI check for loan interest text box 
	public boolean interest_ui_check()
	{
		boolean interest1 = loan_interest.isEnabled();
		return interest1;
	}	
	
	//UI check for loan tenure text box 
	public boolean tenure_ui_check()
	{
		boolean tenure1 = loan_tenure.isEnabled();
		return tenure1;
	}	
	
	//UI check for loan fees & charges text box 
	public boolean fees_ui_check()
	{
		boolean fees1 = loan_fees.isEnabled();
		return fees1;
	}	
	
	//scale check/verification
	public boolean amount_slider_ui_check() 
	{
			Actions act = new Actions(driver);
			String amount1=loan_amount.getAttribute("value");
			act.dragAndDropBy(loan_amount_slider, 10, 0).build().perform();
			String amount2 = loan_amount.getAttribute("value");
			boolean amount = amount1.equals(amount2);
			return amount;
			
	}

	
	//scale check/verification
	public boolean interest_slider_ui_check() 
	{
			Actions act = new Actions(driver);
			String amount1=loan_interest.getAttribute("value");
			act.dragAndDropBy(loan_interest_slider, 5, 0).build().perform();
			String amount2 = loan_interest.getAttribute("value");
			boolean amount = amount1.equals(amount2);
			return amount;
			
	}
	
	//scale check/verification
	public boolean tenure_slider_ui_check() 
	{
			Actions act = new Actions(driver);
			String amount1=loan_tenure.getAttribute("value");
			act.dragAndDropBy(loan_tenure_slider, 10, 0).build().perform();
			String amount2 = loan_tenure.getAttribute("value");
			boolean amount = amount1.equals(amount2);
			return amount;
			
	}
	
	//scale check/verification
	public boolean fees_slider_ui_check() 
	{
			Actions act = new Actions(driver);
			String amount1=loan_fees.getAttribute("value");
			act.dragAndDropBy(loan_fees_slider, 10, 0).build().perform();
			String amount2 = loan_fees.getAttribute("value");
			boolean amount = amount1.equals(amount2);
			return amount;
			
	}
	
	//filling the details in tenure
	public void fill_tenure_details()
	{
		//sending time
		loan_tenure.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		loan_tenure.sendKeys(Keys.DELETE);
		loan_tenure.sendKeys("6");
	}
	
	//getting tenure in year(text)   
	public String get_tenure()
	{
		String tenure_year = loan_tenure.getAttribute("value"); 
		return tenure_year;
	}
	
	//clicking month in tenure 
	public void click_month()
	{
		//month.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",month);
			
	}	
	
   
	
	
	
	

}
