package com.goldenesystem.appsi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SobreActivity extends AppCompatActivity {

    /**
     * Tela sobre apresentará informações sobre o trabalho e alunos.
     * ArrayList<Aluno> utlizada para armazenar os alunos criados através do método adicionaAluno();
     * AlunoAdapter adicionar os alunos no ListView.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        setTitle(R.string.action_about);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);

        ListView lista = (ListView) findViewById(R.id.listaAluno);

        ArrayList<Aluno> alunos = adicionaAluno();

        AlunoAdapter adapter =
                new AlunoAdapter(this, alunos);
        lista.setAdapter(adapter);

        Log.d("Tela Sobre", "Tela no evento onCreate");
    }

    private ArrayList<Aluno> adicionaAluno(){
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        Aluno a = new Aluno(getString(R.string.nomeGiovanni),
                getString(R.string.raGiovanni), R.drawable.giovanni);
            alunos.add(a);

        a = new Aluno(getString(R.string.nomeRoger),
                getString(R.string.raRoger), R.drawable.roger);
            alunos.add(a);

        a = new Aluno(getString(R.string.nomeWerik),
                getString(R.string.raWerik), R.drawable.werik);
            alunos.add(a);

        return alunos;
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Tela Sobre", "Tela no evento onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Tela Sobre" ,"Tela no evento onDestroy");
    }
}
