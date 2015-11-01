package com.example.tyler.bedlamsboybandbattlesbeadledom;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class selectPower extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_power);

        Button power1;
        Button power2;
        Button power3;
        Button power4;

        power1 = (Button) findViewById(R.id.bPower1);
        power2 = (Button) findViewById(R.id.bPower2);
        power3 = (Button) findViewById(R.id.bPower3);
        power4 = (Button) findViewById(R.id.bPower4);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            power1.setTag(extras.getString("power1"));
        }
        if (extras != null) {
            power2.setTag(extras.getString("power2"));
        }
        if (extras != null) {
            power3.setTag(extras.getString("power3"));
        }
        if (extras != null) {
            power4.setTag(extras.getString("power4"));
        }

        power1.setOnClickListener(this);
        power2.setOnClickListener(this);
        power3.setOnClickListener(this);
        power4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bPower1:
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("playerChoice", 0);
                startActivity(i);

                break;

            case R.id.bPower2:
                Intent j = new Intent(getApplicationContext(), MainActivity.class);
                j.putExtra("playerChoice", 1);
                startActivity(j);
                break;



            case R.id.bPower3:
                Intent k = new Intent(getApplicationContext(), MainActivity.class);
                k.putExtra("playerChoice", 2);
                startActivity(k);
                break;

            case R.id.bPower4:
                Intent l = new Intent(getApplicationContext(), MainActivity.class);
                l.putExtra("playerChoice", 3);
                startActivity(l);
                break;
        }
    }

}
