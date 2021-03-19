package com.company;

import java.io.OutputStream;
import java.io.Writer;
import java.util.Arrays;
import java.util.Scanner;

public class Magazine implements Printable {

                                                                            //pages_in_articles — массив;
                                                                            //name — название;
                                                                            //useless_pages — кол-во страниц с введением;
                                                                            //amountOfUsefulInfo — функциональный метод.

    int[] pages_in_articles;
    String name;
    int useless_pages;

    Magazine() {}                                                           //конструктор по умолчанию.

    Magazine(int[] pages_in_articles) {                                     //конструктор с параметрами,
                                                                            //позволяющими полностью
                                                                            //инициализировать объект.
        this.name                       = setName();
        this.pages_in_articles          = new int[setLength()];
        setPages(pages_in_articles);
        this.useless_pages              = this.pages_in_articles[0];
    }

                                                                                //[
                                                                                //
                                                                                //
                                                                                //NAME;
                                                                                //
                                                                                //
                                                                                //]

    public String setName() {
        System.out.print("\nPlease, enter the name of magazine you want to add:\n>");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        if (name.equals(""))
            name = "unnamed";
        return name;
    }

    public String getName() {
        return name;
    }

                                                                                //[
                                                                                //
                                                                                //
                                                                                //PAGES;
                                                                                //
                                                                                //
                                                                                //]

    public int setLength() {                                                    //метод, устанавливающий длину массива
        System.out.print("\nPlease, enter amount of articles in magazine:\n>");  //значением из консоли.
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        if (length <= 0)
            throw new IllegalArgumentException("\nThere are can't be zero articles in magazine.\n");
        else
            return length;
    }

    public void setPages(int[] pages_in_articles) {                             //метод, задающий кол-во страниц
                                                                                //в каждой статье.
        System.out.print("\nPlease, enter amount of pages on each article:\n");
        Scanner in = new Scanner(System.in);

        for (int i = 0; i != this.pages_in_articles.length; ++i)
        {
            System.out.print(">");
            int buf = in.nextInt();
            if (buf <= 0)
                throw new IllegalArgumentException("\nThere are can't be zero pages in article.\n");
            else
                this.pages_in_articles[i] = buf;
        }

    }

    public int getLength() {
        return pages_in_articles.length;
    }

    public String getPages(int[] pages_in_articles) {
        return Arrays.toString(pages_in_articles);
    }

                                                                                    //[
                                                                                    //
                                                                                    //
                                                                                    //FUNCTIONAL METHOD;
                                                                                    //
                                                                                    //
                                                                                    //]

    public int amountOfUsefulInfo(int[] pages_in_articles) {                       //метод, возвращающий кол-во страниц
                                                                                   //в журнале.
        int result = 0;

        for (int i = 1; i != this.pages_in_articles.length; ++i)
        {
            result += pages_in_articles[i];
        }

        return result;
    }

    public String printInfo() {
                                                                        // Этот метод выводит
                                                                        // информацию о журнале:
                                                                        // название, кол-во статей,
                                                                        // страниц в каждой из них,
                                                                        // страниц с полезной информацией
                                                                        // и кол-во страниц с бесполезной информацией.
        return "\nIn magazine " + getName() + " we have: "+ getLength() + " articles in total. "
                + getPages(pages_in_articles) + " pages in each of them. "
                + "In total there are: " + amountOfUsefulInfo(pages_in_articles) + " pages. "
                + useless_pages + " more are have introducing info.";
    }

    @Override
    public void output(OutputStream out) {

    }

    @Override
    public void write(Writer out) {

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
        return pages_in_articles == mag.pages_in_articles
                && useless_pages == mag.useless_pages
                && (name == mag.name
                || (name != null && name.equals(mag.getName())
        ));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + useless_pages;
        result = prime * result + ((pages_in_articles == null) ? 0 : Arrays.hashCode(pages_in_articles));
        return result;
    }

    @Override
    public String toString() {
        return "Book [attribute=" + useless_pages + "]";
    }
}
