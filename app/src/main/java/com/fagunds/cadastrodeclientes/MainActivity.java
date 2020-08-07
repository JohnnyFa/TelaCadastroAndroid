package com.fagunds.cadastrodeclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.buttonCadastrar = findViewById(R.id.button_cadastro);
        this.mViewHolder.buttonListar = findViewById(R.id.button_list);

        this.mViewHolder.buttonCadastrar.setOnClickListener(this);
        this.mViewHolder.buttonListar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_cadastro) {
            Intent telaCadastro = new Intent(this, cadastro.class);
            startActivity(telaCadastro);
        } else if (view.getId() == R.id.button_list) {
            Intent telaListar = new Intent(this, listar.class);
            startActivity(telaListar);
        }
    }

    private static class ViewHolder {
        Button buttonListar;
        Button buttonCadastrar;
    }
}