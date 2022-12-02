package com.Fenix.ESportTournament.bl.UserData.registration;

import com.Fenix.ESportTournament.bl.UserData.Forma;
import com.Fenix.ESportTournament.bl.UserData.authorization.Authorization;
import com.Fenix.ESportTournament.da.TextWork.TextReader;
import com.Fenix.ESportTournament.da.TextWork.TextWriter;
import com.Fenix.ESportTournament.ui.Menu.Menu;
import java.io.IOException;

/**
 * Клас який зберігає логіку реєстрації
 */
public class Registration {

   /**
    * Метод який зберігає логіку реєстрації
    */
   public static void registr() throws IOException {
      /** Масив, що зберігає інформацію про користувача. */
      String[] readData;
      /** Поле де зберігаються підсумок всіх даних. */
      StringBuilder allText = new StringBuilder();
      /** Всі дані про користувачів. */
      String[][] arrey = Authorization.autorizationSplitSystem(
          TextReader.readAllText("Data/UserInfo/UserData.txt"));

      for (String[] strings : arrey) {
         allText.append(strings[0]).append("௹").append(strings[1]).append('\n');
      }
      readData = Forma.form();
      int i = 0;
      while (arrey.length > i) {
         if (readData[0].equals(arrey[i][0])) {
            System.out.println("Такий користувач вже існує!");
            registr();
         }
         i++;
      }
      //readData[1] = BCrypt.withDefaults().hashToString(8,  readData[1].toCharArray());
      allText.append(readData[0]).append("௹").append(readData[1]).append('\n');
      TextWriter.saveData(allText.toString(), "Data/UserInfo/UserData.txt");
      System.out.println("Реєстрація успішна❕👍🥳");
      Authorization.getAutorizationBoolean(true);
      Menu.modeSelection();


   }
}

