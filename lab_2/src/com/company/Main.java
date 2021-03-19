package com.company;

public class Main {
    /*Создать класс, реализующий работу с векторами (набор вещественных чисел, координат) и базовые операции
    векторной арифметики. Класс должен удовлетворять следующим требованиям.
    Экземпляр должен соответствовать вектору фиксированной длины (она задается как параметр конструктора).
    Должны быть реализованы следующие методы:
    доступа к элементам вектора (получения значения и изменения значения),
    получения «длины» вектора (количества его элементов),
    поиска минимального и максимального значений из элементов вектора,
    сортировки вектора (по возрастанию или убыванию – на ваш выбор),
    нахождения евклидовой нормы,
    умножения вектора на число,
    сложения двух векторов,
    нахождения скалярного произведения двух векторов.*/

    public static void main(String[] args) {
        int size_first = 10;
        int size_second = 15;
        double multiple = 4;

        Vector first = new Vector(size_first); //создание вектора first;
        first.setElements();
        Vector second = new Vector(size_second); //создание вектоа second;
        second.setElements();

        System.out.println("Size of first vector: " + first.getSize() +
                         "\nSize of second vector: " + second.getSize()); //вывод кол-ва элементов вектора first;

        System.out.println("\nSearchable element is: " + first.getElement(6) + "\n"); //вывод элемента №6 из first;
        System.out.println("All elements in second vector: " + second.getElements()); //вывод всех элементов из second;
        first.changeElement(6, 15); //замена элемента №6 в first;
        System.out.println("All elements in first vector: " + first.getElements()); //вывод всех элементов из first;
        System.out.println("Max element in second vector is: " + second.getMax()); //вывод максимального значения из second;
        System.out.println("Min element in first vector is: " + first.getMin()); //вывод минимального значения из first;
        first.arraySort(); //сортировка first по возрастанию;
        System.out.println("All elements in first vector after sorting: " + first.getElements()); //вывод всех элементов из first;
        System.out.println("Euclidean Norm of first vector is: " + first.getEuclideanNorm()); //евклидова норма first;
        System.out.println(second.multiplyingByNumber(multiple)); //умножение вектора second на число multiple;
        System.out.println("All elements in second vector: " + second.getElements()); //вывод элементов вектора second;
        System.out.println("Result of vectors sum is : " + first.sumVectors(second)); //сложение вектора first с вектором second;
        System.out.println("Result of multiplying vectors is: " + second.multiplyVectors(first)); //умножение вектора second на вектор first;
    }

}

//todo: move to separate class
//todo: rename class to Vector and read java naming conventions
