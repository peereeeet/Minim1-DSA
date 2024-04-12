package edu.upc.dsa;

import java.util.*;

import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Piloto;
import edu.upc.dsa.models.Reserva;
import org.apache.log4j.Logger;

public class ManagerImpl implements Manager {
    private static Manager instance;
    protected List<Dron> drones;
    protected List<Piloto> pilotos;
    protected List<Reserva> reservas;
    final static Logger logger = Logger.getLogger(ManagerImpl.class);

    private ManagerImpl(){
        this.pilotos = new ArrayList<>();
        this.drones = new ArrayList<>();
    }
    public static Manager getInstance() {
        if (instance==null) instance = new ManagerImpl();
        return instance;
    }
    @Override
    public void añadirDron(String identificador, String nombre, String fabricante, String modelo, int horas) {
        Dron newDron = new Dron(identificador, nombre, fabricante, modelo, horas);
        drones.add(newDron);
        logger.info("Dron añadido");
    }
    @Override
    public void añadirPiloto(String identificador, String nombre, String apellidos, int horas){
        Piloto newPiloto = new Piloto(identificador, nombre, apellidos, horas);
        pilotos.add(newPiloto);
        logger.info("Piloto añadido");
    }
    public List<Dron> listarDronesPorHorasDeVuelo(){
        List<Dron> dronesHoras=new ArrayList<>();
        for(Dron dron:drones){
            int horasVuelo=dron.getHoras();

            if(horasVuelo>0){
                dronesHoras.add(dron);
            }
        }
        dronesHoras.sort(Comparator.comparingInt(d -> -getHoras(d, dronId)));
        logger.info("Consulta de usuarios que han participado en un juego ordenado por puntuación (descendente). "+ dronesHoras);
        return dronesHoras;
    }
    public List<Piloto> listarPilotosPorHorasDeVuelo(){
        List<Piloto> pilotosHoras=new ArrayList<>();
        for(Piloto piloto:pilotos){
            int horasVuelo=piloto.getHoras();

            if(horasVuelo>0){
                pilotosHoras.add(piloto);
            }
        }
        pilotosHoras.sort(Comparator.comparingInt(p -> -getHoras(p, pilotoId)));
        logger.info("Consulta de usuarios que han participado en un juego ordenado por puntuación (descendente). "+ pilotosHoras);
        return pilotosHoras;
    }
    @Override
    public void guardarDronEnAlmacen(String identificadorDron){

    }
    @Override
    public void repararDronEnAlmacen(){

    }
    @Override
    public void añadirReservaPlanVuelo(String identificadorDron, Date fecha, int duracion, String posicionInicio, String posicionDestino, String identificadorPiloto){
        Reserva newReserva = new Reserva(identificadorDron, fecha, duracion, posicionInicio, posicionDestino, identificadorPiloto);
        reservas.add(newReserva);
        logger.info("Reserva añadida");
    }
    public List<Reserva> listarReservasPorPiloto(String identificadorPiloto){

    }
    public List<Reserva> listarPlanesVueloPorDron(String identificadorDron){

    }
}