package com.company.Factories;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class AmountOfPagesIterator implements Iterator<Integer> {

    int[] amountOfPagesInArticle;
    int curPos;

    public AmountOfPagesIterator(int[] amountOfPagesInArticle) {
        this.amountOfPagesInArticle = amountOfPagesInArticle;
        curPos = 0;
    }

    @Override
    public boolean hasNext() {
        return curPos < amountOfPagesInArticle.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        int next = amountOfPagesInArticle[curPos];
        curPos++;

        return next;
    }
}
