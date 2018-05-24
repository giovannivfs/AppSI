package com.goldenesystem.appsi;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Activity;
//import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.CaptureActivity;

import org.w3c.dom.Text;

import java.util.concurrent.Delayed;

/**
 * Tela de cadastro, é a tela principal do sistema onde será realizado o cadastro.
 * edtNome, edtIdade, edtEndereco, edtCidade, edtEstado serão os compos de entrada de dados;
 * btnScan serve para que seja preenchido os campos de entrada de dados via leitura de QRCode ou Codigo de barras;
 * btnGravar enviara os dados para a tela de confirmação via putExtra;
 */

public class MainActivity extends AppCompatActivity {

    public Button btnGravar;
    public ImageButton btnScanNome, btnScanIdade, btnScanEndereco, btnScanCidade, btnScanEstado;


    public TextView txtNome, txtIdade, txtEndereco, txtCidade, txtEstado;
    public EditText edtNome, edtIdade, edtEndereco, edtCidade, edtEstado;

    public int idScan;

    final Activity activity  = this;
    final int TELACONFIRMACAO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.d("Tela Cadastro", "onCreate");

        setTitle(R.string.telaCadastro);

        btnGravar = (Button) findViewById(R.id.btnGravar);
        btnScanNome = (ImageButton) findViewById(R.id.btnScanNome);
        btnScanIdade = (ImageButton) findViewById(R.id.btnScanIdade);
        btnScanEndereco = (ImageButton) findViewById(R.id.btnScanEndereco);
        btnScanCidade = (ImageButton) findViewById(R.id.btnScanCidade);
        btnScanEstado = (ImageButton) findViewById(R.id.btnScanEstado);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtIdade = (EditText) findViewById(R.id.edtIdade);
        edtEndereco = (EditText) findViewById(R.id.edtEndereco);
        edtCidade = (EditText) findViewById(R.id.edtCidade);
        edtEstado = (EditText) findViewById(R.id.edtEstado);

        txtNome = (TextView) findViewById(R.id.edtNome);
        txtIdade = (TextView) findViewById(R.id.edtIdade);
        txtEndereco = (TextView) findViewById(R.id.edtEndereco);
        txtCidade = (TextView) findViewById(R.id.edtCidade);
        txtEstado = (TextView) findViewById(R.id.edtEstado);

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtNome.getText().toString().isEmpty() || txtIdade.getText().toString().isEmpty() || txtEndereco.getText().toString().isEmpty()
                        || txtCidade.getText().toString().isEmpty() || txtEstado.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Preencha todos os dados corretamente!",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivity.this,TelaConfirmacao.class);
                    intent.putExtra("nome", txtNome.getText().toString());
                    intent.putExtra("idade",txtIdade.getText().toString());
                    intent.putExtra("endereco",txtEndereco.getText().toString());
                    intent.putExtra("cidade",txtCidade.getText().toString());
                    intent.putExtra("estado",txtEstado.getText().toString());

                    startActivityForResult(intent,1);
                }
            }
        });


        btnScanNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idScan = btnScanNome.getId();
                scanCamera();
                edtNome.requestFocus();
            }
        });
        btnScanIdade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idScan = btnScanIdade.getId();
                scanCamera();
                edtIdade.requestFocus();
            }
        });
        btnScanEndereco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idScan = btnScanEndereco.getId();
                scanCamera();
                edtEndereco.requestFocus();
            }
        });
        btnScanCidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idScan = btnScanCidade.getId();
                scanCamera();
                edtCidade.requestFocus();
            }
        });
        btnScanEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idScan = btnScanEstado.getId();
                scanCamera();
                edtEstado.requestFocus();
            }
        });

    }

    public void scanCamera(){
        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("AppSi Scan");
        integrator.setCameraId(0);
        integrator.setOrientationLocked(true);
        integrator.setCaptureActivity(capture.class);
        integrator.initiateScan();
    }

    public void limparDados(){
        txtNome.setText("");
        txtIdade.setText("");
        txtEndereco.setText("");
        txtCidade.setText("");
        txtEstado.setText("");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if(requestCode == TELACONFIRMACAO){
            if(resultCode == Activity.RESULT_OK){
                limparDados();
                Toast.makeText(this, R.string.sucesso,Toast.LENGTH_LONG).show();
            }
        }else {
            if (result != null) {
                if (result.getContents() != null) {
                    if (idScan == btnScanNome.getId()) {
                        edtNome.setText(result.getContents());
                    } else if (idScan == btnScanIdade.getId()) {
                        edtIdade.setText(result.getContents());
                    } else if (idScan == btnScanEndereco.getId()) {
                        edtEndereco.setText(result.getContents());
                    } else if (idScan == btnScanCidade.getId()) {
                        edtCidade.setText(result.getContents());
                    } else if (idScan == btnScanEstado.getId()) {
                        edtEstado.setText(result.getContents());
                    }
                } else {
                    Toast.makeText(this, "Scan cancelado!", Toast.LENGTH_SHORT).show();
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.menu_about){
            Intent intent = new Intent(this, SobreActivity.class);
            startActivity(intent);
        }

        return true;
    }

    @Override
    protected void onPause() {
        Log.d("Tela Cadastro", "onPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        edtNome.requestFocus();
        Log.d("Tela Cadastro", "onResume");
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        Log.d("Tela Cadastro", "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        Log.d("Tela Cadastro", "onBackPressed");
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("Sair");
        alertBuilder
                .setMessage("Deseja realmente sair?")
                .setCancelable(false)
                .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                })
                .setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertBuilder.create();
        alertDialog.show();

    }
}
