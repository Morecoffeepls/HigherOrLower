package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.NetworkErrorException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNum;

    public void generateRandomNumber(){
        Random random = new Random();
        randomNum = random.nextInt(20)+1;
    }

    public void guess (View view){

        Log.i("Random number: ", Integer.toString(randomNum));

        //Log.i("Entered Value: ", editText.getText().toString());

        EditText editText = (EditText) findViewById(R.id.enterNumber);

        int guessValue = Integer.parseInt(editText.getText().toString());

        String message;

        if(guessValue > randomNum){
            message = "Lower";
        }
        else if (guessValue < randomNum){
            message = "Higher";
        }
        else {
            message = "You got it!";

            generateRandomNumber();
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateRandomNumber();

    }
}