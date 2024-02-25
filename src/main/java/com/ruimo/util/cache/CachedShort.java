package com.ruimo.util.cache;

/**
<#if locale="ja">

{@link Cache}のshort版。

<#else>

A short version of the {@link Cache}.

</#if>
 */
abstract public class CachedShort extends AbstractCache {
    private short value;

    /**
    <#if locale="ja">

    値の取得。値がキャッシュされていれば、その値が、そうでなければ
    {@link #computeValue()}による計算値が返されます。
    @return 値。

    <#else>

    Get the value. The cached value will be returned if it is in the
    cache. Otherwise {@link #computeValue()} will be invoked to obtain
    the value.
    @return The value.

    </#if>
     */
    public short getValue() {
        dirtyCheck();
        return value;
    }

    /**
    <#if locale="ja">

    このメソッドをオーバーライドして、計算値を求めるロジックを実装してください。
    @return 計算値。

    <#else>

    A method to compute value. Override this method and implement the
    computation logic.
    @return Computed value.

    </#if>
     */
    abstract protected short computeValue();

    void retrieveValue() {
        value = computeValue();
    }
}
