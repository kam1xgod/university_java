package com.company;

import java.io.OutputStream;
import java.io.Writer;

public interface Printable{

    String printInfo();
    void output(OutputStream out);
    void write(Writer out);
}