package com.algorithm.testarrayalgorithm;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class IntegerAlgorithm implements IntegerList {
    private final Integer[] integers;
    private int size;

    public IntegerAlgorithm() {
        this.integers = new Integer[10];
    }

    public Integer[] getIntegers() {
        return integers;
    }

    @Override
    public Integer add(Integer item) {
        checkItem(item);
        if (size == integers.length) {
            throw new ValidSizeException("Нет места!");
        }
        integers[size] = item;
        size++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkItem(item);
        if (size == integers.length) {
            throw new ValidSizeException("Нет места!");
        }
        if (index > size || index < 0) {
            throw new NullIndexException("Введите корректный индекс!");
        }
        if (index != size) {
            for (int i = size; i > index; i--) {
                integers[i] = integers[i - 1];
            }
        }
        integers[index] = item;
        size++;
        return item;
    }


    @Override
    public Integer set(int index, Integer item) {
        checkItem(item);
        if (index > size || index < 0) {
            throw new NullIndexException("Введите корректный индекс!");
        }
        integers[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        checkItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new NullIndexException("Такого элемента нет!");
        }
        remove(index);
        return item;
    }

    @Override
    public Integer remove(int index) {
        Integer item = integers[index];
        if (index > size - 1 || index < 0) {
            throw new NullIndexException("Введите корректный индекс!");
        }
        if (index != size - 1) {
            for (int i = index; i < size - 1; i++) {
                integers[i] = integers[i + 1];
            }
            integers[size - 1] = null;
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        checkItem(item);
        return IntegerAlgorithm.binarySearch(Arrays.copyOf(integers,integers.length),item)!=-1;
    }

    @Override
    public int indexOf(Integer item) {
        checkItem(item);
        for (int i = 0; i < size; i++) {
            if (integers[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public int lastIndexOf(Integer item) {
        checkItem(item);
        for (int i = size - 1; i >= 0; i--) {
            if (integers[i].equals(item)) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index > size || index < 0) {
            throw new NullIndexException("Введите корректный индекс!");
        }
        return integers[index];
    }

    @Override
    public boolean equals(Integer[] otherList) {
        if (otherList == null) {
            throw new NullElementException("Incorrect value!");
        }
        return Arrays.equals(this.integers, otherList);
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
            integers[i] = null;
        }
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        Integer[] newIntegers = Arrays.copyOf(integers, size);
        return newIntegers;
    }

    public void checkItem(Integer item) {
        if (item == null) {
            throw new NullElementException("Введите значение!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntegerAlgorithm that)) return false;
        return size == that.size && Arrays.equals(integers, that.integers);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(integers);
        return result;
    }

    public static Integer[] toRandomArray() {
        Integer[] integers = new Integer[100000];
        for (int i = 0; i <integers.length ; i++) {
            integers[i] = new Random().nextInt(1000);
        }
        return integers;
    }
    public static void sortBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }


    public static void sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private static int binarySearch(Integer[] integers, Integer item) {
        IntegerAlgorithm.sortInsertion(integers);
        return Arrays.binarySearch(integers,item);
    }

    public static void main(String[] args) {
        Integer[] integers1 = IntegerAlgorithm.toRandomArray();
        Integer[] integers2 = IntegerAlgorithm.toRandomArray();
        Integer[] integers3 = IntegerAlgorithm.toRandomArray();
        long start1 = System.currentTimeMillis();
        sortBubble(integers1);
        System.out.println("Пузырьковая сортировка " +(System.currentTimeMillis() - start1));
        long start2 = System.currentTimeMillis();
        sortInsertion(integers2);
        System.out.println("Сортировка вставками " +(System.currentTimeMillis() - start2));
        long start3 = System.currentTimeMillis();
        sortSelection(integers3);
        System.out.println("Сортировка выбором " +(System.currentTimeMillis() - start3));
    }
}
