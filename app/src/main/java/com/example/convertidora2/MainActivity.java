package com.example.convertidora2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private EditText txtPesos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtPesos = (EditText) findViewById(R.id.txtPesos);
    }

    public void convertir(View view) {
        try {
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            String valorPeso = txtPesos.getText().toString();
            double pesos = Float.parseFloat(valorPeso);
            double euros = pesos / 931.54;
            String valorEuro = decimalFormat.format(euros);
            Intent intent = new Intent(this, Activity2.class);
            String message = "el total en euros es \n" + valorEuro;
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "Ingrese una cantidad, no me lesee", Toast.LENGTH_SHORT).show();
        }


    }
}