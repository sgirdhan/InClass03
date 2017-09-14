package com.example.sharangirdhani.inclass03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    public static final int REQ_CODE = 100;
    public static String VALUE_KEY = null;
    TextView txtName, txtEmail, txtDepartment, txtMood;
    Profile profile;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        if (getIntent().getExtras() != null) {
            profile = getIntent().getExtras().getParcelable(MainActivity.PROFILE_KEY);
            setName(profile.name);
            setDepartment(profile.department);
            setEmail(profile.email);
            setMood(profile.mood);

            setImage(profile.image);
        }
    }

    public void setName(String name) {
        txtName = (TextView) findViewById(R.id.textViewNameDisplay);
        txtName.setText(name);
    }

    public void setImage(String image) {
        ImageView img = (ImageView) findViewById(R.id.imageViewDisplay);

        switch(image){
            case "avatar_f_1":
                img.setImageResource(R.drawable.avatar_f_1);
                break;
            case "avatar_f_2":
                img.setImageResource(R.drawable.avatar_f_2);
                break;
            case "avatar_f_3":
                img.setImageResource(R.drawable.avatar_f_3);
                break;
            case "avatar_m_1":
                img.setImageResource(R.drawable.avatar_m_1);
                break;
            case "avatar_m_2":
                img.setImageResource(R.drawable.avatar_m_2);
                break;
            case "avatar_m_3":
                img.setImageResource(R.drawable.avatar_m_3);
                break;
        }
    }

    public void setDepartment(String department) {
        txtDepartment = (TextView) findViewById(R.id.textViewDepartmentDisplay);
        txtDepartment.setText(department);
    }

    public void setMood(String mood) {
        ImageView img = (ImageView) findViewById(R.id.imageViewEmojiDisplay);

        txtMood = (TextView) findViewById(R.id.textViewMoodDisplay);
        txtMood.setText("I am " + mood + "!");

        switch(mood){
            case "Happy":
                img.setImageResource(R.drawable.happy);
                break;
            case "Awesome":
                img.setImageResource(R.drawable.awesome);
                break;
            case "Angry":
                img.setImageResource(R.drawable.angry);
                break;
            case "Sad":
                img.setImageResource(R.drawable.sad);
                break;

        }
    }

    public void setEmail(String email) {
        txtEmail = (TextView) findViewById(R.id.textViewEmailDisplay);
        txtEmail.setText(email);
    }
}
