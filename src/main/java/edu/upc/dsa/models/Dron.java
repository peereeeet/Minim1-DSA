package edu.upc.dsa.models;

import java.util.List;

public class Dron {
    List<String> reservas;
    String idDron;
    String nombre;
    String fabricante;
    String modelo;
    int horas;

    public Dron(String identificador,String nombre,String fabricante, String modelo, int horas){
        this.idDron=identificador;
        this.nombre=nombre;
        this.fabricante=fabricante;
        this.modelo=modelo;
        this.horas=horas;
    }
    public String getIdDron() {
        return idDron;
    }

    public void setIdDron(String id) {
        this.idDron=id;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getFabricante(){
        return fabricante;
    }
    public void setFabricante(String fabricante){
        this.fabricante = fabricante;
    }
    public String getModelo(){
        return modelo;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    public int getHoras(){
        return horas;
    }
    public void setHoras(int horas){
        this.horas=horas;
    }

    public static Dron buscarDronPorId(List<Dron> drones, String  dronId){
        for(Dron dron : drones){
            if(dron.getIdDron().equals(dronId)) {
                return dron;
            }
        }
        return null;
    }
}
