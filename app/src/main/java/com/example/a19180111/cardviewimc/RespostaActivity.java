package com.example.a19180111.cardviewimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class RespostaActivity extends AppCompatActivity {

    private TextView txtSaidaImc;
    private TextView txtSaidaEstadoFisico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta);
    }

    @Override
    protected void onResume() {
        super.onResume();

        txtSaidaImc = findViewById(R.id.text_view_imc);
        txtSaidaEstadoFisico = findViewById(R.id.text_view_estado);

        Intent intent = getIntent();

        DecimalFormat df = new DecimalFormat("#0.00");

        String nome = intent.getStringExtra("nome");
        double imc = intent.getDoubleExtra("imc", 0);
        String estadoFisico = intent.getStringExtra("estadoFisico");

        txtSaidaImc.setText(df.format(imc).replace(".", ","));
        txtSaidaEstadoFisico.setText(nome + ", " + estadoFisico);
    }
}
