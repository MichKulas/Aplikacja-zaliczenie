package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //modyfikator dostępu/ Typ zmiennej i nazwa zmiennej
    public Button bOblicz;
    protected EditText etMasa;
    public EditText etWzrost;
    public EditText etBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bOblicz = (Button) findViewById(R.id.buttonOK);
        bOblicz.setOnClickListener(this);
        etMasa = (EditText) findViewById(R.id.etMasa);
        etWzrost = (EditText) findViewById(R.id.etWzrost);
        etBMI = (EditText) findViewById(R.id.etBMI);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_main_activity,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.action_settings){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View v){
        String smasa = etMasa.getText().toString().trim();
        String swzrost = etWzrost.getText().toString().trim();

        //double, żeby można podać liczby po przecinku
        double masa = Double.parseDouble(smasa);
        double wzrost = Double.parseDouble(swzrost);

        double wzrostWm = wzrost/100; //dzielenie na 100, poniewaz wzor na BMI obliczamy w metrach
        double bmi = masa/wzrostWm/wzrostWm; //wzor na bmi
        String sbmi = String.valueOf(bmi);


        etBMI.setText(sbmi);
    }
}
