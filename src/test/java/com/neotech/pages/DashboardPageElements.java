package com.neotech.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods {

	@FindBy(xpath = "//span[@id='account-name']")
	public WebElement accountName;

	@FindBy(id = "menu_pim_viewPimModule")
	public WebElement PIM;

	@FindBy(linkText = "Employee List")
	public WebElement employeeListLink;

	@FindBy(linkText = "Add Employee")
	public WebElement addEmployeeLink;

	@FindBy(id = "account-job")
	public WebElement accountMenu;

	@FindBy(id = "logoutLink")
	public WebElement logout;
	
	@FindBy(xpath="//div[@id = 'menu-content']/ul/li")
	public List<WebElement> menuList;
	
	
	@FindBy(xpath="//li[@id='menu_news_More']/a")
	public WebElement moreMenuItem;
	
	

	public DashboardPageElements() {
		PageFactory.initElements(driver, this);
	}
}
