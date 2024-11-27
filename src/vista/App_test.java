package vista;


import controlador.TiendaAlojamiento;
import modelo.*;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {


        DatosCliente datosCliente1 = new DatosCliente("Luis Perez", "97987987");
        DatosCliente datosCliente2 = new DatosCliente("Manuel Perez", "98987987");
        DatosCliente datosCliente3 = new DatosCliente("Pedro Perez", "99987987");


        Carpa carpa = new Carpa(datosCliente1, 10000, 3, "Media", 5);
        Cabagna cabagna = new Cabagna(datosCliente2, 12000, 4, "Baja", 6, true, true);
        Hotel hotel = new Hotel(datosCliente3, 20000, 3, "Media", 3, true, true);



       /* System.out.println("---------------- Hospedaje Carpa --------------------------");
        System.out.println("Nombre Cliente: " + datosCliente.getNombre());
        System.out.println("Rut: " + datosCliente.getRut());
        System.out.println("El valor a cancelar en Carpa es: " + carpa.valorACancelar());
        System.out.println("El bono descuento es: " + carpa.bonoDescuento());
        System.out.println("Temporada: " + carpa.getTipoTemporada());
        System.out.println("Cantidad de Personas:  " + carpa.getCantidadPersonas());
        System.out.println("Cantidad de noches: " + carpa.getCantidadDeNoches());
        System.out.println("El valor Base noche es: "+ carpa.getValorBaseNoche());

        System.out.println("-----------hospedaje Hotel----------------------------------");
        System.out.println("Nombre Cliente: " + datosCliente.getNombre());
        System.out.println("Rut: " + datosCliente.getRut());
        System.out.println("Valor a cancelar Hotel es: "+ hotel.valorACancelar());
        System.out.println("Valor Base noche: "+ hotel.getValorBaseNoche());
        System.out.println("Valor Adicional: "+ hotel.valorAdicional());
        System.out.println("Bono descuento: " + hotel.bonoDescuento());
        System.out.println("Cantidad de personas: "+ hotel.getCantidadDeNoches());
        System.out.println("Temporada: "+ hotel.getTipoTemporada());
        System.out.println("Capacidad: " + hotel.getCapacidad());

        System.out.println("-----------hospedaje Cabagna----------------------------------");
        System.out.println("Nombre Cliente: " + datosCliente.getNombre());
        System.out.println("Rut: " + datosCliente.getRut());
        System.out.println("Valor a cancelar Cabagna es: "+ cabagna.valorACancelar());
        System.out.println("Valor Base noche: "+ cabagna.getValorBaseNoche());
        System.out.println("Bono descuento: " + cabagna.bonoDescuento());
        System.out.println("Cantidad de personas: "+ cabagna.getCantidadDeNoches());
        System.out.println("Temporada: "+ cabagna.getTipoTemporada());
        System.out.println("Capacidad: " + cabagna.getCapacidad());*/

        TiendaAlojamiento tiendaAlojamiento = new TiendaAlojamiento(new ArrayList<>());

        System.out.println("Alojamiento: " + tiendaAlojamiento.getTiendaAlojamiento().size());

        tiendaAlojamiento.ingresarMedioDeAlojamientoCabagna(cabagna);
        System.out.println("Alojamiento: " + tiendaAlojamiento.getTiendaAlojamiento().size());

        tiendaAlojamiento.ingresarMedioDeAlojamientoHotel(hotel);
        System.out.println("Alojamiento: " + tiendaAlojamiento.getTiendaAlojamiento().size());

        tiendaAlojamiento.ingresarMedioDeAlojamientoCarpa(carpa);
        System.out.println("Alojamiento: " + tiendaAlojamiento.getTiendaAlojamiento().size());

        System.out.println("-------------------------------------------------------");
        System.out.println("Mostrar Medios de Alojamiento: ");
        tiendaAlojamiento.mostrarMediosAlojamiento();

        System.out.println("-------------------------------------------------------");
        System.out.println("Mostrar Datos de un cliente: ");
        tiendaAlojamiento.mostrarDatosCliente(datosCliente2.getRut());

        System.out.println("-------------------------------------------------------");
        System.out.println("Total Adicional: ");
        tiendaAlojamiento.totalAdicional();

        System.out.println("-------------------------------------------------------");
        System.out.println("Total Bono Descuento: ");
        tiendaAlojamiento.totalBonoDescuento();

        System.out.println("-------------------------------------------------------");
        System.out.println("Cantidad Medio de Alojamiento: ");
        tiendaAlojamiento.cantidadMedioAlojamiento(cabagna.getClass().getSimpleName());

        System.out.println("-------------------------------------------------------");
        System.out.println("Valor a Cancelar por un Cliente: ");
        tiendaAlojamiento.valorACancelar(datosCliente2.getRut());

        System.out.println("-------------------------------------------------------");
        System.out.println("Aplicar incremento valor base: ");
        tiendaAlojamiento.aplicarIncrementoValorBase();





    }


}
