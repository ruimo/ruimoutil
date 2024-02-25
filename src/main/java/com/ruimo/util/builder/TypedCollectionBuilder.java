package com.ruimo.util.builder;

import java.util.Collection;
import java.util.Collections;

/**
 * Type safe version of the {@link CollectionBuilder}. You need Java 5
 * or higher to user this class.
 * 
<pre>
    Collection&lt;String&gt; col = new TypedCollectionBuilder&lt;String&gt;(new ArrayList&lt;String&gt;())
      .add("Hello")
      .add("World")
      .get();
    System.out.println(set);

[Hello, World]
</pre>
 */
public class TypedCollectionBuilder<T> {
    private CollectionBuilder builder;

    /**
     * Constructor.
     *
     * CollectionBuilder wraps the specified collection. The {@link
     * #add(Object)} will add objects into the wrapped collection.
     *
     * @param collection A collection object to be wrapped.
     */
    public TypedCollectionBuilder(Collection<T> collection) {
        builder = new CollectionBuilder(collection);
    }

    /**
     * Add an object into the wrapped collection.
     *
     * @param o An object to be added. It depends the characteristics
     * of the wrapped collection whether a null argument is
     * permitted. 
     * @return A reference to this object is returned so that you can
     * chain bunch of the {#add(Object)} invocations.
     * @throws IllegalStateException Once the {@link #get()} method is
     * called, the builder object goes into a stale state and
     * consecutive {@link #add(Object)} operation will always throw
     * the {@link java.lang.IllegalStateException}.
     */
    public TypedCollectionBuilder<T> add(T o) {
        builder.add(o);
        return this;
    }

    /**
     * Retrieve the wrapped collection. Once the collection is
     * retrieved by {@link #get()} method, the builder instance goes
     * into a stale state and you cannot make use of this builder any
     * more. Create new builder instance to make another collection.
     * @throws IllegalStateException Once the {@link #get()} method is
     * called, the builder object goes into a stale state and
     * consecutive {@link #get()} operation will always throw the
     * {@link java.lang.IllegalStateException}.
     */
    @SuppressWarnings("unchecked")
    public Collection<T> get() {
        return (Collection<T>)builder.get();
    }

    /**
     * Retrieve the wrapped collection. The returned collection is
     * wrapped by {@link
     * java.util.Collections#unmodifiableCollection(java.util.Collection)}
     * and changes against the returned collection will be
     * rejected. Once the collection is retrieved by {@link #get()}
     * method, the builder instance goes into a stale state and you
     * cannot make use of this builder any more. Create new builder
     * instance to make another collection.
     * @throws IllegalStateException Once the {@link #get()} method is
     * called, the builder object goes into a stale state and
     * consecutive {@link #getUnmodifiable()} operation will always
     * throw the {@link java.lang.IllegalStateException}.
     */
    @SuppressWarnings("unchecked")
    public Collection<T> getUnmodifiable() {
        return (Collection<T>)builder.getUnmodifiable();
    }
}
