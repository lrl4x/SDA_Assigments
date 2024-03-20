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

public class Task2week6 {
    /*
  Go to https://testpages.eviltester.com/styled/apps/notes/simplenotes.html
  Add 10 notes using data provider with excel
  Run it with 3 different browsers using XML file
  Run it parallel with 3 threads
   */
    private WebDriver driver;
    private WebDriverWait wait;
    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;
    @Parameters({"target-browser"})
    @BeforeClass
    public void setUp(@Optional("chrome") String targetBrowser) {
        switch (targetBrowser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + targetBrowser);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @DataProvider(name = "notesData")
    public static Object[][] provideNotes() throws IOException {
        FileInputStream file = new FileInputStream(new File("C://Users//Admin//Desktop//excels.xlsx"));
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        List<Object[]> notesData = new ArrayList<>();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            String title = row.getCell(0).getStringCellValue();
            String content = row.getCell(1).getStringCellValue();
            notesData.add(new Object[]{title, content});
        }
        workbook.close();
        file.close();

        return notesData.toArray(new Object[0][]);
    }


    @Test(dataProvider = "notesData")
    public void addNoteTest(String noteTitle, String noteContent) {
        driver.get("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");
        WebElement titleField = driver.findElement(By.id("note-title-input"));
        WebElement contentField = driver.findElement(By.id("note-details-input"));
        WebElement addButton = driver.findElement(By.id("add-note"));
        titleField.sendKeys(noteTitle);
        contentField.sendKeys(noteContent);
        addButton.click();
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
