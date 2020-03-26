package com.welezohealth.welezo;

import android.os.Bundle;

public class Model_Recent_Add {
    private String package_head;
    private String amont;
    private String standard;
    private String rateings;
    private  String total_reviews;
    private String package_image;

    public Model_Recent_Add(String package_head, String amont, String standard, String rateings, String total_reviews,String package_image) {
        this.package_head = package_head;
        this.amont = amont;
        this.standard = standard;
        this.rateings = rateings;
        this.total_reviews = total_reviews;
        this.package_image=package_image;
    }

    public String getPackage_head() {
        return package_head;
    }


    public String getpackage_image() {
        return package_image;
    }

    public String getAmont() {
        return amont;
    }

    public String getStandard() {
        return standard;
    }

    public float getRateings() {
        return Float.parseFloat(rateings);
    }

    public String getTotal_reviews() {
        return total_reviews;
    }
}

