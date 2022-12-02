package com.Fenix.ESportTournament.bl.Reload;

import com.Fenix.ESportTournament.ui.Menu.Menu;
import java.io.IOException;
import com.Fenix.ESportTournament.bl.parsing.Parser;

/**
 * Клас для збереження всіх турнірів.
 */
public class SaveAllTournament {

   static Parser parser = new Parser();
   static Menu menu = new Menu();

   public static void load() {
      /** Індекси всіх сайтів. */
      String[] link = {"", "csgo", "dota2", "sc2", "pubg", "ow"
          , "apex", "rl", "valorant", "fortnite", "minecraft"};
      System.out.println("🔃⏱️🔃 Починається завантаження! 🔃⏱️🔃");
      for (int i = 0; i < link.length; i++) {
         try {
            parser.Date("https://escharts.com/tournaments" + "/" + link[i],
                "Data/TournamentInfo/" + link[i] + "_Info" + ".txt", false);
         } catch (Exception e) {
            System.out.println(e);
            System.out.println("Ой, щось пішло не так!");
         }

      }
      System.out.println("Завантаження завершене!!! 🫡🥳🥹");
      try {
         menu.modeSelection();
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

}
