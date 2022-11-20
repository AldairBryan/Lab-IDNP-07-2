package com.example.lab_idnp_07_2;

public class Restaurante {
    private String nombre;
    private int capacidad;
    private String direccion;

    public Restaurante(String name,int cap,String address){
        nombre=name;
        capacidad=cap;
        direccion=address;
    }

    public String mostrar(){
        return "Restaurante: "+nombre+
                "\nCapacidad: "+capacidad+
                "\nDireccion: "+direccion;
    }
    public String getNombre(){
        return nombre;
    }
}
