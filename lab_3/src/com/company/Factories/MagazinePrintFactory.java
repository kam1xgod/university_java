package com.company.Factories;

import com.company.Prints.Magazine;

public class MagazinePrintFactory implements  PrintableFactory{

    @Override
    public Magazine createInstance() {
        return new Magazine();
    }

    @Override
    public Magazine createInstance(String title, int amountOfArticles, int amountOfIntroPages) {
        return new Magazine(title, amountOfArticles, amountOfIntroPages);
    }
}
