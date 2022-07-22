package compareData.com.pageObjects;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utiity;

public class IMDBPageRepository {
	@FindBy(id="suggestion-search")
	private WebElement txt_searchBox;
	
	@FindBy(id="suggestion-search-button")
	private WebElement btn_searchButton;
	
	@FindBy(xpath="//a[text()='Pushpa: The Rise - Part 1']")
	private WebElement title_element;
	
	@FindBy(xpath="(//div[@data-testid='title-details-section']//div)[1]//a")
	private WebElement releaseDate_element;
	
	@FindBy(xpath="(//div[@data-testid='title-details-section']//div)[2]//a")
	private WebElement countryOfOrigin_element;
	
	public IMDBPageRepository(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void searchForMovie() {
		txt_searchBox.sendKeys("pushpa");
	}
	public void clickOnSearchButton() {
		btn_searchButton.click();
	}
	public void selectTheMovie() {
		title_element.click();
	}
	public String  getReleaseDate() {
		return releaseDate_element.getText();
	}
	public String getCountryOfOrigin() {
		return countryOfOrigin_element.getText();
	}

}
