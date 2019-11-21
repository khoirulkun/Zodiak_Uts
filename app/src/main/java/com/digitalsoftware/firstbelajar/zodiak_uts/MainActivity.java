package com.digitalsoftware.firstbelajar.zodiak_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText txt_tanggal,txt_name;
    Button btn_ramal;
    LinearLayout btn_tanggal;
    String var_tanggal,var_nama;
    Calendar c;
    DatePickerDialog dpd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_ramal = findViewById(R.id.btn_ramal);
        btn_tanggal = findViewById(R.id.btn_tanggal);
        txt_name = findViewById(R.id.txt_name);
        txt_tanggal = findViewById(R.id.txt_tanggal);

        btn_ramal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(txt_name.getText().toString().length()==0){
                    //jika form Email belum di isi / masih kosong
                    txt_name.setError("Nama Tidak Boleh Kosong");
                }else {
                    var_tanggal = txt_tanggal.getText().toString();
                    var_nama = txt_name.getText().toString();
                    Intent abc = new Intent(MainActivity.this,ZodiakActivity.class);
                    Bundle b = new Bundle();
                    b.putString("parse_tanggal", var_tanggal);
                    b.putString("parse_nama", var_nama);
                    abc.putExtras(b);
                    startActivity(abc);
                }
            }
        });

        btn_tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {
                        txt_tanggal.setText(mDay + "/" +(mMonth+1) + "/" + mYear);
                    }
                },day,month,year);
                dpd.show();
            }
        });

    }
}
