package com.company;

import java.io.OutputStream;
import java.io.Writer;
import java.util.Arrays;
import java.util.Scanner;

public class Book implements Printable {

                                                                           //pages_in_chapter — массив;
                                                                           //name — название;
                                                                           //useless_pages — кол-во страниц с введением;
                                                                           //amountOfPages — функциональный метод.

    int[] pages_in_chapter;
    String name;
    int useless_pages;

    Book() {}                                                               //конструктор по умолчанию.

    Book(int[] pages_in_chapter){                                           //конструктор с параметрами,
                                                                           // позволяющими полностью
                                                                           // инициализировать объект.
        this.name                       = setName();
        this.pages_in_chapter           = new int[setLength()];
        setPages(pages_in_chapter);
        this.useless_pages              = this.pages_in_chapter[0];
    }

                                                                            //[
                                                                            //
                                                                            //
                                                                            //NAME;
                                                                            //
                                                                            //
                                                                            //]

    public String setName() {
        System.out.print("\nPlease, enter the name of book you want to add:\n>");
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

    public int setLength() {                                                 //метод, устанавливающий длину массива
        System.out.print("\nPlease, enter amount of articles in book:\n>");   //значением из консоли.
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        if (length <= 0)
            throw new IllegalArgumentException("\nThere are can't be zero chapters in book.\n");
        else
            return length;
    }

    public void setPages(int[] pages_in_chapter) {                          //метод, задающий кол-во страниц
                                                                             //в каждой главе.
        System.out.print("\nPlease, enter amount of pages on each chapter:\n");
        Scanner in = new Scanner(System.in);

        for (int i = 0; i != this.pages_in_chapter.length; ++i)
        {
            System.out.print(">");
            int buf = in.nextInt();
            if (buf <= 0)
                throw new IllegalArgumentException("\nThere are can't be zero pages in chapter.\n");
            else
                this.pages_in_chapter[i] = buf;
        }

    }

    public int getLength() {
        return pages_in_chapter.length;
    }

    public String getPages(int[] pages_in_chapter) {
        return Arrays.toString(pages_in_chapter);
    }

                                                                                //[
                                                                                //
                                                                                //
                                                                                //FUNCTIONAL METHOD;
                                                                                //
                                                                                //
                                                                                //]

    public int amountOfPages(int[] pages_in_chapter) {                       //метод, возвращающий кол-во страниц
                                                                              //в книге.
        int result = 0;

        for (int i = 0; i != this.pages_in_chapter.length; ++i)
        {
            result += pages_in_chapter[i];
        }

        return result;
    }

    public String printInfo() {
                                                                                        // это метод, выводящий
                                                                                        // информацию о книге:
                                                                                        // название, кол-во глав,
                                                                                        // страниц в каждой из них,
                                                                                        // страниц всего
                                                                                        // и сколько из них не имеют
                                                                                        // особой ценности.

        return "\nIn book " + getName() + " we have: "+ getLength() + " chapters in total. "
                + getPages(pages_in_chapter) + " pages in each of them. "
                + "In total there are: " + amountOfPages(pages_in_chapter) + " pages. "
                + useless_pages + " of them are have introducing info.";
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

        Book book = (Book) obj;
        return pages_in_chapter == book.pages_in_chapter
                && useless_pages == book.useless_pages
                && (name == book.name
                || (name != null && name.equals(book.getName())
        ));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + useless_pages;
        result = prime * result + ((pages_in_chapter == null) ? 0 : pages_in_chapter.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Book [attribute=" + useless_pages + "]";
    }
}
