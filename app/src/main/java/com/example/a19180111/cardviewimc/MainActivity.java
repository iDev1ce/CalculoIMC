package com.example.a19180111.cardviewimc;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnCalcular;
    private TextInputLayout txtLayoutNome;
    private TextView txtNome;
    private TextInputLayout txtLayoutPeso;
    private TextView txtPeso;
    private TextInputLayout txtLayoutAltura;
    private TextView txtAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = findViewById(R.id.button_calcular);
        txtLayoutNome = findViewById(R.id.text_input_nome);
        txtNome = findViewById(R.id.text_nome);
        txtLayoutPeso = findViewById(R.id.text_input_peso);
        txtPeso = findViewById(R.id.text_peso);
        txtLayoutAltura = findViewById(R.id.text_input_altura);
        txtAltura = findViewById(R.id.text_altura);

        btnCalcular.setOnClickListener(new View.OnClickListener() {

            protected boolean isNumeric(String txt) {
                try {
                    double test = Double.parseDouble(txt);
                } catch (Exception e) {
                    return false;
                }
                return true;
            }

            @Override
            public void onClick(View view) {

                String nome = txtNome.getText().toString().trim();
                double peso = Double.parseDouble(txtPeso.getText().toString().trim());
                double altura = Double.parseDouble(txtAltura.getText().toString().trim());

                if (Double.toString(peso).isEmpty()) {
                    txtLayoutPeso.setErrorEnabled(true);
                    txtLayoutPeso.setError("Peso obrigatório");
                }

                if (Double.toString(altura).isEmpty()) {
                    txtLayoutAltura.setErrorEnabled(true);
                    txtLayoutAltura.setError("Altura obrigatória");
                }

                if (!isNumeric(Double.toString(peso))) {
                    txtLayoutPeso.setErrorEnabled(true);
                    txtLayoutPeso.setError("Somente números são aceitos");
                }

                if (!isNumeric(Double.toString(altura))) {
                    txtLayoutAltura.setErrorEnabled(true);
                    txtLayoutAltura.setError("Somente números são aceitos");
                }


                double imc = peso / (altura * altura);
                String estadoFisico = "";

                if (imc >= 40)
                    estadoFisico = "Obesidade III (Mórbida)";
                else if (imc >= 35)
                    estadoFisico = "Obesidade II (Severa)";
                else if (imc >= 30)
                    estadoFisico = "Obesidade I";
                else if (imc >= 25)
                    estadoFisico = "Acima do Peso";
                else if (imc >= 18.5)
                    estadoFisico = "Peso Normal";
                else if (imc >= 17)
                    estadoFisico = "Abaixo do Peso";
                else
                    estadoFisico = "Muito Abaixo do Peso";

                Intent abrirActivityResposta = new Intent(MainActivity.this, RespostaActivity.class);
                abrirActivityResposta.putExtra("imc", imc);
                abrirActivityResposta.putExtra("estadoFisico", estadoFisico);
                abrirActivityResposta.putExtra("nome", nome);
                startActivity(abrirActivityResposta);
            }
        });

        txtLayoutNome = findViewById(R.id.text_input_nome);

    }
}
