package com.company.Factories;

import com.company.Prints.Printable;
import org.jetbrains.annotations.NotNull;

import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;

public class SynchronizedPrintable implements Printable {

    private final Printable p;

    public SynchronizedPrintable(Printable p) {
        this.p = p;
    }

    @Override
    public synchronized String getTitle() {
        return p.getTitle();
    }

    @Override
    public synchronized void setTitle(String title) {
        p.setTitle(title);
    }

    @Override
    public synchronized int getAmountOfArticles() {
        return p.getAmountOfArticles();
    }

    @Override
    public synchronized int getAmountOfIntroducingPages() {
        return p.getAmountOfIntroducingPages();
    }

    @Override
    public synchronized void setAmountOfIntroducingPages(int number) {
        p.setAmountOfIntroducingPages(number);
    }

    @Override
    public synchronized int getPagesInArticle(int index) {
        return p.getPagesInArticle(index);
    }

    @Override
    public synchronized void setPagesInArticle(int index, int number) {
        p.setPagesInArticle(index, number);
    }

    @Override
    public synchronized int getPagesInAllArticles() {
        return p.getPagesInAllArticles();
    }

    @Override
    public synchronized String getInfo() {
        return p.getInfo();
    }

    @Override
    public synchronized int getSumOfPagesWithoutIntro() {
        return p.getSumOfPagesWithoutIntro();
    }

    @Override
    public synchronized void outputAsBytes(OutputStream out) {
        p.outputAsBytes(out);
    }

    @Override
    public synchronized void writeAsText(Writer out) {
        p.writeAsText(out);
    }

    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}
