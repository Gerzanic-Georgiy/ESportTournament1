package com.Fenix.ESportTournament.ui.Menu;

import com.Fenix.ESportTournament.da.TextWork.OflineReader;
import com.Fenix.ESportTournament.bl.UserData.authorization.Authorization;
import java.io.IOException;
import java.util.Scanner;
import com.Fenix.ESportTournament.bl.parsing.Parser;
import com.Fenix.ESportTournament.bl.UserData.authorization.AuthorizationMenu;
import com.Fenix.ESportTournament.bl.UserData.registration.RegistrationMenu;
import com.Fenix.ESportTournament.bl.Reload.SaveAllTournament;
import com.Fenix.ESportTournament.bl.decoration.BeautifulСonclusion;

/**
 * Клас зберігаючий структуру головного меню
 */
public class Menu {


   /**
    * Значення вибраного користувачем елемента.
    */
   static byte el;
   /**
    * Чи авторизований користувач.
    */
   boolean autorization = false;
   /**
    * Використовується онлайн або офлайн режим.
    */
   static boolean onlineViu = true;
   public static MenuConstructor menuConstructor = new MenuConstructor();

   Scanner scanner = new Scanner(System.in);
   static Parser parser = new Parser();
   //static beautifulConclusion bConclusion = new beautifulConclusion
   static AuthorizationMenu aMenu = new AuthorizationMenu();
   static RegistrationMenu rMenu = new RegistrationMenu();
   static SaveAllTournament sat = new SaveAllTournament();
   static BeautifulСonclusion bConclusion = new BeautifulСonclusion();

   public static void MainMenu() throws IOException {
      StartMenu();
   }

   /**
    * Метод, що реалізує початкове меню.
    */
   private static void StartMenu() throws IOException {
      byte index = 0;
      /** Масив, що зберігає пункти меню. */
      String[] menu = {"Автризація", "Увійти як гість", "Зареєструватись", "Вихід"};
      if (Authorization.getAutorizationBoolean() == true) {
         menu[0] = "Перейти до головного меню";
      }
      el = menuConstructor.MenuList(menu.length, menu, "Початкове Меню");

      if (el == 1) {
         if (Authorization.getAutorizationBoolean() != true) {
            aMenu.authorMenu();
         }
         if (Authorization.getAutorizationBoolean() == true) {
            modeSelection();
         }
      } else if (el == 2) {
         modeSelection();
      } else if (el == 3) {
         rMenu.regMenu();
      } else if (el == 4) {
      }
   }

   /**
    * Метод, що реалізує Головне меню.
    */
   public static void modeSelection() throws IOException {
      /** Масив, що зберігає пункти меню. */
      String[] menu = {"Онлайн перегляд", "Офлайн перегляд", "(Зберегти / Обновити) всі турніри",
          "До початкового меню", "Вихід"};
      el = menuConstructor.MenuList(menu.length, menu, "Головне Меню");

      if (el == 1) {
         onlineViu = true;
         ChoiceVieuList();
      } else if (el == 2) {
         if (Authorization.getAutorizationBoolean()) {
            onlineViu = false;
            ChoiceVieuList();
         } else {
            System.out.println("Ця функція стане доступною після авторизації!!!!1");
            modeSelection();
         }
      } else if (el == 3) {
         if (Authorization.getAutorizationBoolean()) {
            sat.load();
         } else {
            System.out.println("Ця функція стане доступною після авторизації!!!!");
            modeSelection();
         }
      } else if (el == 4) {
         StartMenu();
      } else if (el == 5) {
      }
   }

   /**
    * Метод, що реалізує меню перегляду турнірів
    */
   private static void ChoiceVieuList() throws IOException {
      /** Масив, що зберігає пункти меню. */
      String[] menu = {"Найближчі турніри", "Counter-Strike: Global Offensive", "Dota2",
          "StarCraft II", "PUBG: Battlegrounds", "Overwatch", "Apex Legends", "Rocket League",
          "Valorant", "Fortnite", "Minecraft"};
      if (onlineViu == true) {
         el = menuConstructor.MenuList(menu.length, menu, "🟢 Перелік ігор 🟢");
      }
      if (onlineViu == false) {
         el = menuConstructor.MenuList(menu.length, menu, "🔴 Перелік ігор 🔴");
      }
      el--;
      OnlineVieuList();
   }

   /**
    * Метод, що реалізує вивід даних, якщо користувач в онлайн режимі.
    */
   private static void OnlineVieuList() throws IOException {
      /** Масив, що зберігає індекси сайтів*/
      String[] link = {"", "csgo", "dota2", "sc2", "pubg", "ow", "apex", "rl", "valorant",
          "fortnite",
          "minecraft"};
      /** Адаптивний шлях до сторінки сайту. */
      String fileUrl = link[el] + "_Info" + ".txt";

      if (onlineViu == true) {
         parser.Date("https://escharts.com/tournaments" + "/" + link[el],
             "Data/TournamentInfo/" + link[el] + "_Info" + ".txt",
             true);
      } else {

         String[] TournamentArrey = OflineReader.OnlineText(fileUrl);
         for (int i = 0; i < TournamentArrey.length; i++) {
            System.out.println(bConclusion.autoLenghtHeightLine(134, "⩶"));
            System.out.println(TournamentArrey[i]);
         }
         System.out.println(bConclusion.autoLenghtHeightLine(134, "⩶"));
      }
      returnChoiceVieuList();
   }

   /**
    * Метод, що реалізує повернення користувача в попередні вікна
    */
   private static void returnChoiceVieuList() throws IOException {
      /** Масив, що зберігає індекси сайтів*/
      String[] menu = {"Список турнірів", "Головне меню", "Вихід"};
      el = menuConstructor.MenuList(menu.length, menu, "Що далі? ");
      switch (el) {
         case 1:
            ChoiceVieuList();
            break;
         case 2:
            modeSelection();
            break;
         case 3:
            break;
         default:
            System.out.println("Введені не вірні дані!");
            break;
      }
   }
}
