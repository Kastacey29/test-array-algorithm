package com.algorithm.testarrayalgorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegerAlgorithmTest {

    private IntegerAlgorithm expected;
    private IntegerAlgorithm actual;

    @BeforeEach
    public void setUp() {
        Integer str0 = 0;
        Integer str1 = 1;
        Integer str2 = 2;
        Integer str3 = 3;
        Integer str4 = 4;
        expected = new IntegerAlgorithm();
        expected.getIntegers()[0] = str0;
        expected.getIntegers()[1] = str1;
        expected.getIntegers()[2] = str2;
        expected.getIntegers()[3] = str3;
        expected.getIntegers()[4] = str4;

        actual = new IntegerAlgorithm();
    }

    @Test
    void add() {
        Integer str0 = 0;
        Integer str1 = 1;
        Integer str2 = 2;
        Integer str3 = 3;
        Integer str4 = 4;
        actual.add(str0);
        actual.add(str1);
        actual.add(str2);
        actual.add(str3);
        actual.add(str4);
        Assertions.assertArrayEquals(expected.getIntegers(), actual.getIntegers());
    }

    @Test
    void testAdd() {
        Integer str0 = 0;
        Integer str1 = 1;
        Integer str2 = 2;
        Integer str3 = 3;
        Integer str4 = 4;
        actual.add(0, str0);
        actual.add(1, str1);
        actual.add(2, str2);
        actual.add(3, str3);
        actual.add(4, str4);
        Assertions.assertArrayEquals(expected.getIntegers(), actual.getIntegers());
    }

    @Test
    void set() {
        Integer str0 = 0;
        Integer str1 = 1;
        Integer str2 = 2;
        Integer str3 = 3;
        Integer str4 = 4;
        Integer set = 6;
        expected.getIntegers()[1] = set;
        actual.add(0, str0);
        actual.add(1, str1);
        actual.add(2, str2);
        actual.add(3, str3);
        actual.add(4, str4);
        actual.set(1, set);
        Assertions.assertArrayEquals(expected.getIntegers(), actual.getIntegers());
    }

    @Test
    void remove() {
        Integer str0 = 0;
        Integer str1 = 1;
        Integer str2 = 2;
        Integer str3 = 3;
        Integer str4 = 4;
        Integer[] newIntegers = new Integer[10];
        newIntegers[0] = str0;
        newIntegers[1] = str2;
        newIntegers[2] = str3;
        newIntegers[3] = str4;
        actual.add(0, str0);
        actual.add(1, str1);
        actual.add(2, str2);
        actual.add(3, str3);
        actual.add(4, str4);
        actual.remove(1);
        Assertions.assertArrayEquals(newIntegers, actual.getIntegers());

    }

    @Test
    void testRemove() {
        Integer str0 = 0;
        Integer str1 = 1;
        Integer str2 = 2;
        Integer str3 = 3;
        Integer str4 = 4;
        Integer[] newIntegers = new Integer[10];
        newIntegers[0] = str0;
        newIntegers[1] = str2;
        newIntegers[2] = str3;
        newIntegers[3] = str4;
        actual.add(0, str0);
        actual.add(1, str1);
        actual.add(2, str2);
        actual.add(3, str3);
        actual.add(4, str4);
        actual.remove(1);
        Assertions.assertArrayEquals(newIntegers, actual.getIntegers());
    }

    @Test
    void contains() {
        actual.add(0, 0);
        actual.add(1, 1);
        actual.add(2, 2);
        actual.add(3, 3);
        actual.add(4, 4);
        actual.add(5, 5);
        actual.add(6, 6);
        actual.add(7, 7);
        actual.add(8, 8);
        actual.add(9, 19);
        Assertions.assertTrue(actual.contains(5));
    }

    @Test
    void indexOf() {
        Integer str0 = 0;
        Integer str1 = 1;
        Integer str2 = 2;
        Integer str3 = 3;
        Integer str4 = 4;
        actual.add(0, str0);
        actual.add(1, str1);
        actual.add(2, str2);
        actual.add(3, str3);
        actual.add(4, str4);
        Assertions.assertEquals(actual.indexOf(3), 3);
    }

    @Test
    void lastIndexOf() {
        Integer str0 = 0;
        Integer str1 = 1;
        Integer str2 = 2;
        Integer str3 = 3;
        Integer str4 = 4;
        actual.add(0, str0);
        actual.add(1, str1);
        actual.add(2, str2);
        actual.add(3, str3);
        actual.add(4, str4);
        Assertions.assertEquals(actual.lastIndexOf(3), 3);
    }

    @Test
    void get() {
        Integer str0 = 0;
        Integer str1 = 1;
        Integer str2 = 2;
        Integer str3 = 3;
        Integer str4 = 4;
        actual.add(0, str0);
        actual.add(1, str1);
        actual.add(2, str2);
        actual.add(3, str3);
        actual.add(4, str4);
        Assertions.assertEquals(actual.get(2), 2);
        Assertions.assertThrows(NullIndexException.class, () -> actual.get(-2));
    }

    @Test
    void testEquals() {
        Integer str0 = 0;
        Integer str1 = 1;
        Integer str2 = 2;
        Integer str3 = 3;
        Integer str4 = 4;
        Integer[] newIntegers = new Integer[10];
        newIntegers[0] = str0;
        newIntegers[1] = str1;
        newIntegers[2] = str2;
        newIntegers[3] = str3;
        newIntegers[4] = str4;
        actual.add(0, str0);
        actual.add(1, str1);
        actual.add(2, str2);
        actual.add(3, str3);
        actual.add(4, str4);
        Assertions.assertTrue(actual.equals(newIntegers));
        Assertions.assertThrows(NullElementException.class, () -> actual.equals(null));
    }

    @Test
    void size() {
        Integer str0 = 0;
        Integer str1 = 1;
        Integer str2 = 2;
        Integer str3 = 3;
        Integer str4 = 4;
        actual.add(0, str0);
        actual.add(1, str1);
        actual.add(2, str2);
        actual.add(3, str3);
        actual.add(4, str4);
        Assertions.assertEquals(actual.size(), 5);
    }

    @Test
    void isEmpty() {
        Integer str0 = 0;
        Integer str1 = 1;
        Integer str2 = 2;
        Integer str3 = 3;
        Integer str4 = 4;
        actual.add(0, str0);
        actual.add(1, str1);
        actual.add(2, str2);
        actual.add(3, str3);
        actual.add(4, str4);
        Assertions.assertFalse(actual.isEmpty());
        actual.clear();
        Assertions.assertTrue(actual.isEmpty());
    }

    @Test
    void clear() {
        Integer[] newIntegers = new Integer[]{null, null, null, null, null};
        Integer str0 = 0;
        Integer str1 = 1;
        Integer str2 = 2;
        Integer str3 = 3;
        Integer str4 = 4;
        actual.add(0, str0);
        actual.add(1, str1);
        actual.add(2, str2);
        actual.add(3, str3);
        actual.add(4, str4);
        actual.clear();
        Assertions.assertEquals(actual.size(), 0);
    }

    @Test
    void toArray() {
        Integer str0 = 0;
        Integer str1 = 1;
        Integer str2 = 2;
        Integer str3 = 3;
        Integer str4 = 4;
        actual.add(0, str0);
        actual.add(1, str1);
        actual.add(2, str2);
        actual.add(3, str3);
        actual.add(4, str4);
        actual.toArray();
        Assertions.assertTrue(actual.toArray().getClass().isArray());
    }

    @Test
    void checkItem() {
        Assertions.assertThrows(NullElementException.class, () -> actual.checkItem(null));
    }
}