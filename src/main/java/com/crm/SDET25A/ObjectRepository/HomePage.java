package com.crm.SDET25A.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends com.crm.SDET25.GenericUtils.WebDriverUtility{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='index.php?module=Products&action=index']")
	private WebElement productsLink;

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createProductIcon;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorImg;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorIMG;

	public WebElement getAdminstratorIMG() {
		return adminstratorIMG;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getCreateProductIcon() {
		return createProductIcon;
	}

	public WebElement getAdminstratorImg() {
		return adminstratorImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	public void signOut() {
		mouseHoverOnElement(driver, adminstratorIMG);
		signOutLink.click();
	}

	
  }
