/*
todo: в классах Book и Magazine дополнить методы output'а и write'а.

 */
package com.company;

import com.company.Exceptions.NullObjectException;
import com.company.Prints.Book;
import com.company.Prints.Printable;
import com.company.Threads.*;

import static com.company.MenuMethods.*;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final String separator = "---------------------------------------------------------------------------------\n";
        Scanner in = new Scanner(System.in);
        Printable[] pArr = null;
        Printable p = null;
        List<Printable[]> arrayWithSameSumOfPagesWithoutIntro = null;

        int testAmountOfIntroPages;
        final int testAmountOfArticles = 600;
        Printable testPrintable;

        String menu = "";
        while (!menu.equals("0")) {
            System.out.print(separator + "Work with database:\n" +
                    separator +
                    "\t1. Show all info about database;\n" +
                    separator +
                    "\t2. Create database;\n" +
                    "\t3. Setting element of database;\n" +
                    separator +
                    "\t4. Find objects which have equal result\n" +
                    "\tof functional method in db\n" +
                    "\tand place them into new array;\n" +
                    "\t5. Show new array with objects that\n" +
                    "\thave equal result of functional method;\n" +
                    "\t6. Separate database into two arrays\n" +
                    "\twhich will have only books or magazines\n;" +
                    separator +
                    "\t7. Read database from byte stream;\n" +
                    "\t8. Read database from text stream;\n" +
                    "\t9. Deserialize database;\n" +
                    separator +
                    "\t10. Write database in byte stream;\n" +
                    "\t11. Write database in text stream;\n" +
                    "\t12. Serialize database;\n" +
                    separator +
                    separator +
                    "Work with objects:\n" +
                    separator +
                    "\t13. Show object info;\n" +
                    separator +
                    "\t14. Create and fill Printable object;\n" +
                    "\t15. Read from byte stream;\n" +
                    "\t16. Read from text stream;\n" +
                    "\t17. Deserialize database;\n" +
                    separator +
                    "\t18. Write object in byte stream;\n" +
                    "\t19. Write object in text stream;\n" +
                    "\t20. Serialize database;\n" +
                    separator +
                    "\t21. Run filling and reading by thread;\n" +
                    separator +
                    "\t22. Run synchronized filling and reading by thread;\n" +
                    separator +
                    separator +
                    "For testing:\n" +
                    separator +
                    "\t-1. Create and fill database automatically;\n" +
                    "\t-2. Automatically create and fill database with two repetitive elements;\n" +
                    separator +
                    "\t-3. Automatically create and fill Printable object;\n" +
                    separator +
                    separator +
                    "0. Exit.\n" +
                    separator +
                    ">");
            menu = in.nextLine();

            switch (menu) {
                case "1":
                    printTask("\t1. Show all info about database.");
                    printPrintableArray(pArr);
                    break;
                case "2":
                    printTask("\t2. Create database;");
                    System.out.print("Setting size of database: ");
                    pArr = getPrintableArray();
                    break;
                case "3":
                    printTask("\t3. Setting element of database.");
                    printPrintableArrayAsTitlesOfElements(pArr);
                    System.out.println();
                    setElementOfPrintableArray(pArr);
                    break;
                case "4":
                    printTask("\t4. Find objects which have equal result\n" +
                            "\tof functional method in db\n" +
                            "\tand place them into new array.");
                    try {
                            arrayWithSameSumOfPagesWithoutIntro = getArrayWithSameSumOfPagesWithoutIntro(pArr);
                    }
                    catch (NullPointerException exc) {
                        exc.getMessage();
                    }
                    break;
                case "5":
                    printTask("\t5. Show new array with objects that\n" +
                            "\thave equal result of functional method.");
                    try {
                        for (Printable[] array : arrayWithSameSumOfPagesWithoutIntro) {
                            printPrintableArray(array);
                        }
                    } catch (Exception exc) {
                        exc.getMessage();
                    }
                    break;
                case "6":
                    printTask("\t6. Separate database into two arrays\n" +
                            "\twhich will have only books or magazines.");
                    splitArrayIntoTwoBooksAndMagazines(pArr);
                case "7":
                    printTask("\t7. Read database from byte stream.");
                    try {
                        pArr = printInputBytesAsPrintableArray();
                    } catch (NullObjectException exc) {
                        System.out.println(exc.getMessage());
                    }
                    break;
                case "8":
                    printTask("\t8. Read database from text stream.");
                    try {
                        pArr = printReadTextAsPrintableArray();
                    } catch (NullObjectException exc) {
                        System.out.println(exc.getMessage());
                    }
                    break;
                case "9":
                    printTask("\t9. Deserialize database.");
                    try {
                        pArr = printDeserializePrintableArray();
                    } catch (NullObjectException exc) {
                        System.out.println(exc.getMessage());
                    }
                    break;
                case "10":
                    printTask("\t10. Write database in byte stream.");
                    printOutputPrintableArrayAsBytes(pArr);
                    break;
                case "11":
                    printTask("\t11. Write database in text stream.");
                    printWritePrintableArrayAsText(pArr);
                    break;
                case "12":
                    printTask("\t12. Serialize database.");
                    printSerializePrintableArray(pArr);
                    break;
                case "13":
                    printTask("\t13. Show object info.");
                    System.out.println(p);
                    break;
                case "14":
                    printTask("\t14. Create and fill Printable object.");
                    p = getAndSetPrintable();
                    break;
                case "15":
                    printTask("\t15. Read from byte stream.");
                    try {
                        p = printInputBytesAsPrintable();
                    } catch (NullObjectException exc) {
                        System.out.println(exc.getMessage());
                    }
                    break;
                case "16" :
                    printTask("\t16. Read from text stream.");
                    try {
                        p = printReadTextAsPrintable();
                    } catch (NullObjectException exc) {
                        System.out.println(exc.getMessage());
                    }
                    break;
                case "17":
                    printTask("\t17. Deserialize database.");
                    try {
                        p = printDeserializePrintable();
                    } catch (NullObjectException exc) {
                        System.out.println(exc.getMessage());
                    }
                    break;
                case "18":
                    printTask("\t18. Write object in byte stream.");
                    printOutputPrintableAsBytes(p);
                    break;
                case "19":
                    printTask("\t19. Write object in text stream.");
                    printWritePrintableAsText(p);
                    break;
                case "20":
                    printTask("\t20. Serialize database.");
                    printSerializePrintable(p);
                    break;
                case "21":
                    printTask("\t21. Run filling and reading by thread.\n");
                    Random rand = new Random();
                    testAmountOfIntroPages = Printable.MIN_AMOUNT_OF_PAGES + rand.nextInt(Printable.MAX_AMOUNT_OF_PAGES-Printable.MIN_AMOUNT_OF_INTRODUCING_PAGES + 1);
                    testPrintable = new Book("Test book.", testAmountOfArticles, testAmountOfIntroPages);
                    WritingThread wt = new WritingThread(testPrintable);
                    ReadingThread rt = new ReadingThread(testPrintable);
                    wt.setPriority(Thread.NORM_PRIORITY);
                    rt.setPriority(Thread.NORM_PRIORITY);
                    wt.runThread();
                    rt.runThread();
                    break;
                case "22":
                    printTask("\t22. Run synchronized filling and reading by thread.\n");
                    Random random = new Random();
                    testAmountOfIntroPages = Printable.MIN_AMOUNT_OF_PAGES + random.nextInt(Printable.MAX_AMOUNT_OF_PAGES-Printable.MIN_AMOUNT_OF_INTRODUCING_PAGES + 1);
                    testPrintable = new Book("Test book.", testAmountOfArticles, testAmountOfIntroPages);
                    PrintableSynchronizer psync = new PrintableSynchronizer(testPrintable);
                    RunnableWritingThread rwt = new RunnableWritingThread(psync);
                    RunnableReadingThread rrt = new RunnableReadingThread(psync);

                    new Thread(rwt).start();
                    new Thread(rrt).start();
                    break;
                case "-1":
                    printTask("\t-1. Create and fill database automatically.");
                    pArr = Testing.createAndFillDbWithFiveElementsAutomatically();
                    break;
                case "-2":
                    printTask("\t-2. Automatically create and fill database with two repetitive elements.");
                    pArr = Testing.createAndFillDbWithFiveElementsAutomatically();
                    Testing.setTwoPrintableWithSameSumOfPagesWithoutStart(pArr);
                    break;
                case "-3":
                    printTask("\t-3. Automatically create and fill Printable object.");
                    p = Testing.createAndFillPrintableAutomatically();
                    break;
                default:
                    break;
            }
            printExit();
            System.out.println();
        }
    }
}


