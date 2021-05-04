package com.company.Prints;

import com.company.Exceptions.DatabaseNotSelectedException;
import com.company.Factories.BookPrintFactory;
import com.company.Factories.PrintableFactory;
import com.company.Factories.SynchronizedPrintable;
import com.company.Factories.UnmodifiablePrintable;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class WorkWithPrintables {

    private static LinkedList<Integer> getIndexesOfArticlesInMagazine(Printable[] pArr) throws DatabaseNotSelectedException {
        if (pArr == null) {
            throw new DatabaseNotSelectedException("Operation denied. Database wasn't selected.");
        } else {
            LinkedList<Integer> indexesOfArticles = new LinkedList<>();

            for (int i = 0; i < pArr.length; ++i) {
                if (pArr[i] instanceof Magazine) {
                    indexesOfArticles.add(i);
                }
            }
            return indexesOfArticles;
        }
    }

    private static LinkedList<Integer> getIndexesOfArticlesInBook(Printable[] pArr) throws DatabaseNotSelectedException {
        if (pArr == null) {
            throw new DatabaseNotSelectedException("Operation denied. Database wasn't selected.");
        } else {
            LinkedList<Integer> indexesOfArticles = new LinkedList<>();

            for (int i = 0; i < pArr.length; ++i) {
                if (pArr[i] instanceof Book) {
                    indexesOfArticles.add(i);
                }
            }
            return indexesOfArticles;
        }
    }

    public static Magazine[] getMagazinesFromPrintableArray(Printable[] pArr) throws DatabaseNotSelectedException {
        if (pArr == null) {
            throw new DatabaseNotSelectedException("Operation denied. Database wasn't selected.");
        } else {
            LinkedList<Integer> indexesOfMagazines = getIndexesOfArticlesInMagazine(pArr);
            Magazine[] m = new Magazine[indexesOfMagazines.size()];

            for (int i = 0; i < m.length; ++i) {
                m[i] = (Magazine) pArr[indexesOfMagazines.get(i)];
            }
            return m;
        }
    }

    public static Book[] getBooksFromPrintableArray(Printable[] pArr) throws DatabaseNotSelectedException {
        if (pArr == null) {
            throw new DatabaseNotSelectedException("Operation denied. Database wasn't selected.");
        } else {
            LinkedList<Integer> indexesOfBooks = getIndexesOfArticlesInBook(pArr);
            Book[] b = new Book[indexesOfBooks.size()];

            for (int i = 0; i < b.length; ++i) {
                b[i] = (Book) pArr[indexesOfBooks.get(i)];
            }
            return b;
        }
    }

    private static int[] getSumOfPagesWithoutIntro(Printable[] pArr) throws DatabaseNotSelectedException {
        if (pArr == null) {
            throw new DatabaseNotSelectedException("Operation denied. Database wasn't selected.");
        } else {
            int[] sumOfPagesWithoutIntro = new int[pArr.length];

            for (int i = 0; i < sumOfPagesWithoutIntro.length; ++i) {
                sumOfPagesWithoutIntro[i] = pArr[i].getSumOfPagesWithoutIntro();
            }
            return sumOfPagesWithoutIntro;
        }
    }

    public static List<Printable[]> getPrintableArrayWithSameSumOfPagesWithoutIntro(Printable[] pArr)
            throws DatabaseNotSelectedException {
        if (pArr == null) {
            throw new DatabaseNotSelectedException("Operation denied. Database wasn't selected.");
        } else {
            List<Printable[]> sameSumOfPagesWithoutIntro = new ArrayList<>();

            int[] sumOfPagesWithoutIntro = getSumOfPagesWithoutIntro(pArr);
            boolean[] check = new boolean[pArr.length];
            Arrays.fill(check, Boolean.TRUE);
            int currentIndexOfSum;
            int indexToCompareWith;
            int length = sumOfPagesWithoutIntro.length;

            List<Printable> temp = new ArrayList<Printable>();

            for (currentIndexOfSum = 0; currentIndexOfSum < length; ++currentIndexOfSum) {
                temp.add(pArr[currentIndexOfSum]);
                for (indexToCompareWith = currentIndexOfSum + 1; indexToCompareWith < length; ++indexToCompareWith) {
                    if (sumOfPagesWithoutIntro[currentIndexOfSum] == sumOfPagesWithoutIntro[indexToCompareWith]) {
                        if (check[indexToCompareWith] == true) {
                            temp.add(pArr[indexToCompareWith]);
                            check[indexToCompareWith] = false;
                        }
                    }
                }
                if (temp.size() != 1) {
                    Printable[] sameObject = new Printable[temp.size()];
                    for (int i = 0; i < temp.size(); ++i) {
                        sameObject[i] = temp.get(i);
                    }
                    sameSumOfPagesWithoutIntro.add(sameObject);
                }
                temp.clear();
            }
            if (sameSumOfPagesWithoutIntro == null) {
                throw  new NoSuchElementException("No such elements.");
            }

            return sameSumOfPagesWithoutIntro;
        }
    }

    private static PrintableFactory factory = new BookPrintFactory();

    public static void setPrintableFactory(PrintableFactory pf) {
        factory = pf;
    }

    public static Printable createInstance() {
        return factory.createInstance();
    }

    public static Printable createInstance(String title, int amountOfArticles, int amountOfIntroPages) {
        return factory.createInstance(title, amountOfArticles, amountOfIntroPages);
    }

    public static Printable getSynchroPrint(Printable p) {
        return new SynchronizedPrintable(p);
    }

    public static Printable getUnmodifiablePrintable(Printable p) {
        return new UnmodifiablePrintable(p);
    }
}


