package com.example.sharangirdhani.inclass03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AvatarActivity extends AppCompatActivity {

//    public static String VALUE_KEY = null;
    Intent intent;

    ImageButton avatarSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);


    }

    public void buttonF1(View view) {
        intent = new Intent();
        int selected = R.drawable.avatar_f_1;
        MainActivity.VALUE_KEY = "f1";
        intent.putExtra(MainActivity.VALUE_KEY,selected);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void buttonF2(View view) {
        intent = new Intent();
        int selected = R.drawable.avatar_f_2;
        MainActivity.VALUE_KEY = "f2";

        intent.putExtra(MainActivity.VALUE_KEY,selected);
        setResult(RESULT_OK, intent);
        finish();

    }

    public void buttonF3(View view) {
        intent = new Intent();
        int selected = R.drawable.avatar_f_3;
        intent.putExtra(MainActivity.VALUE_KEY,selected);
        MainActivity.VALUE_KEY = "f3";

        setResult(RESULT_OK, intent);
        finish();

    }

    public void buttonM1(View view) {
        intent = new Intent();
        int selected = R.drawable.avatar_m_1;
        MainActivity.VALUE_KEY = "m1";
        intent.putExtra(MainActivity.VALUE_KEY,selected);
        setResult(RESULT_OK, intent);
        finish();

    }
    public void buttonM2(View view) {
        intent = new Intent();
        int selected = R.drawable.avatar_m_2;
        MainActivity.VALUE_KEY = "m2";
        intent.putExtra(MainActivity.VALUE_KEY,selected);
        setResult(RESULT_OK, intent);
        finish();

    }
    public void buttonM3(View view) {
        intent = new Intent();
        int selected = R.drawable.avatar_m_3;
        MainActivity.VALUE_KEY = "m3";
        intent.putExtra(MainActivity.VALUE_KEY,selected);
        setResult(RESULT_OK, intent);
        finish();

    }
}
