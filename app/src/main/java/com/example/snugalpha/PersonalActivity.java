package com.example.snugalpha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class PersonalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        final ImageButton backButton=(ImageButton)findViewById(R.id.backButton);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(PersonalActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

