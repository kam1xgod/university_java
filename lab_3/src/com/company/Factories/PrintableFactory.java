package com.company.Factories;

import com.company.Prints.Printable;

public interface PrintableFactory {
    Printable createInstance();

    Printable createInstance(String title, int amountOfArticles, int amountOfIntroPages);
}
