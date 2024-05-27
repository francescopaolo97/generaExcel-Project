package com.generaExcel.helper;

import com.generaExcel.entity.UtenteEntity;
import com.generaExcel.repository.UtenteRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class Helper {

    public static String[] HEADERS_OUTPUT = {
            "NOME",
            "COGNOME",
            "ETA'"
    };

    public static String SHEET_NAME = "foglioExcelNameSheet";

    public static ByteArrayInputStream dataToExcel(List<UtenteEntity> listaUtenti) throws IOException {

        //CREA UN WORKBOOK
        Workbook workbook = new XSSFWorkbook();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try{

            //CREA IL FOGLIO
            Sheet sheet = workbook.createSheet(SHEET_NAME);

            //CREA LE RIGHE
            Row row = sheet.createRow(0);
            for (int i = 0; i<HEADERS_OUTPUT.length; i++){
                Cell cell = row.createCell(i);
                cell.setCellValue(HEADERS_OUTPUT[i]);
            }

            //VALORIZZA LE RIGHE
            int rowIndex = 1;
            for (UtenteEntity utente : listaUtenti) {
                rowIndex ++;
                Row dataRow = sheet.createRow(rowIndex);
                dataRow.createCell(0).setCellValue(utente.getNome());
                dataRow.createCell(1).setCellValue(utente.getCognome());
                dataRow.createCell(2).setCellValue(utente.getEta());
            }

            workbook.write(output);

            return new ByteArrayInputStream(output.toByteArray());

        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Errore nell'importare il file Excel...");
            return null;
        }finally {
            workbook.close();
            output.close();
        }
    }
}
