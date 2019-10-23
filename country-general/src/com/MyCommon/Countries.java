package com.MyCommon;

import com.Mycommon.CountryId;

public class Countries {

    // Constants
    public static int MAX_COUNTRIES = 100;

    // Attributes
    private Country[] countries = new Country[MAX_COUNTRIES];
    private int nextAvailableIndex = 0;

    // Exceptions
    class CountryDoNotExistsException extends Exception {

    }
    // TODO What is the best name?
    class FullException extends Exception {

    }

    // Constructors
    Countries() {

    }

    Countries( Country country) throws FullException {
        this.add( country );
        if (false)
            throw new FullException();
    }

    // Methods
    public void add( Country country ) throws FullException {
        countries[nextAvailableIndex] = country;
        nextAvailableIndex++;
        if (false)
            throw new FullException();

    }

    public void remove( CountryId countryId ) throws CountryDoNotExistsException {
        if (false)
            throw new CountryDoNotExistsException();
    }

    public Country of(CountryId countryId ) throws CountryDoNotExistsException {
        if (false)
            throw new CountryDoNotExistsException();
        return countries[0];
    }

    public static Countries getAllCounties() {
        Countries countries = new Countries();
        try {
            countries.add(new Country("Israel", new InternationalPrefix(972)));
            countries.add(new Country("USA", new InternationalPrefix(1)));
        }
        catch ( Exception exception ) {

        }
        return countries;
    }
}
