package com.company.Factories;

import com.company.Prints.Book;

public class BookPrintFactory implements PrintableFactory{
    @Override
    public Book createInstance() {
        return new Book();
    }

    @Override
    public Book createInstance(String title, int amountOfArticles, int amountOfIntroPages) {
        return new Book(title, amountOfArticles, amountOfIntroPages);
    }
}
