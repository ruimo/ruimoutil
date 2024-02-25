package com.ruimo.util;

import com.ruimo.util.TypedMethodInvoker;

import test.Bar;
import junit.framework.TestCase;

public class TypedMethodInvokerTest extends TestCase {
    public void test001() throws Exception {
        TypedMethodInvoker mi = TypedMethodInvoker.getInstance();
        Bar bar = mi.invokeConstructor(Bar.class, new Class[] {int.class}, new Object[] {123});
        assertEquals(123, bar.i);
        
//         int i = mi.invokeMethod(Bar.class, bar, "add",
//                                 new Class[] {int.class, int.class},
//                                 new Object[] {123, 345}, int.class);
//         assertEquals(123 + 345, i);
    }

    public void test002() throws Exception {
        TypedMethodInvoker mi = TypedMethodInvoker.getInstance();
        Bar bar = mi.invokeConstructor(Bar.class);
        assertEquals(123, bar.i);
    }

    public void test003() throws Exception {
        TypedMethodInvoker mi = TypedMethodInvoker.getInstance();
        Bar bar = mi.invokeConstructor(Bar.class, 12);
        assertEquals(12, bar.i);
    }

    public void test004() throws Exception {
        TypedMethodInvoker mi = TypedMethodInvoker.getInstance();
        Bar bar = mi.invokeConstructor(Bar.class, "Hello");
        assertEquals("Bar Hello", bar.str);
    }
}

