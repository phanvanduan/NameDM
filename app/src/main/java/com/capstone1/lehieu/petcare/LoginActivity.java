package com.capstone1.lehieu.petcare;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import java.util.Objects;


public class LoginActivity extends AppCompatActivity {
    Button btnLoginFacebook;
    AnimationDrawable animationDrawable;
    ConstraintLayout mainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        onClick();
        backgroundColor();
    }

    private void init() {
        btnLoginFacebook = findViewById(R.id.btnLoginFacebook);
    }

    private void onClick() {
      btnLoginFacebook.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(LoginActivity.this, MainActivity.class);
              startActivity(intent);
              finish();
          }
      });
    }

    private void backgroundColor(){
        mainLayout = findViewById(R.id.mainLayout);
        animationDrawable = (AnimationDrawable)mainLayout.getBackground();
        //add time change
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(2000);
        //and start the animation Now
        animationDrawable.start();
    }
}
