package com.example.itccafe;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {

    Button btnTambah, btnKurang, btnTambaharab, btnKurangarab, btnBeli, btnReset;
    TextView tvJumlahMaknan, tvJumlahMaknanarab, tvHarga, tvBayar;

    int jumlahHargaawal = 0;
    int JumlahHargaawaldua = 0;
    int totalharga = 0;
    final int HARGA_MAKANAWAL = 10000;
    final int HARGA_MAKANKEDUA = 50000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnTambah = findViewById(R.id.tambahmakan);
        btnKurang = findViewById(R.id.kurangmakanan);
        btnTambaharab = findViewById(R.id.tambahmakan1);
        btnKurangarab = findViewById(R.id.kurangmakanan1);
        btnBeli = findViewById(R.id.beli);
        btnReset = findViewById(R.id.reset);

        tvJumlahMaknan = findViewById(R.id.textplus);
        tvJumlahMaknanarab = findViewById(R.id.textplus1);
        tvHarga = findViewById(R.id.btn_buy);
        tvBayar = findViewById(R.id.btn_reset);

        btnTambah.setOnClickListener(this);
        btnKurang.setOnClickListener(this);
        btnTambaharab.setOnClickListener(this);
        btnKurangarab.setOnClickListener(this);
        btnBeli.setOnClickListener(this);
        btnReset.setOnClickListener(this);

        tvBayar.setText("");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tambahmakan:
                tambahPesanan(R.id.tambahmakan);
                break;
            case R.id.kurangmakanan:
                kurangPesanan(R.id.kurangmakanan);
                break;
            case R.id.tambahmakan1:
                tambahPesanan(R.id.tambahmakan1);
                break;
            case R.id.kurangmakanan1:
                kurangPesanan(R.id.kurangmakanan1);
                break;
            case R.id.beli:
                tvBayar.setText("Bayar");
                break;
            case R.id.reset:
                reset();
                break;
        }
    }

    void reset() {
        jumlahHargaawal = 0;
        JumlahHargaawaldua = 0;
        totalharga = 0;

        tvJumlahMaknan.setText("0");
        tvJumlahMaknanarab.setText("0");
        tvHarga.setText("0");
        tvBayar.setText("");

    }

    void tambahPesanan(int asal) {
        if (asal == R.id.tambahmakan) {
            if (jumlahHargaawal < 10) {
                jumlahHargaawal++;
                totalharga = totalharga + HARGA_MAKANAWAL;

                tvJumlahMaknan.setText("" + jumlahHargaawal);
                tvHarga.setText("Rp." + totalharga);
            }
        }
        if (asal == R.id.tambahmakan1) {
            if (JumlahHargaawaldua < 10) {
                JumlahHargaawaldua++;
                totalharga = totalharga + HARGA_MAKANKEDUA;

                tvJumlahMaknanarab.setText("" + JumlahHargaawaldua);
                tvHarga.setText("Rp." + totalharga);
            }
        }
    }

    void kurangPesanan(int asall) {
        if (asall == R.id.kurangmakanan) {
            if (jumlahHargaawal > 0) {
                jumlahHargaawal--;
                totalharga = totalharga - HARGA_MAKANAWAL;

                tvJumlahMaknan.setText("" + jumlahHargaawal);
                tvHarga.setText("Rp." + totalharga);
            }
        }
        if (asall == R.id.kurangmakanan1) {
            if (JumlahHargaawaldua > 0) {
                JumlahHargaawaldua--;
                totalharga = totalharga - HARGA_MAKANKEDUA;

                tvJumlahMaknanarab.setText("" + JumlahHargaawaldua);
                tvHarga.setText("Rp." + totalharga);
            }
        }
    }
}
