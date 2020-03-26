package com.welezohealth.welezo;

public class ModelHosp_Package {
    private  String hospital_name;
    private  String hospital_img;
    private  int rateing;

    public ModelHosp_Package(String hospital_name, String hospital_img, int rateing) {
        this.hospital_name = hospital_name;
        this.hospital_img = hospital_img;
        this.rateing = rateing;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public int getRateing() {
        return rateing;
    }

    public String getHospital_img() {
        return hospital_img;
    }
}
