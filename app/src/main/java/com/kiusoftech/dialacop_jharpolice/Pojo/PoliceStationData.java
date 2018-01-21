package com.kiusoftech.dialacop_jharpolice.Pojo;

/**
 * Created by bamakantkar on 21/6/17.
 */
public class PoliceStationData {

    private String mStationContactPhone;
    private String mStationContactMobile;

    public PoliceStationData(String StationContactPhone, String StationContactMobile){

        mStationContactPhone = StationContactPhone;
        mStationContactMobile = StationContactMobile;
    }

    public String getmStationContactPhone(){ return mStationContactPhone; }
    public String getmStationContactMobile() { return mStationContactMobile; }

}
