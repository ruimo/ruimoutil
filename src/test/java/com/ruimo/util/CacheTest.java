package com.ruimo.util;

import junit.framework.*;

import com.ruimo.util.cache.Cache;

public class CacheTest extends TestCase {
    public CacheTest(String name) {
        super (name);
    }

    public void doTest() {
        final int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final boolean[] called = new boolean[1];
        class Computer extends Cache {
            public Integer computeValue() {
                int sum = 0;
                for (int i = 0; i < nums.length; i++) {
                    sum += nums[i];
                }

                called[0] = true;
                return new Integer(sum);
            }
        };
        Cache cache = new Computer();
        assertEquals(new Integer(55), cache.getValue());
        called[0] = false;
        assertEquals(new Integer(55), cache.getValue());
        assertEquals(false, called[0]);
        cache.invalidate();
        assertEquals(new Integer(55), cache.getValue());
        assertEquals(true, called[0]);
        called[0] = false;
        assertEquals(new Integer(55), cache.getValue());
        assertEquals(false, called[0]);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new CacheTest("doTest"));
        return suite;
    }
}
