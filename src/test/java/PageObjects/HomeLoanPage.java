package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class HomeLoanPage extends BasePage {
	
	public HomeLoanPage(WebDriver driver) 
	{
		super(driver);
	
	}
	
	
	//finding xpath of calculator menu
	@FindBy(xpath="//*[@id=\"menu-item-dropdown-2696\"]")
	WebElement calculator;
	
	//finding xpath of calculator menu
	@FindBy(xpath="//*[@id=\"menu-item-3294\"]")
	WebElement homeloan_calculator;
	
	//finding xpath of car loan amount
	@FindBy(xpath="//*[@id=\"homeprice\"]")
	WebElement home_loan_amount;
	
	//finding xpath of car loan interest
	@FindBy(xpath="//*[@id=\"homeloaninterest\"]")
	WebElement home_loan_interest;
			
	//finding xpath of car loan tenure
	@FindBy(xpath="//*[@id=\"homeloanterm\"]")
	WebElement home_loan_tenure;
	
	
	//finding xpath of table (for scrolling)
	@FindBy(xpath="//*[@id=\"paymentschedule\"]")
	WebElement homeloan_data_table;
	

	//finding xpath of table rows
	@FindBy(xpath="//*[@id=\"paymentschedule\"]/table//tr[@class='row no-margin yearlypaymentdetails']")
	List<WebElement> table_row;
	
	//finding xpath of table rows
	@FindBy(xpath="//*[@id=\"paymentschedule\"]/table//th")
	List<WebElement> table_col;

	
	//#####################
	
	//finding xpath of table rows
	@FindBy(xpath="//*[@id=\"paymentschedule\"]/table//th")
	List<WebElement> table_headers;
	
	//finding xpath of table column 1
	@FindBy(xpath="//tr[@class='row no-margin yearlypaymentdetails']/td[1]")
	List<WebElement> table_col1;
	
	//finding xpath of table column 1
	@FindBy(xpath="//tr[@class='row no-margin yearlypaymentdetails']/td[2]")
	List<WebElement> table_col2;
	
	//finding xpath of table column 1
	@FindBy(xpath="//tr[@class='row no-margin yearlypaymentdetails']/td[3]")
	List<WebElement> table_col3;
	
	//finding xpath of table column 1
	@FindBy(xpath="//tr[@class='row no-margin yearlypaymentdetails']/td[4]")
	List<WebElement> table_col4;
	
	//finding xpath of table column 1
	@FindBy(xpath="//tr[@class='row no-margin yearlypaymentdetails']/td[5]")
	List<WebElement> table_col5;
	
	//finding xpath of table column 1
	@FindBy(xpath="//tr[@class='row no-margin yearlypaymentdetails']/td[6]")
	List<WebElement> table_col6;
	
	//finding xpath of table column 1
	@FindBy(xpath="//tr[@class='row no-margin yearlypaymentdetails']/td[7]")
	List<WebElement> table_col7;
	
	
	//#####################
	
	//clicking on calculator menu
	public void click_claculator()
	{
		calculator.click();
	}
	
	//clicking on home loan emi calculator 
	public void click_homeloan()
	{
		homeloan_calculator.click();
	}
	
	public void fill_details()
	{
		//sending loan amount
		home_loan_amount.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		home_loan_amount.sendKeys(Keys.DELETE);
		home_loan_amount.sendKeys("2500000");
		
        //sending interest
		home_loan_interest.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		home_loan_interest.sendKeys(Keys.DELETE);
		home_loan_interest.sendKeys("10");
		
		//sending time
		home_loan_tenure.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		home_loan_tenure.sendKeys(Keys.DELETE);
	    home_loan_tenure.sendKeys("10");
	}
	
	//Scrolling down till data table is visible
	public void scroll_down()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",homeloan_data_table);
	}
	
	
	//getting headers from year table
	public List get_table_headers() throws InterruptedException
	{
			
		Thread.sleep(6000);
		return table_headers;
	}
	
	//getting data from column 1 of table
	public List get_table_data()
	{
		List<List<WebElement>> listOfLists = new ArrayList();
		listOfLists.add(table_col1);
		listOfLists.add(table_col2);
		listOfLists.add(table_col3);
		listOfLists.add(table_col4);
		listOfLists.add(table_col5);
		listOfLists.add(table_col6);
		listOfLists.add(table_col7);
		return listOfLists;
	}
	
}
