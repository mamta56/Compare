package compareData.com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaPageObjects {
	@FindBy(id="searchInput")
	private WebElement txt_searchBox;
	
	@FindBy(id="searchButton")
	private WebElement btn_searchButton;
	
	@FindBy(xpath="(//table[@class='infobox vevent']//tr)[12]//li")
	private WebElement element_releaseDate;
	
	@FindBy(xpath="(//table[@class='infobox vevent']//tr)[14]//td")
	private WebElement element_countryofOrigin;
	
	public WikipediaPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void searchForMovieOnWiki() {
		 txt_searchBox.sendKeys("pushpa");
	}
	public void clickOnSearchButton() {
		btn_searchButton.click();
	}
	public String getReleaseDate() {
		return element_releaseDate.getText();
	}
	public String getCountryOfOrigin() {
		return element_countryofOrigin.getText();
	}
	

}
