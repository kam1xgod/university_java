package com.company.Prints;

import com.company.Exceptions.NullObjectException;
import java.io.*;
import static com.company.Prints.InputAndOutputPrintable.inputBytesAsPrintable;
import static com.company.Prints.InputAndOutputPrintable.readTextAsPrintable;

public class InputAndOutputPrintableArray {

    public static void outputPrintableArrayAsBytes(Printable[] pArr, OutputStream out) {
        BufferedOutputStream bos = new BufferedOutputStream(out);
        outputLengthOfPrintableArrayAsBytes(pArr, bos);
        for (Printable p : pArr) {
            p.outputAsBytes(out);
        }
    }

    private static void outputLengthOfPrintableArrayAsBytes(Printable[] pArr, BufferedOutputStream bos) {
        DataOutputStream dataOutputter;
        try {
            dataOutputter = new DataOutputStream(bos);
            dataOutputter.writeInt(pArr.length);
            dataOutputter.flush();
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static void writePrintableArrayAsText(Printable[] pArr, Writer out) {
        BufferedWriter bw = new BufferedWriter(out);
        writeLengthOfPrintableArrayAsText(pArr, bw);
        for (Printable p : pArr) {
            p.writeAsText(out);
        }
    }

    private static void writeLengthOfPrintableArrayAsText(Printable[] pArr, BufferedWriter bw) {
        PrintWriter printer = new PrintWriter(bw);
        printer.println(pArr.length);
        printer.flush();
    }

    public static void serializePrintableArray(Printable[] pArr, OutputStream out) {
        ObjectOutputStream serializer;
        try {
            serializer = new ObjectOutputStream(out);
            serializer.writeObject(pArr);
            serializer.flush();
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static Printable[] inputByteAsPrintableArray(InputStream in) throws NullObjectException, ClassNotFoundException {
        final int length = getLengthOfPrintableArrayFromBytes(in);
        Printable[] pArr = new Printable[length];

        for (int index = 0; index < length; ++index) {
            pArr[index] = inputBytesAsPrintable(in);
        }

        return pArr;
    }

    private static int getLengthOfPrintableArrayFromBytes(InputStream in) {
        int length = -1;
        DataInputStream dataInputter;
        try {
            dataInputter = new DataInputStream(in);
            length = dataInputter.readInt();
            if (length == -1) {
                throw new IOException("Error: can't read length of array from byte stream.");
            }
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
        return length;
    }

    public static Printable[] readTextAsPrintableArray(Reader in) throws NullObjectException, ClassNotFoundException {
        BufferedReader bf = new BufferedReader(in);
        final int length = getLengthOfPrintableArrayFromText(bf);
        Printable[] pArr = new Printable[length];

        for (int index = 0; index < length; ++index) {
            pArr[index] = readTextAsPrintable(bf);
        }
        return pArr;
    }

    private static int getLengthOfPrintableArrayFromText(BufferedReader bf) {
        int length = -1;
        try {
            length = Integer.parseInt(bf.readLine());
            if (length == -1) {
                throw new IOException("Error: can't read length of array from byte stream.");
            }
        } catch (IOException | NumberFormatException exc) {
            System.out.println(exc.getMessage());
        }
        return length;
    }

    public static Printable[] deserializePrintableArray(InputStream in) throws NullObjectException {
        Printable[] pArr;
        ObjectInputStream deserializer;
        try {
            deserializer = new ObjectInputStream(in);
            pArr = (Printable[]) deserializer.readObject();
        } catch (IOException | ClassNotFoundException exc) {
            System.out.println(exc.getMessage());
            pArr = null;
        }
        if (pArr == null) {
            throw new NullObjectException("Can't read Printable.");
        }
        return pArr;
    }
}
