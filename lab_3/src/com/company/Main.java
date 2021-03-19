//to-do:
//исключения.

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length;
        int increment = 0;
        int[] pages_in_article = new int[0];                                            // здесь создаётся
        Book book1 = new Book();                                                        // экземпляр класса
        //System.out.print(book1.printInfo());                                            // Book и выводится
                                                                                        // информация о нём.

        Magazine mag1 = new Magazine();                                                 // здесь создаётся
        //System.out.print(mag1.printInfo());                                             // экзмепляр класса
                                                                                        // Magazine и выводится
                                                                                        // информация о нём.


        //сделать доп. кейсы и подпункт меню, где будет выводится интесующая пользователя инфа:
        //кол-во литературы всего, кол-во одинаковых экземпляров, кол-во книг и журналов отдельно.

        boolean main_menu_true = true;
        System.out.print("\nPlease, enter amount of literature you want to add:\n>");

        length = in.nextInt();
        Printable[] printable_literature = new Printable[length];

        while (main_menu_true) {
            System.out.print("\nWhat do you want to add?\n" +
                    "1. Magazine;\n" +
                    "2. Book;\n" +
                    "3. Exit.\n>");

            int add_menu = in.nextInt();
            boolean add_menu_true = true;
            while (add_menu_true) {
                switch (add_menu) {
                    case 1:
                        try {
                            if (printable_literature[increment] == null) {
                                printable_literature[increment] = new Magazine(pages_in_article);
                                ++increment;
                                add_menu_true = false;
                            } else
                                ++increment;
                        }
                        catch (IllegalArgumentException | NullPointerException exception)
                        {
                            System.out.println(exception.getMessage());
                        }
                        break;
                    case 2:
                        try {
                            if (printable_literature[increment] == null) {
                                printable_literature[increment] = new Book(pages_in_article);
                                ++increment;
                                add_menu_true = false;
                            } else
                                ++increment;
                        }
                        catch (IllegalArgumentException | NullPointerException exception) {
                            System.out.println(exception.getMessage());
                        }
                        break;
                    case 3:
                        add_menu_true = false;
                        main_menu_true = false;
                        break;
                    default:
                        System.out.print("\nSomething went wrong. Try again.\n");
                        add_menu_true = false;
                        break;
                }
            }
            if (increment == length)
                main_menu_true = false;
        }

        System.out.print("\nDo you want to see information about literature in database?\n" +
                "1. Yes;\n" +
                "2. No.\n>");
        int main_watch_menu = in.nextInt();
        boolean main_watch_menu_true = true;

        while (main_watch_menu_true)
        {
            switch (main_watch_menu)
            {
                case 1:

                    System.out.print("\nWhat type of info you want to see?\n" +
                            "1. All literature in database;\n" +
                            "2. Repetitive literature;\n" +
                            "3. Show only magazines;\n" +
                            "4. Show only books;\n" +
                            "5. Exit.\n>");
                    int watch_menu = in.nextInt();
                        switch (watch_menu)
                        {
                            case 1:
                                try {
                                    System.out.print("\nAll literature info:\n");
                                    for (int i = 0; i != printable_literature.length; ++i) {
                                        System.out.println(printable_literature[i].printInfo());
                                    }
                                }
                                catch (NullPointerException exception)
                                {
                                    System.out.println(exception.getMessage());
                                }
                                break;
                            case 2:
                                Printable[] same_printable_examples = new Printable[length];
                                try {
                                    for (int i = 0; i != length; ++i) {
                                        int repeat = 0;
                                        for (int j = 0; j != length; ++j) {
                                            if (printable_literature[j] != null
                                                    && printable_literature[i] != null
                                                    && printable_literature[j].printInfo().equals(
                                                    printable_literature[i].printInfo())) {
                                                ++repeat;
                                                if (repeat > 1)
                                                    same_printable_examples[i] = printable_literature[j];
                                            }
                                        }
                                    }

                                    System.out.print("\nRepetitive literature info:\n");
                                    for (int i = 0; i != same_printable_examples.length; ++i) {
                                        if (same_printable_examples[i] != null)
                                            System.out.println(same_printable_examples[i].printInfo());
                                    }
                                }
                                catch (NullPointerException exception)
                                {
                                 exception.getMessage();
                                }
                                break;
                            case 3:
                                Printable[] Magazines = new Printable[length];

                                System.out.print("\nAll magazines in database:\n");
                                int j = 0;
                                for (int i= 0; i != length; ++i)
                                {
                                    if (printable_literature[i] != null && printable_literature[i] instanceof Magazine)
                                    {
                                        Magazines[j] = printable_literature[i];
                                        System.out.println(Magazines[j].printInfo());
                                        ++j;
                                    }
                                }
                                break;
                            case 4:
                                j = 0;
                                Printable[] Books = new Printable[length];
                                System.out.print("\nAll books in database:\n");
                                for (int i = 0; i != length; ++i)
                                {

                                    if (printable_literature[i] != null && printable_literature[i] instanceof Book)
                                    {
                                        Books[j] = printable_literature[i];
                                        System.out.println(Books[j].printInfo());
                                        ++j;
                                    }
                                }
                                break;
                            case 5:
                                main_watch_menu_true = false;
                                break;
                            default:
                                System.out.print("\nSomething went wrong. Try again.\n");
                                break;
                    }
                    break;
                case 2:
                    main_watch_menu_true = false;
                    break;
                default:
                    System.out.print("\nSomething went wrong. Try again.\n");
                    break;
            }
        }



                                // нужно переносить данные из одного массива в другой
                                // [, при этом в первом оставлять null. думаю, это не нужно.]

                                // сделаю просто отдельный список,
                                // который показывает дубликаты.

                                // в случае какого-то книжного магазина это будет удобно.
                                // книги и журналы могут быть в нескольких экземплярах —  учитываться как разные товары,
                                // но быть абсолютно идентичными.

                                // цикл начинается с первого,
                                // каждый нынешний элемент проверяется с предыдущим.
                                // пришлось заменить, так как я не меняю на null. идёт length * length проходов по
                                // конструкции. если книга одна, то у неё будет всего одно нахождение. вне зависимости
                                // от кол-ва книг и журналов всего (проверено в тетради).

                                // где я добавляю книги и журналы нужно поставить if (element == null) [done.]
                                // и на вывод потом if (element != null). [done.]
    }
}

