package com.ruimo.util;

import com.ruimo.util.MethodInvoker;

import test.Bar;
import test.Foo;
import junit.framework.TestCase;

public class MethodInvokerTest extends TestCase {
    public void test001() throws Exception {
        MethodInvoker mi = MethodInvoker.getInstance();
        Bar bar = (Bar)mi.invokeConstructor(Bar.class, new Class[] {int.class}, new Object[] {123});
        assertEquals(123, bar.i);
    }

    public void test002() throws Exception {
        MethodInvoker mi = MethodInvoker.getInstance();
        try {
            mi.invokeConstructor(Bar.class, new Class[] {int.class, long.class},
                                 new Object[] {123, 123l});
            fail("Exception should be thrown.");
        }
        catch (RuntimeException ex) {
        }
    }

    public void test003() throws Exception {
        MethodInvoker mi = MethodInvoker.getInstance();
        try {
            mi.invokeConstructor(Bar.class, new Class[] {long.class}, new Object[] {123l});
            fail("Exception should be thrown.");
        }
        catch (RuntimeException ex) {
        }
    }

    public void test004() throws Exception {
        MethodInvoker mi = MethodInvoker.getInstance();
        Bar bar = (Bar)mi.invokeConstructor(Bar.class, new Class[] {int.class}, new Object[] {123});

        Integer i = (Integer)mi.invokeMethod(Bar.class, bar, "add",
                                             new Class[] {int.class, int.class},
                                             new Object[] {123, 345});
        assertEquals(123 + 345, i.intValue());
    }

    public void test005() throws Exception {
        MethodInvoker mi = MethodInvoker.getInstance();
        Bar bar = (Bar)mi.invokeConstructor(Bar.class, new Class[] {int.class}, new Object[] {123});

        try {
            mi.invokeMethod(Bar.class, bar, "bar", new Class[0], new Object[0]);
            fail("Exception should be thrown.");
        }
        catch (RuntimeException ex) {
        }
    }

    public void test006() throws Exception {
        MethodInvoker mi = MethodInvoker.getInstance();
        Bar bar = (Bar)mi.invokeConstructor(Bar.class, new Class[] {int.class}, new Object[] {123});

        try {
            mi.invokeMethod(Bar.class, bar, "baz", new Class[0], new Object[0]);
            fail("Exception should be thrown.");
        }
        catch (RuntimeException ex) {
        }
    }

    public void test007() throws Exception {
        MethodInvoker mi = MethodInvoker.getInstance();
        assertEquals("Hello", mi.invokeMethod(Foo.class, null, "hello"));
    }

    public void test008() throws Exception {
        MethodInvoker mi = MethodInvoker.getInstance();
        Foo foo = new Foo();
        assertEquals(101, mi.invokeMethod(Foo.class, foo, "inc", 100));
    }

    public void test009() throws Exception {
        MethodInvoker mi = MethodInvoker.getInstance();
        Foo foo = new Foo();
        assertEquals("Hello World", mi.invokeMethod(Foo.class, foo, "hello", "World"));
    }

    public void test010() throws Exception {
        MethodInvoker mi = MethodInvoker.getInstance();
        Bar bar = (Bar)mi.invokeConstructor(Bar.class);
        assertEquals(123, bar.i);
    }

    public void test011() throws Exception {
        MethodInvoker mi = MethodInvoker.getInstance();
        Bar bar = (Bar)mi.invokeConstructor(Bar.class, 12);
        assertEquals(12, bar.i);
    }

    public void test012() throws Exception {
        MethodInvoker mi = MethodInvoker.getInstance();
        Bar bar = (Bar)mi.invokeConstructor(Bar.class, "Hello");
        assertEquals("Bar Hello", bar.str);
    }
}
