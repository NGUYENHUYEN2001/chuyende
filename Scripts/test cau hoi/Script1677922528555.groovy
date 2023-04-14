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

WebUI.click(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/button_Thm'))

WebUI.click(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/a_Hi p'))

WebUI.click(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/span_'))

WebUI.setText(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/input_Tiu_title'), tieude)

WebUI.click(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/p'))

WebUI.setText(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/div_to hoc lop 3'), mota)

if (chude == '') {
    WebUI.click(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/button_Lu'))
} else {
    WebUI.click(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/input_Ch_el-select__input'))

    WebUI.click(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/li_T1'))

    WebUI.click(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/button_Lu'))
}

isShowing = WebUI.waitForElementVisible(findTestObject('Page_BeWork  ng dng qun tr doanh nghip/div_Thm cu hi thnh cng'), 
    2)

if (isShowing == true) {
    try {
        isSuccessPopup = WebUI.verifyElementPresent(findTestObject('Page_BeWork  ng dng qun tr doanh nghip/div_Thm cu hi thnh cng'), 
            2)
    }
    catch (Exception e) {
        isSuccessPopup = false
    } 
    
    if (isSuccessPopup == true) {
        CustomKeywords.'customKeywordPackage.WriteToExcel.writeToExcel'('Tạo câu hỏi thành công', 'D:\\chuyende\\TEST CASE BEWORK.xlsx', 
            index.toInteger(), 7, 5)
    } else {
        CustomKeywords.'customKeywordPackage.WriteToExcel.writeToExcel'('Tạo câu hỏi không thành công', 'D:\\chuyende\\TEST CASE BEWORK.xlsx', 
            index.toInteger(), 7, 5)
    }
} else {
    CustomKeywords.'customKeywordPackage.WriteToExcel.writeToExcel'('Tạo câu hỏi không thành công', 'D:\\chuyende\\TEST CASE BEWORK.xlsx', 
        index.toInteger(), 7, 5)
}

isSuccessPopup = false

WebUI.closeBrowser()

