package com.ruimo.util.builder;

import java.util.Collections;
import java.util.List;

/**
<#if locale="ja">

リストビルダ。手軽にリストを作成することができます。

<#else>
List builder. A helper class to create ad-hoc list object.
</#if>

<pre>
    List list = new ListBuilder(new ArrayList())
      .add("Hello")
      .add("World")
      .get();
    System.out.println(list);

[Hello, World]
</pre>
 */
public class ListBuilder {
    private CollectionBuilder builder;

    /**
    <#if locale="ja">

    コンストラクタ。ListBuilderは、指定されたリストをラップします。
    {@link #add(Object)}を呼び出すことで、オブジェクトをラップされたリ
    ストに追加することができます。
    @param list ラップされるリスト。
    <#else>
    Constructor.
    
    ListBuilder wraps the specified list. The {@link #add(Object)}
    will add objects into the wrapped list.
    
    @param list A list object to be wrapped.
    </#if>
    */
    public ListBuilder(List list) {
        builder = new CollectionBuilder(list);
    }

    /**
    <#if locale="ja">

    ラップされたリストにオブジェクトを追加します。
    @param o 追加するオブジェクト。nullが許されるかどうかは、ラップさ
    れているリストの特性によって決まります。
    @return このオブジェクト自身。これを利用することで{#add(Object)}を
    つなげて書くことができます。
    @throws IllegalStateException ひとたび{@link #get()}が呼び出される
    と、オブジェクトは無効状態になります。その後に、{@link
    #add(Object)}が呼び出されると、常に{@link
    java.lang.IllegalStateException}がスローされます。

    <#else>
    Add an object into the wrapped list.
    
    @param o An object to be added. It depends the characteristics
    of the wrapped list whether a null argument is permitted.
    @return A reference to this object is returned so that you can
    chain bunch of the {#add(Object)} invocations.
    @throws IllegalStateException Once the {@link #get()} method is
    called, the builder object goes into a stale state and
    consecutive {@link #add(Object)} operation will always throw
    the {@link java.lang.IllegalStateException}.
    </#if>
    */
    public ListBuilder add(Object o) {
        builder.add(o);
        return this;
    }

    /**
    <#if locale="ja">

    ラップされたリストを取り出します。リストをひとたび{@link #get()}で
    取り出すと、オブジェクトは無効化され、利用できなくなります。更に別
    のリストが必要であれば、ビルダを再度生成してください。
    @throws IllegalStateException ひとたび{@link #get()}が呼び出される
    と、オブジェクトは無効状態になります。その後に、{@link #get()}が呼
    び出されると、常に{@link java.lang.IllegalStateException}がスロー
    されます。

    <#else>
    Retrieve the wrapped list. Once the list is retrieved by {@link
    #get()} method, the builder instance goes into a stale state and
    you cannot make use of this builder any more. Create new
    builder instance to make another list.
    @throws IllegalStateException Once the {@link #get()} method is
    called, the builder object goes into a stale state and
    consecutive {@link #get()} operation will always throw the
    {@link java.lang.IllegalStateException}.
    </#if>
    */
    public List get() {
        return (List)builder.get();
    }

    /**
    <#if locale="ja">

    ラップされたリストを取り出します。結果は{@link
    java.util.Collections#unmodifiableList(java.util.List)} によってラッ
    プされて変更不可なリストとなります。リストをひとたび{@link
    #get()}で取り出すと、オブジェクトは無効化され、利用できなくなりま
    す。更に別のリストが必要であれば、ビルダを再度生成してくださ
    い。
    @throws IllegalStateException ひとたび{@link #getUnmodifiable()}が
    呼び出されると、オブジェクトは無効状態になります。その後に、{@link
    #getUnmodifiable()}が呼び出されると、常に{@link
    java.lang.IllegalStateException}がスローされます。

    <#else>
    Retrieve the wrapped list. The returned list is wrapped by
    {@link java.util.Collections#unmodifiableList(java.util.List)}
    and changes against the returned list will be rejected. Once
    the list is retrieved by {@link #getUnmodifiable()} method, the
    builder instance goes into a stale state and you cannot make
    use of this builder any more. Create new builder instance to
    make another collection.
    @throws IllegalStateException Once the {@link #get()} method is
    called, the builder object goes into a stale state and
    consecutive {@link #getUnmodifiable()} operation will always
    throw the {@link java.lang.IllegalStateException}.
    </#if>
    */
    public List getUnmodifiable() {
        return Collections.unmodifiableList(get());
    }
}
