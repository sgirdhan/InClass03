package com.example.sharangirdhani.inclass03;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import com.example.sharangirdhani.inclass03.databinding.ActivityMainBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {

    Profile prf;
    ImageView imgAvatar ;

    public static final int REQ_CODE = 100;
    public static String VALUE_KEY = null;
    private ActivityMainBinding binding;

    String[] mood = {"Awesome", "Happy", "Sad", "Angry"};
    final static String PROFILE_KEY = "PROFILE";
    EditText txtViewN, txtViewE;
    SeekBar seekB;
    String prog;
    RadioGroup rg;
    RadioButton rb;
    int selected = 0;
    String cat;
    String image;
    ImageView avatar;
    ImageView emoji;
    int progInt=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        final String[] mood = {"Angry", "Sad", "Happy", "Awesome"};
        progInt=2;
        cat = "SIS";
        prog = "Happy";
        binding.seekBarMood.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progInt = progress;
                switch (progress) {
                    case 0:
                        prog = "Angry";
                        binding.imageViewEmoji.setImageResource(R.drawable.angry);
                        break;
                    case 1:
                        prog = "Sad";
                        binding.imageViewEmoji.setImageResource(R.drawable.sad);
                        break;
                    case 2:
                        prog = "Happy";
                        binding.imageViewEmoji.setImageResource(R.drawable.happy);
                        break;
                    case 3:
                        prog = "Awesome";
                        binding.imageViewEmoji.setImageResource(R.drawable.awesome);
                        break;
                }
                binding.textViewCurrentMood.setText(prog);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        rg = (RadioGroup) findViewById(R.id.radioGroupDepartment);
        rb = (RadioButton) rg.findViewById(rg.getCheckedRadioButtonId());

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // This will get the radiobutton that has changed in its check state
                RadioButton checkedRadioButton = (RadioButton) group.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();
                // If the radiobutton that has changed in check state is now checked...
                if (isChecked) {
                    // Changes the textview's text to "Checked: example radiobutton text"
                    cat = checkedRadioButton.getText().toString();
                }
            }
        });



        avatar = (ImageView) findViewById(R.id.imageView);


        findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                txtViewN = (EditText) findViewById(R.id.editTextName);
                txtViewE = (EditText) findViewById(R.id.editTextEmail);
                String name = txtViewN.getText().toString();
                String email = txtViewE.getText().toString();



                if(!isEmailValid(email)) {
                    makeText(getApplicationContext(), R.string.emailInvalidError,
                            LENGTH_SHORT).show();
                }
                else if(name == null || name.equals("") || email == null || email.equals("") || cat == null || prog == null || image == null || image.equals("")) {
                    makeText(getApplicationContext(), "Please fill all the inputs",
                            LENGTH_SHORT).show();
                }
                else {

                    Log.d("demo", image );
                    Log.d("demo", mood[progInt]);
                    Profile profile = new Profile(name, cat, email, mood[progInt], image    );
                    intent.putExtra(PROFILE_KEY, profile);
                    startActivity(intent);
                }
            }
        });


//        @Override
//        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//            if (requestCode == REQ_CODE) {
//                if (resultCode == RESULT_OK) {
//                    String returnedVal = data.getExtras().getString(VALUE_KEY);
//                    switch (VALUE_KEY) {
//                        case "editName":
//                            setName(returnedVal);
//                            break;
//                        case "editEmail":
//                            setEmail(returnedVal);
//                            break;
//                        case "editDep":
//                            setDepartment(returnedVal);
//                            break;
//                        case "editMood":
//                            setMood(returnedVal);
//                            break;
//                    }
//                }
//            }
//        }
    }

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void avatarClick(View view) {
        Intent intent = new Intent(MainActivity.this, AvatarActivity.class);
        startActivityForResult(intent, REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQ_CODE) {
            if (resultCode == RESULT_OK) {

                String returnedVal = data.getExtras().getString(VALUE_KEY);
                switch (VALUE_KEY) {
                    case "f1":
                        image = "avatar_f_1";
                        binding.imageView.setImageResource(R.drawable.avatar_f_1);
                        break;
                    case "f2":
                        image = "avatar_f_2";
                        binding.imageView.setImageResource(R.drawable.avatar_f_2);

                        break;
                    case "f3":
                        image = "avatar_f_3";
                        binding.imageView.setImageResource(R.drawable.avatar_f_3);

                        break;
                    case "m1":
                        image = "avatar_m_1";
                        binding.imageView.setImageResource(R.drawable.avatar_m_1);

                        break;
                    case "m2":
                        image = "avatar_m_2";
                        binding.imageView.setImageResource(R.drawable.avatar_m_2);

                        break;
                    case "m3":
                        image = "avatar_m_3";
                        binding.imageView.setImageResource(R.drawable.avatar_m_3);

                        break;


                }
            }
        }
    }
}
