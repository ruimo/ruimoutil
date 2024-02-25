package com.ruimo.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class TypedRingBuffer<E> implements Cloneable, Serializable {
    private transient Object[] buffer;
    /** 空き領域の先頭へのポインタ(inclusive) */
    protected volatile int first;
    /** データの最後へのポインタ(exclusive) */
    protected volatile int last;

    public TypedRingBuffer(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal capacity:" + capacity);
        buffer = new Object[capacity + 1]; // +1 for guard.
    }

    /**
     * ポインタを 1 すすめる
     * @param pointer
     * @return 1 進めたポインタ
     * */
    protected int increment(int pointer) {
        return (pointer + 1) % buffer.length;
    }

    /**
     * バッファがフルかどうか調べます
     * @return バッファがフルなら true
     * */
    protected boolean bufferFull() {
        return (first == increment(last));
    }

    /**
     * バッファが空かどうか調べます
     * @return バッファが空なら true
     * */
    protected boolean bufferEmpty() {
        return (first == last);
    }

    /**
     * バッファにデータを押し込みます。既にバッファが一杯であれば， 
     * BufferFullException が throw されます。
     * @param obj 押し込むデータ
     * @throws BufferFullException バッファが一杯の場合に throw されます。
     * */
    public void put(Object obj) throws BufferFullException {
        if (bufferFull()) throw new BufferFullException();
        buffer[last] = obj;
        last = increment(last);
    }

    /**
     * バッファからデータを取り出します。
     * @return バッファから取り出したデータ。もしもバッファが空の場合
     * は， BufferEmptyException が throw されます。
     * @throws BufferEmptyException バッファが空の場合に throw されます
     * */
    public Object get() {
        Object ret = null;
        if (bufferEmpty()) throw new BufferEmptyException();
        ret = buffer[first];
        first = increment(first);
        return ret;
    }

    /**
     * データを覗き見します。読み込みを行なう
     * @return 覗き見したデータ。バッファが空なら，
     * BufferEmptyException が throw されます。
     * @throws BufferEmptyException バッファが空の場合に throw されます
     * */
    public Object peek() {
        Object ret = null;
        if (bufferEmpty()) throw new BufferEmptyException();
        ret = buffer[first];
        return ret;
    }

    /**
     * バッファ内のデータ数を調べます。
     * @return データ数
     * */
    public int size() {
        int currentFirst = first;
        int currentLast = last;
        if (currentFirst > currentLast) {
            currentLast += buffer.length;
        }
        return currentLast - currentFirst;
    }

    /**
     * バッファに入れる事の出来るデータ数の最大値を調べます。 
     * */
    public int capacity() {
        return buffer.length - 1; // -1 は番兵の分
    }
}
