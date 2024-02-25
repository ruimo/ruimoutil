package com.ruimo.util;

import java.lang.reflect.Field;

/**
<#if locale="ja">

クラスのフィールドを読み書きするためのヘルパクラス。リフレクションを使
用しているため、privateフィールドにもアクセスできます。

<#else>

A helper class to get and set fields. Since it uses the reflection
feature, you can even access private fields.

</#if>
 *
<pre>
public class Foo {
    private boolean bool = true;
    private byte b = 123;
}

    FieldAccessor fa = FieldAccessor.getInstance();
    Foo foo = new Foo();
    assertTrue(fa.getBooleanField(Foo.class, foo, "bool"));
    assertEquals(123, fa.getByteField(Foo.class, foo, "b"));
...
</pre>
 */
public class FieldAccessor {
    protected FieldAccessor() {}

    private final static FieldAccessor instance = new FieldAccessor();

    /**
    <#if locale="ja">

    インスタンスの取得。
    @return このクラスのインスタンス。nullが返ることはありません。
    <#else>

    Get instance of this class.
    @return An instance of this class. Null will be never returned.
    </#if>
     */
    public static FieldAccessor getInstance() {
        return instance;
    }

    /**
    <#if locale="ja">

    booleanのフィールドを読み出します。
    @param cls フィールドが宣言されているクラス。nullは許されません。
    @param thisObj フィールドが宣言されているクラスのインスタンス。フィー
    ルドがstaticの場合はnullを渡してください。そうでなければnullは許さ
    れません。
    @param fieldName アクセスするフィールドの名前。
    @return フィールドの値。
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException}と{@link
    java.lang.IllegalAccessException}は、{@link
    java.lang.RuntimException}にラップされてスローされます。このため、
    呼び出し元でtry-catch節を用意する必要はありません。
    
    <#else>

    Get boolean field.
    @param cls The class object the field belongs to. Null is not
    permitted.
    @param thisObj An instance of the class the accessing field
    belongs to. Specify null to retrieve a value of a static
    field. Null is not permitted if the field is non-static field.
    @param fieldName The field name to be accessed.
    @return Field value.
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException} and {@link
    java.lang.IllegalAccessException} are wrapped in a {@link
    java.lang.RuntimException} and the invocation do not need to be
    surrounded by a try-catch clause.

    </#if>
     */
    public boolean getBooleanField(Class cls, Object thisObj, String fieldName) {
        return ((Boolean)getField(cls, thisObj, fieldName)).booleanValue();
    }

    /**
    <#if locale="ja">

    byteのフィールドを取得する。
    @param cls フィールドが宣言されているクラス。nullは許されません。
    @param thisObj フィールドが宣言されているクラスのインスタンス。フィー
    ルドがstaticの場合はnullを渡してください。そうでなければnullは許さ
    れません。
    @param fieldName アクセスするフィールドの名前。
    @return フィールドの値。
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException}と{@link
    java.lang.IllegalAccessException}は、{@link
    java.lang.RuntimException}にラップされてスローされます。このため、
    呼び出し元でtry-catch節を用意する必要はありません。

    <#else>

    Get byte field.
    @param cls The class object the field belongs to. Null is not
    permitted.
    @param thisObj An instance of the class the accessing field
    belongs to. Specify null to retrieve a value of a static
    field. Null is not permitted if the field is non-static field.
    @param fieldName The field name to be accessed.
    @return Field value.
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException} and {@link
    java.lang.IllegalAccessException} are wrapped in a {@link
    java.lang.RuntimException} and the invocation do not need to be
    surrounded by a try-catch clause.

    </#if>
     */
    public byte getByteField(Class cls, Object thisObj, String fieldName) {
        return ((Byte)getField(cls, thisObj, fieldName)).byteValue();
    }
    
    /**
    <#if locale="ja">

    charのフィールドを取得する。
    @param cls フィールドが宣言されているクラス。nullは許されません。
    @param thisObj フィールドが宣言されているクラスのインスタンス。フィー
    ルドがstaticの場合はnullを渡してください。そうでなければnullは許さ
    れません。
    @param fieldName アクセスするフィールドの名前。
    @return フィールドの値。
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException}と{@link
    java.lang.IllegalAccessException}は、{@link
    java.lang.RuntimException}にラップされてスローされます。このため、
    呼び出し元でtry-catch節を用意する必要はありません。

    <#else>
    Get char field.
    @param cls The class object the field belongs to. Null is not
    permitted.
    @param thisObj An instance of the class the accessing field
    belongs to. Specify null to retrieve a value of a static
    field. Null is not permitted if the field is non-static field.
    @param fieldName The field name to be accessed.
    @return Field value.
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException} and {@link
    java.lang.IllegalAccessException} are wrapped in a {@link
    java.lang.RuntimException} and the invocation do not need to be
    surrounded by a try-catch clause.
    </#if>
     */
    public char getCharField(Class cls, Object thisObj, String fieldName) {
        return ((Character)getField(cls, thisObj, fieldName)).charValue();
    }
    
    /**
    <#if locale="ja">
    
    doubleのフィールドを取得する。
    @param cls フィールドが宣言されているクラス。nullは許されません。
    @param thisObj フィールドが宣言されているクラスのインスタンス。フィー
    ルドがstaticの場合はnullを渡してください。そうでなければnullは許さ
    れません。
    @param fieldName アクセスするフィールドの名前。
    @return フィールドの値。
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException}と{@link
    java.lang.IllegalAccessException}は、{@link
    java.lang.RuntimException}にラップされてスローされます。このため、
    呼び出し元でtry-catch節を用意する必要はありません。

    <#else>
    Get double field.
    @param cls The class object the field belongs to. Null is not
    permitted.
    @param thisObj An instance of the class the accessing field
    belongs to. Specify null to retrieve a value of a static
    field. Null is not permitted if the field is non-static field.
    @param fieldName The field name to be accessed.
    @return Field value.
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException} and {@link
    java.lang.IllegalAccessException} are wrapped in a {@link
    java.lang.RuntimException} and the invocation do not need to be
    surrounded by a try-catch clause.
    </#if>
     */
    public double getDoubleField(Class cls, Object thisObj, String fieldName) {
        return ((Double)getField(cls, thisObj, fieldName)).doubleValue();
    }
    
    /**
    <#if locale="ja">

    floatのフィールドを取得する。
    @param cls フィールドが宣言されているクラス。nullは許されません。
    @param thisObj フィールドが宣言されているクラスのインスタンス。フィー
    ルドがstaticの場合はnullを渡してください。そうでなければnullは許さ
    れません。
    @param fieldName アクセスするフィールドの名前。
    @return フィールドの値。
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException}と{@link
    java.lang.IllegalAccessException}は、{@link
    java.lang.RuntimException}にラップされてスローされます。このため、
    呼び出し元でtry-catch節を用意する必要はありません。

    <#else>
    Get float field.
    @param cls The class object the field belongs to. Null is not
    permitted.
    @param thisObj An instance of the class the accessing field
    belongs to. Specify null to retrieve a value of a static
    field. Null is not permitted if the field is non-static field.
    @param fieldName The field name to be accessed.
    @return Field value.
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException} and {@link
    java.lang.IllegalAccessException} are wrapped in a {@link
    java.lang.RuntimException} and the invocation do not need to be
    surrounded by a try-catch clause.
    </#if>
     */
    public float getFloatField(Class cls, Object thisObj, String fieldName) {
        return ((Float)getField(cls, thisObj, fieldName)).floatValue();
    }
    
    /**
    <#if locale="ja">
    
    shortのフィールドを取得する。
    @param cls フィールドが宣言されているクラス。nullは許されません。
    @param thisObj フィールドが宣言されているクラスのインスタンス。フィー
    ルドがstaticの場合はnullを渡してください。そうでなければnullは許さ
    れません。
    @param fieldName アクセスするフィールドの名前。
    @return フィールドの値。
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException}と{@link
    java.lang.IllegalAccessException}は、{@link
    java.lang.RuntimException}にラップされてスローされます。このため、
    呼び出し元でtry-catch節を用意する必要はありません。

    <#else>
    Get short field.
    @param cls The class object the field belongs to. Null is not
    permitted.
    @param thisObj An instance of the class the accessing field
    belongs to. Specify null to retrieve a value of a static
    field. Null is not permitted if the field is non-static field.
    @param fieldName The field name to be accessed.
    @return Field value.
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException} and {@link
    java.lang.IllegalAccessException} are wrapped in a {@link
    java.lang.RuntimException} and the invocation do not need to be
    surrounded by a try-catch clause.
    </#if>
     */
    public short getShortField(Class cls, Object thisObj, String fieldName) {
        return ((Short)getField(cls, thisObj, fieldName)).shortValue();
    }
    
    /**
    <#if locale="ja">

    intのフィールドを取得する。
    @param cls フィールドが宣言されているクラス。nullは許されません。
    @param thisObj フィールドが宣言されているクラスのインスタンス。フィー
    ルドがstaticの場合はnullを渡してください。そうでなければnullは許さ
    れません。
    @param fieldName アクセスするフィールドの名前。
    @return フィールドの値。
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException}と{@link
    java.lang.IllegalAccessException}は、{@link
    java.lang.RuntimException}にラップされてスローされます。このため、
    呼び出し元でtry-catch節を用意する必要はありません。

    <#else>
    Get int field.
    @param cls The class object the field belongs to. Null is not
    permitted.
    @param thisObj An instance of the class the accessing field
    belongs to. Specify null to retrieve a value of a static
    field. Null is not permitted if the field is non-static field.
    @param fieldName The field name to be accessed.
    @return Field value.
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException} and {@link
    java.lang.IllegalAccessException} are wrapped in a {@link
    java.lang.RuntimException} and the invocation do not need to be
    surrounded by a try-catch clause.
    </#if>
     */
    public int getIntField(Class cls, Object thisObj, String fieldName) {
        return ((Integer)getField(cls, thisObj, fieldName)).intValue();
    }
    
    /**
    <#if locale="ja">

    longのフィールドを取得する。
    @param cls フィールドが宣言されているクラス。nullは許されません。
    @param thisObj フィールドが宣言されているクラスのインスタンス。フィー
    ルドがstaticの場合はnullを渡してください。そうでなければnullは許さ
    れません。
    @param fieldName アクセスするフィールドの名前。
    @return フィールドの値。
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException}と{@link
    java.lang.IllegalAccessException}は、{@link
    java.lang.RuntimException}にラップされてスローされます。このため、
    呼び出し元でtry-catch節を用意する必要はありません。

    <#else>
    Get long field.
    @param cls The class object the field belongs to. Null is not
    permitted.
    @param thisObj An instance of the class the accessing field
    belongs to. Specify null to retrieve a value of a static
    field. Null is not permitted if the field is non-static field.
    @param fieldName The field name to be accessed.
    @return Field value.
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException} and {@link
    java.lang.IllegalAccessException} are wrapped in a {@link
    java.lang.RuntimException} and the invocation do not need to be
    surrounded by a try-catch clause.
    </#if>
     */
    public long getLongField(Class cls, Object thisObj, String fieldName) {
        return ((Long)getField(cls, thisObj, fieldName)).longValue();
    }
    
    /**
    <#if locale="ja">

    Stringのフィールドを取得する。
    @param cls フィールドが宣言されているクラス。nullは許されません。
    @param thisObj フィールドが宣言されているクラスのインスタンス。フィー
    ルドがstaticの場合はnullを渡してください。そうでなければnullは許さ
    れません。
    @param fieldName アクセスするフィールドの名前。
    @return フィールドの値。
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException}と{@link
    java.lang.IllegalAccessException}は、{@link
    java.lang.RuntimException}にラップされてスローされます。このため、
    呼び出し元でtry-catch節を用意する必要はありません。

    <#else>
    Get String field.
    @param cls The class object the field belongs to. Null is not
    permitted.
    @param thisObj An instance of the class the accessing field
    belongs to. Specify null to retrieve a value of a static
    field. Null is not permitted if the field is non-static field.
    @param fieldName The field name to be accessed.
    @return Field value.
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException} and {@link
    java.lang.IllegalAccessException} are wrapped in a {@link
    java.lang.RuntimException} and the invocation do not need to be
    surrounded by a try-catch clause.
    </#if>
     */
    public String getStringField(Class cls, Object thisObj, String fieldName) {
        return (String)getField(cls, thisObj, fieldName);
    }
    
    /**
    <#if locale="ja">

    フィールドを取得する。取得したいフィールドの型がプリミティブ型でも
    Stringでもない場合にこのメソッドを使用してください。
    @param cls フィールドが宣言されているクラス。nullは許されません。
    @param thisObj フィールドが宣言されているクラスのインスタンス。フィー
    ルドがstaticの場合はnullを渡してください。そうでなければnullは許さ
    れません。
    @param fieldName アクセスするフィールドの名前。
    @return フィールドの値。
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException}と{@link
    java.lang.IllegalAccessException}は、{@link
    java.lang.RuntimException}にラップされてスローされます。このため、
    呼び出し元でtry-catch節を用意する必要はありません。

    <#else>
    Get field value. Use this method to retrieve field value that
    is in type of other than the String or any primitives.
    @param cls The class object the field belongs to. Null is not
    permitted.
    @param thisObj An instance of the class the accessing field
    belongs to. Specify null to retrieve a value of a static
    field. Null is not permitted if the field is non-static field.
    @param fieldName The field name to be accessed.
    @return Field value.
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException} and {@link
    java.lang.IllegalAccessException} are wrapped in a {@link
    java.lang.RuntimException} and the invocation do not need to be
    surrounded by a try-catch clause.
    </#if>
     */
    public Object getField(Class cls, Object thisObj, String fieldName) {
        try {
            Field field = cls.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(thisObj);
        }
        catch (NoSuchFieldException ex) {
            throw new RuntimeException(ex);
        }
        catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
    <#if locale="ja">

    booleanのフィールドを設定する。
    @param cls フィールドが宣言されているクラス。nullは許されません。
    @param thisObj フィールドが宣言されているクラスのインスタンス。フィー
    ルドがstaticの場合はnullを渡してください。そうでなければnullは許さ
    れません。
    @param fieldName アクセスするフィールドの名前。
    @param value 設定する値。
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException}と{@link
    java.lang.IllegalAccessException}は、{@link
    java.lang.RuntimException}にラップされてスローされます。このため、
    呼び出し元でtry-catch節を用意する必要はありません。

    <#else>
    Set boolean field. 
    @param cls The class object the field belongs to. Null is not
    permitted.
    @param thisObj An instance of the class the accessing field
    belongs to. Specify null to retrieve a value of a static
    field. Null is not permitted if the field is non-static field.
    @param fieldName The field name to be accessed.
    @param value A value to be set.
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException} and {@link
    java.lang.IllegalAccessException} are wrapped in a {@link
    java.lang.RuntimException} and the invocation do not need to be
    surrounded by a try-catch clause.
    </#if>
     */
    public void setBooleanField(Class cls, Object thisObj, String fieldName, boolean value) {
        setField(cls, thisObj, fieldName, value ? Boolean.TRUE:Boolean.FALSE);
    }

    /**
    <#if locale="ja">

    byteのフィールドを設定する。
    @param cls フィールドが宣言されているクラス。nullは許されません。
    @param thisObj フィールドが宣言されているクラスのインスタンス。フィー
    ルドがstaticの場合はnullを渡してください。そうでなければnullは許さ
    れません。
    @param fieldName アクセスするフィールドの名前。
    @param value 設定する値。
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException}と{@link
    java.lang.IllegalAccessException}は、{@link
    java.lang.RuntimException}にラップされてスローされます。このため、
    呼び出し元でtry-catch節を用意する必要はありません。

    <#else>
    Set byte field. 
    @param cls The class object the field belongs to. Null is not
    permitted.
    @param thisObj An instance of the class the accessing field
    belongs to. Specify null to retrieve a value of a static
    field. Null is not permitted if the field is non-static field.
    @param fieldName The field name to be accessed.
    @param value A value to be set.
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException} and {@link
    java.lang.IllegalAccessException} are wrapped in a {@link
    java.lang.RuntimException} and the invocation do not need to be
    surrounded by a try-catch clause.
    </#if>
     */
    public void setByteField(Class cls, Object thisObj, String fieldName, byte value) {
        setField(cls, thisObj, fieldName, new Byte(value));
    }

    /**
    <#if locale="ja">

    charのフィールドを設定する。
    @param cls フィールドが宣言されているクラス。nullは許されません。
    @param thisObj フィールドが宣言されているクラスのインスタンス。フィー
    ルドがstaticの場合はnullを渡してください。そうでなければnullは許さ
    れません。
    @param fieldName アクセスするフィールドの名前。
    @param value 設定する値。
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException}と{@link
    java.lang.IllegalAccessException}は、{@link
    java.lang.RuntimException}にラップされてスローされます。このため、
    呼び出し元でtry-catch節を用意する必要はありません。

    <#else>
    Set char field. 
    @param cls The class object the field belongs to. Null is not
    permitted.
    @param thisObj An instance of the class the accessing field
    belongs to. Specify null to retrieve a value of a static
    field. Null is not permitted if the field is non-static field.
    @param fieldName The field name to be accessed.
    @param value A value to be set.
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException} and {@link
    java.lang.IllegalAccessException} are wrapped in a {@link
    java.lang.RuntimException} and the invocation do not need to be
    surrounded by a try-catch clause.
    </#if>
     */
    public void setCharField(Class cls, Object thisObj, String fieldName, char value) {
        setField(cls, thisObj, fieldName, new Character(value));
    }

    /**
    <#if locale="ja">

    doubleのフィールドを設定する。
    @param cls フィールドが宣言されているクラス。nullは許されません。
    @param thisObj フィールドが宣言されているクラスのインスタンス。フィー
    ルドがstaticの場合はnullを渡してください。そうでなければnullは許さ
    れません。
    @param fieldName アクセスするフィールドの名前。
    @param value 設定する値。
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException}と{@link
    java.lang.IllegalAccessException}は、{@link
    java.lang.RuntimException}にラップされてスローされます。このため、
    呼び出し元でtry-catch節を用意する必要はありません。

    <#else>
    Set double field. 
    @param cls The class object the field belongs to. Null is not
    permitted.
    @param thisObj An instance of the class the accessing field
    belongs to. Specify null to retrieve a value of a static
    field. Null is not permitted if the field is non-static field.
    @param fieldName The field name to be accessed.
    @param value A value to be set.
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException} and {@link
    java.lang.IllegalAccessException} are wrapped in a {@link
    java.lang.RuntimException} and the invocation do not need to be
    surrounded by a try-catch clause.
    </#if>
    */
    public void setDoubleField(Class cls, Object thisObj, String fieldName, double value) {
        setField(cls, thisObj, fieldName, new Double(value));
    }

    /**
    <#if locale="ja">

    floatのフィールドを設定する。
    @param cls フィールドが宣言されているクラス。nullは許されません。
    @param thisObj フィールドが宣言されているクラスのインスタンス。フィー
    ルドがstaticの場合はnullを渡してください。そうでなければnullは許さ
    れません。
    @param fieldName アクセスするフィールドの名前。
    @param value 設定する値。
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException}と{@link
    java.lang.IllegalAccessException}は、{@link
    java.lang.RuntimException}にラップされてスローされます。このため、
    呼び出し元でtry-catch節を用意する必要はありません。

    <#else>
    Set float field. 
    @param cls The class object the field belongs to. Null is not
    permitted.
    @param thisObj An instance of the class the accessing field
    belongs to. Specify null to retrieve a value of a static
    field. Null is not permitted if the field is non-static field.
    @param fieldName The field name to be accessed.
    @param value A value to be set.
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException} and {@link
    java.lang.IllegalAccessException} are wrapped in a {@link
    java.lang.RuntimException} and the invocation do not need to be
    surrounded by a try-catch clause.
    </#if>
    */
    public void setFloatField(Class cls, Object thisObj, String fieldName, float value) {
        setField(cls, thisObj, fieldName, new Float(value));
    }

    /**
    <#if locale="ja">

    shortのフィールドを設定する。
    @param cls フィールドが宣言されているクラス。nullは許されません。
    @param thisObj フィールドが宣言されているクラスのインスタンス。フィー
    ルドがstaticの場合はnullを渡してください。そうでなければnullは許さ
    れません。
    @param fieldName アクセスするフィールドの名前。
    @param value 設定する値。
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException}と{@link
    java.lang.IllegalAccessException}は、{@link
    java.lang.RuntimException}にラップされてスローされます。このため、
    呼び出し元でtry-catch節を用意する必要はありません。

    <#else>
    Set short field. 
    @param cls The class object the field belongs to. Null is not
    permitted.
    @param thisObj An instance of the class the accessing field
    belongs to. Specify null to retrieve a value of a static
    field. Null is not permitted if the field is non-static field.
    @param fieldName The field name to be accessed.
    @param value A value to be set.
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException} and {@link
    java.lang.IllegalAccessException} are wrapped in a {@link
    java.lang.RuntimException} and the invocation do not need to be
    surrounded by a try-catch clause.
    </#if>
    */
    public void setShortField(Class cls, Object thisObj, String fieldName, short value) {
        setField(cls, thisObj, fieldName, new Short(value));
    }

    /**
    <#if locale="ja">

    intのフィールドを設定する。
    @param cls フィールドが宣言されているクラス。nullは許されません。
    @param thisObj フィールドが宣言されているクラスのインスタンス。フィー
    ルドがstaticの場合はnullを渡してください。そうでなければnullは許さ
    れません。
    @param fieldName アクセスするフィールドの名前。
    @param value 設定する値。
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException}と{@link
    java.lang.IllegalAccessException}は、{@link
    java.lang.RuntimException}にラップされてスローされます。このため、
    呼び出し元でtry-catch節を用意する必要はありません。

    <#else>
    Set int field. 
    @param cls The class object the field belongs to. Null is not
    permitted.
    @param thisObj An instance of the class the accessing field
    belongs to. Specify null to retrieve a value of a static
    field. Null is not permitted if the field is non-static field.
    @param fieldName The field name to be accessed.
    @param value A value to be set.
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException} and {@link
    java.lang.IllegalAccessException} are wrapped in a {@link
    java.lang.RuntimException} and the invocation do not need to be
    surrounded by a try-catch clause.
    </#if>
    */
    public void setIntField(Class cls, Object thisObj, String fieldName, int value) {
        setField(cls, thisObj, fieldName, new Integer(value));
    }

    /**
    <#if locale="ja">

    longのフィールドを設定する。
    @param cls フィールドが宣言されているクラス。nullは許されません。
    @param thisObj フィールドが宣言されているクラスのインスタンス。フィー
    ルドがstaticの場合はnullを渡してください。そうでなければnullは許さ
    れません。
    @param fieldName アクセスするフィールドの名前。
    @param value 設定する値。
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException}と{@link
    java.lang.IllegalAccessException}は、{@link
    java.lang.RuntimException}にラップされてスローされます。このため、
    呼び出し元でtry-catch節を用意する必要はありません。

    <#else>
    Set long field. 
    @param cls The class object the field belongs to. Null is not
    permitted.
    @param thisObj An instance of the class the accessing field
    belongs to. Specify null to retrieve a value of a static
    field. Null is not permitted if the field is non-static field.
    @param fieldName The field name to be accessed.
    @param value A value to be set.
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException} and {@link
    java.lang.IllegalAccessException} are wrapped in a {@link
    java.lang.RuntimException} and the invocation do not need to be
    surrounded by a try-catch clause.
    </#if>
    */
    public void setLongField(Class cls, Object thisObj, String fieldName, long value) {
        setField(cls, thisObj, fieldName, new Long(value));
    }

    /**
    <#if locale="ja">

    フィールドを設定する。設定したいフィールドの型がプリミティブ型でも
    Stringでもない場合に、このメソッドを使用してください。
    @param cls フィールドが宣言されているクラス。nullは許されません。
    @param thisObj フィールドが宣言されているクラスのインスタンス。フィー
    ルドがstaticの場合はnullを渡してください。そうでなければnullは許さ
    れません。
    @param fieldName アクセスするフィールドの名前。
    @param value 設定する値。
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException}と{@link
    java.lang.IllegalAccessException}は、{@link
    java.lang.RuntimException}にラップされてスローされます。このため、
    呼び出し元でtry-catch節を用意する必要はありません。

    <#else>
    Set field. Use this method to set field value that is in
    type of other than the String or any primitived.
    @param cls The class object the field belongs to. Null is not
    permitted.
    @param thisObj An instance of the class the accessing field
    belongs to. Specify null to retrieve a value of a static
    field. Null is not permitted if the field is non-static field.
    @param fieldName The field name to be accessed.
    @param value A value to be set.
    @throws {@link java.lang.RuntimeException} {@link
    java.lang.NoSuchFieldException} and {@link
    java.lang.IllegalAccessException} are wrapped in a {@link
    java.lang.RuntimException} and the invocation do not need to be
    surrounded by a try-catch clause.
    </#if>
    */
    public void setField(Class cls, Object thisObj, String fieldName, Object value) {
        try {
            Field field = cls.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(thisObj, value);
        }
        catch (NoSuchFieldException ex) {
            throw new RuntimeException(ex);
        }
        catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }
}
