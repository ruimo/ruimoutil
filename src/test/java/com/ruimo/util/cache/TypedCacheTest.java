package com.ruimo.util.cache;

import junit.framework.*;

public class TypedCacheTest extends TestCase {
    public void test1() {
        final int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final boolean[] called = new boolean[1];
        TypedCache<Integer> cache = new TypedCache<Integer>() {
            protected Integer computeValue() {
                called[0] = true;
                int sum = 0;
                for (int num:nums) sum += num;
                return Integer.valueOf(sum);
            }
        };
        assertEquals(Integer.valueOf(55), cache.getValue());
        called[0] = false;
        assertEquals(Integer.valueOf(55), cache.getValue());
        assertEquals(false, called[0]);
        cache.invalidate();
        assertEquals(Integer.valueOf(55), cache.getValue());
        assertEquals(true, called[0]);
        called[0] = false;
        assertEquals(Integer.valueOf(55), cache.getValue());
        assertEquals(false, called[0]);
    }
}
