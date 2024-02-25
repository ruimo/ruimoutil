package com.ruimo.util.cache;

/**
<#if locale="ja">

キャッシュクラス。計算が高価な場合に使用することで、無駄な計算処理を省
きます。このクラスを継承して{@link #computeValue()} メソッドをオーバー
ライドして計算処理を実装します。値を取得する際は、{@link #getValue()} 
を呼び出します。もしも計算値がまだ取得されていなければ{@link
#computeValue()}が呼び出され、値がキャッシュされます。その後、もう一度
{@link #getValue()}が呼び出されると、キャッシュされた値がそのまま戻さ
れます。値の再計算が必要な際には{@link AbstractCache#invalidate()}を呼
び出すことで、値を無効化できます。

<#else>

Cache class. You can avoid unnecessary calculation by using this
class. Derive a class from this class and override the {@link
#computeValue()} so that it returns the computed value. To retrieve
the value, invoke the {@link #getValue()}. If the value is not
caliculated yet, {@link #computeValue()} will be invoked first and the
obtained value will be cahced for future use. Consecutive invocation
of {@link #getValue()} will return the cached value. If the value
becomes obsolete and re-calculation is needed, invoke the {@link
AbstractCache#invalidate()} and the cached value will be cleared.

</#if>

<pre>

    final int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    TypedCache<Integer> cache = new TypedCache<Integer>() {
        protected Integer computeValue() {
            int sum = 0;
            for (int num:nums) sum += num;
            return Integer.valueOf(sum);
        }
    };

    assertEquals(Integer.valueOf(55), cache.getValue());
<#if locale="ja">
    assertEquals(Integer.valueOf(55), cache.getValue()); // computeValue()が呼び出されない。
<#else>
    assertEquals(Integer.valueOf(55), cache.getValue()); // computeValue() will not be invoked.
</#if>
</pre>
 */
abstract public class TypedCache<T> extends AbstractCache {
    private T value;

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
    public T getValue() {
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
    abstract protected T computeValue();

    void retrieveValue() {
        value = computeValue();
    }
}
