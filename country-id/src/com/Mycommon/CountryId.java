package com.Mycommon;

public class CountryId {

    public static final long USA = 1;
    public static final long ISRAEL = 2;

    private long value;

    public CountryId(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
