package com.ADMNetworks.Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.testng.annotations.*;
import org.testng.Assert;
import com.ADMNetworks.Utill.CustomMethod;
import com.ADMNetworks.Utill.ReadProperty;
import com.thoughtworks.selenium.Selenium;

public class UnoccupiedPropertyOwners {
	
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
		driver.findElement(By.linkText("Unoccupied Property Owners")).click();
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("click here to sign in")));
		Assert.assertTrue(custom.isElementPresent(driver, By.name("AgentRegistration")));
		Assert.assertTrue(selenium.isTextPresent("Search for existing client (optional)"));
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Click here to sign in to your agent user account.")));
		Assert.assertTrue(custom.isElementPresent(driver, By.id("ctl00_MainContent_lnkBack")));
		Assert.assertTrue(custom.isElementPresent(driver, By.id("ctl00_MainContent_btnNext")));
		driver.findElement(By.linkText("click here to sign in")).click();
		custom.waitForElementPresentid(driver, "Username",61);
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("I forgot my username or password")));
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Return to My Homepage")));
		custom.Login(driver, selenium, "Admin");
		custom.waitForElementPresentid(driver, "ctl00_MainContent_btnNext", 61);
		Thread.sleep(2000);
		Assert.assertTrue(selenium.isTextPresent("Get a quick quote"));
		Assert.assertTrue(selenium.isTextPresent("Agent details"));
		Assert.assertTrue(custom.isElementPresent(driver, By.name("SignOut")));		
		driver.findElement(By.id("ctl00_MainContent_btnNext")).click();
		Thread.sleep(2000);
		custom.waitForElementPresentname(driver, "SubmitQuote", 61);
		Assert.assertTrue(selenium.isTextPresent("Quotation Request"));
		Assert.assertTrue(custom.isElementPresent(driver, By.name("QuestionPage_Back")));
		Assert.assertTrue(custom.isElementPresent(driver, By.name("QuestionPage_Next")));
		Assert.assertTrue(custom.isElementPresent(driver, By.name("SubmitQuote")));
		Assert.assertTrue(selenium.isTextPresent("General Declaration"));
		driver.findElement(By.cssSelector("#stub_page_Page1 > div.inner")).click();
		Thread.sleep(2000);
		custom.waitForElementPresentid(driver, "OfficeReference", 61);
		driver.findElement(By.id("OfficeReference")).clear();
		driver.findElement(By.id("OfficeReference")).sendKeys("Test QA");
		driver.findElement(By.id("PartnerName")).clear();
		driver.findElement(By.id("PartnerName")).sendKeys("Mr. Tester Sr");
		driver.findElement(By.id("Address1")).clear();
		driver.findElement(By.id("Address1")).sendKeys("HN. 242");
		driver.findElement(By.id("Address2")).clear();
		driver.findElement(By.id("Address2")).sendKeys("Foster City, CA");
		driver.findElement(By.id("County")).clear();
		driver.findElement(By.id("County")).sendKeys("USA");
		driver.findElement(By.id("Postcode")).clear();
		driver.findElement(By.id("Postcode")).sendKeys("94404");
		driver.findElement(By.id("SurveyName")).clear();
		driver.findElement(By.id("SurveyName")).sendKeys("QA");
		driver.findElement(By.id("Third_Party_YesNo_No")).click();
		custom.waitForElementPresent(driver, "#stub_page_Page4 > div.inner", 61);
		driver.findElement(By.cssSelector("#stub_page_Page4 > div.inner")).click();
		Thread.sleep(2000);
		Assert.assertTrue(selenium.isTextPresent("General Questions"));
		driver.findElement(By.id("CoverAllRisks_Yes")).click();
		driver.findElement(By.id("ConstructionRbl_Yes")).click();
		driver.findElement(By.id("FlatRoof_No")).click();
		driver.findElement(By.id("OccupierRbl_No")).click();
		driver.findElement(By.id("HowLongInterest")).clear();
		driver.findElement(By.id("HowLongInterest")).sendKeys("2010/November");
		driver.findElement(By.id("ContInsuranceRbl_Yes")).click();
		driver.findElement(By.id("InsurerDetails")).clear();
		driver.findElement(By.id("InsurerDetails")).sendKeys("AVIVA");
		driver.findElement(By.id("SeaFrontRbl_No")).click();
		driver.findElement(By.id("CliffTopRbl_No")).click();
		driver.findElement(By.id("RiverRbl_Yes")).click();
		driver.findElement(By.id("FloodRbl_No")).click();
		driver.findElement(By.id("BuiltDetails")).clear();
		driver.findElement(By.id("BuiltDetails")).sendKeys("2008");
		driver.findElement(By.id("GradeListed_Yes")).click();
		driver.findElement(By.id("GradeListed_No")).click();
		driver.findElement(By.id("DoorWindowLocks_Yes")).click();
		driver.findElement(By.id("ShuttersGrilles_No")).click();
		driver.findElement(By.id("WindowsBarred_Yes")).click();
		driver.findElement(By.id("LetterBoxFlaps_Yes")).click();
		driver.findElement(By.id("ServicesDisconnected_Yes")).click();
		driver.findElement(By.id("ElectCert_No")).click();
		driver.findElement(By.id("WaterIsolated_Yes")).click();
		driver.findElement(By.id("Inspected_No")).click();
		driver.findElement(By.id("CombustibleREmoval_Yes")).click();
		driver.findElement(By.id("Smoke__Detectors_Yes")).click();
		driver.findElement(By.id("Sprinklers_Yes")).click();
		driver.findElement(By.id("Reside_No")).click();
		driver.findElement(By.id("Caretaker_Yes")).click();
		driver.findElement(By.id("CCTV_No")).click();
		driver.findElement(By.id("AdjacentPropertyOccupied_Yes")).click();
		driver.findElement(By.id("Adjacent__PropertyPartOccupied_Yes")).click();
		driver.findElement(By.id("AdjacentPropertyUnoccupied_No")).click();
		driver.findElement(By.id("HowLongUnoccupiedDetails")).clear();
		driver.findElement(By.id("HowLongUnoccupiedDetails")).sendKeys("2010/March");
		driver.findElement(By.id("PlanningConsent_Yes")).click();
		driver.findElement(By.id("AlarmRbl_Yes")).click();
		driver.findElement(By.cssSelector("#stub_page_Page7 > div.inner")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("AlarmInstall")).clear();
		driver.findElement(By.id("AlarmInstall")).sendKeys("Security Set");
		driver.findElement(By.id("InstallApproveRbl_Yes")).click();
		selenium.select("id=SignallingType", "label=Digital Communicator");
		driver.findElement(By.id("PoliceResponseLevel_Yes")).click();
		driver.findElement(By.cssSelector("#stub_page_Page5 > div.inner")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ClaimsHistory_No")).click();
		driver.findElement(By.cssSelector("#stub_page_PageCalculation > div.inner")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("SubsRequired_Yes")).click();
		driver.findElement(By.id("Subsidence")).clear();
		driver.findElement(By.id("Subsidence")).sendKeys("500");
		driver.findElement(By.id("MachineryPlant")).clear();
		driver.findElement(By.id("MachineryPlant")).sendKeys("120");
		driver.findElement(By.id("EL_Required_No")).click();
		driver.findElement(By.id("PL_Required_No")).click();
		driver.findElement(By.id("ADGlass")).clear();
		driver.findElement(By.id("ADGlass")).sendKeys("200");
		driver.findElement(By.cssSelector("#stub_page_Page6 > div.inner")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("AdditionalNotes")).clear();
		driver.findElement(By.id("AdditionalNotes")).sendKeys("Not Having Additional notes yet");
		selenium.click("document.forms[0].elements[560]");
		custom.waitForElementPresentid(driver, "ctl00_MainContent_Firstname", 51);
		Assert.assertTrue(selenium.isTextPresent("Client details"));
		selenium.select("id=ctl00_MainContent_UserTitle", "label=Mr");
		driver.findElement(By.id("ctl00_MainContent_Firstname")).clear();
		driver.findElement(By.id("ctl00_MainContent_Firstname")).sendKeys("tester");
		driver.findElement(By.id("ctl00_MainContent_Surname")).clear();
		driver.findElement(By.id("ctl00_MainContent_Surname")).sendKeys("Jr");
		driver.findElement(By.id("Next")).click();
		Assert.assertTrue(selenium.isTextPresent("Quotation request received"));
		String CaseID = driver.findElement(By.cssSelector("span.policy_reference")).getText();
		System.out.println(CaseID);
		Assert.assertTrue(selenium.isTextPresent("exact:IMPORTANT: Your quotation reference is " + CaseID));
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("contact us")));
		custom.waitForElementPresentid(driver, "ctl00_MainContent_btnViewAccount", 51);
		driver.findElement(By.id("ctl00_MainContent_btnViewAccount")).click();
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("My Homepage")));
		Assert.assertTrue(custom.isElementPresent(driver, By.id("ctl00_ctl00_navtop_miniBar_A1")));
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("My Profile")));
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("My Company")));
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("Logout")));
		Assert.assertTrue(custom.isElementPresent(driver, By.linkText("HELP GUIDE")));
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
		custom.waitForElementPresentlink(driver, "Add a new Survey question", 51);
		driver.findElement(By.linkText("Add a new Survey question")).click();
		custom.waitForElementPresentid(driver, "LibrarySearch", 51);
		driver.findElement(By.id("Question.Text")).clear();
		driver.findElement(By.id("Question.Text")).sendKeys("Test Survey");
		driver.findElement(By.id("Question.Save")).click();
		custom.waitForElementPresentlink(driver, "Add a new Flood question", 51);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Add a new Flood question")).click();
		custom.waitForElementPresentid(driver, "Question.Text", 51);
		driver.findElement(By.id("Question.Text")).clear();
		driver.findElement(By.id("Question.Text")).sendKeys("Flood Item");
		driver.findElement(By.id("Question.Save")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Add a new Subsidence question")).click();
		custom.waitForElementPresentid(driver, "Question.Text", 51);
		driver.findElement(By.id("Question.Text")).clear();
		driver.findElement(By.id("Question.Text")).sendKeys("New Subsidence Item");
		driver.findElement(By.id("Question.Save")).click();
		driver.findElement(By.cssSelector("img.ViewPolicy_Save")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Matrix")).click();
		custom.waitForElementPresentid(driver, "ctl00_ctl00_MainContent_Grey_PolicyContent_PageButtonsTop_btnSnapshot", 51);
		Assert.assertTrue(custom.isElementPresent(driver, By.cssSelector("img.ViewPolicy_Save")));
		driver.findElement(By.linkText("Documents")).click();
		driver.findElement(By.cssSelector("img.hand")).click();
		custom.waitForElementPresentname(driver, "NewDocumentType", 51);
		Assert.assertTrue(custom.isElementPresent(driver, By.id("add_file_link")));
		selenium.select("name=NewDocumentType", "label=Renewal Invoice Payable");
		driver.findElement(By.id("ctl00_ctl00_MainContent_Grey_PolicyContent_btnSave")).click();
		driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td/div[2]/div/div[9]/div/a")).click();
		driver.findElement(By.linkText("Notes")).click();
		Thread.sleep(3000);
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
