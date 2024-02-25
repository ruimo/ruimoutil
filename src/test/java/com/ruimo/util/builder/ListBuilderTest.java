package com.ruimo.util.builder;

import java.util.ArrayList;
import java.util.List;

import com.ruimo.util.builder.ListBuilder;

import junit.framework.TestCase;

public class ListBuilderTest extends TestCase {
    public void test001() throws Exception {
        List list = new ListBuilder(new ArrayList())
            .add("Hello")
            .add("World")
            .get();
        assertEquals(2, list.size());
        assertEquals("Hello", list.get(0));
        assertEquals("World", list.get(1));
    }
    
    public void test002() throws Exception {
        List list = new ListBuilder(new ArrayList())
            .add("Hello")
            .add("World")
            .getUnmodifiable();
        assertEquals(2, list.size());
        assertEquals("Hello", list.get(0));
        assertEquals("World", list.get(1));
        try {
            list.add("Foo");
            fail("Exception should be thrown.");
        }
        catch (UnsupportedOperationException ex) {
        }
    }

    public void test003() throws Exception {
        try {
            new ListBuilder(null);
            fail("Exception should be thrown.");
        }
        catch (NullPointerException ex) {
        }
    }

    public void test004() throws Exception {
        ListBuilder builder = new ListBuilder(new ArrayList());
        builder.get();
        try {
            builder.add("Hello");
            fail("Exception should be thrown.");
        }
        catch (IllegalStateException ex) {
        }
    }

    public void test005() throws Exception {
        ListBuilder builder = new ListBuilder(new ArrayList());
        builder.get();
        try {
            builder.get();
            fail("Exception should be thrown.");
        }
        catch (IllegalStateException ex) {
        }
    }
}
