package com.example.techacks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayScan extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_scan);
        Bundle bundle = getIntent().getExtras();
        String scanned = bundle.getString("scan");

//        String[] parts = scanned.split("\n");
//
//        String newString = "";
//        for (int i = 0; i < parts.length; i++) {
//            // accessing each element of array
//            String x = parts[i];
//            newString = newString + x + "\n";
//        }

        TextView scanned_output = (TextView)findViewById(R.id.textView);
        scanned_output.setText(scanned);
        Button back = (Button) findViewById(R.id.back1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayScan.this, Next_Page.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
