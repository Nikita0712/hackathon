package stepDefinations;

import java.io.IOException;

import TestBase.BaseClass;
import TestCases.Tc_001_carLoanTest;
import TestCases.Tc_002_homeLoanTest;
import TestCases.Tc_003_loanTest;
import io.cucumber.java.en.*;

public class EmiStepDefination
{
	Tc_001_carLoanTest tc1;
	Tc_002_homeLoanTest tc2;
	Tc_003_loanTest tc3;
	
	@Given("user is navigating to emi calculator site")
	public void user_is_navigating_to_emi_calculator_site() throws IOException 
	{
		BaseClass bc=new BaseClass();
		bc.setUp("windows","chrome");
	   
	}

	@When("User is filling car loan details")
	public void user_is_filling_car_loan_details() 
	{
	   tc1=new Tc_001_carLoanTest();
	   tc1.verify_car_loan();
	   tc1.verify_click_emi_schemes();
	   tc1.scroll_down();
	}

	@When("user is getting principal and interest amount for one month")
	public void user_is_getting_principal_and_interest_amount_for_one_month() throws InterruptedException, IOException 
	{
		tc1=new Tc_001_carLoanTest();
		tc1.get_monthly_principal();
		tc1.get_monthly_interest();
	}
	

	@When("User is clicking home loan calculator")
	public void user_is_clicking_home_loan_calculator() 
	{
	    tc2 = new Tc_002_homeLoanTest();
	    tc2.verify_click_homeLoan_calculator();		
	    		
	}

	@When("User is filling home loan details")
	public void user_is_filling_home_loan_details() 
	{
		tc2 = new Tc_002_homeLoanTest();
	    tc2.verify_home_loan();
	}

	@When("user is storing home loan details for a year in excel")
	public void user_is_storing_home_loan_details_for_a_year_in_excel() throws InterruptedException 
	{
		tc2 = new Tc_002_homeLoanTest();
		tc2.verify_scroll_down();
	    tc2.write__table_headers();
	    tc2.write_table_data();
	}

	@When("User is clicking loan calculator")
	public void user_is_clicking_loan_calculator() 
	{
		tc3 = new Tc_003_loanTest();
		tc3.verify_click_menu();

	    
	}

	@Then("user is validating UI for text box & scales")
	public void user_is_validating_ui_for_text_box_scales() 
	{
		tc3 = new Tc_003_loanTest();
		tc3.verify_textbox_ui_emi();
		tc3.verify_scale_ui_emi();
	}

	@Then("user is changing the Loan tenure for year & month")
	public void user_is_changing_the_loan_tenure_for_year_month() 
	{
		tc3 = new Tc_003_loanTest();
	    tc3.verify_month_change_emi();
	}

	@When("User is clicking loan amount calculator")
	public void user_is_clicking_loan_amount_calculator() 
	{
		tc3 = new Tc_003_loanTest();
		tc3.verify_click_loanAmount();
	}

	@Then("user is validating UI for text box & scales for loan amount")
	public void user_is_validating_ui_for_text_box_scales_for_loan_amount() 
	{
		tc3 = new Tc_003_loanTest();
		tc3.verify_textbox_ui_loanamount();
		tc3.verify_scale_ui_loanamount();
	}

	@Then("user is changing the Loan tenure for year & month for loan amount")
	public void user_is_changing_the_loan_tenure_for_year_month_for_loan_amount() 
	{
		tc3 = new Tc_003_loanTest();
		tc3.verify_month_change_loanamount();
	}

	@When("User is clicking loan tenure calculator")
	public void user_is_clicking_loan_tenure_calculator() 
	{
		tc3 = new Tc_003_loanTest();
		tc3.verify_click_loanTenure();
	}

	@Then("user is validating UI for text box & scales for loan tenure")
	public void user_is_validating_ui_for_text_box_scales_for_loan_tenure() 
	{
		tc3 = new Tc_003_loanTest();
		tc3.verify_textbox_ui_loantenure();
		tc3.verify_scale_ui_loantenure();
	}

	


}
