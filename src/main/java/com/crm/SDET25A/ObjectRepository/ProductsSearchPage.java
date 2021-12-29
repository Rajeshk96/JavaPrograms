package com.crm.SDET25A.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.SDET25.GenericUtils.WebDriverUtility;

public class ProductsSearchPage {
	
	WebDriver driver;
	public ProductsSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//select[@name='search_field' and @id='bas_searchfield'])[1]")
	private WebElement inDropdown;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchForTxt;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchNowBtn;
	
	@FindBy(xpath="//a[@href='index.php?module=Products&action=index']")
	private WebElement productsLink;

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getInDropdown() {
		return inDropdown;
	}

	public WebElement getSearchForTxt() {
		return searchForTxt;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	public void productSearchInfo(String visible) {
	
		productsLink.click();
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.select(inDropdown, visible);
		
	}

}
