package com.ruimo.util.invariant;

public abstract class InvariantForInt {
    final String name;
    
    protected InvariantForInt(String name) {
        this.name = name;
    }

    abstract public int ensuring(int i);
}
