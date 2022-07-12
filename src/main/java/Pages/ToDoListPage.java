package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import org.junit.Assert;

public class ToDoListPage {


	WebDriver driver;
	
	public ToDoListPage (WebDriver driver) {
		this.driver = driver;
	}	
	    @FindBy(how= How.NAME,using="data") WebElement ListFieldElement;
	    @FindBy(how= How.CSS,using="input[value='Add']") WebElement AddButtonElement;
		@FindBy(how= How.NAME,using="allbox") WebElement ToggleAllCheckboxElement;
		@FindBy(how= How.NAME,using="todo[0]") WebElement FirstListCheckboxElement;
		@FindBy(how= How.NAME,using="todo[1]") WebElement SecondListCheckboxElement;
		@FindBy(how= How.NAME,using="todo[2]") WebElement ThirdListCheckboxElement;
		@FindBy(how= How.CSS,using="input[value='Remove']") WebElement RemoveButtonElement;
	    
		public void addOneListItem() {
			ListFieldElement.sendKeys("Study");
			AddButtonElement.click();
		}
		public void addThreeListItems() {
			ListFieldElement.sendKeys("Study");
			AddButtonElement.click();
			ListFieldElement.sendKeys("Homework");
			AddButtonElement.click();
			ListFieldElement.sendKeys("Dinner");
			AddButtonElement.click();
			
		}
		
		public void clickRemoveButton() {
			RemoveButtonElement.click();
		}
		public void checkToggleAllCheckbox() {
			ToggleAllCheckboxElement.click();
		}

        public void validateToggleAllWithListCheckboxes() {
        	Assert.assertEquals(ToggleAllCheckboxElement.isSelected(),FirstListCheckboxElement.isSelected()&&SecondListCheckboxElement.isSelected()&&ThirdListCheckboxElement.isSelected());
        }
        
        public void DeleteFirstItemWithSingleCheckboxAndRemoveButton() {
        	FirstListCheckboxElement.click();
        	RemoveButtonElement.click();   
        }
        
        public void validateDeleteFirstItemWithSingleCheckboxAndRemoveButton() {
        	try {
        		FirstListCheckboxElement.isDisplayed();
        		System.out.println("First list item is present.");
        	}catch(NoSuchElementException e) {
        		System.out.println("First list item is deleted.");
        	}
        }
        
        public void validateSecondAndThirdListItemIsPresent() {
        	Assert.assertTrue(SecondListCheckboxElement.isDisplayed()&&ThirdListCheckboxElement.isDisplayed());
        }
        
        

         public void validateDeleteSecondItemWithSingleCheckboxAndRemoveButton() {
             	try {
            		SecondListCheckboxElement.isDisplayed();
            		System.out.println("Second list item is present.");
            	}catch(NoSuchElementException e) {
            		System.out.println("Second list item is deleted.");
            	}
         }
          public void validateDeleteThirdItemWithSingleCheckboxAndRemoveButton() {
               	try {
                		ThirdListCheckboxElement.isDisplayed();
                		System.out.println("Third list item is present.");
                	}catch(NoSuchElementException e) {
                		System.out.println("Third list item is deleted.");
                	}
        }
         
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
}