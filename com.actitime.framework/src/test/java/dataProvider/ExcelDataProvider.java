package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;

	public ExcelDataProvider() {

		File xlSrc = new File("./ApplicationTestData/actiTimeTestData.xlsx");
		try {
			FileInputStream xlfis = new FileInputStream(xlSrc);
			wb = new XSSFWorkbook(xlfis);
		} catch (Exception e) {

			System.out.println("Exception occured in ExcelDataProvider method "
					+ e.getMessage());
		}

	}

	public String getData(int sheetIndex, int row, int column) {
		String xldata = wb.getSheetAt(sheetIndex).getRow(row).getCell(column)
				.getStringCellValue();
		return xldata;
	}

	public String getData(String sheetName, int row, int column) {
				String data = wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		return data;
	}

}
