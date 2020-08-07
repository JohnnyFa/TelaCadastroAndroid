package com.fagunds.cadastrodeclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class cadastro extends AppCompatActivity {
    private static final String TAG = "cadastro";
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    DataBase mDataBase;
    private TextView mDisplayDate;
    private TextView tvNome, tvEmail, tvPassword, tvCidade, tvObservacao;
    private Spinner tvUF;
    private Button buttonCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        mDisplayDate = findViewById(R.id.tv_date);

        mDataBase = new DataBase(this);

        tvNome = findViewById(R.id.text_nome);
        tvEmail = findViewById(R.id.text_email);
        tvPassword = findViewById(R.id.text_password);
        tvCidade = findViewById(R.id.text_cidade);
        tvUF = findViewById(R.id.sp_states);

        buttonCadastrar = findViewById(R.id.button_cadastrar);

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName = tvNome.getText().toString();
                String newEmail = tvEmail.getText().toString();
                String newPassword = tvPassword.getText().toString();
                String newCidade = tvCidade.getText().toString();
                if (tvNome.length() != 0) {
                    addName(newName);

                } else {
                    toastMessage("Preencha os campos");
                }
            }
        });


        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(cadastro.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: Date:" + day + "/" + month + "/" + year);

                String mDate = day + "/" + month + "/" + year;
                mDisplayDate.setText(mDate);
            }
        };

    }

    public void addName(String newName) {
        boolean nameData = mDataBase.addData(newName);

        if (nameData) {
            toastMessage("Data Succesfully Inserted");
        } else {
            toastMessage("Something went wrong!");
        }
    }


    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}