package com.example.androidclassatkhoapham;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView mTxtViewResult;
    Button mBtnRandom;
    EditText mEdtTextMin, mEdtTextMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        mBtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int min     = Integer.parseInt(mEdtTextMin.getText().toString());
                int max     = Integer.parseInt(mEdtTextMax.getText().toString());
                int random = new Random().nextInt(max - min) + min;
                mTxtViewResult.setText(random + "");
            }
        });

    }

    private void AnhXa(){
        mTxtViewResult   = findViewById(R.id.textViewResult);
        mEdtTextMin      = findViewById(R.id.editTextMin);
        mEdtTextMax      = findViewById(R.id.editTextMax);
        mBtnRandom       = findViewById(R.id.buttonRandom);
    }
}