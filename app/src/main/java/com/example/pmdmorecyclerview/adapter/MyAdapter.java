package com.example.pmdmorecyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdmorecyclerview.R;
import com.example.pmdmorecyclerview.model.Profesor;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private Profesor profesores[];
    //private ArrayList<Profesor> profesores;
    private OnItemClickListener listener;
    public interface OnItemClickListener{
        public void onItemClick(Profesor profesor);
    }

    public MyAdapter(Profesor[] profesores, OnItemClickListener listener) {
        this.profesores = profesores;
        this.listener = listener;
    }
    /*public MyAdapter(ArrayList<Profesor> profesores, OnItemClickListener listener) {
        this.profesores = profesores;
        this.listener = listener;
    }*/
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.my_recycler_view, parent, false); //true -> se infla y se añade a la vista; false -> lo hace el RecyclerView
        MyViewHolder vh = new MyViewHolder(itemView);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final Profesor profesor = profesores[position];
        holder.imProfesor.setImageResource(Integer.parseInt(profesores[position].getImagen()));
        holder.tvNombre.setText(profesores[position].getNombre());
        holder.tvDepartamento.setText(profesores[position].getDepartamento());
        holder.tvSalario.setText(Double.toString(profesores[position].getSalario()));
        holder.cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(), "has pulsado " + position, Toast.LENGTH_SHORT).show();
                listener.onItemClick(profesor);
            }
        });

    }

    @Override
    public int getItemCount() {
        return profesores.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imProfesor;
        TextView tvNombre, tvDepartamento, tvSalario;
        ConstraintLayout cl;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imProfesor = itemView.findViewById(R.id.imProfesor);
            tvNombre = itemView.findViewById(R.id.textView);
            tvDepartamento = itemView.findViewById(R.id.tvDepartamento);
            tvSalario = itemView.findViewById(R.id.textView2);
            cl = itemView.findViewById(R.id.cl);
        }
    }
}
