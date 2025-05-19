package ru.job4j.set;

import java.util.Iterator;

public interface SimpleSet<T> {

    boolean add(T value);

    boolean contains(T value);

    Iterator<T> iterator();
}