import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
public class ExcelExporter {
    public void ExportOpenHouse(List<OpenHouse> openHouseList){
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Open House Data");
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Name");
        headerRow.createCell(1).setCellValue("Phone Number");
        headerRow.createCell(2).setCellValue("Dorm");
        int rowNum = 1;
        for (OpenHouse oh : openHouseList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(oh.getName());
            row.createCell(1).setCellValue(oh.getPhoneNumber());
            row.createCell(2).setCellValue(oh.getDorm());
        }
        try (FileOutputStream fileOut = new FileOutputStream("RushData.xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ExportFirstRound(List<FirstRound> firstRoundList){
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("First Round Data");
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Brother");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Phone Number");
        headerRow.createCell(3).setCellValue("Notes");
        int rowNum = 1;
        for (FirstRound fr : firstRoundList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(fr.getBrother());
            row.createCell(1).setCellValue(fr.getName());
            row.createCell(2).setCellValue(fr.getPhoneNumber());
            row.createCell(3).setCellValue(fr.getNotes());
        }
        try (FileOutputStream fileOut = new FileOutputStream("RushData.xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ExportSecondRound(List<SecondRound> secondRoundList){
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Second Round Data");
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Brother");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Phone Number");
        headerRow.createCell(3).setCellValue("Notes");
        int rowNum = 1;
        for (SecondRound sr : secondRoundList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(sr.getBrother());
            row.createCell(1).setCellValue(sr.getName());
            row.createCell(2).setCellValue(sr.getPhoneNumber());
            row.createCell(3).setCellValue(sr.getNotes());
        }
        try (FileOutputStream fileOut = new FileOutputStream("RushData.xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ExportThirdRound(List<ThirdRound> thirdRoundList){
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Third Round Data");
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Brother");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Phone Number");
        headerRow.createCell(3).setCellValue("Notes");
        int rowNum = 1;
        for (ThirdRound tr : thirdRoundList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(tr.getBrother());
            row.createCell(1).setCellValue(tr.getName());
            row.createCell(2).setCellValue(tr.getPhoneNumber());
            row.createCell(3).setCellValue(tr.getNotes());
        }
        try (FileOutputStream fileOut = new FileOutputStream("RushData.xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
