package com.MyCommon;

public class CountryId {

    // Attributes unique to CountryId
    public static final long USA_CODE = 1;
    public static final long ISRAEL_CODE = 2;
    public static final CountryId USA = new CountryId(USA_CODE);
    public static final CountryId ISRAEL = new CountryId(ISRAEL_CODE);

    // Attributes
    private long value;

    // Constructors
    public CountryId(long value) {
        this.value = value;
    }

    // Setters & Getters
    public long getValue() {
        return value;
    }
    public void setValue(long value) {
        this.value = value;
    }
}
