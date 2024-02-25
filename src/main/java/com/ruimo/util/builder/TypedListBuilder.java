package com.ruimo.util.builder;

import java.util.Collections;
import java.util.List;

/**
 * Type safe version of the {@link ListBuilder}. You need Java 5 or
 * higher to user this class.
 * 
<pre>
    List&lt;String&gt; list = new TypedListBuilder&lt;String&gt;(new ArrayList&lt;String&gt;())
      .add("Hello")
      .add("World")
      .get();
    System.out.println(set);

[Hello, World]
 */
public class TypedListBuilder<T> extends TypedCollectionBuilder<T> {

    /**
     * Constructor.
     *
     * ListBuilder wraps the specified list. The {@link #add(Object)}
     * will add objects into the wrapped list.
     *
     * @param list A list object to be wrapped.
     */
    public TypedListBuilder(List<T> list) {
        super (list);
    }

    /**
     * Add an object into the wrapped list.
     *
     * @param o An object to be added. It depends the characteristics
     * of the wrapped list whether a null argument is permitted.
     * @return A reference to this object is returned so that you can
     * chain bunch of the {#add(Object)} invocations.
     * @throws IllegalStateException Once the {@link #get()} method is
     * called, the builder object goes into a stale state and
     * consecutive {@link #add(Object)} operation will always throw
     * the {@link java.lang.IllegalStateException}.
     */
    public TypedListBuilder<T> add(T o) {
        super.add(o);
        return this;
    }

    /**
     * Retrieve the wrapped list. Once the list is retrieved by {@link
     * #get()} method, the builder instance goes into a stale state and
     * you cannot make use of this builder any more. Create new
     * builder instance to make another list.
     * @throws IllegalStateException Once the {@link #get()} method is
     * called, the builder object goes into a stale state and
     * consecutive {@link #get()} operation will always throw the
     * {@link java.lang.IllegalStateException}.
     */
    public List<T> get() {
        return (List<T>)super.get();
    }

    /**
     * Retrieve the wrapped list. The returned list is wrapped by
     * {@link java.util.Collections#unmodifiableList(java.util.List)} and changes
     * against the returned list will be rejected. Once the list is
     * retrieved by {@link #getUnmodifiable()} method, the builder
     * instance goes into a stale state and you cannot make use of
     * this builder any more. Create new builder instance to make
     * another collection.
     * @throws IllegalStateException Once the {@link #get()} method is
     * called, the builder object goes into a stale state and
     * consecutive {@link #getUnmodifiable()} operation will always
     * throw the {@link java.lang.IllegalStateException}.
     */
    public List<T> getUnmodifiable() {
        return Collections.unmodifiableList(get());
    }
}
