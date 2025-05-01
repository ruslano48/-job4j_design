package ru.job4j.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        Generics generics = new Generics();
        List<Animal> first = new ArrayList<>();
        List<Predator> second = new ArrayList<>();
        List<Tiger> third = new ArrayList<>();
        first.add(new Animal());
        second.add(new Predator());
        third.add(new Tiger());

        generics.printObject(first);
        generics.printObject(second);
        generics.printObject(third);
        System.out.println();

        // generics.printBoundedWildCard(first); // Ошибка: Animal — выше по иерархии
        generics.printBoundedWildCard(second);
        generics.printBoundedWildCard(third);
        System.out.println();

        generics.printLowerBoundedWildCard(first);
        generics.printLowerBoundedWildCard(second);
        // generics.printLowerBoundedWildCard(third); // Ошибка: Tiger — ниже по иерархии
    }

    // исправлено: принимаем любой список (<?>)
    public void printObject(List<?> list) {
        for (Object next : list) {
            System.out.println("Текущий элемент: " + next);
        }
    }

    // верхняя граница — только Predator и его наследники
    public void printBoundedWildCard(List<? extends Predator> list) {
        for (Predator next : list) {
            System.out.println("Текущий элемент: " + next);
        }
    }

    // нижняя граница — Predator и его предки
    public void printLowerBoundedWildCard(List<? super Predator> list) {
        for (Object next : list) {
            System.out.println("Текущий элемент: " + next);
        }
    }
}

class Animal {

    @Override
    public String toString() {
        return "Животное";
    }
}

class Predator extends Animal {

    @Override
    public String toString() {
        return "Хищник";
    }
}

class Tiger extends Predator {

    @Override
    public String toString() {
        return "Тигр";
    }
}
