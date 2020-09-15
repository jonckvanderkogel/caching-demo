package com.example.withoutspring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaffeineCacheableTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private B b = new B();

    @BeforeEach
    public void init() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testCaching() {
        b.getEntityCount("foo");
        b.getEntityCount("foo");

        assertEquals("Inside function: foo", outContent.toString());
    }
}
