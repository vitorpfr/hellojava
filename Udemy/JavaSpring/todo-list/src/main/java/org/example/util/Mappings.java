package org.example.util;

// final keyword prevents this class from being inherited
// private constructor prevents this class from being instantiated
// combined, this makes an immutable class that only have static data
public final class Mappings {
    public static final String ITEMS = "items";
    public static final String ADD = "add";
    public static final String ADD_ITEM = "addItem";


    // == constructor ==
    private Mappings() {

    }
}
