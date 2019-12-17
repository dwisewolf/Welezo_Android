package com.welezohealth.welezo;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Sign_in_Activity extends AppCompatActivity {

    @BindView(R.id.sign_inHead)
    TextView signInHead;
    @BindView(R.id.password_id)
    TextInputEditText passwordId;
    @BindView(R.id.username_id)
    TextInputEditText usernameId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_);
        ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Typeface roboto = Typeface.createFromAsset(this.getAssets(),
                "font/Roboto-Regular.ttf"); //use this.getAssets if you are calling from an Activity
        signInHead.setTypeface(roboto);
        usernameId.setTypeface(roboto);
        passwordId.setTypeface(roboto);



    }
}
