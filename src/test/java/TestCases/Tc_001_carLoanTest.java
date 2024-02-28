package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.CarLoanPage;
import TestBase.BaseClass;

public class Tc_001_carLoanTest extends BaseClass  {
	
	CarLoanPage cp;
	
	@Test(priority=1)
	public void verify_car_loan()
	{
		cp=new CarLoanPage(driver);
		logger.info("------FILLING THE CAR LOAN DETAILS ------");
		cp.car_loan_details();
	}
	
	@Test(priority=2)
	public void verify_click_emi_schemes()
	{
		cp=new CarLoanPage(driver);
		cp.click_emi_schemes();
		
	}
	
	@Test(priority=3)
	public void scroll_down() 
	{
		cp=new CarLoanPage(driver);
		cp.scroll();
		
	}
	
	@Test(priority=4)
	public void get_monthly_principal() throws InterruptedException
	{
		cp=new CarLoanPage(driver);
		String principal_amount=cp.monthly_principal();
		logger.info("------GETTING THE PRINCIPAL AMOUNT FOR 1 MONTH ------");
		System.out.println("Principal Amount for One Month="+principal_amount);
	}
	
	@Test(priority=5)
	public void get_monthly_interest() throws IOException
	{
		cp=new CarLoanPage(driver);
		String interest_amount=cp.monthly_interest();
		logger.info("------GETTING THE INTEREST AMOUNT FOR 1 MONTH ------");
		System.out.println("Interest Amount for One Month="+interest_amount);
		
	}


}
