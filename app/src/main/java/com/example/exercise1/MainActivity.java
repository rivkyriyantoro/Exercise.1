package com.example.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    Button bLogin;
    EditText eEmail;
    EditText ePassword;
    TextInputLayout emailError;
    boolean checkmail;
    boolean checkpass;
    TextInputLayout passError;
    TextView tDaftar;

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.eEmail = (EditText) findViewById(R.id.inputEmail);
        this.ePassword = (EditText) findViewById(R.id.inputPW);
        this.tDaftar = (TextView) findViewById(R.id.registrasi);
        this.bLogin = (Button) findViewById(R.id.btSignin);
        this.emailError = (TextInputLayout) findViewById(R.id.WrongMail);
        this.passError = (TextInputLayout) findViewById(R.id.WrongPass);
        this.bLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                MainActivity.this.Validasi();
            }
        });
        this.tDaftar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this.getApplicationContext(), Registrasi.class));
            }
        });
    }

    public void Validasi() {
        if (this.eEmail.getText().toString().isEmpty()) {
            this.emailError.setError("Email Tidak Boleh Kosong");
            this.checkmail = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(this.eEmail.getText().toString()).matches()) {
            this.emailError.setError("Tolong Masukkan Email Dengan Benar");
            this.checkmail = false;
        } else {
            this.checkmail = true;
            this.emailError.setErrorEnabled(false);
        }
        if (this.ePassword.getText().toString().isEmpty()) {
            this.passError.setError("Password Tidak Boleh Kosong");
            this.checkpass = false;
        } else {
            this.checkpass = true;
            this.passError.setErrorEnabled(false);
        }
        if (!this.checkmail || !this.checkpass || !this.eEmail.getText().toString().equals("admin@mail.com") || !this.ePassword.getText().toString().equals("123456")) {
            Toast.makeText(getApplicationContext(), "Email Atau Password Salah", Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_LONG).show();
        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
    }
}