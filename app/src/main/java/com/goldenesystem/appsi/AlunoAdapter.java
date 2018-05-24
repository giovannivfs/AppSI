package com.goldenesystem.appsi;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlunoAdapter extends BaseAdapter {

    private final Activity activity;
    private final ArrayList<Aluno> elementos;

    public AlunoAdapter(Activity activity,ArrayList<Aluno> elementos){
        this.activity = activity;
        this.elementos = elementos;

    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Nullable
    @Override
    public Aluno getItem(int position) {
        return elementos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.item_aluno_list, parent,false);

        Aluno aluno = elementos.get(position);

        TextView alunoNome = (TextView) view.findViewById(R.id.alunoNome);
        TextView alunoRa = (TextView) view.findViewById(R.id.alunoRa);
        ImageView imgAluno = (ImageView) view.findViewById(R.id.imgAluno);

        alunoNome.setText(aluno.getNome());
        alunoRa.setText(aluno.getRa());
        imgAluno.setImageResource(aluno.getImage());

        return view;
    }


}
