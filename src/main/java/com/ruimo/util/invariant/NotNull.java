package com.ruimo.util.invariant;

/**
<#if locale="ja">

引数のnullチェック。引数がnullならば{@link
java.lang.NullPointerException}をスロー。さもなければ、引数をそのま
ま返します。

<#else> 

Check the argument is null. If the argument is null, {@link
java.lang.NullPointerException} will be thrown. Otherwise, the
argument will be returned.

</#if>
*/
public class NotNull extends Invariant {
    /**
    <#if locale="ja">
    @param name {@link java.lang.NullPointerException}をスローする際に
    メッセージとして使用されます。nullを渡すと、フィールド名をメッセー
    ジに含めません。

    <#else> 

    @param name This is used as the name in case the {@link
    java.lang.NullPointerException} is thrown. If null is specified,
    the field name will not be included in the exception object.
    </#if>
     */
    public NotNull(String name) {
        super (name);
    }

    /**
    <#if locale="ja">

    引数のnullチェック。引数がnullならば{@link
    java.lang.NullPointerException}をスロー。さもなければ、引数をそのま
    ま返します。

    @param o Nullチェックされる引数。
    @return oが返ります。もしもoがnullの場合は{@link
    java.lang.NullPointerException}がスローされます。

    <#else> 

    Check the argument is null. If the argument is null, {@link
    java.lang.NullPointerException} will be thrown. Otherwise, the
    argument will be returned.

    @param o This will be returned.
    @return o will be returned. If o is null, {@link
    java.lang.NullPointerException} will be thrown.

    </#if>
     */
    public Object ensuring(Object o) {
        if (o == null) {
            if (name == null) throw new NullPointerException();
            else throw new NullPointerException(name + " is null.");
        }
        return o;
    }
}
