package com.siwoo.javacore.io;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        assertNotNull(in);
        Scanner scanner = new Scanner(in);
        System.out.println("Your name?");
        String name = scanner.nextLine();
        assertNotNull(name);
        assertEquals(name, "Siwoo Kim");

        System.out.println("[FirstName] [LastName]");
        String firstName = scanner.next();
        String lastName = scanner.next();
        assertEquals(firstName, "Siwoo");
        assertEquals(lastName, "Kim");

        System.out.println("How old are you? ");
        int age = scanner.nextInt();
        assertEquals(age, 30);

//        System.out.println("Type the sentence: ");
//        String sentence = "Please, Come to see me.\nI miss you a lot";
//        System.out.println(sentence + "[Ctrl + D]");
//        StringBuilder builder = new StringBuilder();
//        while (scanner.hasNextLine()) {
//            builder.append(scanner.nextLine());
//        }
//        assertEquals(sentence, builder.toString());

    }

    @Test
    public void format() {
        System.out.print(1000.0 / 3.0);
        System.out.println();
        // 정수점 8 은 field 폭
        // 소수점 2 은 precision
        // .  333.33 을 출력하라
        System.out.printf("%8.2f", 1000.0 / 3.0);

        String name = "Siwoo Kim";
        int age = 29;
        System.out.println();
        // Hello, Siwoo Kim. Next year, you'll be 30.\n 를 찍어라
        System.out.printf("Hello, %s. Next year, you'll be %d.\n", name, age+1);
        String language = "Java";
        // 'JAVAJava' 를 찍어라
        System.out.printf("%S%s", language, language);
        boolean notMeaning = false;
        System.out.println();
        // 'falseFALSE' 를 찍어라
        System.out.printf("%b%B", notMeaning, notMeaning);
        System.out.println();
        // +33,3333.33 을 찍어라
        System.out.printf("%,+.2f", 1000000 / 3.0);
        String value = "";
        // .  333.33 을 출력하라
        value = String.format("%8.2f", 1000. / 3.);
        assertEquals("  333.33", value);
        // Hello, Siwoo Kim. Next year, you'll be 30.\n 를 찍어라
        value = String.format("Hello, %s. Next year, you'll be %d.\n", name, age+1);
        assertEquals("Hello, Siwoo Kim. Next year, you'll be 30.\n", value);
        // 'JAVAJava' 를 찍어라
        value = String.format("%S%s", language, language);
        assertEquals("JAVAJava", value);
        // 'falseFALSE' 를 찍어라
        value = String.format("%b%B", notMeaning, notMeaning);
        assertEquals("falseFALSE", value);
        // +33,3333.33 을 찍어라
        value = String.format("%+,.2f", 100000. / 3.);
        assertEquals("+33,333.33", value);
    }
}
