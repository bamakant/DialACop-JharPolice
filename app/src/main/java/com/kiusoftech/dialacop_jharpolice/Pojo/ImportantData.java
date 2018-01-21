package com.kiusoftech.dialacop_jharpolice.Pojo;

/**
 * Created by bamakantkar on 23/6/17.
 */
public class ImportantData {

    private String mPersonName;
    private String mMobileNo;
    private String mOfficeNo;
    private String mResidenceNo;
    private String mFaxNo;
    private String mEmail;

    public ImportantData(String PersonName, String MobileNo, String OfficeNo, String ResidenceNo, String FaxNo, String Email){

        mPersonName = PersonName;
        mMobileNo = MobileNo;
        mOfficeNo = OfficeNo;
        mResidenceNo = ResidenceNo;
        mFaxNo = FaxNo;
        mEmail = Email;
    }

    public String getmPersonName() { return mPersonName; }
    public String getmMobileNo() { return mMobileNo; }
    public String getmOfficeNo() { return mOfficeNo; }
    public String getmResidenceNo() { return mResidenceNo; }
    public String getmFaxNo() { return mFaxNo; }
    public String getmEmail() { return mEmail; }

}
