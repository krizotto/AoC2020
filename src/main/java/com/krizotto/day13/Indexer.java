package com.krizotto.day13;

public class Indexer implements Comparable<Indexer> {
    private long index;
    private long value;

    public Indexer(long index, long value) {
        this.index = index;
        this.value = value;
    }

    public long getIndex() {
        return index;
    }

    public long getValue() {
        return value;
    }

    @Override
    public int compareTo(Indexer o) {
        if (this.value < o.value) {
            return -1;
        } else if (this.value > o.value) {
            return 1;
        }
        return 0;
    }
}
