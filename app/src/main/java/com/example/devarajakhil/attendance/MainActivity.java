package com.example.devarajakhil.attendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView editTVV,attTVV,statTVV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTVV = (TextView) findViewById(R.id.editTV);
        attTVV = (TextView) findViewById(R.id.attendaceTV);
        statTVV = (TextView) findViewById(R.id.statTV);
        editTVV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrasesIntent = new Intent(MainActivity.this, EditActivity.class);
                startActivity(phrasesIntent);
            }
        });
        attTVV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrasesIntent = new Intent(MainActivity.this, AttActivity.class);
                startActivity(phrasesIntent);
            }
        });
        statTVV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrasesIntent = new Intent(MainActivity.this, StatActivity.class);
                startActivity(phrasesIntent);
            }
        });
    }
}
