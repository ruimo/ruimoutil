package com.ruimo.util.invariant;

public abstract class Invariant {
    final String name;
    
    protected Invariant(String name) {
        this.name = name;
    }
    
    abstract public Object ensuring(Object o);
}
