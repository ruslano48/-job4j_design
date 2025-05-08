package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> input = new SimpleStack<>();
    private final SimpleStack<T> output = new SimpleStack<>();
    private int size;
    private int modCount;

    public void push(T value) {
        input.push(value);
        size++;
        modCount++;
    }

    public T poll() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }

        if (!hasElementsInOutput()) {
            transferInputToOutput();
        }

        T value = output.pop();
        size--;
        modCount++;
        return value;
    }

    private boolean hasElementsInOutput() {
        try {

            T temp = output.pop();
            output.push(temp);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private void transferInputToOutput() {
        while (true) {
            try {
                output.push(input.pop());
            } catch (NoSuchElementException e) {
                break;
            }
        }
    }

    public int size() {
        return size;
    }
}