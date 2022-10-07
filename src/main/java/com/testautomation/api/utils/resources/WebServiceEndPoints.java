package com.testautomation.api.utils.resources;
import com.testautomation.api.utils.constants.EndPoints;

public enum WebServiceEndPoints {
    //URI(EndPoints.URL_POSTREGISTER);
    URI(EndPoints.URL_GETUSERS);

    private final String url;

    WebServiceEndPoints(String url){
        this.url = url;
    }

    public String getUrl(){
        return url;
    }
}
