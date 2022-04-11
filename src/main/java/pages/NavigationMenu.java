package pages;

import helper.common.action;
import helper.logger.LoggerHelper;
import helper.wait.WaitHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class NavigationMenu extends BPage {
	

	private final Logger log = LoggerHelper.getLogger(NavigationMenu.class);
	WaitHelper waitHelper;

	public NavigationMenu() throws IOException {
		super();
	}

	@FindBy(xpath = "//*[@id=\"menu\"]/nav/ul[1]")
	private List<WebElement> subMenuList;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[1]/a[1]")
	private WebElement gardenDropdownBtn;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[2]/a[1]")
	private WebElement shopAllBtn;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[3]/a[1]")
	private WebElement kitchenBtn;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[4]/a[1]")
	private WebElement publications;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[5]/a[1]")
	private WebElement utilityBtn;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[6]/a[1]")
	private WebElement journalBtn;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[7]/a[1]")
	private WebElement ourStoryBtn;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[8]/a[1]")
	private WebElement contactUsBtn;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[9]/a[1]")
	private WebElement shippingAndReturnBtn;


	public ProductCategoryPage clickOnMenu(WebElement element) throws IOException {
		log.info("clicking on : "+element.getText());
		action.click(driver, element);
		return new ProductCategoryPage();
	}
	public ProductCategoryPage clickOnItem(String data) throws IOException {
		log.info("clicking on :"+data);
		WebElement item = driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]"));
		action.click(driver, item);
		return new ProductCategoryPage();
	}

	public List<WebElement> getSubMenuList() {
		return subMenuList;
	}

	public void clickOnGardenDropdownBtn() {
		action.click(driver, gardenDropdownBtn);
	}

	public void clickOnShopAllBtn() {
		action.click(driver, shopAllBtn);
	}

	public void clickOnKitchenBtn() {
		action.click(driver, kitchenBtn);
	}

	public void clickOnPublications() {
		action.click(driver, publications);
	}

	public void clickOnUtilityBtn() {
		action.click(driver, utilityBtn);
	}

	public void clickOnJournalBtn() {
		action.click(driver, journalBtn);
	}

	public void clickOnOurStoryBtn() {
		action.click(driver, ourStoryBtn);
	}

	public void clickOnContactUsBtn() {
		action.click(driver, contactUsBtn);
	}

	public void clickOnShippingAndReturnBtn() {
		action.click(driver, shippingAndReturnBtn);
	}

}
