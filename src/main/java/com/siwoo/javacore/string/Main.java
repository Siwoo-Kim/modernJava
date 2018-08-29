package com.siwoo.javacore.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class Main {

    @Test
    public void concat() {
        String location = "Java";
        String greeting = "Hello " + location;
        assertEquals(greeting, "Hello Java");

        int age = 42;
        String output = age + " years";
        assertEquals(output, "42 years");

        String names = String.join(", ", "Peter", "Paul", "Mary");
        assertEquals(names, "Peter, Paul, Mary");

        StringBuilder builder = new StringBuilder();
        String[] arrays = names.split(", ");
        for(int i=0; i<arrays.length; i++) {
            if(i == arrays.length - 1)
                builder.append(arrays[i]);
            else
                builder.append(arrays[i] + ", ");
        }
        assertEquals(builder.toString(), "Peter, Paul, Mary");
    }

    @Test
    public void substring() {
        String location = "Greeting World People!".substring(9, 14);
        assertEquals(location, "World");

        String names = String.join(", ", "Peter", "Paul", "Mary");
        String[] arrays = names.split(", ");
        assertEquals(arrays.length, 3);
        assertArrayEquals(arrays, new String[]{"Peter", "Paul", "Mary"});

        assertTrue(new StringBuilder() instanceof CharSequence);
        assertTrue("" instanceof  CharSequence);
    }

    @Test
    public void equals() {
        String location = "World";
        assertTrue("World".equals(location));
        assertFalse(null == "");
        assertTrue("world".equalsIgnoreCase(location));
        String compareWord = "Porld";
        assertTrue(compareWord.compareTo(location) < 0);
        assertTrue(location.compareTo(compareWord) > 0);
        assertTrue( location.compareToIgnoreCase("world") == 0);
    }

    @Test
    public void parsing() {
        int number = 42;
        String fortyTwo = Integer.toString(number);
        assertEquals(fortyTwo, "42");
        String binary = Integer.toString(number, 2);
        assertEquals(binary, "101010");
        int wrongNumber = Integer.parseInt(binary);
        assertEquals(wrongNumber, 101010);
        int parsedNumber = Integer.parseInt(binary, 2);
        assertEquals(number, parsedNumber);
    }

    @Test
    public void codePoint() {
        // A -> \U+0041
        assertTrue('A' == '\u0041');

        int[] codePoints = "Hello Java!".codePoints().toArray();
        StringBuilder builder = new StringBuilder();
        for(int ch: codePoints) {
            if(ch == 'J') ch = 'P';
            builder.append((char)ch);
        }
        assertEquals(builder.toString(), "Hello Pava!");
    }
}
