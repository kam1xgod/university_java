package com.company.Prints;

import java.io.OutputStream;
import java.io.Writer;
import java.util.Arrays;


public class Magazine implements Printable {

                                                                            //pagesInArticles — массив;
                                                                            //title — название;
                                                                            //introducingPages — кол-во страниц с введением;
                                                                            //getInfo — функциональный метод.

    int[] pagesInArticles;
    String title;
    int introducingPages;

    Magazine() {}                                                                   //конструктор по умолчанию.

    public Magazine(String title, int numberOfArticles, int introducingPages) {     //конструктор с параметрами,
                                                                                    //позволяющими полностью
                                                                                    //инициализировать объект.
        this.title                      = title;
        this.pagesInArticles            = new int[numberOfArticles];
        this.introducingPages           = introducingPages;
    }

                                                                                //[
                                                                                //
                                                                                //
                                                                                //NAME;
                                                                                //
                                                                                //
                                                                                //]

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

                                                                                //[
                                                                                //
                                                                                //
                                                                                //PAGES;
                                                                                //
                                                                                //
                                                                                //]


    public int getAmountOfArticles() {
        return pagesInArticles.length;
    }

    public int getAmountOfIntroducingPages() {
        return this.introducingPages;
    }

    public void setAmountOfIntroducingPages(int number) {
        this.introducingPages = number;
    }

    public int getPagesInArticle(int index) {
            if (index < 0 | index >= pagesInArticles.length) {
                throw new IllegalArgumentException();
            }

            return pagesInArticles[index];
    }

    public void setPagesInArticle(int index, int number) {
        this.pagesInArticles[index] = number;
    }

    public int getPagesInAllArticles() {
        int result = 0;
        for (int pagesInArticle : pagesInArticles) {
            result += pagesInArticle;
        }
        return result;
    }

                                                                                    //[
                                                                                    //
                                                                                    //
                                                                                    //FUNCTIONAL METHOD;
                                                                                    //
                                                                                    //
                                                                                    //]

    public int getSumOfPagesWithoutIntro() {                                       //метод, возвращающий кол-во страниц
                                                                                   //(без вводных) в журнале.
        int result = 0;

        for (int i = 1; i != this.pagesInArticles.length; ++i)
        {
            result += this.pagesInArticles[i];
        }

        return result - this.introducingPages;
    }

    public String getInfo() {
                                                                                    // Этот метод выводит
                                                                                    // информацию о журнале:
                                                                                    // название, кол-во статей,
                                                                                    // страниц в каждой из них,
                                                                                    // страниц с полезной информацией
                                                                                    // и кол-во страниц с
                                                                                    // бесполезной информацией.
        return "\nIn magazine " + getTitle() + " we have: "+ getAmountOfArticles() + " articles in total. "
                + getPagesInAllArticles() + " pages in each of them. "
                + "In total there are: " + getSumOfPagesWithoutIntro() + " pages. "
                + introducingPages + " more are have introducing info.";
    }

    @Override
    public void outputAsBytes(OutputStream out) {

    }

    @Override
    public void writeAsText(Writer out) {

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Magazine mag = (Magazine) obj;
        return pagesInArticles == mag.pagesInArticles
                && introducingPages == mag.introducingPages
                && (title.equals(mag.title) || title.equals(mag.getTitle()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + introducingPages;
        result = prime * result + ((pagesInArticles == null) ? 0 : Arrays.hashCode(pagesInArticles));
        return result;
    }

    @Override
    public String toString() {
        return "Book[" +
                "name = " + title +
                "; pages in each article = " + Arrays.toString(pagesInArticles) +
                "; introducing pages = " + introducingPages +
                "]";
    }
}
