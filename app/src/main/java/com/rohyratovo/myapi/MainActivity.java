package com.rohyratovo.myapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyAdapter myAdapter;
    private RecyclerView myRecyclerView;
    private ProgressBar Pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Create a handler for the RetrofitInstance interface//

        GetData service = RetrofitClient.getRetrofitInstance().create(GetData.class);
        Pbar = findViewById(R.id.progressBar);
        Pbar.setVisibility(View.VISIBLE);

        Call<List<RetroUsers>> call = service.getAllUsers();

//Execute the request asynchronously//

        call.enqueue(new Callback<List<RetroUsers>>() {

            @Override

//Handle a successful response//

            public void onResponse(Call<List<RetroUsers>> call, Response<List<RetroUsers>> response) {
                loadDataList(response.body());
                Pbar.setVisibility(View.GONE);

            }

            @Override

//Handle execution failures//

            public void onFailure(Call<List<RetroUsers>> call, Throwable throwable) {

//If the request fails, then display the following toast//

                Toast.makeText(MainActivity.this, "Unable to show", Toast.LENGTH_SHORT).show();
                Pbar.setVisibility(View.GONE);

            }

        });
    }

//Display the retrieved data as a list//

    private void loadDataList(List<RetroUsers> usersList) {

//Get a reference to the RecyclerView//

        myRecyclerView = findViewById(R.id.myRecyclerView);
        myAdapter = new MyAdapter(usersList, getListener());

//Use a LinearLayoutManager with default vertical orientation//

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        myRecyclerView.setLayoutManager(layoutManager);

//Set the Adapter to the RecyclerView//

        myRecyclerView.setAdapter(myAdapter);

    }

    private OnItemClickListener getListener() {
        return new OnItemClickListener() {
            @Override
            public void onItemClick(RetroUsers item) {

                Gson gson = new Gson();
                Intent myIntent = new Intent(MainActivity.this, JobDisplayActivity.class);
                myIntent.putExtra("obj", gson.toJson(item)); //Optional parameters
                startActivity(myIntent);
            }
        };
    }

}
