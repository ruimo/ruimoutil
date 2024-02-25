package com.ruimo.util.builder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Map builder. A helper class to create ad-hoc map object.
 *
<pre>
    Map map = new MapBuilder(new HashMap())
        .put("Hello", "World")
        .put("Ruimo", "Uno")
        .get();
    System.out.println(map);    

{Ruimo=Uno, Hello=World}
</pre>
*/
public class MapBuilder {
    private Map map;

    /**
     * Constructor.
     *
     * MapBuilder wraps the specified list. The {@link #put(Object,
     * Object)} will put pairs of key/value into the wrapped map.
     *
     * @param map A map object to be wrapped.
     */
    public MapBuilder(Map map) {
        if (map == null) throw new NullPointerException("map is null.");
        this.map = map;
    }

    /**
     * Put an pair of objects into the wrapped map. It depends the
     * characteristics of the wrapped map whether a null key/value is
     * permitted.
     *
     * @param key Key with which the specified value is to be
     * associated.
     * @param value Value to be associated with the specified key.
     * @return A reference to this object is returned so that you can
     * chain bunch of the {#put(Object, Object)} invocations.
     * @throws IllegalStateException Once the {@link #get()} method is
     * called, the builder object goes into a stale state and
     * consecutive {@link #put(Object, Object)} operation will always
     * throw the {@link java.lang.IllegalStateException}.
     */
    public MapBuilder put(Object key, Object value) {
        if (map == null) throw new IllegalStateException("Create new MapBuilder.");
        map.put(key, value);
        return this;
    }

    /**
     * Retrieve the wrapped map. Once the map is retrieved by {@link
     * #get()} method, the builder instance goes into a stale state and
     * you cannot make use of this builder any more. Create new
     * builder instance to make another map.
     * @throws IllegalStateException Once the {@link #get()} method is
     * called, the builder object goes into a stale state and
     * consecutive {@link #get()} operation will always throw the
     * {@link java.lang.IllegalStateException}.
     */
    public Map get() {
        if (map == null) throw new IllegalStateException("Create new MapBuilder.");
        Map ret = map;
        map = null;
        return ret;
    }

    /**
     * Retrieve the wrapped map. The returned map is wrapped by {@link
     * java.util.Collections#unmodifiableMap(java.util.Map)} and
     * changes against the returned map will be rejected. Once the map
     * is retrieved by {@link #getUnmodifiable()} method, the builder
     * instance goes into a stale state and you cannot make use of
     * this builder any more. Create new builder instance to make
     * another collection.
     * @throws IllegalStateException Once the {@link #get()} method is
     * called, the builder object goes into a stale state and
     * consecutive {@link #getUnmodifiable()} operation will always
     * throw the {@link java.lang.IllegalStateException}.
     */
    public Map getUnmodifiable() {
        return Collections.unmodifiableMap(get());
    }
}
