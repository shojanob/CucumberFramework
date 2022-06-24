package com.neotech.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utils.CommonMethods;

public class PersonalDetailsPageElements extends CommonMethods {

	@FindBy(id = "pimPersonalDetailsForm")
	public WebElement personalDetailsForm;

	@FindBy(id = "employeeId")
	public WebElement employeeId;

	@FindBy(id = "pim.navbar.employeeName")
	public WebElement employeeName;

	@FindBy(id = "licenseNo")
	public WebElement driverLicense;

	@FindBy(xpath = "//label[text()='Smoker']")
	public WebElement smokerBox;

	@FindBy(xpath = "//div[@id='emp_gender_inputfileddiv']/div/input")
	public WebElement genderInput;

	@FindBy(xpath = "//div[@id='emp_gender_inputfileddiv']/div/ul/li")
	public List<WebElement> genderOptions;

	public PersonalDetailsPageElements() {
		PageFactory.initElements(driver, this);
	}
}
