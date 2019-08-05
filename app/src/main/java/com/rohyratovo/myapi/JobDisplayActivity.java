package com.rohyratovo.myapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.google.gson.Gson;

public class JobDisplayActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_job);

        Gson gson = new Gson();
        String strObj = getIntent().getStringExtra("obj");
        RetroUsers obj = gson.fromJson(strObj, RetroUsers.class);

        TextView organization_name = findViewById(R.id.OrganizationtextView);
        organization_name.setText("Organization : " +obj.getOrganization_name());

        TextView start_date = findViewById(R.id.StarttextView);
        start_date.setText("start date : " +obj.getStart_date());

        TextView position_title = findViewById(R.id.PositiontextView);
        position_title.setText( obj.getPosition_title());

        TextView id = findViewById(R.id.IdtextView);
        id.setText("ID : " +obj.getId());

        TextView end_date = findViewById(R.id.EndtextView);
        end_date.setText("end date : " +obj.getEnd_date());

        TextView url = findViewById(R.id.UrltextView);
        url.setMovementMethod(LinkMovementMethod.getInstance());
        url.setText("Web page : " + obj.getUrl());



    }
}

