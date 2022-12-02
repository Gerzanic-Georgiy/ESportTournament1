package com.Fenix.ESportTournament.bl.UserData.registration;

import com.Fenix.ESportTournament.ui.Menu.Menu;
import com.Fenix.ESportTournament.ui.Menu.MenuConstructor;
import java.io.IOException;

/**
 * Клас який зберігає меню авторизації
 */
public class RegistrationMenu {

   /**
    * Зміна, що зберігає вибір користувача.
    */
   byte el;
   MenuConstructor menuConstructor = new MenuConstructor();
   Menu mReturn = new Menu();

   public void regMenu() throws IOException {
      /** Масив, що зберігає пункти меню. */
      String[] menuItem = {"Розпочати реєстрацію", "Головне меню"};
      el = menuConstructor.MenuList(menuItem.length, menuItem, "Реєстраційне меню");
      switch (el) {
         case 1 -> {
            menuConstructor.h1("Реєстрація");
            Registration.registr();
         }
         case 2 -> Menu.MainMenu();
      }
   }
}






