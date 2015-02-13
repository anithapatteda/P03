import java.io.*;

import ssw555.project.input_store;

public class gedcom_main {
 public static void main(String args[]) {
  try {
  input_store gcfr = new input_store();
   gcfr.readFile("C:/QingliaoWu.ged");
   System.out.println("Individuals:");
   gcfr.print_individual();
   System.out.println("Families:");
   gcfr.print_family();
  } catch (IOException e) {
   e.printStackTrace();
  }
 }
}
