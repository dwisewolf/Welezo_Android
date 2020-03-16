package com.welezohealth.welezo;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Sign_in_Activity extends AppCompatActivity {

    @BindView(R.id.sign_inHead)
    TextView signInHead;
    @BindView(R.id.password_id)
    TextInputEditText passwordId;
    @BindView(R.id.username_id)
    TextInputEditText usernameId;
    @BindView(R.id.signin_id)
    Button signinId;
    @BindView(R.id.forgot_id)
    TextView forgotId;
    @BindView(R.id.sUP_id)
    TextView sUPId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_);
        ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        Typeface roboto = Typeface.createFromAsset(this.getAssets(),
                "font/Roboto-Regular.ttf"); //use this.getAssets if you are calling from an Activity
        signInHead.setTypeface(roboto);
        usernameId.setTypeface(roboto);
        passwordId.setTypeface(roboto);
    }

    @OnClick({R.id.signin_id, R.id.forgot_id, R.id.sUP_id})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.signin_id:
                startActivity(new Intent(this,Sign_in_Activity.class));
                break;
            case R.id.forgot_id:
                startActivity(new Intent(this,ForgotPassword_Activity.class));
                break;
            case R.id.sUP_id:
                startActivity(new Intent(this,SignUp_Activity.class));
                break;
        }
    }
}
