package com.ruimo.util;

/**
<#if locale="ja">

{@link FieldAccessor}のタイプセーフ版。使用するにはJava 5以上が必要です。

<#else>
Type safe version of the {@link FieldAccessor}.
</#if>
 *
<pre>
public class Foo {
    private String str = "Hello";
}

    Foo foo = new Foo();

    FieldAccessor fa = FieldAccessor.getInstance();
    String str = (String)fa.getField(Foo.class, foo, "str");

    TypedFieldAccessor tfa = TypedFieldAccessor.getInstance();
    str = fa.getField(Foo.class, foo, "str", String.class);
...
</pre>
 * @see FieldAccessor
 */
public class TypedFieldAccessor extends FieldAccessor {
    protected TypedFieldAccessor() {}

    private static TypedFieldAccessor instance = new TypedFieldAccessor();

    /**
    <#if locale="ja">

    インスタンス取得。
    @return このクラスのインスタンスが返されます。   
    
    <#else>

    Retrieve an instance of this class.
    @return An instance of this class.
    </#if>
    */
    public static TypedFieldAccessor getInstance() {
        return instance;
    }

    /**
    <#if locale="ja">

    フィールドの取得。
    @param cls フィールドが宣言されているクラス。
    @param thisObj フィールドが宣言されているクラスのインスタンス。
    @param fieldName フィールドの名前。
    @param fieldType フィールドの型。
    @return 指定されたフィールドの値。
    
    <#else>

    Retrieve a value of the specified field.
    @param cls A class where the specified field is declared.
    @param thisObj An instance of the specified class that declares
    the field.
    @param fieldName The name of the field.
    @param fieldType The type of the field.
    @return An instance of this class.
    </#if>
    */
    public <T> T getField(Class cls, Object thisObj, String fieldName, Class<T> fieldType) {
        return (T)getField(cls, thisObj, fieldName);
    }

    /**
    <#if locale="ja">

    替わりに{@link #getField(Class, Object, String, Class)}を使用してください。

    <#else>

    Use {@link #getField(Class, Object, String, Class)} instead.

    </#if>
     * @deprecated
     * @see #setField(Class, Object, String, Object)
     */
    public void setBooleanField(Class cls, Object thisObj, String fieldName, boolean value) {
        setField(cls, thisObj, fieldName, value);
    }

    /**
    <#if locale="ja">

    替わりに{@link #getField(Class, Object, String, Class)}を使用してください。

    <#else>

    Use {@link #getField(Class, Object, String, Class)} instead.

    </#if>
     * @deprecated
     * @see #setField(Class, Object, String, Object)
     */
    public void setByteField(Class cls, Object thisObj, String fieldName, byte value) {
        setField(cls, thisObj, fieldName, value);
    }
    
    /**
    <#if locale="ja">

    替わりに{@link #getField(Class, Object, String, Class)}を使用してください。

    <#else>

    Use {@link #getField(Class, Object, String, Class)} instead.

    </#if>
     * @deprecated
     * @see #setField(Class, Object, String, Object)
     */
    public void setCharField(Class cls, Object thisObj, String fieldName, char value) {
        setField(cls, thisObj, fieldName, value);
    }

    /**
    <#if locale="ja">

    替わりに{@link #getField(Class, Object, String, Class)}を使用してください。

    <#else>

    Use {@link #getField(Class, Object, String, Class)} instead.

    </#if>
     * @deprecated
     * @see #setField(Class, Object, String, Object)
     */
    public void setDoubleField(Class cls, Object thisObj, String fieldName, double value) {
        setField(cls, thisObj, fieldName, value);
    }

    /**
    <#if locale="ja">

    替わりに{@link #getField(Class, Object, String, Class)}を使用してください。

    <#else>

    Use {@link #getField(Class, Object, String, Class)} instead.

    </#if>
     * @deprecated
     * @see #setField(Class, Object, String, Object)
     */
    public void setFloatField(Class cls, Object thisObj, String fieldName, float value) {
        setField(cls, thisObj, fieldName, value);
    }

    /**
    <#if locale="ja">

    替わりに{@link #getField(Class, Object, String, Class)}を使用してください。

    <#else>

    Use {@link #getField(Class, Object, String, Class)} instead.

    </#if>
     * @deprecated
     * @see #setField(Class, Object, String, Object)
     */
    public void setShortField(Class cls, Object thisObj, String fieldName, short value) {
        setField(cls, thisObj, fieldName, value);
    }

    /**
    <#if locale="ja">

    替わりに{@link #getField(Class, Object, String, Class)}を使用してください。

    <#else>

    Use {@link #getField(Class, Object, String, Class)} instead.

    </#if>
     * @deprecated
     * @see #setField(Class, Object, String, Object)
     */
    public void setIntField(Class cls, Object thisObj, String fieldName, int value) {
        setField(cls, thisObj, fieldName, value);
    }

    /**
    <#if locale="ja">

    替わりに{@link #getField(Class, Object, String, Class)}を使用してください。

    <#else>

    Use {@link #getField(Class, Object, String, Class)} instead.

    </#if>
     * @deprecated
     * @see #setField(Class, Object, String, Object)
     */
    public void setLongField(Class cls, Object thisObj, String fieldName, long value) {
        setField(cls, thisObj, fieldName, value);
    }
}
