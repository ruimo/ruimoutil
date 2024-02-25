package com.ruimo.util.builder;

import java.util.Collection;
import java.util.Collections;

/**
<#if locale="ja">
コレクションビルダ。手軽にコレクションを作成することができます。
<#else>
Collection builder. A helper class to create ad-hoc colleciton
object.
</#if>

<pre>
    Collection col = new CollectionBuilder(new ArrayList())
      .add("Hello")
      .add("World")
      .get();
    System.out.println(set);

[Hello, World]
</pre>
 */
public class CollectionBuilder {
    private Collection collection;

    /**
    <#if locale="ja">

    コンストラクタ。CollectionBuilderは、指定されたコレクションをラッ
    プします。{@link #add(Object)}を呼び出すことで、オブジェクトをラッ
    プされたコレクションに追加することができます。
    @param collection ラップされるコレクション。

    <#else>
    Constructor.
    
    CollectionBuilder wraps the specified collection. The {@link
    #add(Object)} will add objects into the wrapped collection.
    
    @param collection A collection object to be wrapped.
    </#if>
    */
    public CollectionBuilder(Collection collection) {
        if (collection == null) throw new NullPointerException("collection is null.");
        this.collection = collection;
    }

    /**
    <#if locale="ja">

    ラップされたコレクションにオブジェクトを追加します。
    @param o 追加するオブジェクト。nullが許されるかどうかは、ラップさ
    れているコレクションの特性によって決まります。
    @return このオブジェクト自身。これを利用することで{#add(Object)}を
    つなげて書くことができます。
    @throws IllegalStateException ひとたび{@link #get()}が呼び出される
    と、オブジェクトは無効状態になります。その後に、{@link
    #add(Object)}が呼び出されると、常に{@link
    java.lang.IllegalStateException}がスローされます。

    <#else>

    Add an object into the wrapped collection.
    @param o An object to be added. It depends the characteristics
    of the wrapped collection whether a null argument is
    permitted. 
    @return A reference to this object is returned so that you can
    chain bunch of the {#add(Object)} invocations.
    @throws IllegalStateException Once the {@link #get()} method is
    called, the builder object goes into a stale state and
    consecutive {@link #add(Object)} operation will always throw
    the {@link java.lang.IllegalStateException}.
    </#if>
    */
    public CollectionBuilder add(Object o) {
        if (collection == null) throw new IllegalStateException("Create new CollectionBuilder.");
        collection.add(o);
        return this;
    }

    /**
    <#if locale="ja">

    ラップされたコレクションを取り出します。コレクションをひとたび
    {@link #get()}で取り出すと、オブジェクトは無効化され、利用できなく
    なります。更に別のコレクションが必要であれば、ビルダを再度生成して
    ください。
    @throws IllegalStateException ひとたび{@link #get()}が呼び出される
    と、オブジェクトは無効状態になります。その後に、{@link #get()}が呼
    び出されると、常に{@link java.lang.IllegalStateException}がスロー
    されます。

    <#else>
    Retrieve the wrapped collection. Once the collection is
    retrieved by {@link #get()} method, the builder instance goes
    into a stale state and you cannot make use of this builder any
    more. Create new builder instance to make another collection.
    @throws IllegalStateException Once the {@link #get()} method is
    called, the builder object goes into a stale state and
    consecutive {@link #get()} operation will always throw the
    {@link java.lang.IllegalStateException}.
    </#if>
    */
    public Collection get() {
        if (collection == null) throw new IllegalStateException("Create new CollectionBuilder.");
        Collection ret = collection;
        collection = null;
        return ret;
    }

    /**
    <#if locale="ja">

    ラップされたコレクションを取り出します。結果は{@link
    java.util.Collections#unmodifiableCollection(java.util.Collection)} 
    によってラップされて変更不可なコレクションとなります。コレクション
    をひとたび{@link #get()}で取り出すと、オブジェクトは無効化され、利
    用できなくなります。更に別のコレクションが必要であれば、ビルダを再
    度生成してください。
    @throws IllegalStateException ひとたび{@link #getUnmodifiable()}が
    呼び出されると、オブジェクトは無効状態になります。その後に、{@link
    #getUnmodifiable()}が呼び出されると、常に{@link
    java.lang.IllegalStateException}がスローされます。

    <#else>
    Retrieve the wrapped collection. The returned collection is
    wrapped by {@link
    java.util.Collections#unmodifiableCollection(java.util.Collection)}
    and changes against the returned collection will be
    rejected. Once the collection is retrieved by {@link #get()}
    method, the builder instance goes into a stale state and you
    cannot make use of this builder any more. Create new builder
    instance to make another collection.
    @throws IllegalStateException Once the {@link #get()} method is
    called, the builder object goes into a stale state and
    consecutive {@link #getUnmodifiable()} operation will always
    throw the {@link java.lang.IllegalStateException}.
    </#if>
    */
    public Collection getUnmodifiable() {
        return Collections.unmodifiableCollection(get());
    }
}
