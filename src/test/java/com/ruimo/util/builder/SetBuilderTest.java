package com.ruimo.util.builder;

import java.util.HashSet;
import java.util.Set;

import com.ruimo.util.builder.SetBuilder;

import junit.framework.TestCase;

public class SetBuilderTest extends TestCase {
    public void test001() throws Exception {
        Set list = new SetBuilder(new HashSet())
            .add("Hello")
            .add("World")
            .get();
        assertEquals(2, list.size());
        assertTrue(list.contains("Hello"));
        assertTrue(list.contains("World"));
    }
    
    public void test002() throws Exception {
        Set list = new SetBuilder(new HashSet())
            .add("Hello")
            .add("World")
            .getUnmodifiable();
        assertEquals(2, list.size());
        assertTrue(list.contains("Hello"));
        assertTrue(list.contains("World"));
        try {
            list.add("Foo");
            fail("Exception should be thrown.");
        }
        catch (UnsupportedOperationException ex) {
        }
    }

    public void test003() throws Exception {
        try {
            new SetBuilder(null);
            fail("Exception should be thrown.");
        }
        catch (NullPointerException ex) {
        }
    }

    public void test004() throws Exception {
        SetBuilder builder = new SetBuilder(new HashSet());
        builder.get();
        try {
            builder.add("Hello");
            fail("Exception should be thrown.");
        }
        catch (IllegalStateException ex) {
        }
    }

    public void test005() throws Exception {
        SetBuilder builder = new SetBuilder(new HashSet());
        builder.get();
        try {
            builder.get();
            fail("Exception should be thrown.");
        }
        catch (IllegalStateException ex) {
        }
    }
}
