package com.company;

import com.company.Exceptions.IllegalIndexException;
import com.company.Exceptions.NullObjectException;
import static com.company.Prints.WorkWithPrintables.*;

import com.company.Prints.InputAndOutputPrintable;
import com.company.Prints.Magazine;
import com.company.Prints.Book;
import com.company.Prints.Printable;
import static com.company.Prints.InputAndOutputPrintable.*;
import static com.company.Prints.InputAndOutputPrintableArray.*;

import java.io.*;
import java.util.Scanner;


public class MenuMethods {

    private static final String BYTES_FILE_WITH_SER = "serAsBytes.bin";
    private static final String TEXT_FILE_WITH_SER = "serAsText.txt";
    private static final String SERIALIZED_FILE_WITH_SER = "serSerialized.bin";

    private static final String BYTES_FILE_WITH_SER_ARR = "serArrAsBytes.bin";
    private static final String TEXT_FILE_WITH_SER_ARR = "serArrAsText.txt";
    private static final String SERIALIZED_FILE_WITH_SER_ARR = "serArrSerialized.bin";

    final static String separator = "------------------------------------------------------------------\n";

    static void printTask(String task) {
        System.out.print("\n" + task + "\n" + separator);
    }

    static void printExit() {
        System.out.print("\n" + "Press Enter to exit.");
        Scanner in = new Scanner(System.in);
        in.nextLine();
    }

    private static Magazine addNewMagazine() {

        System.out.print("Enter name of Magazine: ");
        Scanner in = new Scanner(System.in);
        String title = in.nextLine();

        int numberOfArticles = getNumberOfArticles();
        int numberOfIntroducingPages = getNumberOfIntroducingPages();

        Magazine m = new Magazine(title, numberOfArticles, numberOfIntroducingPages);
        System.out.println("Magazine created successfully.\n" +
                "Fill magazine with pages:");
        fillWithPages(m);

        return m;
    }

    private static Book addNewBook() {
        System.out.print("Enter name of Book: ");
        Scanner in = new Scanner(System.in);
        String title = in.nextLine();

        int numberOfArticles = getNumberOfArticles();
        int numberOfIntroducingPages = getNumberOfIntroducingPages();

        Book b = new Book(title, numberOfArticles, numberOfIntroducingPages);
        System.out.println("Book created successfully.\n" +
                "Fill book with pages:");
        fillWithPages(b);

        return b;
    }

    static Printable getAndSetPrintable() {
        Printable p;
        Scanner in = new Scanner(System.in);
        String str;
        while (true) {
            System.out.print("Choose element type: \n" +
                    separator +
                    "1. " + Magazine.class.getName() +
                    "2. " + Book.class.getName() +
                    separator +
                    ">");
            str = in.nextLine();
            System.out.println();
            if (str.equals("1")) {
                p = addNewMagazine();
                return p;
            } else if (str.equals("2")) {
                p = addNewBook();
                return p;
            } else {
                System.out.println("Error: wrong menu item.");
            }
        }
    }

    private static int getInt() {
        int number;

        Scanner in = new Scanner(System.in);
        String str;

        while (true) {
            System.out.print("Enter number: ");
            str = in.nextLine();

            try {
                number = Integer.parseInt(str);
                break;
            } catch (NumberFormatException exc) {
                System.out.println("Error: entered string isn't a number.");
            }
        }
        return number;
    }

    private static int getIndex(int maxIndex) {
        int index;
        Scanner in = new Scanner(System.in);
        String str;

        while (true) {
            System.out.print("Enter index: ");
            str = in.nextLine();
            System.out.println();

            try {
                index = Integer.parseInt(str);
                if (index < 0 || index > maxIndex) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IllegalIndexException exc) {
                System.out.println("Error: invalid index.");
            } catch (Exception exc) {
                System.out.println("Error: entered string isn't a number.");
            }
        }
        return index;
    }



    private static int getNumberOfArticles() {
        int number;

        while (true) {
            System.out.print("Amount of articles: ");
            number = getInt();

            if (number < Printable.MIN_AMOUNT_OF_ELEMENTS_IN_ARRAY) {
                System.out.println("Amount of articles must be at least " + Printable.MIN_AMOUNT_OF_ELEMENTS_IN_ARRAY);
            } else if (number > Printable.MAX_AMOUNT_OF_ELEMENTS_IN_ARRAY) {
                System.out.println("There are too much articles.");
            } else {
                return number;
            }
        }
    }

    private static int getNumberOfIntroducingPages() {
        int number;

        while (true) {
            System.out.print("Amount of introducing pages: ");
            number = getInt();

            if (number < Printable.MIN_AMOUNT_OF_INTRODUCING_PAGES) {
                System.out.println("Amount of pages must be at least " + Printable.MIN_AMOUNT_OF_INTRODUCING_PAGES);
            } else if (number > Printable.MAX_AMOUNT_OF_INTRODUCING_PAGES) {
                System.out.println("There are too much pages.");
            } else {
                return number;
            }
        }
    }

    private static void fillWithPages(Printable p) {
        if (p == null) {
            System.out.println("Operation denied. Literature wasn't selected.");
        } else {
            for (int i = 0; i < p.getAmountOfArticles(); ++i) {
                System.out.print("Element with index [" + i + "]\n");
                try {
                    if(!setElementOfLiterature(p, i)) {
                        i--;
                    }
                } catch (Exception exc) {
                    System.out.println(exc.getMessage());
                } finally {
                    System.out.println();
                }
            }
        }
    }

    private static boolean setElementOfLiterature(Printable p, int index) throws Exception {
        if (p == null) {
            throw new UnsupportedOperationException("Operation denied. Literature wasn't selected.");
        } else {
            try {
                System.out.print("Enter amount of pages in article: ");
                Scanner in = new Scanner(System.in);
                int amount = in.nextInt();
                p.setPagesInArticle(index, amount);
                return true;
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException exc) {
                System.out.print(exc.getMessage());
                return false;
            } catch (Exception exc) {
                throw new Exception(exc.getMessage());
            }
        }
    }

    private static void printPrintable(Printable p) {
        if (p == null) {
            System.out.println("Literature wasn't selected.");
        } else {
            System.out.printf("<<%s>>\n", p.getTitle());
            System.out.print(separator);
            System.out.println(p);
        }
    }

    static void printPrintableArray(Printable[] pArr) {
        System.out.print("Database: ");
        if (pArr == null) {
            System.out.println("wasn't selected.");
        } else {
            System.out.print(separator);

            for (int i = 0; i < pArr.length; ++i) {
                System.out.printf("[%d]", i);
                printPrintable(pArr[i]);
                System.out.print(separator + separator);
            }
        }
    }



    //todo: удалить, если будет не нужно.
    static void printPrintableArrayAsTitlesOfElements(Printable[] pArr) {
        System.out.print("база данных: ");
        if (pArr == null) {
            System.out.println("не задана");
        } else {
            System.out.print('\n' + separator);

            for (int i = 0; i < pArr.length; i++) {
                System.out.print("[" + i + "] ");
                if (pArr[i] == null) {
                    System.out.println("элемент не задан");
                } else {
                    System.out.println('«' + pArr[i].getTitle() + '»');
                }
            }
        }
    }

    private static void printElementsOfPrintable(Printable p) {
        if (p == null) {
            System.out.println("Literature wasn't selected.");
        } else {
            for (int i = 0; i < p.getAmountOfArticles(); ++i) {
                System.out.print(i + ") ");
                if (p.getPagesInArticle(i) == 0) {
                    System.out.println("Element isn't selected.");
                } else {
                    System.out.println(p.getPagesInArticle(i) + " — amount of pages in literature.");
                }
            }
        }
    }

    static Printable[] getPrintableArray() {
        int length;
        while (true) {
            length = getInt();

            if (length < Printable.MIN_AMOUNT_OF_ELEMENTS_IN_ARRAY) {
                System.out.println("Array must have length equal at least " + Printable.MIN_AMOUNT_OF_ELEMENTS_IN_ARRAY);
            } else if (length > Printable.MAX_AMOUNT_OF_ELEMENTS_IN_ARRAY) {
                System.out.println("Too big database.");
            } else {
                Printable[] pArr = new Printable[length];
                System.out.println("Array with length equal " + length + " was created successfully.");
                return pArr;
            }
        }
    }

    static void setElementOfPrintableArray(Printable[] db) {
        if (db == null) {
            System.out.println("Operation denied. Database wasn't selected.");
        } else {
            System.out.println("Enter index of element you want to change (starting from 0): ");
            int index = getIndex(db.length - 1);

            Scanner in = new Scanner(System.in);
            String str;

            System.out.print("Updating element with index " + index + "\n" + separator);
            while (true) {
                System.out.print("Select element type:" +
                        separator +
                        "1. " + Magazine.class.getName() + "\n" +
                        "2. " + Book.class.getName() + "\n" +
                        separator +
                        ">");
                str = in.nextLine();
                System.out.println();
                if (str.equals("1")) {
                   db[index] = addNewMagazine();
                   break;
                } else if (str.equals("2")) {
                    db[index] = addNewBook();
                    break;
                } else {
                    System.out.println("Error: invalid menu item.");
                }
            }
        }
    }

    private static int getAmountOfPagesInArticle() {
        int num;
        while (true) {
            num = getInt();
            if (num < Printable.MIN_AMOUNT_OF_PAGES) {
                System.out.println("Error: amount of pages must be higher than " + Printable.MIN_AMOUNT_OF_PAGES);
            } else if (num > Printable.MAX_AMOUNT_OF_PAGES) {
                System.out.println("There are too much pages.");
            } else {
                return num;
            }
        }
    }



    //todo: удалить то, что выше, если не нужно.

    static void getArrayWithTwoSameSumOfPagesWithoutIntro(Printable[] pArr) {
        Printable[] arrayWithTwoSameSumOfPagesWithoutIntro;

        try {
            arrayWithTwoSameSumOfPagesWithoutIntro = getPrintableArrayWithTwoSameSumOfPagesWithoutIntro(pArr);
            System.out.println("Database created successfully.\n");
            printPrintableArray(arrayWithTwoSameSumOfPagesWithoutIntro);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    static void splitArrayIntoTwoBooksAndMagazines(Printable[] pArr) {
        if (pArr == null) {
            System.out.println("Operation denied. Database wasn't selected.");
        } else {
            try {
                Magazine[] m = getMagazinesFromPrintableArray(pArr);
                Book[] b = getBooksFromPrintableArray(pArr);
                System.out.println("Split of database was successfull.");
                System.out.println();
                printPrintableArray(m);
                printPrintableArray(b);
            } catch (Exception exc) {
                System.out.println(exc.getMessage());
            }
        }
    }

    //todo: 417 строка.

    static void printOutputPrintableAsBytes(Printable p) {
        if (p == null) {
            System.out.println("Operation denied. Object wasn't selected.");
        } else {
            FileOutputStream fileOutputter;
            try {
                fileOutputter = new FileOutputStream(BYTES_FILE_WITH_SER);
                InputAndOutputPrintable.outputPrintableAsBytes(p, fileOutputter);
                fileOutputter.flush();
                fileOutputter.close();
                System.out.println("Object was wrote in byte stream successfully.");
            } catch (IOException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }

    static void printWritePrintableAsText(Printable p) {
        if (p == null) {
            System.out.println("Operation denied. Object wasn't selected.");
        } else {
            FileWriter fileWriter;
            try {
                fileWriter = new FileWriter(TEXT_FILE_WITH_SER);
                InputAndOutputPrintable.writePrintableAsText(p, fileWriter);
                fileWriter.flush();
                fileWriter.close();
                System.out.println("Object was wrote in text stream successfully ");
            } catch (IOException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }

    static void printSerializePrintable(Printable p) {
        if (p == null) {
            System.out.println("Operation denied. Object wasn't selected.");
        } else {
            FileOutputStream fileOutputter;
            try {
                fileOutputter = new FileOutputStream(SERIALIZED_FILE_WITH_SER);
                InputAndOutputPrintable.serializePrintable(p, fileOutputter);
                fileOutputter.flush();
                fileOutputter.close();
                System.out.println("Object was serialized successfully.");
            } catch (IOException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }

    static void printOutputPrintableArrayAsBytes(Printable[] pArr) {
        if (pArr == null) {
            System.out.println("Operation denied. Array wasn't selected.");
        } else {
            FileOutputStream fileOutputter;
            try {
                fileOutputter = new FileOutputStream(BYTES_FILE_WITH_SER_ARR);
                outputPrintableArrayAsBytes(pArr, fileOutputter);
                fileOutputter.flush();
                fileOutputter.close();
                System.out.println("Object was wrote in byte stream successfully.");
            } catch (IOException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }

    static void printWritePrintableArrayAsText(Printable[] pArr) {
        if (pArr == null) {
            System.out.println("Operation denied. Array wasn't selected.");
        } else {
            FileWriter fileWriter;
            try {
                fileWriter = new FileWriter(TEXT_FILE_WITH_SER_ARR);
                writePrintableArrayAsText(pArr, fileWriter);
                fileWriter.flush();
                fileWriter.close();
                System.out.println("Array was wrote in text stream successfully.");
            } catch (IOException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }

    static void printSerializePrintableArray(Printable[] pArr) {
        if (pArr == null) {
            System.out.println("Operation denied. Array wasn't selected.");
        } else {
            FileOutputStream fileOutputter;
            try {
                fileOutputter = new FileOutputStream(SERIALIZED_FILE_WITH_SER_ARR);
                serializePrintableArray(pArr, fileOutputter);
                fileOutputter.flush();
                fileOutputter.close();
                System.out.println("Array was serialized successfully.");
            } catch (IOException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }

    static Printable printInputBytesAsPrintable() throws NullObjectException {
        Printable p = null;
        FileInputStream fInput;
        try {
            fInput = new FileInputStream(BYTES_FILE_WITH_SER);
            p = inputBytesAsPrintable(fInput);
            fInput.close();

            System.out.println("Object was successfully reed from read from byte stream.");
        } catch (IOException | NullObjectException | ClassNotFoundException exc) {
            System.out.print(exc.getMessage());
        }

        if (p == null) {
            throw new NullObjectException("Can't read Printable.");
        }

        return p;
    }

    static Printable printReadTextAsPrintable() throws NullObjectException {
        Printable p = null;
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(TEXT_FILE_WITH_SER);
            bufferedReader = new BufferedReader(fileReader);
            p = readTextAsPrintable(bufferedReader);
            bufferedReader.close();
            fileReader.close();
            System.out.println("Object was read from text stream successfully.");
        } catch (IOException | NullObjectException | ClassNotFoundException exc) {
            System.out.println(exc.getMessage());
        }
        if (p == null) {
            throw new NullObjectException("Can't read Printable.");
        }
        return p;
    }

    static Printable printDeserializePrintable() throws NullObjectException {
        Printable p = null;
        FileInputStream fileInputter;
        try {
            fileInputter = new FileInputStream(SERIALIZED_FILE_WITH_SER);
            p = deserializePrintable(fileInputter);
            fileInputter.close();
            System.out.println("Object was deserialized from file successfully.");
        } catch (IOException | NullObjectException exc) {
            System.out.println(exc.getMessage());
        }
        if (p == null) {
            throw new NullObjectException("Can't read Printable.");
        }
        return p;
    }

    static Printable[] printInputBytesAsPrintableArray() throws NullObjectException  {
        Printable[] pArr = null;
        FileInputStream fileInputter;
        try {
            fileInputter = new FileInputStream(BYTES_FILE_WITH_SER_ARR);
            pArr = inputByteAsPrintableArray(fileInputter);
            fileInputter.close();
            System.out.println("Object was read from byte stream successfully.");
        } catch (IOException | NullObjectException | ClassNotFoundException exc) {
            System.out.println(exc.getMessage());
        }
        if (pArr == null) {
            throw new NullObjectException("Can't read Printable array.");
        }
        return pArr;
    }

    static Printable[] printReadTextAsPrintableArray() throws NullObjectException {
        Printable[] pArr = null;
        FileReader fileReader;
        try {
            fileReader = new FileReader(TEXT_FILE_WITH_SER_ARR);
            pArr = readTextAsPrintableArray(fileReader);
            fileReader.close();
            System.out.println("Object was read from text stream successfully.");
        } catch (IOException | NullObjectException | ClassNotFoundException exc) {
            System.out.println(exc.getMessage());
        }
        if (pArr == null) {
            throw new NullObjectException("Can't read Printable array.");
        }
        return pArr;
    }

    static Printable[] printDeserializePrintableArray() throws NullObjectException {
        Printable[] pArr = null;
        FileInputStream fileInputter;
        try {
            fileInputter = new FileInputStream(SERIALIZED_FILE_WITH_SER_ARR);
            pArr = deserializePrintableArray(fileInputter);
            fileInputter.close();
            System.out.println("Array was deserialized successfully.");
        } catch (IOException | NullObjectException exc) {
            System.out.println(exc.getMessage());
        }
        if (pArr == null) {
            throw new NullObjectException("Can't deserialize Printable array.");
        }
        return pArr;
    }
}
