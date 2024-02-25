package com.ruimo.util.cache;

abstract class AbstractCache {
    private boolean dirty = true;

    abstract void retrieveValue();

    final void dirtyCheck() {
        if (dirty) {
            retrieveValue();
            dirty = false;
        }
    }

    /**
    <#if locale="ja">

    キャッシュの無効化。このメソッドを呼び出すと、キャッシュに保持して
    いる値が無効化されます。この後の値取得によってデータは再計算されま
    す。

    <#else>

    Invalidate the cached value. This method invalidates the cached
    value. Consecutive data retrieval will cause data computation.

    </#if>
     */
    public final void invalidate() {
        dirty = true;
    }
}
