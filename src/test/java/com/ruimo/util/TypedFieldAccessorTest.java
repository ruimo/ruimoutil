package com.ruimo.util;

import com.ruimo.util.TypedFieldAccessor;

import test.Foo;
import junit.framework.TestCase;

public class TypedFieldAccessorTest extends TestCase {
    public void test001() throws Exception {
        TypedFieldAccessor fa = TypedFieldAccessor.getInstance();
        Foo foo = new Foo();
        assertTrue(fa.getBooleanField(Foo.class, foo, "bool"));
        assertTrue(fa.getField(Foo.class, foo, "bool", boolean.class));

        assertEquals(123, fa.getByteField(Foo.class, foo, "b"));
        assertEquals(Byte.valueOf((byte)123), fa.getField(Foo.class, foo, "b", byte.class));

        assertEquals(1234, fa.getCharField(Foo.class, foo, "c"));
        assertEquals(Character.valueOf((char)1234), fa.getField(Foo.class, foo, "c", char.class));

        assertEquals(12345f, fa.getFloatField(Foo.class, foo, "f"));
        assertEquals(12345f, fa.getField(Foo.class, foo, "f", float.class));

        assertEquals(123456d, fa.getDoubleField(Foo.class, foo, "d"));
        assertEquals(123456d, fa.getField(Foo.class, foo, "d", double.class));

        assertEquals(999, fa.getShortField(Foo.class, foo, "s"));
        assertEquals(Short.valueOf((short)999), fa.getField(Foo.class, foo, "s", short.class));

        assertEquals(777, fa.getIntField(Foo.class, foo, "i"));
        assertEquals(Integer.valueOf(777), fa.getField(Foo.class, foo, "i", int.class));

        assertEquals(888, fa.getLongField(Foo.class, foo, "l"));
        assertEquals(Long.valueOf(888), fa.getField(Foo.class, foo, "l", long.class));

        assertEquals("hello", fa.getStringField(Foo.class, foo, "str"));
        assertEquals("hello", fa.getField(Foo.class, foo, "str", String.class));

        fa.setBooleanField(Foo.class, foo, "bool", false);
        assertFalse(fa.getBooleanField(Foo.class, foo, "bool"));

        fa.setByteField(Foo.class, foo, "b", (byte)21);
        assertEquals(21, fa.getByteField(Foo.class, foo, "b"));

        fa.setCharField(Foo.class, foo, "c", (char)4321);
        assertEquals(4321, fa.getCharField(Foo.class, foo, "c"));

        fa.setFloatField(Foo.class, foo, "f", 54321f);
        assertEquals(54321f, fa.getFloatField(Foo.class, foo, "f"));
        
        fa.setDoubleField(Foo.class, foo, "d", 654321d);
        assertEquals(654321d, fa.getDoubleField(Foo.class, foo, "d"));
        
        fa.setShortField(Foo.class, foo, "s", (short)111);
        assertEquals(111, fa.getShortField(Foo.class, foo, "s"));
        
        fa.setIntField(Foo.class, foo, "i", 222);
        assertEquals(222, fa.getIntField(Foo.class, foo, "i"));
        
        fa.setLongField(Foo.class, foo, "l", 333);
        assertEquals(333, fa.getLongField(Foo.class, foo, "l"));
        
        fa.setField(Foo.class, foo, "str", "world");
        assertEquals("world", fa.getStringField(Foo.class, foo, "str"));
    }

    public void test002() throws Exception {
        TypedFieldAccessor fa = TypedFieldAccessor.getInstance();
        Foo foo = new Foo();
        try {
            fa.getBooleanField(Foo.class, foo, "fool");
            fail("Exception should be thrown.");
        }
        catch (RuntimeException ex) {
        }

        try {
            fa.setBooleanField(Foo.class, foo, "fool", true);
            fail("Exception should be thrown.");
        }
        catch (RuntimeException ex) {
        }
    }
}
