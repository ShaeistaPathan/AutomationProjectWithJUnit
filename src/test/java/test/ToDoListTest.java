package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Pages.ToDoListPage;
import util.BrowserFactory;

public class ToDoListTest {

	WebDriver driver;
	ToDoListPage toDoListPageObj;
	
	@Before
	public void setUp() {
		driver = BrowserFactory.inIt();
	}
	
	@Test
	public void validateToggleAllCheckboxWithListItemsCheckbox() {
	    toDoListPageObj = PageFactory.initElements(driver, ToDoListPage.class);
	    toDoListPageObj.addThreeListItems();
		toDoListPageObj.checkToggleAllCheckbox();
		toDoListPageObj.validateToggleAllWithListCheckboxes();
	
		toDoListPageObj.clickRemoveButton();
	}
	
	@Test
	public void validateSingleItemRemovalWithSingleCheckboxAndRemoveButton() {
		toDoListPageObj = PageFactory.initElements(driver, ToDoListPage.class);
		toDoListPageObj.addThreeListItems();
		toDoListPageObj.DeleteFirstItemWithSingleCheckboxAndRemoveButton();
		toDoListPageObj.validateDeleteFirstItemWithSingleCheckboxAndRemoveButton();
		toDoListPageObj.validateSecondAndThirdListItemIsPresent();
	}
	
	@Test
	public void ValidateDeleteAllListItemsWithRemoveButtonAndToggleAllOn() {
		toDoListPageObj = PageFactory.initElements(driver, ToDoListPage.class);
		toDoListPageObj.addThreeListItems();
		toDoListPageObj.checkToggleAllCheckbox();
		toDoListPageObj.clickRemoveButton();
		toDoListPageObj.validateDeleteFirstItemWithSingleCheckboxAndRemoveButton();
		toDoListPageObj.validateDeleteSecondItemWithSingleCheckboxAndRemoveButton();
		toDoListPageObj.validateDeleteThirdItemWithSingleCheckboxAndRemoveButton();
		
	}
	
	@After
	public void closeBrowser() {
		BrowserFactory.tearDown();
	}
	
	
	
	
}
