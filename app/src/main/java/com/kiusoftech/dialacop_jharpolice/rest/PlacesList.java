package com.kiusoftech.dialacop_jharpolice.rest;

import com.google.api.client.util.Key;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bamakant on 26/1/18.
 */

public class PlacesList implements Serializable {

    @Key
    public String status;

    @Key
    public List<Place> results;

}