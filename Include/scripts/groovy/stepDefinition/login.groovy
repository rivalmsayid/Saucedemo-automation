package stepDefinition
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class login {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("user is already on the login page")
	public void user_is_already_on_the_login_page() {
		WebUI.openBrowser('https://saucedemo.com')
		WebUI.maximizeWindow()
		WebUI.verifyElementPresent(findTestObject('Object Repository/Login Page/Swag Labs'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Login Page/input_username'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Login Page/input_password'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Login Page/button_login'), 0)
	}

	@When("user input username password and click login button")
	public void user_input_username_password_and_click_login_button() {
		WebUI.setText(findTestObject('Object Repository/Login Page/input_username'), 'standard_user')
		WebUI.setText(findTestObject('Object Repository/Login Page/input_password'), 'secret_sauce')
		WebUI.click(findTestObject('Object Repository/Login Page/button_login'),)
	}

	@Then("user can successfully login")
	public void user_can_successfully_login() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Katalog Page/img_sauce_labs_backpack'), 0)
	}

	@When("user input (.*) in login page")
	public void user_input_in_login_page(String condition) {

		if(condition=="valid email and ivalid password") {
			WebUI.setText(findTestObject('Object Repository/Login Page/input_username'), 'aaaa')
			WebUI.setText(findTestObject('Object Repository/Login Page/input_password'), 'aaaa')
		}else if(condition=="invalid email and valid password") {
			WebUI.setText(findTestObject('Object Repository/Login Page/input_username'), 'rival_ms')
			WebUI.setText(findTestObject('Object Repository/Login Page/input_password'), 'secret_sauce')
		}
	}

	@And("user click login button")
	public void user_click_login_button() {
		WebUI.click(findTestObject('Object Repository/Login Page/button_login'),)
	}

	@Then("user get pop up (.*)")
	public void user_get_pop_up(String result) {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Login Page/Alert/Epic sadface Username and password do not match any user in this service'), 0)
		WebUI.closeBrowser()
	}
}