package com.Fenix.ESportTournament.bl.UserData.authorization;

import com.Fenix.ESportTournament.bl.UserData.Forma;
import com.Fenix.ESportTournament.da.TextWork.TextReader;
import java.io.IOException;

/**
 * Клас який зберігає логіку авторизації
 */
public class Authorization {

   /**
    * Поле, вказуюче чи авторизований користувач.
    */
   static boolean boolAutorization = false;

   /**
    * Метод що повертає двовимірний масив з даними про користувачів
    *
    * @param text Текст який потрібно розбити на частини
    * @return Розбитий по коміркам
    */
   public static String[][] autorizationSplitSystem(String text) {
      int i = 0;
      /** Зберігає логін та пароль. */
      String[][] arrey = new String[text.split("\n").length][2];
      while (i < text.split("\n").length) {
         arrey[i][0] = text.split("\n")[i].split("௹")[0];
         arrey[i][1] = text.split("\n")[i].split("௹")[1].split("\r")[0];
         i++;
      }
      return arrey;
   }

   /**
    * Метод, який обробляє всі дані авторизації.
    */
   public static void autorizationLogic() {
      /** Зберігає логін та пароль. */
      String readData[] = new String[2];
      /** Зберігає логін та пароль всіх користувачів.. */
      String[][] arrey = new String[0][];
      try {
         arrey = Authorization.autorizationSplitSystem(TextReader.readAllText(
             "Data/UserInfo/UserData.txt"));
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
      readData = Forma.form();
      int i = 0;

      while (i < arrey.length) {
         if (readData[0].equals(arrey[i][0])) {
            // readData[1] = BCrypt.withDefaults().hashToString(8,  readData[1].toCharArray());
            if (readData[1].equals(arrey[i][1])) {
               boolAutorization = true;
               System.out.println("Авторизація успішна");
               break;
            }
         }
         i++;
      }
      if (boolAutorization != true) {
         System.out.println("Не вірно введені дані");
         autorizationLogic();
      }

   }

   public static void getAutorizationBoolean(boolean b) {
      boolAutorization = b;
   }

   public static boolean getAutorizationBoolean() {
      return boolAutorization;
   }

}
