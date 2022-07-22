package test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browserSetting.Base;
import compareData.com.pageObjects.IMDBPageRepository;
import compareData.com.pageObjects.WikipediaPageObjects;

public class TestCases extends Base {
	WikipediaPageObjects wikipediaPageObjects;
	IMDBPageRepository imdbPageRepository;
	String countryOnIMDB;
	String countryOnWiki;
	String releaseDateOnIMDB;
	String releaseDateOnWiki;
	
	@BeforeClass
	public void openUrl(){
		setupBrowser("chrome");
		driver.get("https://www.imdb.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		imdbPageRepository=new IMDBPageRepository(driver);
		imdbPageRepository.searchForMovie();
		imdbPageRepository.clickOnSearchButton();
		imdbPageRepository.selectTheMovie();
		releaseDateOnIMDB= imdbPageRepository.getReleaseDate();
		countryOnIMDB= imdbPageRepository.getCountryOfOrigin();
		
		driver.navigate().to("https://en.wikipedia.org/wiki/Main_Page");
		 wikipediaPageObjects=new WikipediaPageObjects(driver);
		wikipediaPageObjects.searchForMovieOnWiki();
		wikipediaPageObjects.clickOnSearchButton();
		releaseDateOnWiki= wikipediaPageObjects.getReleaseDate();
		countryOnWiki =wikipediaPageObjects.getCountryOfOrigin();
	}
	@Test
	public void compareReleaseDate() {

		System.out.println(releaseDateOnIMDB);
		System.out.println(releaseDateOnWiki);
		Assert.assertEquals(releaseDateOnIMDB, releaseDateOnWiki);
	}
	
	@Test 
	public void compareCountry() {
		System.out.println(countryOnIMDB);
		System.out.println(countryOnWiki);
		Assert.assertEquals(countryOnIMDB, countryOnWiki);
	}
	
//	@AfterMethod
//	public void clearObjects() {
//		imdbPageRepository=null;
//		wikipediaPageObjects=null;
//	}
	@AfterClass
	public void closeBrowser() {
	driver.close();
	}

}
