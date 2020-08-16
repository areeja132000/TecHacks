package com.example.techacks;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Older_Prescriptions_Page extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.older_perscriptions);

        dataBase db = new dataBase(Older_Prescriptions_Page.this);

        //Cursor to Perscriptions table
        Cursor allPerscriptions = db.getPerscriptions();
        allPerscriptions.moveToFirst();

        //Array list of all Perscriptions
        ArrayList<String> perscriptions = new ArrayList<String>();
        while (!allPerscriptions.isAfterLast()) {
            perscriptions.add(allPerscriptions.getString(0));
            allPerscriptions.moveToNext();
        }
        allPerscriptions.close();

        String finalText="Older Perscriptions: \n\n";
        for (int i = 0; i < perscriptions.size(); i++) {
            finalText += "Perscription #" + String.valueOf(i+1) + ";\n";
            finalText = finalText + perscriptions.get(i) +"\n\n";
        }

        TextView all_output = (TextView)findViewById(R.id.textView);
        all_output.setText(finalText);

        Button back = (Button) findViewById(R.id.back1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Older_Prescriptions_Page.this, Menu.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
