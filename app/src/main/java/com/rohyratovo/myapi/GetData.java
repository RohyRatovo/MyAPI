package com.rohyratovo.myapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetData {

//Specify the request type and pass the relative URL//

    @GET("/jobs/search.json?query=nursing+jobs")
  //  @GET("/api/location/search/?query=san")

//Wrap the response in a Call object with the type of the expected result//

    Call<List<RetroUsers>> getAllUsers();
}
