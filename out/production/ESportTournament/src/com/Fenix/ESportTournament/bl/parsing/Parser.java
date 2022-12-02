package com.Fenix.ESportTournament.bl.parsing;

import com.Fenix.ESportTournament.da.TextWork.TextWriter;
import com.Fenix.ESportTournament.bl.decoration.BeautifulСonclusion;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Клас який реалізує читання даних з сайту
 */
public class Parser {

   Document doc;
   TextWriter tw = new TextWriter();
   BeautifulСonclusion bConclusion = new BeautifulСonclusion();

   /**
    * Парсинг сайту.
    *
    * @param url      Ссилка на сайт.
    * @param nameFile Файл, куди записуються дані.
    * @param Viue     Чи функція використовується тільки для перегляду
    */
   public void Date(String url, String nameFile, boolean Viue) throws IOException {

      // Парсінг даних
      doc = Jsoup.connect(url).get();
      Elements blockEl = doc.getElementsByAttributeValue("class", "group_dQEnY");
      Elements blok = doc.select("tr");
      boolean start = false;
      /** Назва турніру.  */
      String allInformation = "";
      /**Назва турніру. */
      String name = "";
      /** Статус турніру. */
      String status = "";
      /** Призовий фонд.  */
      String price = "";
      /** Дата проведення. */
      String date = "";

      for (var el : blok) {
         /** Зчитана інформація. */
         String nameGamesAllInfo = el.child(0).text();
         String[] nameGames = nameGamesAllInfo.split(",");
         String nameInfo = nameGames[0].toString();
         String[] nameArrey = nameInfo.split(" ", 2);
         try {
            nameArrey = nameInfo.split(" ", 2)[1].split("-");
         } catch (Exception e) {
         }
         try {
            status = nameInfo.split(" ", 2)[0];
            if (status.length() < 1) {
               status = "❔❓❔";
            }
         } catch (Exception e) {
            status = "❔❓❔";
         }
         try {
            name = nameArrey[0];
         } catch (Exception e) {
         }

         price = el.child(1).text();
         date = el.child(5).text();
         if (start == false) {
            status = bConclusion.autoLenghtCenter("СТАТУС", 15, "СТАТУС".length()) + "СТАТУС";
            name = bConclusion.autoLenghtCenter("НАЗВА ТУРНІРУ", 70, "НАЗВА ТУРНІРУ".length())
                + "НАЗВА ТУРНІРУ";
            price = bConclusion.autoLenghtCenter("ВИГРАШНИЙ ФОНД", 20, "ВИГРАШНИЙ ФОНД".length())
                + "ВИГРАШНИЙ ФОНД";
            date = bConclusion.autoLenghtCenter("ДАТА ПРОВЕДЕННЯ", 25, "ДАТА ПРОВЕДЕННЯ".length())
                + "ДАТА ПРОВЕДЕННЯ";
         }

         //Вивід даних
         String a = "🔴🟢";
         String rowINfo = "";
         String splitElements = " ";
         try {
            rowINfo = ("|||  " + "🔴🟢 " + splitElements + status
                + bConclusion.autoLenght(status, 15) + splitElements + "😲😊 " + splitElements
                + name + bConclusion.autoLenght(name, 70) + splitElements + "💲💵💲️ " + splitElements
                + price + bConclusion.autoLenght(price, 20) + splitElements + "⏱⌚⏱ " + splitElements
                + date + bConclusion.autoLenght(date, 25) + splitElements + " ||");
            if (Viue) {
               System.out.println(bConclusion.autoLenghtHeightLine(134, "⩶"));
               System.out.println(rowINfo);
            }
            allInformation += rowINfo + '\n';
            start = true;
         } catch (Exception e) {
            System.out.println("Ой, щось пішло не так!");
         }
      }
      if (Viue) {
         System.out.println(bConclusion.autoLenghtHeightLine(134, "⩶") + '\n' + '\n');
      } else {
         System.out.println("📁 Дані файлу: " + nameFile + " оновлено! ✅");
      }

      tw.saveData(allInformation, nameFile);
   }
}
