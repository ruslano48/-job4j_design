package ru.job4j.collection;

import java.util.NoSuchElementException;
import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> input = new SimpleStack<>();
    private final SimpleStack<T> output = new SimpleStack<>();
    private int inputCount = 0;
    private int outputCount = 0;

    public T poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        if (outputCount == 0) {
            transferInputToOutput();
        }

        T value = output.pop();
        outputCount--;
        return value;
    }

    public void push(T value) {
        input.push(value);
        inputCount++;
    }

    private void transferInputToOutput() {
        while (inputCount > 0) {
            output.push(input.pop());
            inputCount--;
            outputCount++;
        }
    }

    private boolean isEmpty() {
        return inputCount + outputCount == 0;
    }
}