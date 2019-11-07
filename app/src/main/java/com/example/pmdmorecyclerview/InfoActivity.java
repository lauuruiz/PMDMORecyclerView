package com.example.pmdmorecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {
    private ImageView imDepartamento;
    private TextView tvNombre, tvSalario;
    private Uri biologia, matematicas, informatica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        String departamento = getIntent().getStringExtra("departamento");
        imagenes();
        initComponents();
        if(departamento.compareTo("informatica") == 0){
            imDepartamento.setImageResource(Integer.parseInt(informatica.toString()));
        }else if(departamento.compareTo("matematicas") == 0){
            imDepartamento.setImageResource(Integer.parseInt(matematicas.toString()));
        }else{
            imDepartamento.setImageResource(Integer.parseInt(biologia.toString()));
        }

        String nombre = getIntent().getStringExtra("nombre");
        tvNombre.setText(nombre);

        String salario = getIntent().getStringExtra("salario");
        if(salario.compareTo("1050") < 0){
            tvSalario.setTextColor(getResources().getColor(R.color.colorRed));
        }
        tvSalario.setText(salario);
    }

    private void imagenes() {
        biologia = Uri.parse(Integer.toString(R.drawable.biologia));
        matematicas = Uri.parse(Integer.toString(R.drawable.matematicas));
        informatica = Uri.parse(Integer.toString(R.drawable.informatica));
    }

    private void initComponents(){
        imDepartamento = findViewById(R.id.imDepartamento);
        tvNombre = findViewById(R.id.tvNombre);
        tvSalario = findViewById(R.id.tvSalario);
    }
}
