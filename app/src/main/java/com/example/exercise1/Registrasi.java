package com.example.exercise1;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;

public class Registrasi extends AppCompatActivity {
    String agama = "";
    Button cancel;
    Button reg;
    private int cr;
    private int cgend;
    EditText regemail,regnama,regpass,regrepass,regalamat;
    private boolean isChecking = true;
    boolean cmail = false;
    boolean cpass = false;
    boolean crpass = false;
    boolean calamat = false;
    boolean cnama = false;
    String jk = "";
    TextInputLayout wrongalamat,wrongmailerror,wrongnameerr,wongpasserror,wongrepasserror;
    RadioGroup r1, r2, r3;
    RadioButton budha, hindu, islam, katolik, other, konghucu, kristen;
    RadioGroup gendergp;
    RadioButton l, p;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regestrasi);
        MenghubungkanKomponen();
        this.r1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != -1 && Registrasi.this.isChecking) {
                    Registrasi.this.isChecking = false;
                    Registrasi.this.r2.clearCheck();
                    Registrasi.this.r3.clearCheck();
                    Registrasi.this.cr = i;
                }
                Registrasi.this.isChecking = true;
            }
        });
        this.r2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != -1 && Registrasi.this.isChecking) {
                    Registrasi.this.isChecking = false;
                    Registrasi.this.r1.clearCheck();
                    Registrasi.this.r3.clearCheck();
                    Registrasi.this.cr = i;
                }
                Registrasi.this.isChecking = true;
            }
        });
        this.r3
                .setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        if (i != -1 && Registrasi.this.isChecking) {
                            Registrasi.this.isChecking = false;
                            Registrasi.this.r2.clearCheck();
                            Registrasi.this.r1.clearCheck();
                            Registrasi.this.cr = i;
                        }
                        Registrasi.this.isChecking = true;
                    }
                });
        this.gendergp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != -1 && Registrasi.this.isChecking) {
                    Registrasi.this.isChecking = false;
                    Registrasi.this.cgend = i;
                }
                Registrasi.this.isChecking = true;
            }
        });
        this.reg.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Registrasi.this.JenisAgama(view);
                Registrasi.this.JenisKelamin(view);
                Registrasi.this.validasi(view);
            }
        });
        this.cancel.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Registrasi.this.startActivity(new Intent(Registrasi.this.getApplicationContext(), MainActivity.class));
            }
        });
    }

    public void MenghubungkanKomponen() {
        regnama = (EditText) findViewById(R.id.regnama);
        this.regalamat = (EditText) findViewById(R.id.regalamat);
        this.regemail = (EditText) findViewById(R.id.regmail);
        this.regpass = (EditText) findViewById(R.id.regpass);
        this.regrepass = (EditText) findViewById(R.id.regrepass);
        this.gendergp = (RadioGroup) findViewById(R.id.reggender);
        this.r1 = (RadioGroup) findViewById(R.id.agama1);
        this.r2 = (RadioGroup) findViewById(R.id.agama2);
        this.r3 = (RadioGroup) findViewById(R.id.agama3);
        this.l = (RadioButton) findViewById(R.id.regl);
        this.p = (RadioButton) findViewById(R.id.regp);
        this.islam = (RadioButton) findViewById(R.id.islam);
        this.katolik = (RadioButton) findViewById(R.id.katolik);
        this.kristen = (RadioButton) findViewById(R.id.kristen);
        this.konghucu = (RadioButton) findViewById(R.id.konghucu);
        this.hindu = (RadioButton) findViewById(R.id.hindu);
        this.budha = (RadioButton) findViewById(R.id.budha);
        this.other = (RadioButton) findViewById(R.id.other);
        this.wrongnameerr = (TextInputLayout) findViewById(R.id.namaeror);
        this.wrongalamat = (TextInputLayout) findViewById(R.id.alamateror);
        this.wrongmailerror = (TextInputLayout) findViewById(R.id.ermail);
        this.wongpasserror = (TextInputLayout) findViewById(R.id.erpass);
        this.wongrepasserror = (TextInputLayout) findViewById(R.id.repasserror);
        this.cancel = (Button) findViewById(R.id.cancel);
        this.reg = (Button) findViewById(R.id.reg);
    }

    public void JenisAgama(View view) {
        int i = this.cr;
        if (i == R.id.islam) {
            this.agama = "Islam";
        } else if (i == R.id.katolik) {
            this.agama = "Katolik";
        } else if (i == R.id.kristen) {
            this.agama = "Kristen";
        } else if (i == R.id.konghucu) {
            this.agama = "Konghucu";
        } else if (i == R.id.hindu) {
            this.agama = "Hindu";
        } else if (i == R.id.budha) {
            this.agama = "Budha";
        } else if (i == R.id.other) {
            this.agama = "Aliran Kepercayaan";
        }
    }

    public void JenisKelamin(View view) {
        int i = this.cgend;
        if (i == R.id.regl) {
            this.jk = "Laki-Laki";
        } else if (i == R.id.regp) {
            this.jk = "Perempuan";
        }
    }

    public void validasi(View view) {
        if (this.regnama.getText().toString().isEmpty() || this.regalamat.getText().toString().isEmpty() || this.regemail.getText().toString().isEmpty() || this.regpass.getText().toString().isEmpty() || this.regrepass.getText().toString().isEmpty() || this.agama.isEmpty() || this.jk.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Data Harus DiIsi Semua", Toast.LENGTH_LONG).show();
        }
        if (this.regnama.getText().toString().isEmpty()) {
            this.wrongnameerr.setError("Nama Tidak Boleh Kosong");
            this.cnama = false;
        } else {
            this.wrongnameerr.setErrorEnabled(false);
            this.cnama = true;
        }
        if (this.regalamat.getText().toString().isEmpty()) {
            this.wrongalamat.setError("Alamat Tidak Boleh Kosong");
            this.calamat = false;
        } else {
            this.wrongalamat.setErrorEnabled(false);
            this.calamat = true;
        }
        if (this.regemail.getText().toString().isEmpty()) {
            this.wrongmailerror.setError("Email Tidak Boleh Kosong");
            this.cmail = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(this.regemail.getText().toString()).matches()) {
            this.wrongmailerror.setError("Please Enter Email Correctly");
            this.cmail = false;
        } else {
            this.cmail = true;
            this.wrongmailerror.setErrorEnabled(false);
        }
        if (this.regpass.getText().toString().isEmpty()) {
            this.wongpasserror.setError("Password Tidak Boleh Kosong");
            this.cpass = false;
        } else if (this.regpass.getText().length() < 6) {
            this.wongpasserror.setError("Password Minimal 6 Karakter");
            this.cpass = false;
        } else {
            this.cpass = true;
            this.wongpasserror.setErrorEnabled(false);
        }
        if (this.regrepass.getText().toString().isEmpty()) {
            this.wongrepasserror.setError("Re-Password Tidak Boleh Kosong");
            this.crpass = false;
        } else if (this.regrepass.getText().length() < 6) {
            this.wongrepasserror.setError("Re-Password Minimal 6 Karakter");
            this.crpass = false;
        } else if (!this.regrepass.getText().toString().equals(this.regpass.getText().toString())) {
            this.wongrepasserror.setError("Password Tidak Sama");
            this.crpass = false;
        } else {
            this.crpass = true;
            this.wongrepasserror.setErrorEnabled(false);
        }
        if (this.cnama && this.calamat && this.cmail && this.cpass && this.crpass && !this.agama.isEmpty() && !this.jk.isEmpty()) {
            Toast.makeText(getApplicationContext(), " Registrasi Berhasil", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    }
}