package com.ruimo.util.cache;

import junit.framework.*;

public class CacheTest extends TestCase {
    public void test1() {
        final int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final boolean[] called = new boolean[1];
        Cache cache = new Cache() {
            protected Object computeValue() {
                called[0] = true;
                int sum = 0;
                for (int num:nums) sum += num;
                return new Integer(sum);
            }
        };
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
}
