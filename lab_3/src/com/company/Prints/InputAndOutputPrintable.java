package com.company.Prints;

import com.company.Exceptions.NullObjectException;

import java.io.*;

public class InputAndOutputPrintable {
    public static void outputPrintableAsBytes(Printable p, OutputStream out) {
        p.outputAsBytes(out);
    }

    public static void writePrintableAsText(Printable p, Writer out) {
        p.writeAsText(out);
    }

    public static void serializePrintable(Printable p, OutputStream out) {
        ObjectOutputStream serializer;
        try {
            serializer = new ObjectOutputStream(out);
            serializer.writeObject(p);
            serializer.flush();
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static Printable inputBytesAsPrintable(InputStream in) throws NullObjectException, ClassNotFoundException {
        Printable p;
        DataInputStream dataInputer;
        try {
            dataInputer = new DataInputStream(in);
            String className = dataInputer.readUTF();
            String title = dataInputer.readUTF();
            int amountOfIntroducingPages = dataInputer.readInt();
            int amountOfArticles = dataInputer.readInt();

            p = getNewPrintableByClassName(className, title, amountOfArticles, amountOfIntroducingPages);

            final int length = p.getAmountOfArticles();
            int amountOfPages;
            for (int index = 0; index < length; ++index) {
                amountOfPages = dataInputer.readInt();
                p.setPagesInArticle(index, amountOfPages);
            }
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
            p = null;
        }
        if (p == null) {
            throw new NullObjectException("Can't read Printable.");
        }
        return p;
    }

    public static Printable getNewPrintableByClassName(String className, String title, int amountOfArticles, int amountOfIntroducingPages) throws ClassNotFoundException {
        if (className.equals(Magazine.class.getName())) {
            return new Magazine(title, amountOfArticles, amountOfIntroducingPages);
        } else if (className.equals(Book.class.getName())) {
            return new Book(title, amountOfArticles, amountOfIntroducingPages);
        } else {
            throw new ClassNotFoundException("Error: class doesn't exist.");
        }
    }

    public static Printable readTextAsPrintable(BufferedReader bf) throws NullObjectException, ClassNotFoundException {
        Printable p;
        try {
            String className = bf.readLine();
            String title = bf.readLine();
            int amountOfIntroducingPages = Integer.parseInt(bf.readLine());
            int amountOfArticles = Integer.parseInt(bf.readLine());

            p = getNewPrintableByClassName(className, title, amountOfIntroducingPages, amountOfArticles);
            final int length =  p.getAmountOfArticles();
            int amountOfPagesInArticle;
            for (int index = 0; index < length; ++index) {
                amountOfPagesInArticle = Integer.parseInt(bf.readLine());
                p.setPagesInArticle(index, amountOfPagesInArticle);
            }
        } catch (IOException | NumberFormatException exc) {
            System.out.println(exc.getMessage());
            p = null;
        } catch (ClassNotFoundException exc) {
            throw new ClassNotFoundException(exc.getMessage());
        }
        if (p == null) {
            throw new NullObjectException("Can't read Printable.");
        }
        return p;
    }

    public static Printable deserializePrintable (InputStream in) throws NullObjectException {
        Printable p;
        ObjectInputStream deserializer;
        try {
            deserializer = new ObjectInputStream(in);
            p =(Printable) deserializer.readObject();
        } catch (IOException | ClassNotFoundException exc) {
            System.out.println(exc.getMessage());
            p = null;
        }
        if (p == null) {
            throw new NullObjectException("Can't read Printable.");
        }
        return p;
    }
}
