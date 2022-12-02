package com.Fenix.ESportTournament.da.TextWork;

import java.io.IOException;

/**
 * Клас, що реалізує офлайн зчитування.
 */
public class OflineReader {

   /**
    * Клас, що реалізує зчитування тексту
    *
    * @param path Шлях до файлу, з якого зчитуються дані.
    * @return Зчитані дані.
    */
   public static String[] OnlineText(String path) throws IOException {
      /** Масив, що зберігає всі дані файлу по рядках. */
      String[] allText = TextReader.readAllText("Data/TournamentInfo/" + path).split("\n");
      return allText;
   }
}
