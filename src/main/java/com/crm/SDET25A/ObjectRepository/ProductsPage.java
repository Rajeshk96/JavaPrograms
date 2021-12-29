package com.crm.SDET25A.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);    
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createProductIcon;

	@FindBy(name="productname")
	private WebElement productNameText;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//a[@href='index.php?module=Products&action=index']")
	private WebElement productsLink;
	
	public WebElement getCreateProductIcon() {
		return createProductIcon;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getProductNameText() {
		return productNameText;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void productPageInfo(String value) {
		
		productsLink.click();
		createProductIcon.click();
		productNameText.sendKeys(value);
		saveBtn.click();
		
	}
	
}
