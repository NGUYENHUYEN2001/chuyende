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

WebUI.click(findTestObject('Page_BeWork  ng dng qun tr doanh nghip/img_1'))

WebUI.click(findTestObject('Page_BeWork  ng dng qun tr doanh nghip/span_Ti khon'))

WebUI.click(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/li_Thay i mt khu'))

WebUI.setText(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/input_Thay i mt khu_oldPassword'), 
    matkhauhientai)

WebUI.setText(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/input_Thay i mt khu_password'), matkhaumoi)

WebUI.setText(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/input_Thay i mt khu_confirmPassword'), 
    matkhauxacnhan)


WebUI.click(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/button_Thay i'))
isSuccessPopup = false
try {
    isSuccessPopup = WebUI.verifyElementPresent(findTestObject('Object Repository/Page_BeWork  ng dng qun tr doanh nghip/div_Thay i mt khu thnh cng'), 
        2)
}
catch (Exception e) {
    isSuccessPopup = false
} 
if (isSuccessPopup == true) {
    CustomKeywords.'customKeywordPackage.WriteToExcel.writeToExcel'('Thay đổi mật khẩu thành công', 'D:\\chuyende\\TEST CASE BEWORK.xlsx', 
        index.toInteger(), 7, 4)
} else {
    CustomKeywords.'customKeywordPackage.WriteToExcel.writeToExcel'('Thay đổi mật khẩu không thành công', 'D:\\chuyende\\TEST CASE BEWORK.xlsx', 
        index.toInteger(), 7, 4)
}

WebUI.closeBrowser()
