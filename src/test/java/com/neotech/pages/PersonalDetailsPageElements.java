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

	@FindBy(xpath = "//div[@id='nation_code_inputfileddiv']/div/input")
	public WebElement nationalityInput;

	@FindBy(xpath = "//div[@id='nation_code_inputfileddiv']/div/ul/li")
	public List<WebElement> nationalityOptions;

	@FindBy(xpath = "//input[@id='emp_dri_lice_exp_date']/following-sibling::span[1]//i")
	public WebElement licExpDate;

	@FindBy(xpath = "//input[@id='emp_dri_lice_exp_date']/following-sibling::span[1]//div[@class='select-wrapper picker__select--year']/input")
	public WebElement licExpYearInput;

	@FindBy(xpath = "//input[@id='emp_dri_lice_exp_date']/following-sibling::span[1]//div[@class='select-wrapper picker__select--year']/ul/li")
	public List<WebElement> licExpYearOptions;

	@FindBy(xpath = "//input[@id='emp_dri_lice_exp_date']/following-sibling::span[1]//div[@class='select-wrapper picker__select--month']/input")
	public WebElement licExpMonthInput;

	@FindBy(xpath = "//input[@id='emp_dri_lice_exp_date']/following-sibling::span[1]//div[@class='select-wrapper picker__select--month']/ul/li")
	public List<WebElement> licExpMonthOptions;

	@FindBy(xpath = "//input[@id='emp_dri_lice_exp_date']/following-sibling::span[1]//table/tbody/tr/td")
	public List<WebElement> licExpDays;

	@FindBy(xpath = "//form[@id='pimPersonalDetailsForm']//button[@type='submit']")
	public WebElement detailsBtnSave;

	public PersonalDetailsPageElements() {
		PageFactory.initElements(driver, this);
	}
}
