package com.ruimo.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
<#if locale="ja">

メソッドを呼び出すためのヘルパクラス。リフレクションを使用しているため、
privateメソッドもコールできます。

<#else>
A helper class to invoke methods. Since it uses the reflection
feature, you can even invoke private methods.
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

    MethodInvoker mi = MethodInvoker.getInstance();
    Bar bar = (Bar)mi.invokeConstructor(Bar.class, new Class[] {int.class}, new Object[] {123});
    assertEquals(123, bar.i);

    Integer i = (Integer)mi.invokeMethod(Bar.class, bar, "add",
                                         new Class[] {int.class, int.class},
                                         new Object[] {123, 345});
    assertEquals(123 + 345, i.intValue());
</pre>
 */
public class MethodInvoker {
    protected MethodInvoker() {}

    private final static MethodInvoker instance = new MethodInvoker();

    /**
    <#if locale="ja">
    インスタンスの取得。
    @return このクラスのインスタンス。nullが返ることはありません。
    <#else>
    Get instance of this class.
    @return An instance of this class. Null will be never returned.
    </#if>
    */
    public static MethodInvoker getInstance() {
        return instance;
    }

    /**
    <#if locale="ja">

    引数無しメソッドを呼び出す。
    @param cls このメソッドが宣言されているクラス。nullは許されません。
    @param thisObj このメソッドが宣言されているクラスのインスタンス。
    staticメソッドを呼び出す場合はnullを渡してください。それ以外の場合
    にはnullは許されません。
    @param methodName 呼び出すメソッドの名前。nullは許されません。
    @return 呼び出したメソッドの戻り値。
    @throws java.lang.RuntimeException {@link
    java.lang.IllegalArgumentException}, {@link
    java.lang.reflect.InvocationTargetException}, {@link
    java.lang.NoSuchMethodException}, {@link
    java.lang.IllegalAccessException} は全て{@link
    java.lang.RuntimeException} にラップされてスローされます。このため
    呼び出し元でtry-catch節で囲む必要はありません。

    <#else> 
    
    Invoke a null-arg method.
    @param cls The class object the method belongs to. Null is not
    permitted.
    @param thisObj An instance of the class the invoking method
    belongs to. Specify null to invoke a static method. Null is not
    permitted if the method is non-static.
    @param methodName A method name to be invoked. Null is not
    allowed
    @return The return value of the invoked method.
    @throws java.lang.RuntimeException All of the {@link
    java.lang.IllegalArgumentException}, {@link
    java.lang.reflect.InvocationTargetException}, {@link
    java.lang.NoSuchMethodException}, and {@link
    java.lang.IllegalAccessException} are wrapped into the {@link
    java.lang.RuntimeException} and the invocation do not need to be
    surrounded by a try-catch clause.
    </#if>
     */
    public Object invokeMethod(Class cls, Object thisObj, String methodName) {
        return invokeMethod(cls, thisObj, methodName, EmptyArrays.OF_CLASS, EmptyArrays.OF_OBJECT);
    }

    /**
    <#if locale="ja">

    int引数を1つとるメソッドを呼び出す。
    @param cls このメソッドが宣言されているクラス。nullは許されません。
    @param thisObj このメソッドが宣言されているクラスのインスタンス。
    staticメソッドを呼び出す場合はnullを渡してください。それ以外の場合
    にはnullは許されません。
    @param methodName 呼び出すメソッドの名前。nullは許されません。
    @param i メソッドに渡す引数。
    @return 呼び出したメソッドの戻り値。
    @throws java.lang.RuntimeException {@link
    java.lang.IllegalArgumentException}, {@link
    java.lang.reflect.InvocationTargetException}, {@link
    java.lang.NoSuchMethodException}, {@link
    java.lang.IllegalAccessException} は全て{@link
    java.lang.RuntimeException} にラップされてスローされます。このため
    呼び出し元でtry-catch節で囲む必要はありません。

    <#else> 

    Invoke a method that has a single int parameter.
    @param cls The class object the method belongs to. Null is not
    permitted.
    @param thisObj An instance of the class the invoking method
    belongs to. Specify null to invoke a static method. Null is not
    permitted if the method is non-static.
    @param methodName A method name to be invoked. Null is not
    allowed
    @param i An argument to be passed to the invoking method.
    @return The return value of the invoked method.
    @throws java.lang.RuntimeException All of the {@link
    java.lang.IllegalArgumentException}, {@link
    java.lang.reflect.InvocationTargetException}, {@link
    java.lang.NoSuchMethodException}, and {@link
    java.lang.IllegalAccessException} are wrapped into the {@link
    java.lang.RuntimeException} and the invocation do not need to be
    surrounded by a try-catch clause.
    </#if>
     */
    public Object invokeMethod(Class cls, Object thisObj, String methodName, int i) {
        return invokeMethod(cls, thisObj, methodName,
                            CLASS_INT_1, new Object[] {new Integer(i)});
    }

    static final Class[] CLASS_INT_1 = new Class[] {int.class};

    /**
    <#if locale="ja">

    String引数を1つとるメソッドを呼び出す。
    @param cls このメソッドが宣言されているクラス。nullは許されません。
    @param thisObj このメソッドが宣言されているクラスのインスタンス。
    staticメソッドを呼び出す場合はnullを渡してください。それ以外の場合
    にはnullは許されません。
    @param methodName 呼び出すメソッドの名前。nullは許されません。
    @param str メソッドに渡す引数。
    @return 呼び出したメソッドの戻り値。
    @throws java.lang.RuntimeException {@link
    java.lang.IllegalArgumentException}, {@link
    java.lang.reflect.InvocationTargetException}, {@link
    java.lang.NoSuchMethodException}, {@link
    java.lang.IllegalAccessException} は全て{@link
    java.lang.RuntimeException} にラップされてスローされます。このため
    呼び出し元でtry-catch節で囲む必要はありません。

    <#else> 

    Invoke a method that has a single String parameter.
    @param cls The class object the method belongs to. Null is not
    permitted.
    @param thisObj An instance of the class the invoking method
    belongs to. Specify null to invoke a static method. Null is not
    permitted if the method is non-static.
    @param methodName A method name to be invoked. Null is not
    allowed
    @param str An argument to be passed to the invoking method.
    @return The return value of the invoked method.
    @throws java.lang.RuntimeException All of the {@link
    java.lang.IllegalArgumentException}, {@link
    java.lang.reflect.InvocationTargetException}, {@link
    java.lang.NoSuchMethodException}, and {@link
    java.lang.IllegalAccessException} are wrapped into the {@link
    java.lang.RuntimeException} and the invocation do not need to be
    surrounded by a try-catch clause.

    </#if>
    */
    public Object invokeMethod(Class cls, Object thisObj, String methodName, String str) {
        return invokeMethod(cls, thisObj, methodName,
                            CLASS_STRING_1, new Object[] {str});
    }

    static final Class[] CLASS_STRING_1 = new Class[] {String.class};

    /**
    <#if locale="ja">

    メソッドを呼び出す。
    @param cls このメソッドが宣言されているクラス。nullは許されません。
    @param thisObj このメソッドが宣言されているクラスのインスタンス。
    staticメソッドを呼び出す場合はnullを渡してください。それ以外の場合
    にはnullは許されません。
    @param methodName 呼び出すメソッドの名前。nullは許されません。
    @param argTypes 引数の型を格納した配列。nullは許されません。
    @param args 引数を格納した配列。nullは許されません。
    @return 呼び出したメソッドの戻り値。
    @throws java.lang.RuntimeException {@link
    java.lang.IllegalArgumentException}, {@link
    java.lang.reflect.InvocationTargetException}, {@link
    java.lang.NoSuchMethodException}, {@link
    java.lang.IllegalAccessException} は全て{@link
    java.lang.RuntimeException} にラップされてスローされます。このため
    呼び出し元でtry-catch節で囲む必要はありません。

    <#else> 

    Invoke a method.
    @param cls The class object the method belongs to. Null is not
    permitted.
    @param thisObj An instance of the class the invoking method
    belongs to. Specify null to invoke a static method. Null is not
    permitted if the method is non-static.
    @param methodName A method name to be invoked. Null is not
    allowed
    @param argTypes Types of the arguments to be passed to the
    invoking method. Null is not allowed.
    @param args Arguments to be passed to the invoking method. Null
    is not allowed.
    @return The return value of the invoked method.
    @throws javava.lang.RuntimeException All of the {@link
    java.lang.IllegalArgumentException}, {@link
    java.lang.reflect.InvocationTargetException}, {@link
    java.lang.NoSuchMethodException}, and {@link
    java.lang.IllegalAccessException} are wrapped into the {@link
    java.lang.RuntimeException} and the invocation do not need to be
    surrounded by a try-catch clause.

    </#if>
    */
    public Object invokeMethod
        (Class cls, Object thisObj, String methodName, Class[] argTypes, Object[] args)
    {
        try {
            Method method = cls.getDeclaredMethod(methodName, argTypes);
            method.setAccessible(true);
            return method.invoke(thisObj, args);
        }
        catch (IllegalArgumentException ex) {
            throw new RuntimeException(ex);
        }
        catch (InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
        catch (NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        }
        catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
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
    @param cls The class object the constructor belongs to. Null is
    not permitted.
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
    public Object invokeConstructor(Class cls, Class[] argTypes, Object[] args) {
        Constructor ctor;
        try {
            ctor = cls.getDeclaredConstructor(argTypes);
            ctor.setAccessible(true);
            return ctor.newInstance(args);
        }
        catch (SecurityException ex) {
            throw new RuntimeException(ex);
        }
        catch (NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        }
        catch (IllegalArgumentException ex) {
            throw new RuntimeException(ex);
        }
        catch (InstantiationException ex) {
            throw new RuntimeException(ex);
        }
        catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
        catch (InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
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
    Invoke a constructor that has no argument.
    @param cls The class object the method belongs to. Null is not
    ermitted.
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
    public Object invokeConstructor(Class cls) {
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
    @param i An int argument to be passed.
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
    public Object invokeConstructor(Class cls, int i) {
        return invokeConstructor(cls, CLASS_INT_1, new Object[] {new Integer(i)});
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
    @param str A String argument to be passed.
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
    public Object invokeConstructor(Class cls, String str) {
        return invokeConstructor(cls, CLASS_STRING_1, new Object[] {str});
    }
}
