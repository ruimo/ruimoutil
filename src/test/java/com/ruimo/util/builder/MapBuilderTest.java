package com.ruimo.util.builder;

import java.util.HashMap;
import java.util.Map;

import com.ruimo.util.builder.MapBuilder;

import junit.framework.TestCase;

public class MapBuilderTest extends TestCase {
    public void test001() throws Exception {
        Map map = new MapBuilder(new HashMap())
            .put("Hello", "World")
            .put("Ruimo", "Uno")
            .get();
        assertEquals(2, map.size());
        assertEquals("World", map.get("Hello"));
        assertEquals("Uno", map.get("Ruimo"));
    }

    public void test002() throws Exception {
        try {
            new MapBuilder(null);
            fail("Exception should be thrown.");
        }
        catch (NullPointerException ex) {
        }
    }

    public void test003() throws Exception {
        Map map = new MapBuilder(new HashMap())
            .put("Hello", "World")
            .put("Ruimo", "Uno")
            .getUnmodifiable();
        assertEquals(2, map.size());
        assertEquals("World", map.get("Hello"));
        assertEquals("Uno", map.get("Ruimo"));
        try {
            map.put("Foo", "Bar");
            fail("Exception should be thrown.");
        }
        catch (UnsupportedOperationException ex) {
        }
    }

    public void test004() throws Exception {
        MapBuilder builder = new MapBuilder(new HashMap());
        builder.get();
        try {
            builder.put("Hello", "World");
            fail("Exception should be thrown.");
        }
        catch (IllegalStateException ex) {
        }
    }

    public void test005() throws Exception {
        MapBuilder builder = new MapBuilder(new HashMap());
        builder.get();
        try {
            builder.get();
            fail("Exception should be thrown.");
        }
        catch (IllegalStateException ex) {
        }
    }
}
