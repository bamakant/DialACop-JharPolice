package com.kiusoftech.dialacop_jharpolice.rest;

import com.google.api.client.util.Key;

import java.io.Serializable;

/**
 * Created by bamakant on 26/1/18.
 */

public class PlaceDetails implements Serializable {

    @Key
    public String status;

    @Key
    public Place result;

    @Override
    public String toString() {
        if (result!=null) {
            return result.toString();
        }
        return super.toString();
    }
}
