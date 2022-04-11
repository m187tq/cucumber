package pages;


import helper.DropDown.DropDownHelper;
import helper.javaScript.JavaScriptHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductCategoryPage  extends BPage {

	/*private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(ProductCategoryPage.class);
	WaitHelper waitHelper;*/
	
	@FindBy(xpath="//*[@id='layered_block_left']/p")
	public WebElement catalogTextObj;
	
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[1]/h2")
	public WebElement productAddedSuccessfully;
	
	@FindBy(xpath="//body/main[@id='main-content']/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/article[1]/figure[1]/figcaption[1]/div[1]/a[1]")
	public WebElement addToCart;
	
	@FindBy(xpath="//a[contains(text(),'Check out')]")
	public WebElement proceedToCheckOut;
	
	@FindBy(xpath="//*[@id='center_column']/ul/li")
	List<WebElement> totalProducts;
	
	@FindBy(xpath="//*[@id='selectProductSort']")
	public WebElement sortBy;
	
	@FindBy(xpath="//*[@id='center_column']/ul/li/div/div[2]/div/span[1]")
	List<WebElement> allPriceElements;

	public ProductCategoryPage() throws IOException {
		super();
	}
	
	public void clickOnAddToCart(){
		System.out.println("clicking on add to cart");
		addToCart.click();
	}
	
	public void clickOnProceedTCheckOut(){
		System.out.println("clicking on :"+proceedToCheckOut.getText());
		proceedToCheckOut.click();
	}
	
	public void selectColor(String data){
		new JavaScriptHelper(driver).scrollIntoView(driver.findElement(By.xpath("//a[contains(text(),'"+data+"')]/parent::*/preceding-sibling::input[1]")));
		driver.findElement(By.xpath("//a[contains(text(),'"+data+"')]/parent::*/preceding-sibling::input[1]")).click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectSmallSize() {
		System.out.println("selecting small size..");
		driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_1']")).click();
	}

	public void selectMediumSize() {
		System.out.println("selecting Medium size..");
		try {
			boolean selected = driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_2']']")).isSelected();
			if (!selected) {
				driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_2']']")).click();
				System.out.println("checkbox is checked..");
			}
		} catch (Exception e) {
			System.out.println("checkbox was already checked..");
		}
	}

	public void selectLSize() {
		System.out.println("selecting Large size..");
		try {
			boolean selected = driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_3']")).isSelected();
			if (!selected) {
				driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_3']")).click();
				System.out.println("checkbox is checked..");
			}
		} catch (Exception e) {
			System.out.println("checkbox was already checked..");
		}
	}
	
	public void selectFirstProduct() {
		Actions obj = new Actions(driver);
		System.out.println("performing mouse over on first product of page..");
		System.out.println("performing mouse over on first product of page..");
		obj.moveToElement(totalProducts.get(0)).build().perform();
		System.out.println("clicking on add to basket..");
		System.out.println("clicking on add to basket..");
		addToCart.click();
	}
	
	public int getTotalProducts(){
		return totalProducts.size();
	}
	
	public List<WebElement> getAllProductsPrice(){
		return allPriceElements;
	}
	
	public void selectSortByFilter(String dataToSelect){
		DropDownHelper dropdown = new DropDownHelper(driver);
		dropdown.SelectUsingVisibleText(sortBy, dataToSelect);
	}
	
	public boolean verifyArrayHasAscendingData(ArrayList<Integer> array){
		for (int i = 0; i < array.size() - 1; i++) {
			// this condition will check all next price should be smaller than previous one.
			// next price can be grater and equal
			if (array.get(i) <= array.get(i + 1)) {
				System.out.println("obj.get(i).." + array.get(i));
				System.out.println("obj.get(i+1).." + array.get(i + 1));
			} else {
				System.out.println("price filter is not working");
				return false;
			}
		}
		return true;
	}
	
	public ArrayList<Integer> getPriceMassagedData(Iterator<WebElement> itr){
		ArrayList<Integer> array = new ArrayList<Integer>();
		while (itr.hasNext()) {
			String p = itr.next().getText();
			if (p.contains("$")) {
				String actualData = p.substring(1);
				System.out.println(actualData);
				double p1 = Double.parseDouble(actualData);
				int productPrice = (int) (p1);
				array.add(productPrice);
			}
		}
		return array;
	}
}
