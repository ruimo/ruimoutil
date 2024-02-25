package com.ruimo.util;

import com.ruimo.util.builder.CollectionBuilderTest;
import com.ruimo.util.builder.ListBuilderTest;
import com.ruimo.util.builder.MapBuilderTest;
import com.ruimo.util.builder.SetBuilderTest;
import com.ruimo.util.builder.TypedCollectionBuilderTest;
import com.ruimo.util.builder.TypedListBuilderTest;
import com.ruimo.util.builder.TypedMapBuilderTest;
import com.ruimo.util.builder.TypedSetBuilderTest;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.ruimo.util.cache.CacheTest;
import com.ruimo.util.cache.TypedCacheTest;

public final class AllTests {
    public static Test suite() {
        TestSuite suite = new TestSuite("Test for com.ruimo.util");
        //$JUnit-BEGIN$
        suite.addTestSuite(TypedCollectionBuilderTest.class);
        suite.addTestSuite(TypedSetBuilderTest.class);
        suite.addTestSuite(TypedMapBuilderTest.class);
        suite.addTestSuite(MethodInvokerTest.class);
        suite.addTestSuite(ListBuilderTest.class);
        suite.addTestSuite(SetBuilderTest.class);
        suite.addTestSuite(TypedMethodInvokerTest.class);
        suite.addTestSuite(TypedFieldAccessorTest.class);
        suite.addTestSuite(FieldAccessorTest.class);
        suite.addTestSuite(MapBuilderTest.class);
        suite.addTestSuite(CollectionBuilderTest.class);
        suite.addTestSuite(TypedListBuilderTest.class);
        suite.addTestSuite(EmptyArraysTest.class);
        suite.addTestSuite(TypedEmptyArraysTest.class);
        suite.addTestSuite(CacheTest.class);
        suite.addTestSuite(TypedCacheTest.class);
        suite.addTestSuite(MathTest.class);
        //$JUnit-END$
        return suite;
    }

}
