package TestCases;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import PageObjects.HomeLoanPage;
import TestBase.BaseClass;
import Utilities.ExcelUtility;

public class Tc_002_homeLoanTest extends BaseClass 
{
	HomeLoanPage hp;
	
	@Test(priority=6)
	public void verify_click_homeLoan_calculator()
	{
		hp=new HomeLoanPage(driver);
		hp.click_claculator();
		hp.click_homeloan();
	}
	
	@Test(priority=7)
	public void verify_home_loan()
	{
		hp=new HomeLoanPage(driver);
		logger.info("------FILLING THE HOME LOAN DETAILS ------");
		hp.fill_details();
		
	}
	

	@Test(priority=8)
	public void verify_scroll_down()
	{
		hp=new HomeLoanPage(driver);
		hp.scroll_down();
		
	}
	
	@Test(priority=9)
	public void write__table_headers() throws InterruptedException
	{
		hp=new HomeLoanPage(driver);
		
		List<WebElement> list_headers = hp.get_table_headers();
        logger.info("------STORING YEARLY DATA INTO EXCEL ------");
		int col=0;
		String heading="";
		for(WebElement e: list_headers)
		{
			heading=e.getText();
			
			try 
			{
				//System.out.println(heading);
				ExcelUtility.write("Sheet1",0,0,"------Year wise Data------");
				ExcelUtility.write("Sheet1",1,col,heading);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			col++;
		}
		
	}
	
	@Test(priority=10)
	public void write_table_data()
	{
		hp=new HomeLoanPage(driver);
		List<List<WebElement>> all_list = hp.get_table_data();
		int col=0;
		for(List<WebElement> l1 : all_list) 
		{
			int row=2;
			
			String data="";
			for(WebElement e: l1 )
			{
				data=e.getText();
				
				try 
				{
					//System.out.println(data);
					ExcelUtility.write("Sheet1",row,col,data);
				} catch (IOException e1) 
				{
					e1.printStackTrace();
				}
				
				row++;
			}
			col++;
		  }
	}



}
