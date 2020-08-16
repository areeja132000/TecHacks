package com.example.techacks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_screen);

        Button nextButton = (Button) findViewById(R.id.next_page);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Next_Page.class);
                startActivity(intent);
                finish();
            }
        });

        Button prescriptionsButton = (Button) findViewById(R.id.my_prescriptions_button);
        prescriptionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Older_Prescriptions_Page.class);
                startActivity(intent);
                finish();
            }
        });

        Button profileButton = (Button) findViewById(R.id.my_profile_button);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, myProfile.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
