package com.welezohealth.welezo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUp_Activity extends AppCompatActivity {

    @BindView(R.id.signup_button)
    Button signupButton;
    @BindView(R.id.signin_btn)
    TextView signinBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_);
        ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
    }

    @OnClick({R.id.signup_button, R.id.signin_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.signup_button:

                startActivity(new Intent(this,OTP_Activity.class));
                break;
            case R.id.signin_btn:
                startActivity(new Intent(this,Sign_in_Activity.class));
                break;
        }
    }
}
