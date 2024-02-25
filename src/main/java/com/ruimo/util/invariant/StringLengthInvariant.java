package com.ruimo.util.invariant;

/**
<#if locale="ja">

文字列引数の長さチェック。引数がnullならば{@link
java.lang.NullPointerException}をスロー。さもなければ、引数の長さが範囲
内に入っているかをチェックし、範囲外なら、IllegalArgumentExceptionをス
ロー。

<#else> 

Check the string argument is null. If the argument is null, {@link
java.lang.NullPointerException} will be thrown. Otherwise, the length
of the string argument is checked. If the length is out of range,
IllegalArgumentException will be thrown.

</#if>
*/
public class StringLengthInvariant extends NotNull {
    final int minLength;
    final int maxLength;

    /**
    <#if locale="ja">
    @param name {@link java.lang.NullPointerException}をスローする際に
    メッセージとして使用されます。nullを渡すと、フィールド名をメッセー
    ジに含めません。
    @param minLength 文字列長さの下限。これよりも短い文字列はエラーにし
    ます。
    @param maxLength 文字列長さの上限。これよりも長い文字列はエラーにし
    ます。

    <#else> 

    @param name This is used as the name in case the {@link
    java.lang.NullPointerException} is thrown. If null is specified,
    the field name will not be included in the exception object.
    @param minLength Minimum limit of string length(inclusive).
    @param maxLength Maximum limit of string length(inclusive).
    
    </#if>
     */
    public StringLengthInvariant(String name, int minLength, int maxLength) {
        super (name);
        if (minLength > maxLength) {
            throw new IllegalArgumentException("minLength(=" + minLength + ") > maxLength(=" + maxLength + ")");
        }
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    /**
     <#if locale="ja">

     文字列引数の長さチェック。引数がnullならば{@link
     java.lang.NullPointerException}をスロー。さもなければ、引数の長さが範囲
     内に入っているかをチェックし、範囲外なら、IllegalArgumentExceptionをス
     ロー。さもなければ、引数をそのまま返します。
     @param s チェックする文字列。
     @return 引数がそのまま返ります。

     <#else> 

     Check the string argument is null. If the argument is null,
     {@link java.lang.NullPointerException} will be thrown. Otherwise,
     the length of the string argument is checked. If the length is
     out of range, IllegalArgumentException will be thrown. Otherwise,
     the argument string will be returned.
     @param s String object to be checked.
     @return The argument string will be returned.
     
     </#if>
    */
    public String ensuringString(String s) {
        s = (String)super.ensuring(s);
        int len = s.length();
        if (len < minLength) {
            String msg = (name == null)
                ? "'" + s + "' should be longer than " + minLength + "."
                : "Argument " + name + " '" + s + "' should be longer than " + minLength + ".";
            throw new IllegalArgumentException(msg);
        }

        if (len > maxLength) {
            String msg = (name == null)
                ? "'" + s + "' should be shorter than " + maxLength + "."
                : "Argument " + name + " '" + s + "' should be shorter than " + maxLength + ".";
            throw new IllegalArgumentException(msg);
        }

        return s;
    }
}
