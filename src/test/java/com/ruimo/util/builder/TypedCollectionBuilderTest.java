package com.ruimo.util.builder;

import java.util.ArrayList;
import java.util.Collection;

import com.ruimo.util.builder.TypedCollectionBuilder;

import junit.framework.TestCase;

public class TypedCollectionBuilderTest extends TestCase {
    public void test001() throws Exception {
        Collection<String> list = new TypedCollectionBuilder<String>(new ArrayList<String>())
            .add("Hello")
            .add("World")
            .get();
        assertEquals(2, list.size());
        assertTrue(list.contains("Hello"));
        assertTrue(list.contains("World"));
    }
    
    public void test002() throws Exception {
        Collection<String> list = new TypedCollectionBuilder<String>(new ArrayList<String>())
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
            new TypedCollectionBuilder(null);
            fail("Exception should be thrown.");
        }
        catch (NullPointerException ex) {
        }
    }

    public void test004() throws Exception {
        TypedCollectionBuilder<String> builder = new TypedCollectionBuilder<String>(new ArrayList<String>());
        builder.get();
        try {
            builder.add("Hello");
            fail("Exception should be thrown.");
        }
        catch (IllegalStateException ex) {
        }
    }

    public void test005() throws Exception {
        TypedCollectionBuilder builder = new TypedCollectionBuilder<String>(new ArrayList<String>());
        builder.get();
        try {
            builder.get();
            fail("Exception should be thrown.");
        }
        catch (IllegalStateException ex) {
        }
    }
}
