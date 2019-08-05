package com.rohyratovo.myapi;

import com.google.gson.annotations.SerializedName;


public class RetroUsers {

//Give the field a custom name//
//organization_name

    @SerializedName("position_title")
    private String position_title;
    @SerializedName("organization_name")
    private String organization_name;
    @SerializedName("id")
    private String id;
    @SerializedName("start_date")
    private String start_date;
    @SerializedName("end_date")
    private String end_date;
    @SerializedName("url")
    private String url;




    public RetroUsers(String position_title,String organization_name,String id,String start_date,String end_date,String url) {
        this.position_title = position_title;
        this.organization_name = organization_name;
        this.id = id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.url = url;



    }

//Retrieve the data using setter/getter methods//

    public String getPosition_title() {
        return position_title;
    }
    public String getOrganization_name() {
        return  organization_name;
    }
    public String getId() { return id; }

    public String getStart_date() {
       return start_date;
    }

    public String getEnd_date() {
       return end_date;
    }
    public String getUrl() {
     return url;
    }

}
