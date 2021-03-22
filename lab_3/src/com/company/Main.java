/*
todo: в классах Book и Magazine дополнить методы output'а и write'а.

 */
package com.company;

import com.company.Exceptions.NullObjectException;
import com.company.Prints.Printable;

import static com.company.MenuMethods.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final String separator = "------------------------------------------------------------------\n";
        Scanner in = new Scanner(System.in);
        Printable[] pArr = null;
        Printable p = null;

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
                    "\t5. Separate database into two arrays\n" +
                    "\twhich will have only books or magazines\n;" +
                    separator +
                    "\t6. Read database from byte stream;\n" +
                    "\t7. Read database from text stream;\n" +
                    "\t8. Deserialize database;\n" +
                    separator +
                    "\t9. Write database in byte stream;\n" +
                    "\t10. Write database in text stream;\n" +
                    "\t11. Serialize database;\n" +
                    separator +
                    separator +
                    "Work with objects:\n" +
                    separator +
                    "\t12. Show object info;\n" +
                    separator +
                    "\t13. Create and fill Printable object;\n" +
                    "\t14. Read from byte stream;\n" +
                    "\t15. Read from text stream;\n" +
                    "\t16. Deserialize database;\n" +
                    separator +
                    "\t17. Write object in byte stream;\n" +
                    "\t18. Write object in text stream;\n" +
                    "\t19. Serialize database;\n" +
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
                    printTask("\t1. Show all info about database;");
                    printPrintableArray(pArr);
                    break;
                case "2":
                    printTask("\t2. Create database;");
                    System.out.print("Setting size of database: ");
                    pArr = getPrintableArray();
                    break;
                case "3":
                    printTask("\t3. Setting element of database;");
                    printPrintableArrayAsTitlesOfElements(pArr);
                    System.out.println();
                    setElementOfPrintableArray(pArr);
                    break;
                case "4":
                    printTask("\t4. Find objects which have equal result\n" +
                            "\tof functional method in db\n" +
                            "\tand place them into new array;");
                    getArrayWithTwoSameSumOfPagesWithoutIntro(pArr);
                    break;
                case "5":
                    printTask("\t5. Separate database into two arrays\n" +
                            "which will have only books or magazines;");
                    splitArrayIntoTwoBooksAndMagazines(pArr);
                case "6":
                    printTask("\t6. Read database from byte stream;");
                    try {
                        pArr = printInputBytesAsPrintableArray();
                    } catch (NullObjectException exc) {
                        System.out.println(exc.getMessage());
                    }
                    break;
                case "7":
                    printTask("\t7. Read database from text stream;");
                    try {
                        pArr = printReadTextAsPrintableArray();
                    } catch (NullObjectException exc) {
                        System.out.println(exc.getMessage());
                    }
                    break;
                case "8":
                    printTask("\t8. Deserialize database;");
                    try {
                        pArr = printDeserializePrintableArray();
                    } catch (NullObjectException exc) {
                        System.out.println(exc.getMessage());
                    }
                    break;
                case "9":
                    printTask("\t9. Write database in byte stream;");
                    printOutputPrintableArrayAsBytes(pArr);
                    break;
                case "10":
                    printTask("\t10. Write database in text stream;");
                    printWritePrintableArrayAsText(pArr);
                    break;
                case "11":
                    printTask("\t11. Serialize database;");
                    printSerializePrintableArray(pArr);
                    break;
                case "12":
                    printTask("\t12. Show object info;");
                    System.out.println(p);
                    break;
                case "13":
                    printTask("\t13. Create and fill Printable object;");
                    p = getAndSetPrintable();
                    break;
                case "14":
                    printTask("\t14. Read from byte stream;");
                    try {
                        p = printInputBytesAsPrintable();
                    } catch (NullObjectException exc) {
                        System.out.println(exc.getMessage());
                    }
                    break;
                case "15" :
                    printTask("\t15. Read from text stream;");
                    try {
                        p = printReadTextAsPrintable();
                    } catch (NullObjectException exc) {
                        System.out.println(exc.getMessage());
                    }
                    break;
                case "16":
                    printTask("\t16. Deserialize database;");
                    try {
                        p = printDeserializePrintable();
                    } catch (NullObjectException exc) {
                        System.out.println(exc.getMessage());
                    }
                    break;
                case "17":
                    printTask("\t17. Write object in byte stream;");
                    printOutputPrintableAsBytes(p);
                    break;
                case "18":
                    printTask("\t18. Write object in text stream;");
                    printWritePrintableAsText(p);
                    break;
                case "19":
                    printTask("\t19. Serialize database;");
                    printSerializePrintable(p);
                    break;
                case "-1":
                    printTask("\t-1. Create and fill database automatically;");
                    pArr = Testing.createAndFillDbWithFiveElementsAutomatically();
                    break;
                case "-2":
                    printTask("\t-2. Automatically create and fill database with two repetitive elements;");
                    pArr = Testing.createAndFillDbWithFiveElementsAutomatically();
                    Testing.setTwoPrintableWithSameSumOfPagesWithoutStart(pArr);
                    break;
                case "-3":
                    printTask("\t-3. Automatically create and fill Printable object;");
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

