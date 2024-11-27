package controlador;


import modelo.*;

import java.util.ArrayList;

public class TiendaAlojamiento {
    //Atributo

    private ArrayList<MedioDeAlojamiento> tiendaAlojamiento;

    //Metodos

    public TiendaAlojamiento(ArrayList<MedioDeAlojamiento> tiendaAlojamiento) {
        this.tiendaAlojamiento = tiendaAlojamiento;
    }

    public ArrayList<MedioDeAlojamiento> getTiendaAlojamiento() {
        return tiendaAlojamiento;
    }

    public void setTiendaAlojamiento(ArrayList<MedioDeAlojamiento> tiendaAlojamiento) {
        this.tiendaAlojamiento = tiendaAlojamiento;
    }
    //Funciones de Negocio

    public int buscarCliente(String rut) {
        for (int i = 0; i < tiendaAlojamiento.size(); i++) {
            if (tiendaAlojamiento.get(i).getDatosCliente().getRut().compareToIgnoreCase(rut) == 0) {
                return i;
            }
        }
        return -1;
    }

    public void ingresarMedioDeAlojamientoCabagna(Cabagna cabagna) {
        if (this.buscarCliente(cabagna.getDatosCliente().getRut()) == -1) {
            tiendaAlojamiento.add(cabagna);
        }
    }

    public void ingresarMedioDeAlojamientoHotel(Hotel hotel) {
        if (this.buscarCliente(hotel.getDatosCliente().getRut()) == -1) {
            tiendaAlojamiento.add(hotel);
        }
    }

    public void ingresarMedioDeAlojamientoCarpa(Carpa carpa) {
        if (this.buscarCliente(carpa.getDatosCliente().getRut()) == -1) {
            tiendaAlojamiento.add(carpa);
        }

    }

    //Mostrar medios de alojamiento (muestra datos de todos los objetos almacenados)
    public void mostrarMediosAlojamiento() {
        if (!tiendaAlojamiento.isEmpty()) {
            for (MedioDeAlojamiento alojamiento : tiendaAlojamiento) {
                System.out.println("-------------------------------------------------------");
                System.out.println("Medio de Alojamiento: " + alojamiento.getClass().getSimpleName());
                System.out.println("Temporada: " + alojamiento.getTipoTemporada());
                System.out.println("Valor Base Noche: " + alojamiento.getValorBaseNoche());
                System.out.println("Cliente: " + alojamiento.getDatosCliente().getNombre());
                System.out.println("Cantidad de noches: " + alojamiento.getCantidadDeNoches());
                System.out.println("-------------------------------------------------------");
            }
        } else System.out.println("No se encontraron alojamientos");
    }

    public void mostrarDatosCliente(String rut) {
        int posicion = buscarCliente(rut);
        if (posicion != -1) {
            System.out.println("-------------------------------------------------------");
            System.out.println("Cliente Alojado en: " + tiendaAlojamiento.get(posicion).getClass().getSimpleName());
            System.out.println("Nombre: " + tiendaAlojamiento.get(posicion).getDatosCliente().getNombre());
            System.out.println("Rut: " + tiendaAlojamiento.get(posicion).getDatosCliente().getRut());
        } else System.out.println("Cliente no encontrado en el sistema");
    }

    public void totalAdicional() {
        for (int i = 0; i < tiendaAlojamiento.size(); i++) {
            if (tiendaAlojamiento.get(i) instanceof Hotel) {
                System.out.println("----------------------------------------");
                System.out.println("Hotel " + (i + 1) + " Total Adicional: " + ((Hotel) tiendaAlojamiento.get(i)).valorAdicional());
                System.out.println("----------------------------------------");
            } else {
                System.out.println("----------------------------------------");
                System.out.println(tiendaAlojamiento.get(i).getClass().getSimpleName() + " " + (i + 1) + " No aplica Total Adicional");
                System.out.println("----------------------------------------");
            }
        }
    }

    public void totalBonoDescuento() {
        for (int i = 0; i < tiendaAlojamiento.size(); i++) {
            System.out.println("----------------------------------------");
            System.out.println("Total Bono Descuento en temporada: " + tiendaAlojamiento.get(i).getTipoTemporada() + ": " + tiendaAlojamiento.get(i).getClass().getSimpleName() + " " + (i + 1) + " " + tiendaAlojamiento.get(i).bonoDescuento());
            System.out.println("----------------------------------------");
        }
    }

    public void cantidadMedioAlojamiento(String medioAlojamiento) {
        int cantidad = 0;
        for (MedioDeAlojamiento medioDeAlojamiento : tiendaAlojamiento) {
            if (medioDeAlojamiento.getClass().getSimpleName().equalsIgnoreCase(medioAlojamiento)) {
                cantidad++;
            }
        }
        if (cantidad != 0) {
            System.out.println("----------------------------------------");
            System.out.println("Cantidad de Medio de Alojamiento " + medioAlojamiento + ": " + cantidad);
            System.out.println("----------------------------------------");
        } else System.out.println("El Medio de Alojamiento ingresado no existe");
    }

    public void valorACancelar(String rut) {
        int posicion = buscarCliente(rut);
        if (posicion != -1) {
            System.out.println("Cliente: " + tiendaAlojamiento.get(posicion).getDatosCliente().getNombre());
            System.out.println("Alojamiento: " + tiendaAlojamiento.get(posicion).getClass().getSimpleName());
            System.out.println("Tipo Temporada: " + tiendaAlojamiento.get(posicion).getTipoTemporada());
            System.out.println("Cantidad de noches: " + tiendaAlojamiento.get(posicion).getCantidadDeNoches());
            System.out.println("Valor base noche: " + tiendaAlojamiento.get(posicion).getValorBaseNoche());
            System.out.println("Subtotal: " + tiendaAlojamiento.get(posicion).subtotal());
            System.out.println("Bono de Descuento: " + tiendaAlojamiento.get(posicion).bonoDescuento());
            if (tiendaAlojamiento.get(posicion) instanceof Hotel) {
                System.out.println("Valor Adicional: " + ((Hotel) tiendaAlojamiento.get(posicion)).valorAdicional());
            }
            System.out.println("Total a Pagar: " + tiendaAlojamiento.get(posicion).valorACancelar());
            System.out.println("-------------------------------------------------------");
        } else System.out.println("El cliente ingresado no existe");
    }

    public void aplicarIncrementoValorBase() {
        for (int i = 0; i < tiendaAlojamiento.size(); i++) {
            String medioAlojamiento = tiendaAlojamiento.get(i).getClass().getSimpleName();
            if (medioAlojamiento.equalsIgnoreCase("Cabagna")) {
                if (((Cabagna) tiendaAlojamiento.get(i)).getCapacidad() > 5) {
                    System.out.println("----------------------------------------");
                    System.out.println("Aplicando Incremento del Valor Base en " + medioAlojamiento + " " + (i + 1));
                    ((Cabagna) tiendaAlojamiento.get(i)).incrementaValorBase();
                    System.out.println("Nuevo valor base noche: " + tiendaAlojamiento.get(i).getValorBaseNoche());
                    System.out.println("----------------------------------------");
                } else
                    System.out.println("La cantidad de huespedes es menor a 5. No se aplica el incremento del valor base");
            }
        }
    }
}