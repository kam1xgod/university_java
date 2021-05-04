package com.company.Threads;

import com.company.Prints.Printable;

import java.util.Random;

public class WritingThread extends Thread {
    private Printable p;

    public WritingThread(Printable p) {
        this.p = p;
    }

    public void runThread() {
        if (p == null) {
            System.out.println("Operation denied: object wasn't selected.");
            return;
        }

        int amountOfPages;
        for (int i = 0; i < p.getAmountOfArticles(); ++i) {
            Random rand = new Random();
            amountOfPages = Printable.MIN_AMOUNT_OF_PAGES + rand.nextInt(Printable.MAX_AMOUNT_OF_PAGES-Printable.MIN_AMOUNT_OF_INTRODUCING_PAGES + 1);
            p.setPagesInArticle(i, amountOfPages);
            System.out.println("Write " + amountOfPages + " to position " + i);
        }
    }
}
