package tests.junit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task5week5 extends Tests {
//Store the path of the file as string and open the file.
    //Open the workbook.
    //Open the first worksheet.
    //Go to the first row.
    //Create a cell on the 3rd column (2nd index) on the first row.
    //Write “POPULATION” on that cell.
    //Create a cell on the 2nd row 3rd cell(index2), and write data.
    //Create a cell on the 3rd row 3rd cell(index2), and write data.
    //Create a cell on the 4th row 3rd cell(index2), and write data.
    //Write and save the workbook.
    //Close the file.
    //Close the workbook.

//The 3rd column on excel file must be empty before running.
// Otherwise, new data will be written on the old data


    @Test
    public void main() throws IOException {
        FileInputStream fs = new FileInputStream("C:\\excelfile.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);

        try {
            XSSFSheet sheet = workbook.getSheetAt(0);
            Row firstRow = sheet.getRow(0);

            Row row1 = sheet.createRow(0);
            Cell cell = row1.createCell(2);
            cell.setCellValue("POPULATION");

            Row row2 = sheet.createRow(1);
            Cell cell2 = row2.createCell(2); //
            cell2.setCellValue("Data for 2nd row.");

            Row row3 = sheet.createRow(2);
            Cell cell3 = row3.createCell(2);
            cell3.setCellValue("Data for 3rd row.");

            Row row4 = sheet.createRow(3);
            Cell cell4 = row4.createCell(2);
            cell4.setCellValue("Data for 4th row.");

            FileOutputStream outputStream = new FileOutputStream("C:\\excelfile.xlsx");
            workbook.write(outputStream);
        } finally {
            fs.close();
            workbook.close();
        }
    }
}
