package com.Mycommon;

public class CountryId {

    public static final long USA_CODE = 1;
    public static final long ISRAEL_CODE = 2;
    public static final CountryId USA = new CountryId(USA_CODE);
    public static final CountryId ISRAEL = new CountryId(ISRAEL_CODE);

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
