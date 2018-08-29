package com.siwoo.javacore.array;

import org.junit.Ignore;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class Main {

    @Test
    public void init() {
        String[] names = new String[100];
        assertTrue(names.length == 100);
        for(String name: names) {
            assertNull(name);
        }
        // init all elements to ""
        for(int i=0; i<names.length; i++) {
            names[i] = "";
        }
        // use allMatch to check to match all elements with ""
        assertTrue(Arrays.stream(names).allMatch(name -> "".equals(name)));
        // use Stream api to init all elements to "NotNull"
        names = Arrays.stream(names)
                .map(name -> "NotNull")
                .collect(Collectors.toList())
                .toArray(new String[]{});
        assertTrue(Arrays.stream(names).allMatch(name -> name.equals("NotNull")));

        // init arrays with 1,2,3...100
        BigInteger[] numbers = new BigInteger[100];
        for(int i=0; i<numbers.length; i++) {
            numbers[i] = BigInteger.valueOf(i + 1);
        }

        int[] primes = { 2, 3, 5, 7, 9, 11, 13 };
        int[] redundantPrimes = new int[]{ 2, 3, 5, 7, 9, 11, 13 };
        assertArrayEquals(primes, redundantPrimes);

        //Trigger UnsupportedOperationException class by creating List instance
        try {
            List list = Arrays.asList("Peter", "Paul");
            list.add("Arrays.asList is not modifiable");
        }catch (UnsupportedOperationException e) {
            // Ignore
        }

        //Init modifiable list , [Peter, Paul]
        List<String> friends = new ArrayList<>(Arrays.asList("Peter", "Paul"));
        //Swap element
        friends.remove(1);
        friends.add(0, "Paul");
        assertEquals(friends.get(0), "Paul");
        assertEquals(friends.get(1), "Peter");

        String first = friends.get(0);
        friends.set(0, "Mary");
        friends.add(first);
        assertEquals(friends.get(0), "Mary");
        assertEquals(friends.get(1), "Peter");
        assertEquals(friends.get(2), "Paul");

        //loop and print
        for(String friend: friends) {
            System.out.printf("%8S ", friend);
        }
    }
}
