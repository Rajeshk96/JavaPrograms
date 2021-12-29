package com.crm.SDET25A.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	
	public ProductInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dtlview_Product Name")
	private WebElement editProductNameTxtBox;

	@FindBy(id="dtlview_Part Number")
	private WebElement editPartNumberTxtBox;

	public WebElement getEditPartNumberTxtBox() {
		return editPartNumberTxtBox;
	}
	
	public WebElement getEditProductNameTxtBox() {
		return editProductNameTxtBox;
	}
	
}
