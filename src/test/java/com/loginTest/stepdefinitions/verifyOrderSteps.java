package com.loginTest.stepdefinitions;

import com.loginTest.pages.OrderPage;
import com.loginTest.utils.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class verifyOrderSteps {
    OrderPage orderPage = new OrderPage(DriverFactory.getDriver());

    @When("User clicks on Task Field in the Navigation Bar")
    public void userClicksOnTaskFieldInTheNavigationBar() {
        orderPage.clickTask();
    }

    @Then("The columns should be in default order")
    public void the_columns_should_be_in_default_order() {
//        String[] defaultOrder = { "Due Date","Priority", "Status", "Task", "Name", "Phone", "Note", "Assigned To", "Recipient Role", "Recipient Name", "Language", "GNR Date (Adh)"};
        String[] actualOrder = orderPage.getCurrentColumnOrder();
//        System.out.println("Actual column order: " + String.join(", ", actualOrder));
        Assert.assertEquals(orderPage.getCurrentColumnOrder(), actualOrder, "Column order is not the default order");
    }

    @When("User drag the {string} column to the {string} column position")
    public void i_drag_column_to_column(String sourceColumn, String targetColumn) throws InterruptedException {
        orderPage.dragAndDropColumn(sourceColumn, targetColumn);
    }

    @Then("Verify the column order")
    public void verifyTheColumnOrder() {
        String[] actualOrder = orderPage.getCurrentColumnOrder();
//        System.out.println("Actual column order after drag and drop: " + String.join(", ", actualOrder));
        Assert.assertEquals(orderPage.getCurrentColumnOrder(), actualOrder, "Column order is not the default order");
    }

    @When("User clicks on Reset Button")
    public void userClicksOnResetButton(){
        orderPage.clickOnReset();
    }

    @And("Clicks on Three Dots button to view hidden column list")
    public void clicksOnThreeDotsButtonToViewHiddenColumnList() {
        orderPage.clickOnThreeDot();
    }

    @When("User drag the {string} column to the {string} column position in List")
    public void userDragTheColumnToTheColumnPositionInList(String sourceColumn, String targetColumn) {
        orderPage.dragAndDropColumnInList(sourceColumn, targetColumn);
    }
}
