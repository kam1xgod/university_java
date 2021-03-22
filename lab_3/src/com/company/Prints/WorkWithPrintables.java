package com.company.Prints;

import com.company.Exceptions.DatabaseNotSelectedException;

import java.util.LinkedList;
import java.util.NoSuchElementException;

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

    public static Printable[] getPrintableArrayWithTwoSameSumOfPagesWithoutIntro (Printable[]pArr)
            throws DatabaseNotSelectedException {
        if (pArr == null) {
            throw new DatabaseNotSelectedException("Operation denied. Database wasn't selected.");
        } else {
            int[] sumOfPagesWithoutIntro = getSumOfPagesWithoutIntro(pArr);
            int currentIndexOfSum;
            int indexToCompareWith;
            int length = sumOfPagesWithoutIntro.length;

            for (currentIndexOfSum = 0; currentIndexOfSum < length; ++currentIndexOfSum) {
                for (indexToCompareWith = currentIndexOfSum + 1; indexToCompareWith < length; ++indexToCompareWith) {
                    if (sumOfPagesWithoutIntro[currentIndexOfSum] == sumOfPagesWithoutIntro[indexToCompareWith]) {
                        Printable[] twoSameSumOfPagesWithoutIntro = new Printable[2];
                        twoSameSumOfPagesWithoutIntro[0] = pArr[currentIndexOfSum];
                        twoSameSumOfPagesWithoutIntro[1] = pArr[indexToCompareWith];
                        return twoSameSumOfPagesWithoutIntro;
                    }
                }
            }
            throw  new NoSuchElementException("No such elements.");
        }
    }

}


