package filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAndWriteExcel {
	public static void main(String[] args) throws IOException {
		ReadAndWriteExcel rd = new ReadAndWriteExcel();
		rd.readDatafromTable();
	}

	public void readDatafromTable() throws IOException {
		String filepath = System.getProperty("user.dir");
		System.out.println(filepath);
		File file = new File(filepath + "\\dataSet\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("Data");
		int phrows = sh.getPhysicalNumberOfRows();
		int phcells = sh.getRow(0).getPhysicalNumberOfCells();
		
		for(int i=0; i<phrows; i++) {
			for(int j=0; j<phcells; j++) {
				String data = sh.getRow(i).getCell(j).getStringCellValue();
				System.out.print(data+" ");
			}
			System.out.println();
		}
	}

	public void readExcel() throws IOException {
		String filepath = System.getProperty("user.dir");
		System.out.println(filepath);
		File file = new File(filepath + "\\dataSet\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);

		int lastrownum = sh.getLastRowNum();
		int pyrows = sh.getPhysicalNumberOfRows();
		System.out.println(lastrownum + "\n" + pyrows);

		XSSFRow row = sh.getRow(0);
		System.out.println(row.getCell(0).getNumericCellValue());

		System.out.println(sh.getRow(1).getCell(1).getNumericCellValue());

	}

}
