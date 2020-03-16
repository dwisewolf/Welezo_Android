package com.welezohealth.welezo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUp_Activity extends AppCompatActivity {

    @BindView(R.id.signup_button)
    Button signupButton;
    @BindView(R.id.signin_btn)
    TextView signinBtn;
    @BindView(R.id.email_id)
    TextInputEditText emailId;
    @BindView(R.id.phone_id)
    TextInputEditText phoneId;
    @BindView(R.id.username_id)
    TextInputEditText usernameId;
    @BindView(R.id.password_id)
    TextInputEditText passwordId;

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
               // startActivity(new Intent(this, OTP_Activity.class));

                break;
            case R.id.signin_btn:
                startActivity(new Intent(this, Sign_in_Activity.class));
                break;
        }
    }

}
