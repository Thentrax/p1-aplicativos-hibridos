package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    protected void onStart() {
        super.onStart();
        Button caltulateButton = findViewById(R.id.calculate_button);
        caltulateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ammountValue = findViewById(R.id.ammount_input);
                String ammountValueString = ammountValue.getText().toString();
                Float ammountValueFloat = Float.parseFloat(ammountValueString);

                EditText taxesValue = findViewById(R.id.taxes_input);
                String taxesValueString = taxesValue.getText().toString();
                int taxesValueInt = Integer.parseInt(taxesValueString);

                EditText yearsValue = findViewById(R.id.years_input);
                String yearsValueString = yearsValue.getText().toString();
                int yearsValueInt = Integer.parseInt(yearsValueString);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("ammountValue", ammountValueFloat);
                intent.putExtra("taxesValue", taxesValueInt);
                intent.putExtra("yearsValue", yearsValueInt);
                startActivity(intent);
            }
        });
    }
}
