package com.example.waherungsrechner_mobsys;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Toast;

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
        } else if (selected.getId() == R.id.iv_DKK) {
            tv_result.setText("Daenische Krone");
        } else if (selected.getId() == R.id.iv_GBP) {
            tv_result.setText("Pfund");
        } else if (selected.getId() == R.id.iv_YEN) {
            tv_result.setText("Yen");
        } else if (selected.getId() == R.id.iv_HRK) {
            tv_result.setText("Kuna");
        }
    }

    public void calc(View v) {
        tv_input = findViewById(R.id.tv_input);
        tv_calc = findViewById(R.id.tv_calc);
        String input = tv_input.getText().toString();
        if (selected == null || input.isEmpty()) {
            Toast.makeText(MainActivity.this, "Bitte Flagge auswählen und Betrag eingeben", Toast.LENGTH_SHORT).show();
        }
        else{
            double inputAmount = Double.parseDouble(input);
            if (selected.getId() == R.id.iv_USD) {
                double convertedAmount = inputAmount * 1.07;
                tv_calc.setText(String.format("%.2f",convertedAmount));
            } else if (selected.getId() == R.id.iv_SRF) {
                double convertedAmount = inputAmount * 0.98;
                tv_calc.setText(String.format("%.2f", convertedAmount));
            } else if (selected.getId() == R.id.iv_DKK) {
                double convertedAmount = inputAmount * 7.46;
                tv_calc.setText(String.format("%.2f",convertedAmount));
            } else if (selected.getId() == R.id.iv_GBP) {
                double convertedAmount = inputAmount * 0.86;
                tv_calc.setText(String.format("%.2f", convertedAmount));
            } else if (selected.getId() == R.id.iv_YEN) {
                double convertedAmount = inputAmount * 164.61;
                tv_calc.setText(String.format("%.2f",convertedAmount));
            } else if (selected.getId() == R.id.iv_HRK) {
                double convertedAmount = inputAmount * 7.53;
                tv_calc.setText(String.format("%.2f",convertedAmount));
            }
        }



    }
}