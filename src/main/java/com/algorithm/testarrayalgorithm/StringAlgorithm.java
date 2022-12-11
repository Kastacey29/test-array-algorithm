package com.algorithm.testarrayalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StringAlgorithm implements StringList {
    private final String[] strings;
    private int size;

    public StringAlgorithm() {
        this.strings = new String[10];
    }

    public String[] getStrings() {
        return strings;
    }

    @Override
    public String add(String item) {
        checkItem(item);
        if (size == strings.length) {
            throw new ValidSizeException("Нет места!");
        }
        strings[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        checkItem(item);
        if (size == strings.length) {
            throw new ValidSizeException("Нет места!");
        }
        if (index > size || index < 0) {
            throw new NullIndexException("Введите корректный индекс!");
        }
        if (index != size) {
            for (int i = size; i > index; i--) {
                strings[i] = strings[i - 1];
            }
        }
        strings[index] = item;
        size++;
        return item;
    }


    @Override
    public String set(int index, String item) {
        checkItem(item);
        if (index > size || index < 0) {
            throw new NullIndexException("Введите корректный индекс!");
        }
        strings[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        checkItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new NullIndexException("Такого элемента нет!");
        }
        remove(index);
        return item;
    }

    @Override
    public String remove(int index) {
        String item = strings[index];
        if (index > size - 1 || index < 0) {
            throw new NullIndexException("Введите корректный индекс!");
        }
        if (index != size - 1) {
            for (int i = index; i < size - 1; i++) {
                strings[i] = strings[i + 1];
            }
            strings[size - 1] = null;
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        checkItem(item);
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        checkItem(item);
        for (int i = 0; i < size; i++) {
            if (strings[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public int lastIndexOf(String item) {
        checkItem(item);
        for (int i = size - 1; i >= 0; i--) {
            if (strings[i].equals(item)) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index > size || index < 0) {
            throw new NullIndexException("Введите корректный индекс!");
        }
        return strings[index];
    }

    @Override
    public boolean equals(String[] otherList) {
        if (otherList == null) {
            throw new NullElementException("Incorrect value!");
        }
        return Arrays.equals(this.strings, otherList);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size - 1; i++) {
            strings[i] = null;
        }
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] newStrings = Arrays.copyOf(strings, size);
        return newStrings;
    }

    public void checkItem(String item) {
        if (item == null) {
            throw new NullElementException("Введите значение!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringAlgorithm that)) return false;
        return size == that.size && Arrays.equals(strings, that.strings);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(strings);
        return result;
    }
}
