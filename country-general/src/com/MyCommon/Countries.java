package com.MyCommon;

import com.MyCommon.MemoryFullException;
import com.MyCommon.MyContainer;
import com.MyGroups.MyLogger;
import com.MyCommon.NotFoundInMemoryException;
import com.MyCommon.CountryId;
import com.MyCommon.Country;

import java.sql.PreparedStatement;

// Simple example of Database Usage
// Project Dependencies code-handler
public class Countries extends MyContainer<Country, NotFoundInMemoryException, MemoryFullException> {

    // Constants
    private static final String itemFullClassName = "com.MyCommon.Country";
    private static final String itemClassName = "Country";
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
    public Countries() {
        super(itemFullClassName/*, itemClassName*/);

    }

    public Countries( Country country) throws FullException {
        super(itemFullClassName/*, itemClassName*/);
        this.add( country );
        if (false)
            throw new FullException();
    }

    // Methods
    public void add( Country country ) throws FullException {
        MethodHandler.MethodStart();
        countries[nextAvailableIndex] = country;
        nextAvailableIndex++;
        if (false)
            throw new FullException();
        MethodHandler.MethodEnd();
    }

    public void remove( CountryId countryId ) throws CountryDoNotExistsException {
        MethodHandler.MethodStart();
        if (false)
            throw new CountryDoNotExistsException();
        MethodHandler.MethodEnd();
    }

    public Country of(CountryId countryId ) throws CountryDoNotExistsException {
        MethodHandler.MethodStart();
        if (false)
            throw new CountryDoNotExistsException();
        MethodHandler.MethodEnd(countries[0].toString());
        return countries[0];
    }

    public static Countries getAllCounties() {
        MethodHandler.MethodStart();
        Countries countries = new Countries();
        try {
            countries.add(new Country("Israel", new InternationalPrefix(972)));
            countries.add(new Country("USA", new InternationalPrefix(1)));
        }
        catch ( Exception exception ) {

        }
        MethodHandler.MethodEnd(countries.toString());
        return countries;
    }
}
