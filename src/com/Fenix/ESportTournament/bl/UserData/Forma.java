package com.Fenix.ESportTournament.bl.UserData;

import java.util.Scanner;

/**
 * Клас, в якому зберігається авторизаційна та реєстраційна форма.
 */
public class Forma {

   static Scanner scanner = new Scanner(System.in);
   /**
    * Поле, яке зберігає у мене користувачем ім'я.
    */
   static String name = "";
   /**
    * Були яке зберігає введений користувачем пароль.
    */
   static String pasworld = "";
   /**
    * Масив, який зберігаються дані якщо вони пройшли повірку.
    */
   static String[] readData = new String[2];

   /**
    * Метод, що повертає оброблені значення авторизації та реєстрації.
    *
    * @return
    */
   public static String[] form() {
      /** чи пройшло валідацію ім'я?  */
      boolean nameBool = false;
      /** Чи пройшов валідацію пароль. */
      boolean pasworldBool = false;
      /** Розбите на символ ім'я. */
      String[] nameSplit;
      /** Розбитий на символи пароль. */
      String[] pasworlSplit;
      /** Оброблене ім'я. */
      StringBuilder trueName = new StringBuilder();
      /** Оброблений пароль. */
      StringBuilder truePasworl = new StringBuilder();

      //логін
      while (!nameBool) {

         System.out.println("Введіть логін: ");
         name = scanner.nextLine();
         nameSplit = name.split("");
         for (int i = 0; i < name.length(); i++) {
            if (!nameSplit[i].equals(" ")) {
               trueName.append(nameSplit[i]);
            }

         }
         if (trueName.length() >= 3) {
            nameBool = true;
         } else {
            System.out.println("Логін занадто кородкий!");
            trueName = new StringBuilder();
         }
      }
      //логін
      while (!pasworldBool) {

         System.out.println("Введіть пароль: ");
         pasworld = scanner.nextLine();
         pasworlSplit = pasworld.split("");
         for (int i = 0; i < pasworld.length(); i++) {
            if (!pasworlSplit[i].equals(" ")) {
               truePasworl.append(pasworlSplit[i]);
            }

         }
         if (truePasworl.length() >= 4) {
            pasworldBool = true;
         } else {
            System.out.println("Пароль занадто кородкий!");
            truePasworl = new StringBuilder();
         }
      }
      readData[0] = trueName.toString();
      readData[1] = truePasworl.toString();
      return readData;
   }

}
