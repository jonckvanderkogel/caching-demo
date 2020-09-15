package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CacheableTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Autowired
    private A a;

    @BeforeEach
    public void init() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testCaching() {
        a.getEntityCount("foo");
        a.getEntityCount("foo");

        assertEquals("Inside function: foo", outContent.toString());
    }
}