package com.welezohealth.welezo;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewPassword_Activity extends AppCompatActivity {

    @BindView(R.id.sign_inHead)
    TextView NewPassHead;
    @BindView(R.id.oldpassword_id)
    TextInputEditText oldpasswordId;
    @BindView(R.id.newpassword_id)
    TextInputEditText newpasswordId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password_);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        Typeface roboto = Typeface.createFromAsset(this.getAssets(),
                "font/Roboto-Regular.ttf"); //use this.getAssets if you are calling from an Activity
        NewPassHead.setTypeface(roboto);
    }
}
