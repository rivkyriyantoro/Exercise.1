package com.example.exercise1;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LihatData extends AppCompatActivity {
    static  TextView tvnama;
    static  TextView tvnomor;
    String nama;
    public static String nomor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihatdata);

        Bundle b = getIntent().getExtras();
        nama = b.getString("a");

        tvnama = (TextView) findViewById(R.id.tvNamaKontak);
        tvnomor = (TextView) findViewById(R.id.tvNomorTelepon);

        switch (nama)
        {
            case "Hakeem":
                tvnama.setText("Hakeem Gufran");
                tvnomor.setText("08222292992");
                nomor = tvnomor.getText().toString();
                break;
            case "Pangayom":
                tvnama.setText("R Pangayom");
                tvnomor.setText("0856632718763" +
                        "");
                nomor = tvnomor.getText().toString();
                break;
            case "Vicky":
                tvnama.setText(" Vicky R");
                tvnomor.setText("0812213344773");
                nomor = tvnomor.getText().toString();
                break;
            case "Bagus":
                tvnama.setText("Bagus R");
                tvnomor.setText("0812333311212");
                nomor = tvnomor.getText().toString();
                break;
            case "Yoga":
                tvnama.setText("Yoga P");
                tvnomor.setText("087424256677");
                nomor = tvnomor.getText().toString();
                break;
            case "Toni":
                tvnama.setText("Taufik Fatoni");
                tvnomor.setText("08222222121");
                nomor = tvnomor.getText().toString();
                break;
            case "Fuad":
                tvnama.setText("Fuad R");
                tvnomor.setText("089912212121");
                nomor = tvnomor.getText().toString();
                break;
        }
    }
}