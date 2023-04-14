package customKeywordPackage
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.lang.String

import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row

class WriteToExcel {
	@Keyword(keywordObject = "Browser")
	def writeToExcel(String input, String filenamePath, int row, int cell, int excelSheetAt){
		// tao ra bien filename dai dien cho file excel
		File filename =new File(filenamePath)
		// file inputstream dung de doc file
		FileInputStream file = new FileInputStream (filename)
		// tao ra bien workbook de doc va ghi vao file excel
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		// lay sheet thu may trong excel
		XSSFSheet sheet = workbook.getSheetAt(excelSheetAt);
		// taoj ra 1 hang moi khi hang can tim bi null thi tao ra hang o vi tri null day
		if(sheet.getRow(row) == null) {
			Row thisRow = sheet.createRow(row)
			// neu o o vi tri day bi null	thi tao o day
			if(thisRow.getCell(cell) == null ) {
				Cell searchText = thisRow.createCell(cell);
				// set gia tri cho o
				searchText.setCellValue(input);
			} else {
				// ko bi null thi xet luon
				Cell searchText =thisRow.getCell(cell);
				searchText.setCellValue(input);
			}
			// neu hang k bi null thi lay hang
		} else {
			Row thisRow = sheet.getRow(row)
			if(thisRow.getCell(cell) == null ) {
				Cell searchText = thisRow.createCell(cell);
				searchText.setCellValue(input);
			} else {
				Cell searchText =thisRow.getCell(cell);
				searchText.setCellValue(input);
			}
		}

		file.close();
		FileOutputStream outFile =new FileOutputStream(filename);
		workbook.write(outFile);
		outFile.close();
	}
}