package com.company.Prints;

import java.io.OutputStream;
import java.io.Writer;

public interface Printable{

    int MIN_AMOUNT_OF_ELEMENTS_IN_ARRAY = 1;                    //minimal length of each array;
    int MAX_AMOUNT_OF_ELEMENTS_IN_ARRAY = 6;                    //maximum length of each array;

    int MIN_AMOUNT_OF_INTRODUCING_PAGES = 1;                    //minimal amount of introducing pages;
    int MAX_AMOUNT_OF_INTRODUCING_PAGES = 100;                  //maximum amount of introducing pages;

    int MIN_AMOUNT_OF_PAGES = 1;                                //minimal amount of pages in each article;
    int MAX_AMOUNT_OF_PAGES = 1000;                             //maximum amount of pages in each article;

    String getTitle();
    void setTitle(String title);

    int getAmountOfArticles();

    int getAmountOfIntroducingPages();
    void setAmountOfIntroducingPages(int number);

    int getPagesInArticle(int index);
    void setPagesInArticle(int index, int number);

    int getPagesInAllArticles();

    String getInfo();

    int getSumOfPagesWithoutIntro();

    void outputAsBytes(OutputStream out);                   //method for output object from bytes stream;
    void writeAsText(Writer out);                           //method for writting object from text stream;
}