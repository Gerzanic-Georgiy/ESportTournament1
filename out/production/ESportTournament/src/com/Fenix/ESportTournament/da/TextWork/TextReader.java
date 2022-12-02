package com.Fenix.ESportTournament.da.TextWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Клас, що реалізує зчитування тексту
 */
public class TextReader {

   /**
    * Зміна, що зберігає шлях до файлу.
    */
   String link = "Data/UserInfo/UserData.txt";

   /**
    * Клас, що реалізує зчитування тексту
    *
    * @param link Шлях до файлу, з якого зчитуються дані.
    * @return Зчитані дані.
    */
   public static String readAllText(String link) throws IOException {
      BufferedReader reader = Files.newBufferedReader(Paths.get(link));
      /** Поле що зберігає зчитані дані. */
      StringBuilder content = new StringBuilder();
      String line;

      while ((line = reader.readLine()) != null) {
         content.append(line);
         content.append(System.lineSeparator());
      }

      return content.toString();
   }


}
