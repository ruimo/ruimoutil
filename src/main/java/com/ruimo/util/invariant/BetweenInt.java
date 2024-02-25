package com.ruimo.util.invariant;

/**
<#if locale="ja">

引数の範囲チェック。指定された値が、範囲外ならば{@link
java.lang.IllegalArgumentException}をスロー。さもなければ、引数をそのま
ま返します。

<#else> 

Check the argument is in valid value range. If the argument is out of
range, {@link java.lang.IllegalArgumentException} will be
thrown. Otherwise, the argument will be returned.

</#if>
*/
public class BetweenInt extends InvariantForInt {
    final int min;
    final int max;
    
    /**
    <#if locale="ja">
    @param name {@link java.lang.NullPointerException}をスローする際に
    メッセージとして使用されます。nullを渡すと、フィールド名をメッセー
    ジに含めません。
    @param min 最小値(この値未満ならエラーになります)。
    @param max 最大値(この値より大きいならエラーになります)。

    <#else> 

    @param name This is used as the name in case the {@link
    java.lang.NullPointerException} is thrown. If null is specified,
    the field name will not be included in the exception object.
    @param min Minimum value(inclusive).
    @param max Maximum value(inclusive).
    </#if>
     */
    public BetweenInt(String name, int min, int max) {
        super (name);
        if (min > max) throw new IllegalArgumentException("min (=" + min + ") is greater than max (=" + max + ").");
        this.min = min;
        this.max = max;
    }

    /**
    <#if locale="ja">

    引数の範囲チェック。指定された値が、範囲外ならば{@link
    java.lang.IllegalArgumentException}をスロー。さもなければ、引数をそ
    のまま返します。

    @param value 範囲チェックされる引数。
    @return valueが返ります。もしもvalueが範囲外の場合は{@link
    java.lang.IllegalArgumentException}がスローされます。

    <#else> 

    Check the argument is in valid value range. If the argument is out
    of range, {@link java.lang.IllegalArgumentException} will be
    thrown. Otherwise, the argument will be returned.

    @return The specified value will be returned. If the value is out
    of range, {@link java.lang.IllegalArgumentException} will be thrown.

    </#if>
     */
    public int ensuring(int value) {
        String valueName = (name == null) ? "value": name;
        if (value < min || max < value)
            throw new IllegalArgumentException
                (valueName + " (=" + value + ") is out of range. The valid range: ("
                 + min + " < " + valueName + " < " + max + ")"); 
        return value;
    }
}
