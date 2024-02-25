package com.ruimo.util.builder;

import java.util.HashSet;
import java.util.Set;

import com.ruimo.util.builder.TypedSetBuilder;

import junit.framework.TestCase;

public class TypedSetBuilderTest extends TestCase {
    public void test001() throws Exception {
        Set<String> set = new TypedSetBuilder<String>(new HashSet<String>())
            .add("Hello")
            .add("World")
            .get();
        assertEquals(2, set.size());
        assertTrue(set.contains("Hello"));
        assertTrue(set.contains("World"));
    }
    
    public void test002() throws Exception {
        Set<String> set = new TypedSetBuilder<String>(new HashSet<String>())
            .add("Hello")
            .add("World")
            .getUnmodifiable();
        assertEquals(2, set.size());
        assertTrue(set.contains("Hello"));
        assertTrue(set.contains("World"));
        try {
            set.add("Foo");
            fail("Exception should be thrown.");
        }
        catch (UnsupportedOperationException ex) {
        }
    }

    public void test003() throws Exception {
        try {
            new TypedSetBuilder(null);
            fail("Exception should be thrown.");
        }
        catch (NullPointerException ex) {
        }
    }

    public void test004() throws Exception {
        TypedSetBuilder<String> builder = new TypedSetBuilder<String>(new HashSet<String>());
        builder.get();
        try {
            builder.add("Hello");
            fail("Exception should be thrown.");
        }
        catch (IllegalStateException ex) {
        }
    }

    public void test005() throws Exception {
        TypedSetBuilder builder = new TypedSetBuilder<String>(new HashSet<String>());
        builder.get();
        try {
            builder.get();
            fail("Exception should be thrown.");
        }
        catch (IllegalStateException ex) {
        }
    }
}
