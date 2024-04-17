package com.example.waherungsrechner_mobsys;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private ImageView selected;
    private TextView tv_result;
    private TextView tv_calc;
    private EditText tv_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selection(View v) {
        selected = findViewById(v.getId());
        tv_result = findViewById(R.id.tv_result);

        if (selected.getId() == R.id.iv_USD) {
            tv_result.setText("US Dollar");
        } else if (selected.getId() == R.id.iv_SRF) {
            tv_result.setText("Schweizer Franken");
        } else {
            tv_result.setText("Euro");
        }
    }

    public void calc(View v) {
        tv_calc = findViewById(R.id.tv_calc);
        tv_input = findViewById(R.id.tv_input);
        String input = tv_input.getText().toString();
        double inputAmount = Double.parseDouble(input);

        if (selected == null) {
            return;
        }

        if (selected.getId() == R.id.iv_USD) {
            double convertedAmount = inputAmount * 1.07;
            tv_calc.setText(String.format("%.2f",convertedAmount));
        } else if (selected.getId() == R.id.iv_SRF) {
            double convertedAmount = inputAmount * 0.98;
            tv_calc.setText(String.format("%.2f",convertedAmount));
        }

    }
}