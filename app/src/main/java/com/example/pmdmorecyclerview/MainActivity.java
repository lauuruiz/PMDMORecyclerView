package com.example.pmdmorecyclerview;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.pmdmorecyclerview.adapter.MyAdapter;
import com.example.pmdmorecyclerview.model.Profesor;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecycler;
    private RecyclerView.LayoutManager layoutManager;
    private Profesor profesores[] = new Profesor[6];
    private Uri mujer1, mujer2, mujer3, hombre1, hombre2, hombre3;
    //private ArrayList<Profesor> profesores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {
        myRecycler = findViewById(R.id.my_recycler);

        //asignarle un layout manager
        //layoutManager = new LinearLayoutManager(this);
        layoutManager = new GridLayoutManager(this, 1);
        myRecycler.setLayoutManager(layoutManager);

        //asignarle un adaptador
        imagenes();
        crearArray();
        MyAdapter myAdapter = new MyAdapter(profesores, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Profesor profesor) {
                /*Toast.makeText(MainActivity.this, "Nombre: " + profesor.getNombre() +
                        "\nDepartamento: " + profesor.getDepartamento() +
                        "\nSalario: " + profesor.getSalario(), Toast.LENGTH_SHORT).show();*/
                Intent i = new Intent(MainActivity.this, InfoActivity.class);
                i.putExtra("departamento", profesor.getDepartamento());
                i.putExtra("nombre", profesor.getNombre());
                i.putExtra("salario", Double.toString(profesor.getSalario()));
                startActivity(i);
            }
        });
        myRecycler.setAdapter(myAdapter);

    }

    private void imagenes() {
        mujer1 = Uri.parse(Integer.toString(R.drawable.mujer1));
        mujer2 = Uri.parse(Integer.toString(R.drawable.mujer2));
        mujer3 = Uri.parse(Integer.toString(R.drawable.mujer3));
        hombre1 = Uri.parse(Integer.toString(R.drawable.hombre1));
        hombre2 = Uri.parse(Integer.toString(R.drawable.hombre2));
        hombre3 = Uri.parse(Integer.toString(R.drawable.hombre3));
    }

    private void crearArray() {
        profesores[0] = new Profesor(mujer1.toString(), "Magdalena", "informatica", 2000);
        profesores[1] = new Profesor(hombre1.toString(), "Juan Carlos", "matematicas", 1999.98);
        profesores[2] = new Profesor(mujer2.toString(), "María", "biologia", 1000);
        profesores[3] = new Profesor(hombre2.toString(), "Federico", "biologia", 1500.52);
        profesores[4] = new Profesor(mujer3.toString(), "Gracia", "matematicas", 1847);
        profesores[5] = new Profesor(hombre3.toString(), "Alfonso", "informatica", 1000);
    }
}
