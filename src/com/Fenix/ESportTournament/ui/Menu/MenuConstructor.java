package com.Fenix.ESportTournament.ui.Menu;

import java.util.Scanner;
import com.Fenix.ESportTournament.bl.decoration.BeautifulСonclusion;

/**
 * Клас автоматизованої генерації меню
 */
public class MenuConstructor {

   /**
    * Зміна, що зберігає вибір користувача.
    */
   byte el;
   String border = "⇇⇉";
   /**
    * Зміна, що зберігає довжину декоративних ліній.
    */
   int lenghtBorder = 50;
   String k = "❕";
   /**
    * Відступи
    */
   int pading = 5;
   BeautifulСonclusion bc = new BeautifulСonclusion();

   /**
    * Метод, що генерує меню.
    *
    * @param numberPunkt      отримує кількість пунктів
    * @param descriptionPunkt отримує масив зві списком меню
    * @param h1               отримує Заголовок
    * @return Вибір користувача
    */
   public byte MenuList(int numberPunkt, String[] descriptionPunkt, String h1) {
      int i = 0;
      h1(h1);
      while (i != numberPunkt) {
         //Якщо менше 6 пунктів
         if (numberPunkt < 6) {
            System.out.println(
                bc.autoLenghtHeightLine(pading, " ")
                    + (i + 1) + ") " + descriptionPunkt[i] + k);
         } else {
            //Якщо більше 6 пунктів
            /**  */
            int rightColumn = numberPunkt / 2;
            if (numberPunkt % 2 == 0) {
               rightColumn = rightColumn + i;
            } else {
               rightColumn = rightColumn + i + 1;
            }
            try {
               System.out.println("    " + (i + 1) + ") " + descriptionPunkt[i] + k
                   + bc.autoLenght(((i + 1) + ") " + descriptionPunkt[i]), 40)
                   + (rightColumn + 1) + ") " + descriptionPunkt[rightColumn] + k);
            } catch (Exception e) {
               System.out.println("    " + (i + 1) + ") " + descriptionPunkt[i] + k);
            }

            if (i == numberPunkt / 2) {
               break;
            }
         }
         i++;
      }

      System.out.println('\n' + bc.autoLenghtHeightLine(lenghtBorder, border));

      System.out.println("Виберіть пункт:");
      try {
         Scanner scanner = new Scanner(System.in);
         el = scanner.nextByte();
         if (el > numberPunkt || el < 0) {
            System.out.println("Виберіть існуючий пункт--->");
            MenuList(numberPunkt, descriptionPunkt, h1);
         }
      } catch (Exception e) {
         System.out.println("Не вірні дані!--->");
         MenuList(numberPunkt, descriptionPunkt, h1);
      }
      ;
      return el;
   }

   /**
    * Метод, що генерує заголовок.
    *
    * @param h1 отримує Заголовок
    */
   public void h1(String h1) {
      /** Декоративна зміна. */
      String decorLine = bc.autoLenghtCenter(bc.autoLenghtCenter(h1, 69, h1.length()), 56,
          bc.autoLenghtCenter(h1, 67, h1.length()).length())
          + "▣※⁂" + bc.autoLenghtHeightLine(30, "——") + "⁂※▣";
      /** Декоративна зміна. */
      String decorLine2 = bc.autoLenghtCenter(bc.autoLenghtHeightLine(10, "¯¯"), 67, 10)
          + bc.autoLenghtHeightLine(10, "¯¯") + "¯¯";

      System.out.println(bc.autoLenghtHeightLine(lenghtBorder, border) + '\n');
      System.out.println(decorLine);
      System.out.println(bc.autoLenghtCenter(h1, 68, h1.length()) + h1);
      System.out.println(decorLine);
      System.out.println(decorLine2);
   }

}
