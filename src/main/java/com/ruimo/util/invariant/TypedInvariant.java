package com.ruimo.util.invariant;

public abstract class TypedInvariant<T> {
    final String name;
    
    protected TypedInvariant(String name) {
        this.name = name;
    }
    
    abstract public T ensuring(T o);
}
