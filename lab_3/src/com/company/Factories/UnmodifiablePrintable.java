package com.company.Factories;

import com.company.Prints.Printable;
import org.jetbrains.annotations.NotNull;

import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;

public class UnmodifiablePrintable implements Printable {

    private final Printable p;

    public UnmodifiablePrintable(Printable p) {
        this.p = p;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public void setTitle(String title) {
        throw new UnsupportedOperationException("Unsupported operation.");
    }

    @Override
    public int getAmountOfArticles() {
        return 0;
    }

    @Override
    public int getAmountOfIntroducingPages() {
        return 0;
    }

    @Override
    public void setAmountOfIntroducingPages(int number) {
        throw new UnsupportedOperationException("Unsupported operation.");
    }

    @Override
    public int getPagesInArticle(int index) {
        return 0;
    }

    @Override
    public void setPagesInArticle(int index, int number) {
        throw new UnsupportedOperationException("Unsupported operation.");
    }

    @Override
    public int getPagesInAllArticles() {
        return 0;
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public int getSumOfPagesWithoutIntro() {
        return 0;
    }

    @Override
    public void outputAsBytes(OutputStream out) {
        p.outputAsBytes(out);
    }

    @Override
    public void writeAsText(Writer out) {
        p.writeAsText(out);
    }

    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        return p.iterator();
    }
}
