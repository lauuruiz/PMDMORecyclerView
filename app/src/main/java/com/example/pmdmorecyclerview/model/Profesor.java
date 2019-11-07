package com.example.pmdmorecyclerview.model;

public class Profesor {
   private String imagen, nombre, departamento;
   private double salario;

    public Profesor(String imagen, String nombre, String departamento, double salario) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;
    }
    public String getImagen() { return imagen; }

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public double getSalario() {
        return salario;
    }
}
