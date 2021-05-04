package com.company.Threads;

import com.company.Prints.Printable;

import java.util.Random;

public class RunnableWritingThread implements  Runnable{
    private final PrintableSynchronizer psync;

    public RunnableWritingThread(PrintableSynchronizer psync) {
        this.psync = psync;
    }

    @Override
    public void run() {
        try {
            int val;
            Random rand = new Random();
            for (int i = 0; i < psync.getPrintableAmountOfArticles(); ++i) {
                val = rand.nextInt(Printable.MIN_AMOUNT_OF_PAGES + (Printable.MAX_AMOUNT_OF_PAGES-Printable.MIN_AMOUNT_OF_PAGES + 1));
                psync.write(val);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
    }
}
