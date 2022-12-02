package com.Fenix.ESportTournament.bl.decoration;

/**
 * Клас для створення декорацій та красивих відступів
 */
public class BeautifulСonclusion {

   private String space;

   /**
    * Створення рівних колонок.
    *
    * @param element Текст, який знаходиться в колонці.
    * @param lenght  Яка повинна бути фінальна довжина блока.
    * @return Відступ вказаної довжини.
    */
   public String autoLenght(String element, int lenght) {
      space = "";
      String space = "";
      if (element.length() < lenght) {
         int spaceLenght = lenght - element.length();
         while (element.length() + space.length() != lenght) {
            space += " ";
         }
      }
      return space;
   }

   /**
    * Центрування елементу.
    *
    * @param element              Текст, який знаходиться в колонці.
    * @param lenght               Яка повинна бути фінальна довжина блока.
    * @param lenghtCentralElement Довжина тексту в колонці.
    */
   public String autoLenghtCenter(String element, int lenght, int lenghtCentralElement) {
      String space = "";
      if (element.length() < lenght) {
         int spaceLenght = (lenght - element.length()) / 2;
         while (space.length() != spaceLenght) {
            space += " ";
         }
      }
      return space;
   }

   /**
    * Створення декоративної лінії вказаної довжини    *
    *
    * @param AllLenght    Дуже на декорації.
    * @param decorElement Елемент, яким заповниться ця відстань.
    * @return Готовий елемент.
    */
   public String autoLenghtHeightLine(int AllLenght, String decorElement) {
      String space = "";
      while (space.length() != AllLenght) {
         space += decorElement;
      }
      return space;
   }
}
