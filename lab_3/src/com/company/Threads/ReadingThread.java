package com.company.Threads;

import com.company.Prints.Printable;

import java.util.concurrent.ThreadPoolExecutor;

public class ReadingThread extends Thread {
    private Printable p;

    public ReadingThread(Printable p) {
        this.p = p;
    }

    public void runThread() {
        if (p == null) {
            System.out.println("Operation denied: object wasn't selected.");
            return;
        }

        for (int i = 0; i < p.getAmountOfArticles(); ++i) {
            System.out.println("Read: " + p.getPagesInArticle(i) + " from position " + i);
        }
    }
}
