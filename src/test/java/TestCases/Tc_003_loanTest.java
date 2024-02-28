package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoanAmountCalculator;
import PageObjects.LoanPage;
import PageObjects.LoanTenureCalculator;
import TestBase.BaseClass;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Tc_003_loanTest extends BaseClass 
{
	LoanPage lp;
	LoanAmountCalculator la;
	LoanTenureCalculator lt;
	
	@Test(priority=11)
	public void verify_click_menu()
	{
		lp=new LoanPage(driver);
		lp.scroll3();
		lp.click_menu();
		lp.click_loan_calculator();
		lp.click_emi_calculator();
		
	}
	
	
	@Test(priority=12)
	public void verify_textbox_ui_emi()
	{
		lp=new LoanPage(driver);
		logger.info("------CHECKING THE TEXTBOX UI FOR EMI CALCULATOR ------");
		boolean amount = lp.amount_ui_check();
		Assert.assertEquals(amount, true, "Loan Amount text box is not Enabled.");
		boolean interest = lp.interest_ui_check();
		Assert.assertEquals(interest, true, "Loan Interest text box is not Enabled.");
		boolean tenure = lp.tenure_ui_check();
		Assert.assertEquals(tenure, true, "Loan Tenure text box is not Enabled.");
		boolean fees = lp.fees_ui_check();
		Assert.assertEquals(fees, true, "Loan Fees & Charges text box is not Enabled.");
	}
	
	
	@Test(priority=13)
	public void verify_scale_ui_emi()
	{
		lp=new LoanPage(driver);
		logger.info("------CHECKING THE SCALE UI FOR EMI CALCULATOR ------");
		
		boolean amount = lp.amount_slider_ui_check();
		Assert.assertEquals(false, amount, "Loan Amount Slider is not Enabled.");
		System.out.println("Loan Amount slider working........... ");
		
		boolean interest = lp.interest_slider_ui_check();
		Assert.assertEquals(false, interest, "Loan Interest Slider is not Enabled.");
		System.out.println("Loan Interest slider working........... ");
		
		boolean tenure = lp.tenure_slider_ui_check();
		Assert.assertEquals(false, tenure, "Loan Tenure Slider is not Enabled.");
		System.out.println("Loan Tenure slider working........... ");
		
		boolean fees = lp.fees_slider_ui_check();
		Assert.assertEquals(false, fees, "Loan Fees & Charges Slider is not Enabled.");
		System.out.println("Loan Fees slider working........... ");
		System.out.println();
		
	}

	
	
	@Test(priority=14)
	public void verify_month_change_emi()
	{
		lp=new LoanPage(driver);
		logger.info("------VERIFYING THE YEAR TO MONTH CONVERTION FOR EMI CALCULATOR ------");
		
		lp.fill_tenure_details();
		int b =Integer.parseInt(lp.get_tenure());// getting (int)year
		int a = b*12;//calculating manually no. of months in b years
		String exp_month = Integer.toString(a);//converting int months to string for Assert
		
		lp.click_month();//clicking month
		String act_month = lp.get_tenure();//getting month that is showed in text box
		
		Assert.assertEquals(act_month, exp_month, "year is not converting into months");
		
	}
	
	@Test(priority=15)
	public void verify_click_loanAmount()
	{
		la=new LoanAmountCalculator(driver);
		la.scroll4();
		la.click_loan_amount_calc();
		
	}
	
	
	@Test(priority=16)
	public void verify_textbox_ui_loanamount()
	{
		la=new LoanAmountCalculator(driver);
		logger.info("------CHECKING THE TEXTBOX UI FOR LOAN AMOUNT CALCULATOR ------");
		
		boolean amount = la.amount_ui_check_loanamount();
		Assert.assertEquals(amount,true, "Loan emi textbox for LoanAmount  is not Enabled.");
		
		boolean interest = la.interest_ui_check_loanamount();
		Assert.assertEquals(interest, true, "Loan Interest text box for LoanAmount is not Enabled.");
		
		boolean tenure = la.tenure_ui_check_loanamount();
		Assert.assertEquals(tenure, true, "Loan Tenure text box for LoanAmount is not Enabled.");
		
		boolean fees = la.fees_ui_check_loanamount();
		Assert.assertEquals(fees, true, "Loan Fees & Charges text box for LoanAmount is not Enabled.");
		
		
	}
	
	
	@Test(priority=17)
	public void verify_scale_ui_loanamount()
	{
		la=new LoanAmountCalculator(driver);
		logger.info("------CHECKING THE SCALE UI FOR LOAN AMOUNT CALCULATOR ------");
		
		boolean amount = la.amount_slider_ui_check_loanamount();
		Assert.assertEquals(false, amount, "Loan Amount Slider for LoanAmount is not Enabled.");
		System.out.println("Loan Emi slider for LoanAmount working........... ");
		
		boolean interest = la.interest_slider_ui_check_loanamount();
		Assert.assertEquals(false, interest, "Loan Interest Slider for LoanAmount is not Enabled.");
		System.out.println("Loan Interest slider for LoanAmount working........... ");
		
		boolean tenure = la.tenure_slider_ui_check_loanamount();
		Assert.assertEquals(false, tenure, "Loan Tenure Slider for LoanAmount is not Enabled.");
		System.out.println("Loan Tenure slider for LoanAmount working........... ");
		
		boolean fees = la.fees_slider_ui_check_loanamount();
		Assert.assertEquals(false, fees, "Loan Fees & Charges Slider for LoanAmount is not Enabled.");
		System.out.println("Loan Fees slider for LoanAmount working........... ");
		System.out.println();
	}
	
	
	@Test(priority=18)
	public void verify_month_change_loanamount() 
	{
		la=new LoanAmountCalculator(driver);
		logger.info("------VERIFYING THE YEAR TO MONTH CONVERTION FOR LOAN AMOUNT CALCULATOR ------");
		
		la.click_year_loanamount();
		la.fill_tenure_details_loanamount();
		
		int b =Integer.parseInt(la.get_tenure_loanamount());// getting (int)year
		int a = b*12;//calculating manually no. of months in b years
		String exp_month = Integer.toString(a);//converting int months to string for Assert
		
		la.click_month_loanamount();//clicking month
		String act_month = la.get_tenure_loanamount();//getting month that is showed in text box
		
		Assert.assertEquals(act_month, exp_month, "Year is not converting into months");
		
	}
	
	@Test(priority=19)
	public void verify_click_loanTenure()
	{
		lt=new 	LoanTenureCalculator(driver);
		lt.scroll5();
		lt.click_loan_tenure_calc();
		
	}
	
	@Test(priority=20)
	public void verify_textbox_ui_loantenure()
	{
		lt=new 	LoanTenureCalculator(driver);
		logger.info("------CHECKING THE TEXTBOX UI FOR LOAN TENURE CALCULATOR ------");
		
		boolean amount = lt.amount_ui_check_loantenure();
		Assert.assertEquals(amount, true, "Loan Amount text box is not Enabled.");
		boolean interest = lt.interest_ui_check_loantenure();
		Assert.assertEquals(interest, true, "Loan Interest text box is not Enabled.");
		boolean tenure = lt.tenure_ui_check_loantenure();
		Assert.assertEquals(tenure, true, "Loan Tenure text box is not Enabled.");
		boolean fees = lt.fees_ui_check_loantenure();
		Assert.assertEquals(fees, true, "Loan Fees & Charges text box is not Enabled.");
	}
	
	
	@Test(priority=21)
	public void verify_scale_ui_loantenure() 
	{
		lt=new LoanTenureCalculator(driver);
		logger.info("------CHECKING THE SCALE UI FOR LOAN TENURE CALCULATOR ------");
		
		boolean amount = lt.amount_slider_ui_check_loantenure();
		Assert.assertEquals(amount, false, "Loan Amount Slider is not Enabled.");
		System.out.println("Loan amount slider for LoanTenure working........... ");
		
		boolean tenure = lt.emi_slider_ui_check_loantenure();
		Assert.assertEquals(tenure, false, "Loan Emi Slider is not Enabled.");
		System.out.println("Loan Emi slider for LoanTenure working........... ");
		
		boolean interest = lt.interest_slider_ui_check_loantenure();
		Assert.assertEquals(interest, false, "Loan Interest Slider is not Enabled.");
		System.out.println("Loan Interest slider for LoanTenure working........... ");
		
		boolean fees = lt.fees_slider_ui_check_loantenure();
		Assert.assertEquals(fees, false, "Loan Fees & Charges Slider is not Enabled.");
		System.out.println("Loan Fees and Charges slider for LoanTenure working........... ");
		System.out.println();
		
	}
	

}
