package com.MyCommon;

// Maybe I can move Country class / project to infrastructure-geography
public class Country {

    private String name;
    private InternationalPrefix internationalPrefix; // 972

    public Country(){
        this.setName("");
    }
    public Country(String name) {
        this.setName(name);
    }
    public Country(String name, InternationalPrefix internationalPrefix ) {
        this.setName(name);
        this.setInternationalPrefix(internationalPrefix);
    }

    /*
    public Country (Country other, InternationalPrefix internationalPrefix){
        this.setName(other.getName());
        this.internationalPrefix = internationalPrefix;
    }
    */

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InternationalPrefix getInternationalPrefix() {
        return internationalPrefix;
    }

    public void setInternationalPrefix(InternationalPrefix internationalPrefix) {
        this.internationalPrefix = internationalPrefix;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                '}';
    }
}