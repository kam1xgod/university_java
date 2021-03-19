package com.company;

import java.util.function.BiPredicate;

public class Vector {
    private double[] array;

    private BiPredicate<Double, Double> get = (n, s) ->
    {
        if (n > s) {
            return true;
        }
        return false;
    };

    //todo: rename to n or length
    public Vector(int length) {
        //todo: do not use methods inside constructor
        try {
            if (length < 0) {
                throw new IllegalArgumentException();
            }
            this.array = new double[length];
        }
        catch (IllegalArgumentException exception) {
            System.out.println("Length can't less then 0.");
        }
    }

    public int getSize() {
        return this.array.length;
    }

    public void addElements(int index, double value) {
        try {
            if (index < 0 || index > this.array.length) {
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < this.array.length; ++i) {
                if (i == index) {
                    array[i] = value;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Index must be bigger then 0 and less or equal then length.");
        }
    }

    public void setElements() {
        for (int i = 0; i < this.array.length; ++i) {
            array[i] = i + 100;
        }
    }

    public String getElements() {
        String temp = "[";
        for (double element : this.array)
        {
            temp += " " + element;
        }
        temp += " ]";
        return temp;
    }

    //todo: return found element
    public double getElement(int element) {
        try {
            if (element < 0 || element > this.array.length) {
                throw new IllegalArgumentException();
            }
            return this.array[element];
        }
        catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("\n" + exception.getMessage() + "\n");
            return 0;
        }
    }

    //todo: return old element
    public void changeElement(int index, double element) {
        System.out.printf("Element %.0f with index %d was changed by %.0f\n", this.array[index], index, element);
        this.array[index] = element;
    }



    //todo return max element
    public double getMax() {
        double max = 0;
        for (int i = 0; i < this.array.length; ++i) {
            if ((i+1 < this.array.length) && (get.test(array[i+1], array[i]))) {
                max = array[i];
            }
        }
        if (max < array[array.length-1])
        {
            max = array[array.length-1];
        }
        return max;
    }



    //todo: read about Predicate
    //todo:
    public double getMin() {
        double min = 0;
        for (int i = 0; i < this.array.length; ++i) {
            if ((i+1 < this.array.length) && !(get.test(array[i+1], array[i]))) {
                min = array[i+1];
            }
        }
        return min;
    }

    public void arraySort() {
        boolean swapped = true;
        int j = 0;
        double tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < this.array.length - j; i++) {
                if (this.array[i] > this.array[i + 1]) {
                    tmp = this.array[i];
                    this.array[i] = this.array[i + 1];
                    this.array[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    public double getEuclideanNorm() {
        double powSum = 0;
        double norm;
        for (int i = 0; i < this.array.length; ++i) {
            powSum += this.array[i] * this.array[i];
        }
        norm = Math.sqrt(powSum);
        return norm;
    }

    //todo: return new Vector
    public Vector multiplyingByNumber(double num) {
        Vector temp = new Vector(this.array.length);
        for (int i = 0; i < this.array.length; ++i) {
            temp.addElements(i, this.array[i] * num);
        }
        return temp;
    }

    //todo: rename and rewrite to math
    public double[] sumVectors(Vector second_vector) {
        if(this.array.length == second_vector.array.length)
        {
            double[] sum = new double[this.array.length];
            for(int i=0; i < this.array.length;i++)
            {
                sum[i]= second_vector.array[i] + this.array[i];
            }
            return sum;
        }
        else
        {
            System.out.println("Length of vectors must be equal.");
            return null;
        }
    }

    public Double multiplyVectors(Vector second_vector) {
        if(this.array.length == second_vector.array.length)
        {
            double multi = 0;
            for(int i = 0; i < array.length; i++)
            {
                multi += second_vector.array[i] * this.array[i];
            }
            return multi;
        }
        else
        {
            System.out.println("Length of vectors must be equal.");
            return null;
        }
    }

    @Override
    public String toString() {
        return getElements();
    }
}
