package com.ruimo.util.builder;

import java.util.ArrayList;
import java.util.Collection;

import com.ruimo.util.builder.CollectionBuilder;

import junit.framework.TestCase;

public class CollectionBuilderTest extends TestCase {
    public void test001() throws Exception {
        Collection list = new CollectionBuilder(new ArrayList())
            .add("Hello")
            .add("World")
            .get();
        assertEquals(2, list.size());
        assertTrue(list.contains("Hello"));
        assertTrue(list.contains("World"));
    }
    
    public void test002() throws Exception {
        Collection list = new CollectionBuilder(new ArrayList())
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
            new CollectionBuilder(null);
            fail("Exception should be thrown.");
        }
        catch (NullPointerException ex) {
        }
    }

    public void test004() throws Exception {
        CollectionBuilder builder = new CollectionBuilder(new ArrayList());
        builder.get();
        try {
            builder.add("Hello");
            fail("Exception should be thrown.");
        }
        catch (IllegalStateException ex) {
        }
    }

    public void test005() throws Exception {
        CollectionBuilder builder = new CollectionBuilder(new ArrayList());
        builder.get();
        try {
            builder.get();
            fail("Exception should be thrown.");
        }
        catch (IllegalStateException ex) {
        }
    }
}
