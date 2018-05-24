package com.goldenesystem.appsi;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Tela confirmação será utilizada pelo usuario para confirmação dos dados incluidos na tela de cadastro
 * Caso clique em editar dados o sistema irá retornar a tela de cadastro para edição das informações.
 * Caso clique em confirmar o aplicativo irá retornar a tela de cadasto limpando os campos e exibindo a mensagem de sucesso.
 */

public class TelaConfirmacao extends AppCompatActivity {

    Button btnAlterar, btnConfirmar;
    TextView txtNome, txtIdade, txtEndereco, txtCidade, txtEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_confirmacao);
        Log.d("Tela Confirmacao", "onCreate");
        setTitle(R.string.telaConfirma);

        txtNome = findViewById(R.id.txtNome) ;
        txtIdade = findViewById(R.id.txtIdade);
        txtEndereco = findViewById(R.id.txtEndereco);
        txtCidade = findViewById(R.id.txtCidade);
        txtEstado = findViewById(R.id.txtEstado);

        btnAlterar = findViewById(R.id.btnAltera);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        Intent intent = getIntent();
        String nome, idade, endereco, cidade, estado;

        nome = intent.getStringExtra("nome");
        idade = intent.getStringExtra("idade");
        endereco = intent.getStringExtra("endereco");
        cidade = intent.getStringExtra("cidade");
        estado = intent.getStringExtra("estado");

        txtNome.setText(getString(R.string.lblName )+" "+ nome);
        txtIdade.setText(getString(R.string.lblAge) +" "+ idade);
        txtEndereco.setText(getString(R.string.lblAddress) +" "+ endereco);
        txtCidade.setText(getString(R.string.lblCity) +" "+ cidade);
        txtEstado.setText(getString(R.string.lblState) +" "+ estado);

        btnAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("salvar","OK");
                setResult(TelaConfirmacao.RESULT_OK,returnIntent);
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        Log.d("Tela Confirmacao", "onPause");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d("Tela Confirmacao", "onCreate");
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        Log.d("Tela Confirmacao", "onBackPressed");
    }
}

