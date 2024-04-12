package edu.upc.dsa.models;

import java.util.List;

public class Piloto {
    List<String> reservas;
    String idPiloto;
    String nombre;
    String apellidos;
    int horas;

    public Piloto(String identificador,String nombre,String apellidos, int horas){
        this.idPiloto=identificador;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.horas=horas;
    }
    public String getIdPiloto() {
        return idPiloto;
    }
    public void setIdPiloto(String id) {
        this.idPiloto=id;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getApellidos(){
        return apellidos;
    }
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    public int getHoras(){
        return horas;
    }
    public void setHoras(int horas){
        this.horas=horas;
    }

    public static Piloto buscarPilotoPorId(List<Piloto> pilotos, String  pilotoId){
        for(Piloto piloto : pilotos){
            if(piloto.getIdPiloto().equals(pilotoId)) {
                return piloto;
            }
        }
        return null;
    }
}
