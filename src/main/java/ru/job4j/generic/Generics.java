package ru.job4j.generic;

import java.util.ArrayList;
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

        /**
         * Метод принимает список типа List<?>, поэтому все три вызова корректны.
         */
        generics.printObject(first);
        generics.printObject(second);
        generics.printObject(third);
        System.out.println();

        /**
         * Ошибка компиляции:
         * printBoundedWildCard ожидает List<? extends Predator>.
         * Animal не является подклассом Predator.
         */
        /* generics.printBoundedWildCard(first); */
        generics.printBoundedWildCard(second);
        generics.printBoundedWildCard(third);
        System.out.println();

        /**
         * Ошибка компиляции:
         * printLowerBoundedWildCard ожидает List<? super Predator>.
         * Tiger — подкласс, а не суперкласс Predator.
         */
        generics.printLowerBoundedWildCard(first);
        generics.printLowerBoundedWildCard(second);
        /* generics.printLowerBoundedWildCard(third); */
    }

    /**
     * Метод принимает список объектов любого типа.
     *
     * @param list список любых объектов
     */
    public void printObject(List<?> list) {
        for (Object next : list) {
            System.out.println("Текущий элемент: " + next);
        }
    }

    /**
     * Метод принимает список, элементы которого — Predator или его потомки.
     *
     * @param list список Predator или наследников
     */
    public void printBoundedWildCard(List<? extends Predator> list) {
        for (Predator next : list) {
            System.out.println("Текущий элемент: " + next);
        }
    }

    /**
     * Метод принимает список, элементы которого — Predator или его предки.
     *
     * @param list список Predator или родителей
     */
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