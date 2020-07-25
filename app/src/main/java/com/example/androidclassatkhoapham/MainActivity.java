package com.example.androidclassatkhoapham;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView mTxtViewResult;
    Button mBtnRandom, mBtnPlayAgain;
    EditText mEdtTextMin, mEdtTextMax;
    int mIndexRandom;
    int mMin, mMax = 0;
    Random mRandom;
    ArrayList<Integer> mArrayList;
    Boolean mGameStatus = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        OnClick();
    }

    private void OnClick(){

        mBtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mEdtTextMax.getText().toString().length() <= 0 || mEdtTextMin.getText().toString().length() <= 0) {
                    Toast.makeText(MainActivity.this, "Min or Max can not be empty", Toast.LENGTH_LONG).show();
                    return;
                }

                mMin = Integer.parseInt(mEdtTextMin.getText().toString());
                mMax = Integer.parseInt(mEdtTextMax.getText().toString());

                if(mMin >= mMax){
                    mMax = mMin + 1;
                    mEdtTextMax.setText(mMax + "");
                }
                if(mGameStatus == false){
                    for(int i = mMin; i <= mMax;i ++){
                        Integer integer = Integer.valueOf(i);
                        mArrayList.add(integer);
                    }
                    mEdtTextMin.setEnabled(false);
                    mEdtTextMax.setEnabled(false);
                    mGameStatus = true;
                    mIndexRandom = mRandom.nextInt(mArrayList.size() - 1);
                    mTxtViewResult.append( mArrayList.get(mIndexRandom) + "");
                    mArrayList.remove(mIndexRandom);
                    Log.e("Array List Size" , mArrayList.size() + "");
                    return;
                }
                if(mArrayList.size() == 0){
                    Toast.makeText(MainActivity.this ,
                            "You have finished the game. Click Restart to play again!"
                            , Toast.LENGTH_LONG).show();
                    return;
                }
                mIndexRandom = mRandom.nextInt(mArrayList.size()) - 1;
                if(mIndexRandom == -1){
                    mIndexRandom = 0;
                }
                mTxtViewResult.append(" - " + mArrayList.get(mIndexRandom)  );
                mArrayList.remove(mIndexRandom);
                Log.e("Error" , mArrayList.size() + "");
//                mValue[mPosition] = random;
//                mPosition++;
            }
        });

        mBtnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEdtTextMin.setText("");
                mEdtTextMin.setEnabled(true);
                mEdtTextMax.setText("");
                mEdtTextMax.setEnabled(true);
                mGameStatus = false;
                mTxtViewResult.setText("");
                mMin = 0;
                mMax = 0;
                mArrayList.clear();
                Toast.makeText(MainActivity.this , "Please insert Min and Max!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void AnhXa() {
        mArrayList = new ArrayList<>();
        mRandom = new Random();
        mTxtViewResult   = findViewById(R.id.textViewResult);
        mEdtTextMin      = findViewById(R.id.editTextMin);
        mEdtTextMax      = findViewById(R.id.editTextMax);
        mBtnRandom       = findViewById(R.id.buttonRandom);
        mBtnPlayAgain    = findViewById(R.id.buttonPlayAgain);
    }
}