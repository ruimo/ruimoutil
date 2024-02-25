package com.ruimo.util;

import junit.framework.TestCase;

public class TypedEmptyArraysTest extends TestCase {
    public void test001() throws Exception {
        Integer[] i = TypedEmptyArrays.getInstance(Integer.class);
        assertEquals(0, i.length);
    }
}
