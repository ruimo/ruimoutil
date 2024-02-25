package com.ruimo.util;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

/**
<#if locale="ja">
サイズ0配列。
<#else>
Empty arrays.
</#if>
 */
public class EmptyArrays {
    EmptyArrays() {}

    /** 
    <#if locale="ja">
    blloeanのサイズ0配列。
    <#else>
    boolean empty array
    </#if>
    */
    public static final boolean[] OF_BOOLEAN = new boolean[0];

    /**
    <#if locale="ja">
    Booleanのサイズ0配列。
    <#else>
    Boolean empty array
    </#if>
    */
    public static final Boolean[] OF_BOOLEAN_WRAPPER = new Boolean[0];

    /** 
    <#if locale="ja">
    byteのサイズ0配列。
    <#else>
    byte empty array 
    </#if>
    */
    public static final byte[] OF_BYTE = new byte[0];

    /**
    <#if locale="ja">
    Byteのサイズ0配列。
    <#else>
    Byte empty array
    </#if>
    */
    public static final Byte[] OF_BYTE_WRAPPER = new Byte[0];

    /**
    <#if locale="ja">
    charのサイズ0配列。
    <#else>
    char empty array
    </#if>
    */
    public static final char[] OF_CHAR = new char[0];

    /**
    <#if locale="ja">
    Characterのサイズ0配列。
    <#else>
    Character empty array
    </#if>
    */
    public static final Character[] OF_CHAR_WRAPPER = new Character[0];

    /**
    <#if locale="ja">
    doubleのサイズ0配列。
    <#else>
    double empty array
    </#if>
    */
    public static final double[] OF_DOUBLE = new double[0];

    /**
    <#if locale="ja">
    Doubleのサイズ0配列。
    <#else>
    Double empty array
    </#if>
    */
    public static final Double[] OF_DOUBLE_WRAPPER = new Double[0];

    /**
    <#if locale="ja">
    floatのサイズ0配列。
    <#else>
    float empty array
    </#if>
    */
    public static final float[] OF_FLOAT = new float[0];

    /**
    <#if locale="ja">
    Floatのサイズ0配列。
    <#else>
    Float empty array
    </#if>
    */
    public static final Float[] OF_FLOAT_WRAPPER = new Float[0];

    /**
    <#if locale="ja">
    shortのサイズ0配列。
    <#else>
    short empty array
    </#if>
    */
    public static final short[] OF_SHORT = new short[0];

    /**
    <#if locale="ja">
    Shortのサイズ0配列。
    <#else>
    Short empty array
    </#if>
    */
    public static final Short[] OF_SHORT_WRAPPER = new Short[0];

    /**
    <#if locale="ja">
    intのサイズ0配列。
    <#else>
    int empty array
    </#if>
    */
    public static final int[] OF_INT = new int[0];

    /**
    <#if locale="ja">
    Integerのサイズ0配列。
    <#else>
    Integer empty array
    </#if>
    */
    public static final Integer[] OF_INT_WRAPPER = new Integer[0];

    /**
    <#if locale="ja">
    longのサイズ0配列。
    <#else>
    long empty array
    </#if>
    */
    public static final long[] OF_LONG = new long[0];

    /**
    <#if locale="ja">
    Longのサイズ0配列。
    <#else>
    Long empty array
    </#if>
    */
    public static final Long[] OF_LONG_WRAPPER = new Long[0];

    /**
    <#if locale="ja">
    classのサイズ0配列。
    <#else>
    class empty array
    </#if>
    */
    public static final Class[] OF_CLASS = (Class[])getInstance(Class.class);

    /**
    <#if locale="ja">
    Stringのサイズ0配列。
    <#else>
    String empty array
    </#if>
    */
    public static final String[] OF_STRING = (String[])getInstance(String.class);

    /**
    <#if locale="ja">
    Objectのサイズ0配列。
    <#else>
    Object empty array
    </#if>
    */
    public static final Object[] OF_OBJECT = (Object[])getInstance(Object.class);

    private static Map map = new HashMap();
    private static Object lock = new Object();

    /**
    <#if locale="ja">

    サイズ0配列の取得。このメソッドを使用することで、あらゆる型のサイ
    ズ0配列を取得できます。警告:ただし、このメソッドでプリミティブ型の
    配列を取得することはできません。例えばgetInstance(int.class)は、
    int[]ではなくInteger[]を返します。
    @param cls クラスオブジェクト。ここで指定された型のサイズ0配列を返
    します。
    @return return サイズ0配列。

    <#else>

    Get empty array in any type. This method can be used for arrays
    in any type. Caution: this method cannot create arrays in types
    of primitives. Invoking getInstance(int.class) will return the
    Integer[] instead of the int[].
    @param cls Class object. This method create an arrays of the
    specified type.
    @return An array of specified type.
    </#if>
     */
    public static Object[] getInstance(Class cls) {
        if (cls == Class.class) return OF_CLASS;
        if (cls == String.class) return OF_STRING;
        if (cls == Object.class) return OF_OBJECT;
        synchronized (lock) {
            Object[] array = (Object[])map.get(cls);
            if (array == null) {
                array = (Object[])Array.newInstance(cls, 0);
                map.put(cls, array);
            }
            return array;
        }
    }
}
