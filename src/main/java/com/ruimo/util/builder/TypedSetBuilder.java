package com.ruimo.util.builder;

import java.util.Collections;
import java.util.Set;

/**
 * Type safe version of the {@link SetBuilder}. You need Java 5 or
 * higher to user this class.
 * 
<pre>
    Set&lt;String&gt; set = new TypedSetBuilder&lt;String&gt;(new HashSet&lt;String&gt;())
      .add("Hello")
      .add("World")
      .get();
    System.out.println(set);

[Hello, World]
 */
public class TypedSetBuilder<T> extends TypedCollectionBuilder<T> {
    /**
     * Constructor.
     *
     * SetBuilder wraps the specified set. The {@link #add(Object)}
     * will add objects into the wrapped set.
     *
     * @param set A set object to be wrapped.
     */
    public TypedSetBuilder(Set<T> set) {
        super (set);
    }

    /**
     * Add an object into the wrapped set.
     *
     * @param o An object to be added. It depends the characteristics
     * of the wrapped set whether a null argument is permitted.
     * @return A reference to this object is returned so that you can
     * chain bunch of the {#add(Object)} invocations.
     * @throws IllegalStateException Once the {@link #get()} method is
     * called, the builder object goes into a stale state and
     * consecutive {@link #add(Object)} operation will always throw
     * the {@link java.lang.IllegalStateException}.
     */
    public TypedSetBuilder<T> add(T o) {
        super.add(o);
        return this;
    }

    /**
     * Retrieve the wrapped set. Once the set is retrieved by {@link
     * #get()} method, the builder instance goes into a stale state and
     * you cannot make use of this builder any more. Create new
     * builder instance to make another set.
     * @throws IllegalStateException Once the {@link #get()} method is
     * called, the builder object goes into a stale state and
     * consecutive {@link #get()} operation will always throw the
     * {@link java.lang.IllegalStateException}.
     */
    public Set<T> get() {
        return (Set<T>)super.get();
    }

    /**
     * Retrieve the wrapped set. The returned set is wrapped by {@link
     * java.util.Collections#unmodifiableSet(java.util.Set)} and
     * changes against the returned set will be rejected. Once the set
     * is retrieved by {@link #getUnmodifiable()} method, the builder
     * instance goes into a stale state and you cannot make use of
     * this builder any more. Create new builder instance to make
     * another collection.
     * @throws IllegalStateException Once the {@link #get()} method is
     * called, the builder object goes into a stale state and
     * consecutive {@link #getUnmodifiable()} operation will always
     * throw the {@link java.lang.IllegalStateException}.
     */
    public Set<T> getUnmodifiable() {
        return Collections.unmodifiableSet(get());
    }
}
