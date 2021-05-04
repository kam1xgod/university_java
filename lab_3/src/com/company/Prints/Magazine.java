package com.company.Prints;

import com.company.Factories.AmountOfPagesIterator;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class Magazine implements Printable, Serializable {

                                                                            //pagesInArticles — массив;
                                                                            //title — название;
                                                                            //introducingPages — кол-во страниц с введением;
                                                                            //getInfo — функциональный метод.

    int[] pagesInArticles;
    String title;
    int introducingPages;

    public Magazine() {}                                                                   //конструктор по умолчанию.

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

        return result;
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
        DataOutputStream dataOutputter = new DataOutputStream(out);

        try {
            dataOutputter.writeUTF(getClass().getName());
            dataOutputter.writeUTF(title);
            dataOutputter.writeInt(introducingPages);
            dataOutputter.writeInt(getAmountOfArticles());

            for (int pages:
                    pagesInArticles) {
                dataOutputter.writeInt(pages);
            }
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }

    @Override
    public void writeAsText(Writer out) {
        PrintWriter printer = new PrintWriter(out);

        printer.println(getClass().getName());
        printer.println(title);
        printer.println(introducingPages);
        printer.println(getAmountOfArticles());

        for (int pages:
             pagesInArticles) {
            printer.println(pages);
        }

        printer.flush();
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
        return "Magazine\n[ " +
                "name = " + title + "; pages in each article = " + Arrays.toString(pagesInArticles) +
                "; introducing pages = " + introducingPages +
                "]";
    }

    @Override
    public Iterator<Integer> iterator() {
        return new AmountOfPagesIterator(this.pagesInArticles);
    }
}
