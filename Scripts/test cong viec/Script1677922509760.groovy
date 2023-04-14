import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://app.bework.vn/login?redirect=%2F')

WebUI.setText(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/input_Ting vit_username'), '0123456780')

WebUI.setText(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/input_Ting vit_password'), '11111111')

WebUI.click(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/button_ng nhp'))

WebUI.click(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/a_Cng vic'))

WebUI.click(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/button_Thm mi'))

WebUI.setText(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/textarea_To cng vic mi_title'), tencv)
if(tenduan == " ")
{
	
}
else {
	WebUI.click(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/input_D n_project'))
	
	WebUI.click(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/li_Tt'))
	
	WebUI.click(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/span_Backlog'))
	
	WebUI.click(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/li_To do'))
	
	WebUI.click(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/input_Giao cho_el-input__inner'))
	
	WebUI.click(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/li_Nguyen Thi Huyen Nhn vin'))
}


WebUI.setText(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/textarea_M t_description'), mota)

isSuccessPopup = false

try {
	WebUI.click(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/button_To mi'))
} catch (Exception e) {
	isSuccessPopup = false
}


try {
	isSuccessPopup=WebUI.verifyElementPresent(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/div_To cng vic thnh cng'), 
    2)

}
catch (Exception e) {
	isSuccessPopup = false
}
if (isSuccessPopup == true) {
        CustomKeywords.'customKeywordPackage.WriteToExcel.writeToExcel'('Tạo công việc thành công', 'D:\\chuyende\\TEST CASE BEWORK.xlsx', 
            index.toInteger(), 9, 3)
    } else {
        CustomKeywords.'customKeywordPackage.WriteToExcel.writeToExcel'('Tạo công việc không thành công', 'D:\\chuyende\\TEST CASE BEWORK.xlsx', 
            index.toInteger(), 9, 3)
    }

	WebUI.closeBrowser()
