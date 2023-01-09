package filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.print.DocFlavor.STRING;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAndWriteExcel {
	public static void main(String[] args) throws IOException {
		ReadAndWriteExcel rd = new ReadAndWriteExcel();
		rd.writetableData();
	}

	public void readcompletedata() throws IOException {
		String filepath = System.getProperty("user.dir");
		System.out.println(filepath);
		File file = new File(filepath + "\\dataSet\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("Data2");
		int phrows = sh.getPhysicalNumberOfRows();
		int phcells = sh.getRow(0).getPhysicalNumberOfCells();

		for (Row row : sh) {
			for (Cell cell : row) {
				switch (cell.getCellTypeEnum()) {
				case STRING:
					System.out.print(cell.getStringCellValue() + " ");
					break;
				case NUMERIC:
					System.out.print(Math.round(cell.getNumericCellValue()) + " ");
					break;
				default:
					break;
				}
			}
			System.out.println();
		}

	}

	public void readMixDataType() throws IOException {
		String filepath = System.getProperty("user.dir");
		System.out.println(filepath);
		File file = new File(filepath + "\\dataSet\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("Data2");
		int phrows = sh.getPhysicalNumberOfRows();
		int phcells = sh.getRow(0).getPhysicalNumberOfCells();

		for (Row row : sh) {
			for (Cell cell : row) {
				switch (cell.getCellTypeEnum()) {
				case STRING:
					System.out.print(cell.getStringCellValue() + " ");
					break;
				case NUMERIC:
					System.out.print(Math.round(cell.getNumericCellValue()) + " ");
				default:
					break;
				}
			}
			System.out.println();

		}
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

		for (int i = 0; i < phrows; i++) {
			for (int j = 0; j < phcells; j++) {
				String data = sh.getRow(i).getCell(j).getStringCellValue();
				System.out.print(data + " ");
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

	public void writeexcel() throws IOException {
		String filepath = System.getProperty("user.dir");
		System.out.println(filepath);
		File file = new File(filepath + "\\dataSet\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.createSheet("sampleData");
		sh.createRow(0).createCell(0).setCellValue(151518);

		FileOutputStream fout = new FileOutputStream(file);
		wb.write(fout);
		fout.close();
		wb.close();
		System.out.println("Data written");

	}

	public void writetableData() throws IOException {
		String filepath = System.getProperty("user.dir");
		System.out.println(filepath);
		File file = new File(filepath + "\\dataSet\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.createSheet("sampleData4");

//		int i=1;
//		int j=1;
//		while(i<=10) {
//		XSSFRow row=sh.createRow(i);
//		while(j<=10) {
//			row.createCell(j).setCellValue("Hello"+j);
//			j++;
//		}
//		 i++;
//		}

		int i = 0;

		while (i <= 5) {
			Row row1 = sh.createRow(i++);
			int col = 0;
			while (col <= 5) {
				row1.createCell(col).setCellValue("Test");
				col++;
			}

		}

		FileOutputStream fout = new FileOutputStream(file);
		wb.write(fout);
		fout.close();
		wb.close();
		System.out.println("Data written");

	}

}
