package tests.junit;

import engine.ActionsBot;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Task2week6 extends Tests{
    /*
  Go to https://testpages.eviltester.com/styled/apps/notes/simplenotes.html
  Add 10 notes using data provider with excel
  Run it with 3 different browsers using XML file
  Run it parallel with 3 threads
   */
//    private WebDriver driver;
//    private WebDriverWait wait;
    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;
//    @Parameters({"target-browser"})
//    @BeforeClass
//    public void setUp(@Optional("chrome") String targetBrowser) {
//        switch (targetBrowser) {
//            case "chrome":
//                driver = new ChromeDriver();
//                break;
//            case "firefox":
//                driver = new FirefoxDriver();
//                break;
//            case "edge":
//                driver = new EdgeDriver();
//                break;
//            default:
//                throw new IllegalArgumentException("Unsupported browser: " + targetBrowser);
//        }
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }

    @DataProvider
    public Object[][] notes() throws IOException {
        FileInputStream file = new FileInputStream("C://Users//Admin//Desktop//excels.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        Object[][] data = null;

        try {
            XSSFSheet sheet = workbook.getSheetAt(0);
            int numRows = 10;
            data = new Object[1][1];
            String[][] notes = new String[numRows][2];

            for (int i = 0; i < numRows; i++) {
                Row row = sheet.getRow(i);
                Cell cell1 = row.getCell(0);
                Cell cell2 = row.getCell(1);
                String cellValue1 = cell1.getStringCellValue();
                String cellValue2 = cell2.getStringCellValue();
                notes[i][0] = cellValue1;
                notes[i][1] = cellValue2;
            }
            data[0][0] = notes;
        } finally {
            file.close();
            workbook.close();
        }

        return data;
    }


    @Test(dataProvider ="notes")
    public void task2(String[][] notes){
        driver.get("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");
        WebElement sendNote = driver.findElement(By.id("add-note"));
        for (String[] note : notes) {
            WebElement titleField = driver.findElement(By.id("note-title-input"));
            titleField.sendKeys(note[0]);
            WebElement notesField = driver.findElement(By.id("note-details-input"));
            notesField.sendKeys(note[1]);
            sendNote.click();
        }

    }
//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
