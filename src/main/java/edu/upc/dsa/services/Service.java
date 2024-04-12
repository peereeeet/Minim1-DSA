package edu.upc.dsa.services;


import edu.upc.dsa.Manager;
import edu.upc.dsa.ManagerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Date;

@Api(value = "/dron", description = "Endpoint to Drones Service")
@Path("/dron")
public class Service {

    private Manager manager;

    public Service() {
        this.manager = ManagerImpl.getInstance();
    }

    @POST
    @ApiOperation(value = "Añade un dron", notes = "Añade un nuevo dron")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Dron añadido"),
            @ApiResponse(code = 500, message = "Error de validación")
    })
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDron(@QueryParam("dronID") String dronID, @QueryParam("nombre") String nombre, @QueryParam("fabricante") String fabricante, @QueryParam("modelo") String modelo) {
        this.manager.añadirDron(dronID, nombre, fabricante, modelo);
        return Response.status(201).build();
    }

    @POST
    @ApiOperation(value = "Añade un piloto", notes = "Añade un nuevo piloto")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Piloto añadido"),
            @ApiResponse(code = 500, message = "Error de validación")
    })
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPiloto(@QueryParam("pilotoID") String pilotoID, @QueryParam("nombre") String nombre, @QueryParam("apellidos") String apellidos) {
        this.manager.añadirPiloto(pilotoID, nombre, apellidos);
        return Response.status(201).build();
    }

    @GET
    @ApiOperation(value = "Obtener lista de drones descendentemente por horas de vuelo", notes = "Listado de drones ordenado descendentemente por horas de vuelo")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Exito"),
            @ApiResponse(code = 404, message = "Lista no encontrada")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListaDrones() {

    }

    @GET
    @ApiOperation(value = "Obtener lista de pilotos descendentemente por horas de vuelo", notes = "Listado de pilotos ordenado descendentemente por horas de vuelo")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Exito"),
            @ApiResponse(code = 404, message = "Lista no encontrada")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListaPilotos() {

    }

    @POST
    @ApiOperation(value = "Guardar dron en almacen", notes = "Guardar un dron en un almacen para realizar tareas de\n" +
            "mantenimiento")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Exito"),
            @ApiResponse(code = 404, message = "Dron no guardado")
    })
    @Path("/")
    public Response guardarDron(@QueryParam("dronID") String dronID) {
        this.manager.guardarDronEnAlmacen(dronID);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "Reparar dron", notes = "Reparar o realizar tareas de manteniemiento sobre un dron que está\n" +
            "en el almacen")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Exito"),
            @ApiResponse(code = 404, message = "Dron no reparado")
    })
    @Path("/")
    public Response repararDron() {
        this.manager.repararDronEnAlmacen();
        return Response.status(201).build();
    }
    @PUT
    @ApiOperation(value = "Añadir una reserva", notes = "Añadir una reserva para un plan de vuelo")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Exito"),
            @ApiResponse(code = 404, message = "Reserva no añadida")
    })
    @Path("/")
    public Response añadirReserva(@QueryParam("dronID") String dronID, @QueryParam("fecha") Date fecha, @QueryParam("duracion") int duracion, @QueryParam("pInicio") String posicionInicio, @QueryParam("pDestino") String posicionDestino, @QueryParam("pilotoID") String pilotoID) {
        this.manager.añadirReservaPlanVuelo(dronID, fecha, duracion, posicionInicio, posicionDestino, pilotoID);
        return Response.status(201).build();
    }
    @GET
    @ApiOperation(value = "Reservas asignadas a un piloto", notes = "Listado de reservas de planes de vuelo que han sido asignados a\n" +
            "un piloto")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Exito"),
            @ApiResponse(code = 404, message = "Lista no encontrada")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReservasPiloto() {

    }
    @GET
    @ApiOperation(value = "Reservas asignadas a un dron", notes = "Listado de planes de vuelo que han sido asignadas a un dron")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Exito"),
            @ApiResponse(code = 404, message = "Lista no encontrada")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReservasDron() {

    }
}