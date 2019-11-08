package com.MyCommon;

// Simple example of Database Usage
// Project Dependencies code-handler
public class Countries extends MyContainer<Country, NotFoundInMemoryException, MemoryFullException> {

    // Constants
    private static final String itemFullClassName = "com.MyCommon.Country";
    private static final String itemClassName = "Country";
    public static int MAX_COUNTRIES = 100;

    // Attributes
    private Country[] values = new Country[MAX_COUNTRIES];
    private int nextAvailableIndex = 0;

    // Exceptions
    class CountryDoNotExistsException extends Exception {

    }
    // TODO What is the best name?
    class FullException extends Exception {

    }

    // Constructors

    // Default Constructor
    public Countries() {
        super(itemFullClassName); // Calling to the parent constuctor
        MethodHandler.MethodStart();
        MethodHandler.MethodEnd();
    } // Countries

    public Countries( Country country) throws FullException {
        this(); // Calling to the Default Constructor
        MethodHandler.MethodStart();
        this.add( country );
        if (false)
            throw new FullException();
        MethodHandler.MethodEnd();
    } // Countries

    // Methods
    public void add( Country country ) throws FullException {
        MethodHandler.MethodStart();
        if (this.nextAvailableIndex>=MAX_COUNTRIES)
            throw new FullException();
        values[nextAvailableIndex] = country;
        nextAvailableIndex++;
        MethodHandler.MethodEnd();
    } // add

    // Used both by find() and by remove()
    private int findIndex(CountryId countryId) throws CountryDoNotExistsException {
        MethodHandler.MethodStart();
        boolean found = false;
        int indexOfTheItem;
        for (indexOfTheItem=0; indexOfTheItem< this.nextAvailableIndex && !found; indexOfTheItem++) {
            if (this.values[indexOfTheItem].getLocalId()==countryId.getValue()) {
                found = true;
            }
        }
        if (!found)
            throw new CountryDoNotExistsException();
        MethodHandler.MethodEnd(indexOfTheItem);
        return indexOfTheItem;
    } // findIndex

    public Country find(CountryId countryId) throws CountryDoNotExistsException {
        MethodHandler.MethodStart();
        Country country = this.values[findIndex(countryId)];
        MethodHandler.MethodEnd(country.toString());
        return country;
    } // find

    public Country of(CountryId countryId ) throws CountryDoNotExistsException {
        MethodHandler.MethodStart();
        Country country = find(countryId);
        MethodHandler.MethodEnd(country.toString());
        return country;
    } // of

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
    } // getAllCountries

    public void update( Country country )  {
        MethodHandler.MethodStart();
        int index = 0;
        try {
            index = findIndex(country.getId());
        } catch (CountryDoNotExistsException e) {
            e.printStackTrace();
        }
        this.values[index] = country;
        MethodHandler.MethodEnd();
    } // update

    private void moveAllItemsBackward(int indexOfTheItemFound) {
        MethodHandler.MethodStart();
        for (int i=indexOfTheItemFound; i<nextAvailableIndex; i++) {
            this.values[i]=this.values[i+1];
        }
        nextAvailableIndex--;
        values[nextAvailableIndex] = null;
        MethodHandler.MethodEnd();
    } // moveAllItemsBackward

    public void remove( CountryId countryId ) throws CountryDoNotExistsException {
        MethodHandler.MethodStart();
        int indexOfTheItemFound = findIndex( countryId );
        moveAllItemsBackward(indexOfTheItemFound);
        MethodHandler.MethodEnd();
    } // remove

}
