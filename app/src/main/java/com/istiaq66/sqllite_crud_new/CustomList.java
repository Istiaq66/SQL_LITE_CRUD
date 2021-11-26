package com.istiaq66.sqllite_crud_new;



public class CustomList {


    public CustomList(String strId, String strName, String strMobile) {
        this.strId = strId;
        this.strName = strName;
        this.strMobile = strMobile;
    }


    public CustomList() {

    }


    private String strId;
    private String strName;
    private String strMobile;


    public String getStrId() {
        return strId;
    }

    public void setStrId(String strId) {
        this.strId = strId;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getStrMobile() {
        return strMobile;
    }

    public void setStrMobile(String strMobile) {
        this.strMobile = strMobile;
    }




}
