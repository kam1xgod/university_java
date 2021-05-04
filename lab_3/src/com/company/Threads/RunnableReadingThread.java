package com.company.Threads;

public class RunnableReadingThread implements Runnable{
    private final PrintableSynchronizer psync;

    public RunnableReadingThread(PrintableSynchronizer psync) {
        this.psync = psync;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < psync.getPrintableAmountOfArticles(); ++i) {
                psync.read();
            }
        } catch (InterruptedException exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
    }
}
