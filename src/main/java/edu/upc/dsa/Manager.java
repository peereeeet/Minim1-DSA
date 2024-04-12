package edu.upc.dsa;

import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Piloto;
import edu.upc.dsa.models.Reserva;

import java.util.List;
import java.util.Date;

public interface Manager {


    void añadirDron(String identificador, String nombre, String fabricante, String modelo, int horas);
    void añadirPiloto(String identificador, String nombre, String apellidos, int horas);
    List<Dron> listarDronesPorHorasDeVuelo();
    List<Piloto> listarPilotosPorHorasDeVuelo();
    void guardarDronEnAlmacen(String identificadorDron);
    void repararDronEnAlmacen();
    void añadirReservaPlanVuelo(String identificadorDron, Date fecha, int duracion, String posicionInicio, String posicionDestino, String identificadorPiloto);
    List<Reserva> listarReservasPorPiloto(String identificadorPiloto);
    List<Reserva> listarPlanesVueloPorDron(String identificadorDron);
}
