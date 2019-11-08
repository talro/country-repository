package com.MyCommon;

import com.MyCommon.DatabaseFieldInfo;
import com.MyGroups.MyLogger;
import com.MyCommon.RelationalDatabaseObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.EnumMap;
import java.util.Map;

// Maybe I can move Country class / project to infrastructure-geography
// STEP1
public class Country extends RelationalDatabaseObject {

    // Constants
    public final String MY_CLASS_NAME = this.getClass().getSimpleName(); // "Country"

    // Attributes
    private String name = "";
    private InternationalPrefix internationalPrefix; // 972

    // Attributes - Database
    enum AttributesNames {
        NAME
        , INTERNATIONAL_PREFIX
    }
    private static Map<AttributesNames, String> attributesNamesMap = new EnumMap<AttributesNames, String>(AttributesNames.class);

    // Constructors
    public Country() {
        super();
        MethodHandler.MethodStart();
        setClassName(MY_CLASS_NAME);
        setDatabaseFields(); // TODO Can we move this statement to the parent class as it is static and can't be abstract
        MethodHandler.MethodEnd();
    }

    public Country(String name) {
        this();
        MethodHandler.MethodStart();
        this.setName(name);
        MethodHandler.MethodEnd();
    }

    public Country(String name, InternationalPrefix internationalPrefix) {
        this(name);
        MethodHandler.MethodStart();
        this.setInternationalPrefix(internationalPrefix);
        MethodHandler.MethodEnd();
    }

    // Copy constructor
    public Country (Country other){
        MethodHandler.MethodStart();
        this.setName(other.getName());
        this.setInternationalPrefix(other.getInternationalPrefix());
        MethodHandler.MethodEnd();
    }

    // Setters & Getters
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
    public void setInternationalPrefix(String internationalPrefixString) {
        this.internationalPrefix.setValue(internationalPrefixString);
    }

    @Override
    public String toString() {
        MethodHandler.MethodStart();
        String result = MY_CLASS_NAME+"{" +
                "name='" + name + '\'' +
                "internationalPrefix='" + internationalPrefix + '\'' +
                '}';
        MethodHandler.MethodEnd();
        return result;
    }

    // Methods

    // Methods - Database
    private static void setAttributesNames() {
        MethodHandler.MethodStart();
        attributesNamesMap.put(AttributesNames.NAME, "name");
        attributesNamesMap.put(AttributesNames.INTERNATIONAL_PREFIX, "international_prefix");
        MethodHandler.MethodEnd();
    }

    public void setAttributes(ResultSet rs, ResultSet[] resultSets) {
        MethodHandler.MethodStart();
        try {
            // STEP
            this.setName(rs.getString(attributesNamesMap.get(AttributesNames.NAME)));
            this.setInternationalPrefix(rs.getString(attributesNamesMap.get(AttributesNames.INTERNATIONAL_PREFIX)));
        } catch (Exception ex) {
            ExceptionHandler.exceptionHandler(ex, slaveLogRecord, "Problem in public void setAttributes(ResultSet rs)" );
        }
        MethodHandler.MethodEnd();
    }

    public static void setDatabaseFields() {
        MethodHandler.MethodStart();
        setAttributesNames(); // Should first run setAttributesNames()
        // STEP
        RelationalDatabaseObject.databaseFields.add("name", new DatabaseFieldInfo("String"));
        RelationalDatabaseObject.databaseFields.add("international_prefix", new DatabaseFieldInfo("String"));
        MethodHandler.MethodEnd();
    }

    // TODO Can we use Map or other container here?
    public String[] getObjectValuesArray() {
        MethodHandler.MethodStart();
        String[] updateValues= new String[3];
        // You need to put here all your attributes (STEP2)
        updateValues[0]=""+this.getName();
        updateValues[1]=""+this.getInternationalPrefix();
        MethodHandler.MethodEnd(updateValues.toString());
        return updateValues;
    }

    // TODO Can we move it to RelationalDatabaseObject?
    public String getObjectValuesString() {
        MethodHandler.MethodStart();
        String result = "'"+this.getName()+"','"+this.getInternationalPrefix()+"'";
        MethodHandler.MethodEnd(result);
        return result;
    }

    public void setPreparedStatement(PreparedStatement statement) {
        MethodHandler.MethodStart();
        try {
            statement.setString(1, this.getName());
            statement.setString(2, String.valueOf(this.getInternationalPrefix()));
        }
        catch (Exception ex) {
            ExceptionHandler.exceptionHandler(ex, slaveLogRecord, "Problem in public void "+MY_CLASS_NAME+".setPreparedStatement(PreparedStatement statement)" );
        }
        MethodHandler.MethodEnd();
    }

    // TODO Can we move this to RelationalDatabaseObject?
    public String setSqlStatement() {
        MethodHandler.MethodStart();
        // STEP
        String sqlStatement = " name = '"+this.getName()+"'"
                +", international_prefix = '"+this.getInternationalPrefix()+"'"
                ;
        MethodHandler.MethodEnd(sqlStatement);
        return sqlStatement;
    }
}