package com.Fenix.ESportTournament.bl.UserData.authorization;

import com.Fenix.ESportTournament.ui.Menu.Menu;
import com.Fenix.ESportTournament.ui.Menu.MenuConstructor;
import java.io.IOException;

/**
 * Клас який зберігає меню авторизації
 */
public class AuthorizationMenu {

   /**
    * Зміна, що зберігає вибір користувача.
    */
   byte el;
   MenuConstructor menuConstructor = new MenuConstructor();

   /**
    * Метод авторизації.
    */
   public void authorMenu() throws IOException {
      /** Масив, що зберігає пункти меню. */
      String[] menuItem = {"Розпочати авторизацію", "Головне меню"};
      el = menuConstructor.MenuList(menuItem.length, menuItem, "Авторизаційне меню");
      switch (el) {
         case 1:
            menuConstructor.h1("Авторизація");
            Authorization.autorizationLogic();
            break;
         case 2:
            Menu.MainMenu();
            break;
      }
   }
}
