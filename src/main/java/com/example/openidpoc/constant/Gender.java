package com.example.openidpoc.constant;

/**
 * Created by abidkhan on 01/06/18.
 */
public enum Gender {
    MALE("male");
    private String value;

    private Gender(String value) {
        this.value = value;
    }

    public static Gender getGender(String value) {
        for (Gender key : Gender.values()) {
            if (key.value.equals(value)) {
                return key;
            }
        }

        return null;
    }
}
