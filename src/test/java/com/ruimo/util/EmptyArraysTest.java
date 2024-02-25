package com.ruimo.util;

import junit.framework.TestCase;

public class EmptyArraysTest extends TestCase {
    public void test001() throws Exception {
        Integer[] i = (Integer[])EmptyArrays.getInstance(Integer.class);
        assertEquals(0, i.length);
    }
}
