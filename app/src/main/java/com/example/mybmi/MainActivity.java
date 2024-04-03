package com.example.mybmi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private TextView show;

    private RadioGroup rgSex;
    private RadioButton rbMale;
    private RadioButton rbFemale;

    private CheckBox appple;
    private CheckBox banana;
    private CheckBox orange;


    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

        rgSex.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbMale) {
                show.setText("我是男生");
            } else if (checkedId == R.id.rbFemale) {
                show.setText("我是女生");
            }
        });

        appple.setOnCheckedChangeListener((buttonView, isChecked) -> getFruits());
        banana.setOnCheckedChangeListener((buttonView, isChecked) -> getFruits());
        orange.setOnCheckedChangeListener((buttonView, isChecked) -> getFruits());
    }

    private void getFruits() {
        String msg = "";
        if (appple.isChecked()) {
            msg += "蘋果";
        }
        if (banana.isChecked()) {
            msg += "香蕉";
        }
        if (orange.isChecked()) {
            msg += "橘子";
        }
        show.setText("我喜歡吃" + msg);
    }


    public void calcBMI(View view) {

        double bmi = getBmi();

        String result = getString(R.string.strShowbmi) + bmi;

       show.setText(result);

    }

    private double getBmi() {
        DecimalFormat df = new DecimalFormat("#.00");
        double h = Double.parseDouble(height.getText().toString());
        double w = Double.parseDouble(weight.getText().toString());
        double bmi = w / (h/100.0  * h /100.0);
        bmi = Double.parseDouble(df.format(bmi));
        return bmi;
    }

    private void findViews() {
        height = findViewById(R.id.etHeight);
        weight = findViewById(R.id.edWeight);
        show = findViewById(R.id.tvShow);
        rgSex = findViewById(R.id.rgSex);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        appple = findViewById(R.id.cbApple);
        banana = findViewById(R.id.cbBanana);
        orange = findViewById(R.id.cbOrange);
    }

    public void GoNext(View view) {
    Intent intent = new Intent(this, ResultActivity.class);
    double bmi = getBmi();
    intent.putExtra("bmi", bmi);
    startActivity(intent);
}
}