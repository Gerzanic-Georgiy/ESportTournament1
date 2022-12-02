package com.Fenix.ESportTournament.da.TextWork;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Клас, що реалізує запис тексту в файл
 */
public class TextWriter {

   /**
    * Клас, що реалізує запис тексту в файл
    *
    * @param info     Шлях до файлу, з якого зчитуються дані.
    * @param NameFile Шлях до файлу, з якого зчитуються дані.
    */
   public static void saveData(String info, String NameFile) throws IOException {

      File file = new File(NameFile);
      if (!file.exists()) {
         file.createNewFile();
      }
      PrintWriter pw = new PrintWriter(file);
      pw.append(info);
      pw.close();
   }
}
