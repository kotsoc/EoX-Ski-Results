/* 
 * Just a filter that allows
 * only .xls files to be selected
 * by the gui
 * @author Konstantinos Peratinos
 */

package Ski;

import java.io.File;
import javax.swing.filechooser.FileFilter;

class xlsFilter extends FileFilter {
    
 public boolean accept(File file) {
  return (file.isDirectory()) || (file.getAbsolutePath().endsWith(".xls"));
 }
 
 public String getDescription() {
  return "Excel Spreadsheets (*.xls)";
 }
}


/* Location:           C:\Users\Kotsoc\Desktop\SkiResultsFinal.jar
 * Qualified Name:     Ski.xlsFilter
 * JD-Core Version:    0.7.0.1
 */