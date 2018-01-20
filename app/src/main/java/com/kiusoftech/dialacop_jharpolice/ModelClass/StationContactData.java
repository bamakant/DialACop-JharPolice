package com.kiusoftech.dialacop_jharpolice.ModelClass;

/**
 * Created by bamakantkar on 21/6/17.
 */
public class StationContactData {

    private String mStationContactPhone;
    private String mStationContactMobile;

    public StationContactData(String StationContactPhone,String StationContactMobile){

        mStationContactPhone = StationContactPhone;
        mStationContactMobile = StationContactMobile;
    }

    public String getmStationContactPhone(){ return mStationContactPhone; }
    public String getmStationContactMobile() { return mStationContactMobile; }

}
