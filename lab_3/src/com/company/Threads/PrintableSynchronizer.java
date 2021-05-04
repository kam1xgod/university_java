package com.company.Threads;

import com.company.Prints.Printable;

public class PrintableSynchronizer {
    private final Printable p;
    private volatile int currentIndex = 0;
    private boolean isElementSet = false;

    public PrintableSynchronizer(Printable p) {
        this.p = p;
    }

    public void write (int val) throws InterruptedException {
        synchronized (p) {
            if (!canWrite()) {
                throw new InterruptedException();
            }

            while (isElementSet) {
                p.wait();
            }

            p.setPagesInArticle(currentIndex, val);
            isElementSet = true;
            System.out.println("Write " + val + " to position " + currentIndex);

            p.notifyAll();
        }
    }

    private boolean canWrite() {
        return (!isElementSet && currentIndex < p.getAmountOfArticles() || (isElementSet && currentIndex < p.getAmountOfArticles() - 1));
    }

    public void read() throws InterruptedException {
        int val;
        synchronized (p) {
            if (!canRead()) {
                throw  new InterruptedException();
            }
            while (!isElementSet) {
                p.wait();
            }
            val = p.getPagesInArticle(currentIndex);
            isElementSet = false;
            System.out.println("Read " + val + " from position " + currentIndex);
            currentIndex++;

            p.notifyAll();
        }
    }

    private boolean canRead() {
        return currentIndex < p.getAmountOfArticles();
    }

    int getPrintableAmountOfArticles() {
        return p.getAmountOfArticles();
    }
}
