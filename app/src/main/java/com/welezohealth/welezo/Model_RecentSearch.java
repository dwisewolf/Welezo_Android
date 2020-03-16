package com.welezohealth.welezo;

public class Model_RecentSearch {
    private  String searchKeys;

    public Model_RecentSearch(String searchKeys) {
        this.searchKeys = searchKeys;
    }

    public  String getSearchKeys(){
        return searchKeys;
    }
}
