package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        float ammountValue = getIntent().getFloatExtra("finalammountValue", 0.00f);
        int taxesValue = getIntent().getIntExtra("taxesValue", 0);
        int yearsValue = getIntent().getIntExtra("yearsValue", 0);

        int months = getMonths(yearsValue);
        float taxesPerMonth = getTaxesPerMonth(taxesValue);
        float contribution = calculateContribution(ammountValue, taxesPerMonth, months);

        TextView contributionValue = findViewById(R.id.contribution_value);
        contributionValue.setText(String.valueOf(contribution));

        TextView finalAmmountValue = findViewById(R.id.final_ammount_value);
        finalAmmountValue.setText(String.valueOf(ammountValue));

        TextView finalTaxesValue = findViewById(R.id.taxes_value);
        finalTaxesValue.setText(String.valueOf(taxesValue));

        TextView monthsValue = findViewById(R.id.months_value);
        monthsValue.setText(String.valueOf(months));

        setContentView(R.layout.second);
    }

    protected void onStart() {
        super.onStart();
        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private int getMonths (int years) {
        return years * 12;
    }

    private float getTaxesPerMonth(int taxes) {
        return (float) taxes / 12;
    }

    private float calculateContribution (float ammount, float taxes, float months){
        float firstLine = ammount * taxes;
        float secondLine = (float) Math.pow(1 + taxes, months)-1;
        return firstLine / secondLine;
    }
}
