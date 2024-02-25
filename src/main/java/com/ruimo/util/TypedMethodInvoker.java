package com.ruimo.util;

/**
<#if locale="ja">

{@link MethodInvoker}のタイプセーフ版。使用するにはJava 5以上が必要です。

<#else>
Type safe version of the {@link MethodInvoker}. Java5 or higher is
required.
</#if>

<pre>
public class Bar {
    public final int i;

    private Bar(int i) {
        this.i = i;
    }

    private int add(int i, int j) {
        return i + j;
    }
}

    TypedMethodInvoker mi = TypedMethodInvoker.getInstance();
    Bar bar = mi.invokeConstructor(Bar.class, new Class[] {int.class}, new Object[] {123});
    assertEquals(123, bar.i);
        
    int i = mi.invokeMethod(Bar.class, bar, "add",
                            new Class[] {int.class, int.class},
                            new Object[] {123, 345}, int.class);
    assertEquals(123 + 345, i);
</pre>
 */
public class TypedMethodInvoker {
    /**
    <#if locale="ja">
    コンストラクタ。
    <#else>
    Constructor.
    </#if>
    */
    protected TypedMethodInvoker() {}

    private static final MethodInvoker parent = new MethodInvoker();
    private static final TypedMethodInvoker instance = new TypedMethodInvoker();

    /**
    <#if locale="ja">

    このクラスのインスタンスを取得します。
    @return このクラスのインスタンス。nullが返ることはありません。

    <#else>
    Get instance of this class.
    @return An instance of this class. Null will be never returned.
    </#if>
    */
    public static TypedMethodInvoker getInstance() {
        return instance;
    }

    /**
    <#if locale="ja">

    コンストラクタを呼び出す。
    @param cls このコンストラクタが宣言されているクラス。nullは許されません。
    @param argTypes 引数の型を格納した配列。nullは許されません。
    @param args 引数を格納した配列。nullは許されません。
    @return 生成されたインスタンス。
    @throws java.lang.RuntimeException {@link SecurityException},
    {@link java.lang.IllegalArgumentException}, {@link
    java.lang.reflect.InvocationTargetException}, {@link
    java.lang.NoSuchMethodException}, {@link
    java.lang.InstantiationException}, {@link
    java.lang.IllegalAccessException} は全て{@link
    java.lang.RuntimeException}にラップされてスローされます。このため
    呼び出し元でtry-catch節で囲む必要はありません。

    <#else>
    Invoke a constructor.
    @param cls The class object the method belongs to. Null is not
    permitted.
    @param argTypes Types of the arguments to be passed to the
    invoking method. Null is not allowed.
    @param args Arguments to be passed to the invoking method. Null
    is not allowed.
    @return The created instance of the invoked method.
    @throws java.lang.RuntimeException All of the {@link
    SecurityException}, {@link java.lang.IllegalArgumentException},
    {@link java.lang.reflect.InvocationTargetException},
    {@link java.lang.NoSuchMethodException}, {@link
    java.lang.InstantiationException}, and {@link
    java.lang.IllegalAccessException} are wrapped into the {@link
    java.lang.RuntimeException} and the invocation do not need to be
    surrounded by a try-catch clause.
    </#if>
    */
    @SuppressWarnings("unchecked")
    public <T> T invokeConstructor(Class<T> cls, Class[] argTypes, Object[] args) {
        return (T)parent.invokeConstructor(cls, argTypes, args);
    }

    /**
    <#if locale="ja">

    引数無しコンストラクタを呼び出す。
    @param cls このコンストラクタが宣言されているクラス。nullは許されません。
    @return 生成されたインスタンス。
    @throws java.lang.RuntimeException {@link SecurityException},
    {@link java.lang.IllegalArgumentException}, {@link
    java.lang.reflect.InvocationTargetException}, {@link
    java.lang.NoSuchMethodException}, {@link
    java.lang.InstantiationException}, {@link
    java.lang.IllegalAccessException} は全て{@link
    java.lang.RuntimeException}にラップされてスローされます。このため
    呼び出し元でtry-catch節で囲む必要はありません。

    <#else> 
    Invoke a constructor that has no arguments.
    @param cls The class object the method belongs to. Null is not
    permitted.
    @return The created instance of the invoked method.
    @throws java.lang.RuntimeException All of the {@link
    SecurityException}, {@link java.lang.IllegalArgumentException},
    {@link java.lang.reflect.InvocationTargetException},
    {@link java.lang.NoSuchMethodException}, {@link
    java.lang.InstantiationException}, and {@link
    java.lang.IllegalAccessException} are wrapped into the {@link
    java.lang.RuntimeException} and the invocation do not need to be
    surrounded by a try-catch clause.
    </#if>
     */
    @SuppressWarnings("unchecked")
    public <T> T invokeConstructor(Class<T> cls) {
        return invokeConstructor(cls, EmptyArrays.OF_CLASS, EmptyArrays.OF_OBJECT);
    }

    /**
    <#if locale="ja">

    int引数を1つとるコンストラクタを呼び出す。
    @param cls このコンストラクタが宣言されているクラス。nullは許されません。
    @param i コンストラクタに渡す引数。
    @return 生成されたインスタンス。
    @throws java.lang.RuntimeException {@link SecurityException},
    {@link java.lang.IllegalArgumentException}, {@link
    java.lang.reflect.InvocationTargetException}, {@link
    java.lang.NoSuchMethodException}, {@link
    java.lang.InstantiationException}, {@link
    java.lang.IllegalAccessException} は全て{@link
    java.lang.RuntimeException}にラップされてスローされます。このため
    呼び出し元でtry-catch節で囲む必要はありません。

    <#else> 
    Invoke a constructor that has a single int argument.
    @param cls The class object the method belongs to. Null is not
    permitted.
    @param i An argument to be passed to the invoking method.
    @return The created instance of the invoked method.
    @throws java.lang.RuntimeException All of the {@link
    SecurityException}, {@link java.lang.IllegalArgumentException},
    {@link java.lang.reflect.InvocationTargetException},
    {@link java.lang.NoSuchMethodException}, {@link
    java.lang.InstantiationException}, and {@link
    java.lang.IllegalAccessException} are wrapped into the {@link
    java.lang.RuntimeException} and the invocation do not need to be
    surrounded by a try-catch clause.
    </#if>
    */
    @SuppressWarnings("unchecked")
    public <T> T invokeConstructor(Class<T> cls, int i) {
        return invokeConstructor(cls, MethodInvoker.CLASS_INT_1, new Object[] {i});
    }
    
    /**
    <#if locale="ja">
    
    String引数を1つとるコンストラクタを呼び出す。
    @param cls このコンストラクタが宣言されているクラス。nullは許されません。
    @param str コンストラクタに渡す引数。
    @return 生成されたインスタンス。
    @throws java.lang.RuntimeException {@link SecurityException},
    {@link java.lang.IllegalArgumentException}, {@link
    java.lang.reflect.InvocationTargetException}, {@link
    java.lang.NoSuchMethodException}, {@link
    java.lang.InstantiationException}, {@link
    java.lang.IllegalAccessException} は全て{@link
    java.lang.RuntimeException}にラップされてスローされます。このため
    呼び出し元でtry-catch節で囲む必要はありません。

    <#else> 
    Invoke a constructor that has a single String argument.
    @param cls The class object the method belongs to. Null is not
    permitted.
    @param str An argument to be passed to the invoking method.
    @return The created instance of the invoked method.
    @throws java.lang.RuntimeException All of the {@link
    SecurityException}, {@link java.lang.IllegalArgumentException},
    {@link java.lang.reflect.InvocationTargetException},
    {@link java.lang.NoSuchMethodException}, {@link
    java.lang.InstantiationException}, and {@link
    java.lang.IllegalAccessException} are wrapped into the {@link
    java.lang.RuntimeException} and the invocation do not need to be
    surrounded by a try-catch clause.
    </#if>
    */
    @SuppressWarnings("unchecked")
    public <T> T invokeConstructor(Class<T> cls, String str) {
        return invokeConstructor(cls, MethodInvoker.CLASS_STRING_1, new Object[] {str});
    }
}
