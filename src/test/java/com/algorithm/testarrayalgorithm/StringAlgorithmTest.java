package com.algorithm.testarrayalgorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StringAlgorithmTest {

    private StringAlgorithm expected;
    private StringAlgorithm actual;

    @BeforeEach
    public void setUp() {
        String str0 = "Zero";
        String str1 = "One";
        String str2 = "Two";
        String str3 = "Three";
        String str4 = "Four";
        expected = new StringAlgorithm();
        expected.getStrings()[0] = str0;
        expected.getStrings()[1] = str1;
        expected.getStrings()[2] = str2;
        expected.getStrings()[3] = str3;
        expected.getStrings()[4] = str4;

        actual = new StringAlgorithm();
    }

    @Test
    void add() {
        String str0 = "Zero";
        String str1 = "One";
        String str2 = "Two";
        String str3 = "Three";
        String str4 = "Four";
        actual.add(str0);
        actual.add(str1);
        actual.add(str2);
        actual.add(str3);
        actual.add(str4);
        Assertions.assertArrayEquals(expected.getStrings(), actual.getStrings());
    }

    @Test
    void testAdd() {
        String str0 = "Zero";
        String str1 = "One";
        String str2 = "Two";
        String str3 = "Three";
        String str4 = "Four";
        actual.add(0, str0);
        actual.add(1, str1);
        actual.add(2, str2);
        actual.add(3, str3);
        actual.add(4, str4);
        Assertions.assertArrayEquals(expected.getStrings(), actual.getStrings());
    }

    @Test
    void set() {
        String str0 = "Zero";
        String str1 = "One";
        String str2 = "Two";
        String str3 = "Three";
        String str4 = "Four";
        String set = "set";
        expected.getStrings()[1] = set;
        actual.add(0, str0);
        actual.add(1, str1);
        actual.add(2, str2);
        actual.add(3, str3);
        actual.add(4, str4);
        actual.set(1, set);
        Assertions.assertArrayEquals(expected.getStrings(), actual.getStrings());
    }

    @Test
    void remove() {
        String str0 = "Zero";
        String str1 = "One";
        String str2 = "Two";
        String str3 = "Three";
        String str4 = "Four";
        String[] newStrings = new String[10];
        newStrings[0] = str0;
        newStrings[1] = str2;
        newStrings[2] = str3;
        newStrings[3] = str4;
        actual.add(0, str0);
        actual.add(1, str1);
        actual.add(2, str2);
        actual.add(3, str3);
        actual.add(4, str4);
        actual.remove("One");
        Assertions.assertArrayEquals(newStrings, actual.getStrings());

    }

    @Test
    void testRemove() {
        String str0 = "Zero";
        String str1 = "One";
        String str2 = "Two";
        String str3 = "Three";
        String str4 = "Four";
        String[] newStrings = new String[10];
        newStrings[0] = str0;
        newStrings[1] = str2;
        newStrings[2] = str3;
        newStrings[3] = str4;
        actual.add(0, str0);
        actual.add(1, str1);
        actual.add(2, str2);
        actual.add(3, str3);
        actual.add(4, str4);
        actual.remove(1);
        Assertions.assertArrayEquals(newStrings, actual.getStrings());
    }

    @Test
    void contains() {
        actual.add(0, "Zero");
        actual.add(1, "One");
        Assertions.assertTrue(actual.contains("One"));
    }

    @Test
    void indexOf() {
        String str0 = "Zero";
        String str1 = "One";
        String str2 = "Two";
        String str3 = "Three";
        String str4 = "Four";
        actual.add(0, str0);
        actual.add(1, str1);
        actual.add(2, str2);
        actual.add(3, str3);
        actual.add(4, str4);
        Assertions.assertEquals(actual.indexOf("Three"), 3);
    }

    @Test
    void lastIndexOf() {
        String str0 = "Zero";
        String str1 = "One";
        String str2 = "Two";
        String str3 = "Three";
        String str4 = "Four";
        actual.add(0, str0);
        actual.add(1, str1);
        actual.add(2, str2);
        actual.add(3, str3);
        actual.add(4, str4);
        Assertions.assertEquals(actual.lastIndexOf("Three"), 3);
    }

    @Test
    void get() {
        String str0 = "Zero";
        String str1 = "One";
        String str2 = "Two";
        String str3 = "Three";
        String str4 = "Four";
        actual.add(0, str0);
        actual.add(1, str1);
        actual.add(2, str2);
        actual.add(3, str3);
        actual.add(4, str4);
        Assertions.assertEquals(actual.get(2), "Two");
        Assertions.assertThrows(NullIndexException.class, () -> actual.get(-2));
    }

    @Test
    void testEquals() {
        String str0 = "Zero";
        String str1 = "One";
        String str2 = "Two";
        String str3 = "Three";
        String str4 = "Four";
        String[] newStrings = new String[10];
        newStrings[0] = str0;
        newStrings[1] = str1;
        newStrings[2] = str2;
        newStrings[3] = str3;
        newStrings[4] = str4;
        actual.add(0, str0);
        actual.add(1, str1);
        actual.add(2, str2);
        actual.add(3, str3);
        actual.add(4, str4);
        Assertions.assertTrue(actual.equals(newStrings));
        Assertions.assertThrows(NullElementException.class, () -> actual.equals(null));
    }

    @Test
    void size() {
        String str0 = "Zero";
        String str1 = "One";
        String str2 = "Two";
        String str3 = "Three";
        String str4 = "Four";
        actual.add(0, str0);
        actual.add(1, str1);
        actual.add(2, str2);
        actual.add(3, str3);
        actual.add(4, str4);
        Assertions.assertEquals(actual.size(), 5);
    }

    @Test
    void isEmpty() {
        String str0 = "Zero";
        String str1 = "One";
        String str2 = "Two";
        String str3 = "Three";
        String str4 = "Four";
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
        String[] newStrings = new String[]{null, null, null, null, null};
        String str0 = "Zero";
        String str1 = "One";
        String str2 = "Two";
        String str3 = "Three";
        String str4 = "Four";
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
        String str0 = "Zero";
        String str1 = "One";
        String str2 = "Two";
        String str3 = "Three";
        String str4 = "Four";
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