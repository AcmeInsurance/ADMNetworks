package com.ADMNetworks.Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.Assert;
import com.ADMNetworks.Utill.CustomMethod;
import com.ADMNetworks.Utill.ReadProperty;
import com.thoughtworks.selenium.Selenium;

public class RestaurantCombined {
	
	private WebDriver driver;
	CustomMethod custom  = new CustomMethod();
	ReadProperty readp = new ReadProperty();
	
	@DataProvider(name = "DP1")
	    public Object[][] createData() {
		  Object[][] retObjArr= custom.GetDataprovider();
		  return (retObjArr);
    }
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = custom.CreateObject(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();			
	}	
	@Test (dataProvider = "DP1")
	public void testRestaurantCombined(String Url) throws Exception {
		
		
		driver.get(Url);		
		Selenium selenium = new WebDriverBackedSelenium(driver, Url);
		driver.findElement(By.id("GetaQuote")).click();
		driver.findElement(By.linkText("Restaurant Combined")).click();
		Assert.assertTrue(selenium.isTextPresent("Get a quick quote"));
		Assert.assertTrue(selenium.isTextPresent("Agent details"));
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("click here to sign in")));
		Assert.assertTrue(custom.isElementPresent(driver, By.name("AgentRegistration")));
		Assert.assertTrue(selenium.isTextPresent("Restaurant Combined"));
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Click here to sign in to your agent user account.")));
		Assert.assertTrue(custom.isElementPresent(driver, By.id("ctl00_MainContent_lnkBack")));
		Assert.assertTrue(custom.isElementPresent(driver, By.id("ctl00_MainContent_btnNext")));
		driver.findElement(By.linkText("click here to sign in")).click();
		custom.waitForElementPresentid(driver, "Username",61);
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("I forgot my username or password")));
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Return to My Homepage")));
		custom.Login(driver, selenium, "Admin");
		custom.waitForElementPresentid(driver, "ctl00_MainContent_btnNext", 61);
		Thread.sleep(4000);
		Assert.assertTrue(selenium.isTextPresent("Get a quick quote"));
		Assert.assertTrue(selenium.isTextPresent("Agent details"));
		Assert.assertTrue(custom.isElementPresent(driver, By.name("SignOut")));
		Assert.assertTrue(selenium.isTextPresent("Restaurant Combined"));
		driver.findElement(By.id("ctl00_MainContent_btnNext")).click();
		Thread.sleep(3000);
		Assert.assertTrue(selenium.isTextPresent("Quotation Request"));
		Assert.assertEquals("", driver.findElement(By.name("QuestionPage_Back")).getText());
		Assert.assertEquals("", driver.findElement(By.name("QuestionPage_Next")).getText());
		Assert.assertTrue(custom.isElementPresent(driver, By.name("SubmitQuote")));
		Assert.assertTrue(selenium.isTextPresent("Declaration"));
		driver.findElement(By.cssSelector("#stub_page_Page1 > div.inner")).click();
		custom.waitForElementPresentid(driver, "OfficeReference", 51);
		Assert.assertTrue(selenium.isTextPresent("Address and Survey Details"));
		driver.findElement(By.id("OfficeReference")).clear();
		driver.findElement(By.id("OfficeReference")).sendKeys("NA");
		driver.findElement(By.id("PartnerName")).clear();
		driver.findElement(By.id("PartnerName")).sendKeys("Mr. Tester Jr");
		driver.findElement(By.id("HoldingBroker_Yes")).click();
		driver.findElement(By.id("TargetPremium")).clear();
		driver.findElement(By.id("TargetPremium")).sendKeys("500");
		driver.findElement(By.id("ConfirmEmail")).clear();
		driver.findElement(By.id("ConfirmEmail")).sendKeys("test360.5@gmail.com");
		driver.findElement(By.id("Address1")).clear();
		driver.findElement(By.id("Address1")).sendKeys("testing");
		driver.findElement(By.id("County")).clear();
		driver.findElement(By.id("County")).sendKeys("USA");
		driver.findElement(By.id("Postcode")).clear();
		driver.findElement(By.id("Postcode")).sendKeys("94404");
		custom.waitForElementPresentid(driver, "SurveyName", 51);
		Assert.assertTrue(selenium.isTextPresent("Survey Contact Details"));
		driver.findElement(By.id("SurveyName")).clear();
		driver.findElement(By.id("SurveyName")).sendKeys("Tester Sr");
		driver.findElement(By.id("SurveyPosition")).clear();
		driver.findElement(By.id("SurveyPosition")).sendKeys("NA");
		driver.findElement(By.cssSelector("#stub_page_Page4 > div.inner")).click();
		driver.findElement(By.id("ConstructionRbl_No")).click();
		driver.findElement(By.id("ConstructionRbl_Yes")).click();
		driver.findElement(By.id("FlatRoof_Yes")).click();
		driver.findElement(By.id("FlatRoof_No")).click();
		driver.findElement(By.id("CurrentDuration")).clear();
		driver.findElement(By.id("CurrentDuration")).sendKeys("2010");
		driver.findElement(By.id("ElsewhereDuration")).clear();
		driver.findElement(By.id("ElsewhereDuration")).sendKeys("2005");
		driver.findElement(By.id("ContInsuranceRbl_No")).click();
		driver.findElement(By.id("ContInsuranceRbl_Yes")).click();
		driver.findElement(By.cssSelector("#question_ContInsuranceRbl > label.radio")).click();
		driver.findElement(By.id("ContInsuranceRbl_No")).click();
		driver.findElement(By.id("ReasonNotCont")).clear();
		driver.findElement(By.id("ReasonNotCont")).sendKeys("Testing");
		driver.findElement(By.id("SeaFrontRbl_No")).click();
		driver.findElement(By.id("CliffTopRbl_No")).click();
		driver.findElement(By.id("RiverRbl_Yes")).click();
		driver.findElement(By.id("FloodRbl_No")).click();
		driver.findElement(By.id("BusinessHours")).clear();
		driver.findElement(By.id("BusinessHours")).sendKeys("9AM");
		driver.findElement(By.id("ResidentsRbl_No")).click();
		driver.findElement(By.id("ManagerDetails")).clear();
		driver.findElement(By.id("ManagerDetails")).sendKeys("Mr tester Jr");
		driver.findElement(By.id("AlarmRbl_Yes")).click();
		driver.findElement(By.cssSelector("#stub_page_Page7 > div.inner")).click();
		driver.findElement(By.id("AlarmInstall")).clear();
		driver.findElement(By.id("AlarmInstall")).sendKeys("Security Set");
		driver.findElement(By.id("InstallApproveRbl_No")).click();
		Thread.sleep(3000);
		selenium.select("id=SignallingType", "label=Digital Communicator");
		driver.findElement(By.id("PoliceResponseLevel_No")).click();
		driver.findElement(By.id("PResponseWithdrawn_No")).click();
		driver.findElement(By.name("PResponseWithdrawn_No")).clear();
		driver.findElement(By.name("PResponseWithdrawn_No")).sendKeys("test");
		driver.findElement(By.cssSelector("#stub_page_Page5 > div.inner")).click();
		driver.findElement(By.id("ClaimsHistory_No")).click();
		driver.findElement(By.cssSelector("#stub_page_PageCalculation > div.inner")).click();
		driver.findElement(By.id("BuildingsUpTo80")).clear();
		driver.findElement(By.id("BuildingsUpTo80")).sendKeys("110");
		driver.findElement(By.id("BuildingsOver20")).clear();
		driver.findElement(By.id("BuildingsOver20")).sendKeys("92");
		driver.findElement(By.id("TenantImprovements")).clear();
		driver.findElement(By.id("TenantImprovements")).sendKeys("15");
		driver.findElement(By.id("Outdoor")).clear();
		driver.findElement(By.id("Outdoor")).sendKeys("15");
		driver.findElement(By.id("SubsRequired_No")).click();
		driver.findElement(By.id("TerrorismRequired_No")).click();
		driver.findElement(By.id("OutbuildingContents")).clear();
		driver.findElement(By.id("OutbuildingContents")).sendKeys("35000");
		driver.findElement(By.id("StockInTrade")).clear();
		driver.findElement(By.id("StockInTrade")).sendKeys("100");
		driver.findElement(By.id("LiquerTobacco")).clear();
		driver.findElement(By.id("LiquerTobacco")).sendKeys("500");
		driver.findElement(By.id("BI_Required_No")).click();
		driver.findElement(By.id("GamingNumber")).clear();
		driver.findElement(By.id("GamingNumber")).sendKeys("5");
		driver.findElement(By.id("SafeMake")).clear();
		driver.findElement(By.id("SafeMake")).sendKeys("2009");
		driver.findElement(By.id("SafeModel")).clear();
		driver.findElement(By.id("SafeModel")).sendKeys("ACME");
		driver.findElement(By.id("EL_Required_No")).click();
		driver.findElement(By.id("PL_Required_No")).click();
		driver.findElement(By.id("TakeawaySales")).clear();
		driver.findElement(By.id("TakeawaySales")).sendKeys("45");
		driver.findElement(By.cssSelector("#stub_page_Page6 > div.inner")).click();
		driver.findElement(By.id("AdditionalNotes")).clear();
		driver.findElement(By.id("AdditionalNotes")).sendKeys("Not related to any third party broker.");
		selenium.click("document.forms[0].elements[527]");
		custom.waitForElementPresentid(driver, "ctl00_MainContent_Firstname", 51);
		Assert.assertTrue(selenium.isTextPresent("Client details"));
		selenium.select("id=ctl00_MainContent_UserTitle", "label=Mr");
		driver.findElement(By.id("ctl00_MainContent_Firstname")).clear();
		driver.findElement(By.id("ctl00_MainContent_Firstname")).sendKeys("Quality");
		driver.findElement(By.id("ctl00_MainContent_Surname")).clear();
		driver.findElement(By.id("ctl00_MainContent_Surname")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_Address_txtAddress1")).clear();
		driver.findElement(By.id("ctl00_MainContent_Address_txtAddress1")).sendKeys("123 main road, 3rd floor");
		driver.findElement(By.id("ctl00_MainContent_Address_txtTown")).clear();
		driver.findElement(By.id("ctl00_MainContent_Address_txtTown")).sendKeys("Foster City");
		driver.findElement(By.id("ctl00_MainContent_Address_txtCounty")).clear();
		driver.findElement(By.id("ctl00_MainContent_Address_txtCounty")).sendKeys("USA");
		driver.findElement(By.id("ctl00_MainContent_Address_txtPostcode")).clear();
		driver.findElement(By.id("ctl00_MainContent_Address_txtPostcode")).sendKeys("94404");
		driver.findElement(By.id("Next")).click();
		Thread.sleep(3000);
		Assert.assertTrue(selenium.isTextPresent("Your quote has been referred"));
		Assert.assertTrue(custom.isElementPresent(driver, By.id("ctl00_MainContent_btnViewAccount")));
		String CaseID = driver.findElement(By.cssSelector("span.policy_reference")).getText();
		System.out.println(CaseID);
		Assert.assertTrue(selenium.isTextPresent("exact:IMPORTANT: Your referral reference is " + CaseID));
		driver.findElement(By.id("ctl00_MainContent_btnViewAccount")).click();
		custom.waitForElementPresent(driver, "img[alt=\"Re-Quote\"]", 51);
		//driver.findElement(By.linkText("Endorsements")).click();
		Assert.assertTrue(selenium.isTextPresent("Viewing Summary for " + CaseID));
		Assert.assertTrue(selenium.isTextPresent("First Premium"));		
		Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img[alt=\"Re-Quote\"]")));
		driver.findElement(By.linkText("Endorsements")).click();
		driver.findElement(By.linkText("Add a new Conditions question")).click();
		custom.waitForElementPresentid(driver, "Question.Text", 61);
		
		driver.findElement(By.id("Question.Text")).clear();
		driver.findElement(By.id("Question.Text")).sendKeys("New Condition");
		driver.findElement(By.id("Question.Save")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Add a new Memorandum question")).click();
		driver.findElement(By.id("Question.Text")).clear();
		driver.findElement(By.id("Question.Text")).sendKeys("New Momo");
		custom.waitForElementPresentid(driver, "Question.DefaultValue", 61);
		driver.findElement(By.id("Question.DefaultValue")).clear();		
		driver.findElement(By.id("Question.DefaultValue")).sendKeys("Testing");
		driver.findElement(By.id("Question.Save")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Matrix")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Documents")).click();
		custom.waitForElementPresent(driver, "img.hand", 51);
		driver.findElement(By.cssSelector("img.hand")).click();
		custom.waitForElementPresentname(driver, "NewDocumentType", 51);
		Assert.assertTrue(custom.isElementPresent(driver, By.id("add_file_link")));
		Assert.assertTrue(selenium.isTextPresent("Create a new document"));
		Thread.sleep(2000);
		selenium.select("name=NewDocumentType", "label=Quotation Request - Restaurant Combined");
		driver.findElement(By.id("ctl00_ctl00_MainContent_Grey_PolicyContent_btnSave")).click();
		driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td/div[2]/div/div[9]/div/a")).click();
		custom.waitForElementPresentid(driver, "ctl00_ctl00_MainContent_Grey_PolicyContent_imgCreateNew", 51);
		driver.findElement(By.id("ctl00_ctl00_MainContent_Grey_PolicyContent_imgCreateNew")).click();
		custom.waitForElementPresentname(driver, "ctl00_ctl00_MainContent_Grey_PolicyContent_imgBack", 51);
		Assert.assertTrue(selenium.isTextPresent("Create a new claim for Policy 182287"));
		Assert.assertTrue(custom.isElementPresent(driver, By.id("ctl00_ctl00_MainContent_Grey_PolicyContent_imgBack")));
		Assert.assertTrue(custom.isElementPresent(driver, By.id("ctl00_ctl00_MainContent_Grey_PolicyContent_imgPrint")));
		driver.findElement(By.id("ctl00_ctl00_MainContent_Grey_PolicyContent_imgBack")).click();
		driver.findElement(By.linkText("Notes")).click();
		
		custom.waitForElementPresentid(driver, "ctl00_ctl00_MainContent_Grey_PolicyContent_Img1", 61);
		//Assert.assertTrue(custom.isElementPresent(driver, By.id("ctl00_ctl00_MainContent_Grey_PolicyContent_Img1")));
		driver.findElement(By.linkText("Money")).click();
		custom.waitForElementPresentid(driver, "ctl00_ctl00_MainContent_Grey_PolicyContent_ExportCSVLink", 61);
		Assert.assertTrue(selenium.isTextPresent("Transactions"));
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Take Card Payment")));
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Record Cheque")));
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Record Bank Payment")));
		Assert.assertTrue(custom.isElementPresent(driver, By.id("ctl00_ctl00_MainContent_Grey_PolicyContent_ExportCSVLink")));
		driver.findElement(By.linkText("Activity")).click();
		Thread.sleep(2000);
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("My Homepage")));
		Assert.assertTrue(custom.isElementPresent(driver, By.id("ctl00_ctl00_navtop_miniBar_A1")));
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("My Profile")));
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("My Company")));
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Logout")));
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("HELP GUIDE")));
		driver.findElement(By.linkText("Logout")).click();
	}
	}


