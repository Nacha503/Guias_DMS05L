package com.example.miprimeraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String mensaje;
    TextView txtv;
    Button  btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mensaje = getString(R.string.hello_world_oscar);
        txtv = (TextView) findViewById(R.id.textView);
        btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtv.setText(mensaje);
            }
        });

        if(savedInstanceState != null) {
            mensaje = savedInstanceState.getString("saludo");
            txtv.setText(mensaje);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("saludo",mensaje);
    }
}