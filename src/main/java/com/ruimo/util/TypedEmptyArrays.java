package com.ruimo.util;

/**
<#if locale="ja">

{@link EmptyArrays}のタイプセーフ版。使用するにはJava 5以上が必要です。

<#else>
Type safe version of {@link EmptyArrays}. Java 5 or higher is
required.
</#if>
 */
public class TypedEmptyArrays {
    TypedEmptyArrays() {}

    /**
    <#if locale="ja">

    サイズ0配列の取得。このメソッドを使用することで、あらゆる型のサイ
    ズ0配列を取得できます。警告:ただし、このメソッドでプリミティブ型の
    配列を取得することはできません。例えばgetInstance(int.class)は、
    int[]ではなくInteger[]を返します。プリミティブ型のサイズ0配列が必
    要な場合は替わりに{@link EmptyArrays}を使用してください。
    @param cls クラスオブジェクト。指定されたクラスのサイズ0配列が返さ
    れます。
    @return 指定された型のサイズ0配列。
    <#else>
    Get empty array in any type. This method can be used for
    creating empty arrays in any type. Caution: this method cannot
    create arrays in types of primitives. Invoking
    getInstance(int.class) will return the Integer[] instead of the
    int[]. If you need to create arrays in primitive types, use the
    {@link EmptyArrays} instead.
    @param cls Class object. This method create an arrays of the
    specified type.
    @return An array of specified type.
    </#if>
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] getInstance(Class<T> cls) {
        return (T[])EmptyArrays.getInstance(cls);
    }
}
