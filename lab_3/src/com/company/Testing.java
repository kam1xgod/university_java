package com.company;

import com.company.Prints.Book;
import com.company.Prints.Magazine;
import com.company.Prints.Printable;

import java.util.Random;

public class Testing {
    private static final String TITLE_1 = "First title";
    private static final String TITLE_2 = "Second title";
    private static final String TITLE_3 = "Third title";
    private static final String TITLE_4 = "Fourth title";
    private static final String TITLE_5 = "Fifth title";

    private static int getRandomInt(int min, int max) {
        int result;
        Random rand = new Random();
        result = min + rand.nextInt(max-min + 1);
        return result;
    }

    private static int getRandomAmountOfPages() {
        return getRandomInt(Printable.MIN_AMOUNT_OF_PAGES, Printable.MAX_AMOUNT_OF_PAGES);
    }

    private static int getRandomAmountOfIntroducingPages() {
        return getRandomInt(Printable.MIN_AMOUNT_OF_INTRODUCING_PAGES, Printable.MAX_AMOUNT_OF_INTRODUCING_PAGES);
    }

    private static Printable getPrintableWithRandomGeneratedType(String title, int amountOfIntroducingPages, int amountOfArticles) {
        Printable p;
        int choice = getRandomInt(1, 2);
        if (choice == 1) {
            p = new Magazine(title, amountOfArticles, amountOfIntroducingPages);
        } else {
            p = new Book(title, amountOfArticles, amountOfIntroducingPages);
        }

        return p;
    }

    private static Printable[] createPrintableArrayWithFileElements() {
        final int articles = 5;
        Printable[] p = new Printable[articles];
        p[0] = getPrintableWithRandomGeneratedType(TITLE_1, getRandomAmountOfIntroducingPages(), articles);
        p[1] = getPrintableWithRandomGeneratedType(TITLE_2, getRandomAmountOfIntroducingPages(), articles);
        p[2] = getPrintableWithRandomGeneratedType(TITLE_3, getRandomAmountOfIntroducingPages(), articles);
        p[3] = getPrintableWithRandomGeneratedType(TITLE_4, getRandomAmountOfIntroducingPages(), articles);
        p[4] = getPrintableWithRandomGeneratedType(TITLE_5, getRandomAmountOfIntroducingPages(), articles);
        return p;
    }

    static Printable[] createAndFillDbWithFiveElementsAutomatically() {
        Printable[] pArr = createPrintableArrayWithFileElements();
        setPagesInArticlesInPrintableArray(pArr);
        System.out.println("Database was created and filled successfully.");
        return pArr;
    }

    private static void setPagesInArticlesInPrintableArray(Printable[] pArr) {
        final int index0 = 0;
        final int index1 = 1;
        final int index2 = 2;
        final int index3 = 3;
        final int index4 = 4;

        pArr[index0].setPagesInArticle(index0, getRandomAmountOfPages());
        pArr[index0].setPagesInArticle(index1, getRandomAmountOfPages());
        pArr[index0].setPagesInArticle(index2, getRandomAmountOfPages());
        pArr[index0].setPagesInArticle(index3, getRandomAmountOfPages());
        pArr[index0].setPagesInArticle(index4, getRandomAmountOfPages());

        pArr[index1].setPagesInArticle(index0, getRandomAmountOfPages());
        pArr[index1].setPagesInArticle(index1, getRandomAmountOfPages());
        pArr[index1].setPagesInArticle(index2, getRandomAmountOfPages());
        pArr[index1].setPagesInArticle(index3, getRandomAmountOfPages());
        pArr[index1].setPagesInArticle(index4, getRandomAmountOfPages());

        pArr[index2].setPagesInArticle(index0, getRandomAmountOfPages());
        pArr[index2].setPagesInArticle(index1, getRandomAmountOfPages());
        pArr[index2].setPagesInArticle(index2, getRandomAmountOfPages());
        pArr[index2].setPagesInArticle(index3, getRandomAmountOfPages());
        pArr[index2].setPagesInArticle(index4, getRandomAmountOfPages());

        pArr[index3].setPagesInArticle(index0, getRandomAmountOfPages());
        pArr[index3].setPagesInArticle(index1, getRandomAmountOfPages());
        pArr[index3].setPagesInArticle(index2, getRandomAmountOfPages());
        pArr[index3].setPagesInArticle(index3, getRandomAmountOfPages());
        pArr[index3].setPagesInArticle(index4, getRandomAmountOfPages());

        pArr[index4].setPagesInArticle(index0, getRandomAmountOfPages());
        pArr[index4].setPagesInArticle(index1, getRandomAmountOfPages());
        pArr[index4].setPagesInArticle(index2, getRandomAmountOfPages());
        pArr[index4].setPagesInArticle(index3, getRandomAmountOfPages());
        pArr[index4].setPagesInArticle(index4, getRandomAmountOfPages());
    }

    static Printable createAndFillPrintableAutomatically() {
        Printable p;
        p = getPrintableWithRandomGeneratedType(TITLE_1, getRandomAmountOfIntroducingPages(), 5);
        p.setPagesInArticle(0, getRandomAmountOfPages());
        p.setPagesInArticle(1, getRandomAmountOfPages());
        p.setPagesInArticle(2, getRandomAmountOfPages());
        p.setPagesInArticle(3, getRandomAmountOfPages());
        p.setPagesInArticle(4, getRandomAmountOfPages());
        System.out.println("Object was created and filled successfully.");
        return p;
    }

    static void setTwoPrintableWithSameSumOfPagesWithoutStart(Printable[] pArr) {
        int lastIndex = pArr.length - 1;
        int firstIndex = getRandomInt(0, lastIndex);
        int secondIndex = getRandomInt(0, lastIndex);

        Printable p1 = pArr[firstIndex];
        Printable p2 = pArr[secondIndex];
        int sameNumOfPages;
        for (int i = 0; i < p1.getAmountOfArticles(); ++i) {
            sameNumOfPages = p1.getPagesInArticle(i);
            p2.setPagesInArticle(i, sameNumOfPages);
        }
        System.out.println("Database was created and filled successfully.");
    }
}
