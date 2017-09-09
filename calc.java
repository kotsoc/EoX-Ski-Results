/* 
* This is the main class of the Ski results points
* calculator that was developed for EOX.
* <p>
* The calculator takes the raw results from an excel file,
* performs the score calculations and then updates the score
* file.
* <p>
* For the Ms office document manipulation, the Apache POI library
* was used.
*
* @author Konstantinos Peratinos
 */


package Ski;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class calc {
  
  /**
    * The method that performs the calculations
    * @param path The path to the file
    * @param nam The name of the file
    */
  public static void pointCalc(String path, String nam) {

    String filename = nam;
    try {

      Workbook rs1 = WorkbookFactory.create(new FileInputStream(path));

      for (int k = 0; k < rs1.getNumberOfSheets(); k++) {

        Sheet paxgs = rs1.getSheetAt(k);

        for (Row row : paxgs) {

          double avgm = 0.0D;double avgl = 0.0D;

          Cell secCell = row.getCell(1);

          Cell firstCell = row.getCell(0);

          if ((firstCell != null) && (firstCell.getCellType() == 1)) {

            if (firstCell.getRichStringCellValue().getString().trim().toLowerCase().equals("ladies")) {

              int rn = row.getRowNum();

              for (int i = 1; i < 7; i++) {

                int j = row.getRowNum() + i;

                avgl += paxgs.getRow(j).getCell(9).getNumericCellValue();
              }
              for (int i = rn; i <= paxgs.getLastRowNum(); i++) {

                if (paxgs.getRow(i) != null) {

                  if (paxgs.getRow(i).getCell(0) != null) {

                    paxgs.getRow(i).getCell(0);

                    if ((paxgs.getRow(i).getCell(0).getCellType() == 1) &&
                      (paxgs.getRow(i).getCell(0).getRichStringCellValue().getString().trim().toLowerCase().equals("men"))) {

                      break;

                    }
                  }
                  if (paxgs.getRow(i).getCell(1) != null) {

                    paxgs.getRow(i).getCell(1);

                    if ((paxgs.getRow(i).getCell(1).getCellType() == 0) && (paxgs.getRow(i).getCell(0) == null) &&
                      (paxgs.getRow(i).getCell(8) == null)) {

                      paxgs.getRow(i).createCell(9).setCellValue(avgl / 6.0D);

                    }
                  }
                }
              }
              System.out.println(avgl / 6.0D);
            } else if (firstCell.getRichStringCellValue().getString().trim().toLowerCase().equals("men")) {

              int rn = row.getRowNum();

              for (int i = 1; i < 7; i++) {

                int j = row.getRowNum() + i;

                avgm += paxgs.getRow(j).getCell(9).getNumericCellValue();

              }
              for (int i = rn; i <= paxgs.getLastRowNum(); i++) {

                if (paxgs.getRow(i) != null) {

                  if (paxgs.getRow(i).getCell(0) != null) {

                    paxgs.getRow(i).getCell(0);

                    if ((paxgs.getRow(i).getCell(0).getCellType() == 1) &&
                      (paxgs.getRow(i).getCell(0).getRichStringCellValue().getString().trim().toLowerCase().equals("ladies"))) {

                      break;

                    }
                  }
                  if (paxgs.getRow(i).getCell(1) != null) {

                    paxgs.getRow(i).getCell(1);

                    if ((paxgs.getRow(i).getCell(1).getCellType() == 0) && (paxgs.getRow(i).getCell(0) == null) &&
                      (paxgs.getRow(i).getCell(8) == null)) {

                      paxgs.getRow(i).createCell(9).setCellValue(avgm / 6.0D);
                    }
                  }
                }
              }
              System.out.println(avgm / 6.0D);
            }
          }
        }
        writeFile(rs1, filename);
      }
    } catch (Exception e) {

      System.out.println("Το αρχείο δεν υπάρχει!");

      e.printStackTrace();
    }
  }

  
  /**
   *Method to write the result to a file
   * 
   * @param wb, name of the workboob
   * @param name, name of the new score file
   */
  public static void writeFile(Workbook wb, String name) {

    try {

      FileOutputStream out = new FileOutputStream(new File(name + ".xls"));

      wb.write(out);

      out.close();

    } catch (Exception ex) {

      ex.printStackTrace();
    }
  }
}
