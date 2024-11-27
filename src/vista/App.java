package vista;

import controlador.TiendaAlojamiento;
import modelo.*;

import java.util.ArrayList;

public class App {

    static String alojamientosAlmacenados = "";

    static TiendaAlojamiento tiendaAlojamiento = new TiendaAlojamiento(new ArrayList<>());

    public static void main(String[] args) {

        int opcion;
        String rut;
        String medioAlojamiento;

        do {
            opcion = menu();

            switch (opcion) {
                case 1:
                    nuevoAlojamiento();
                    break;
                case 2:
                    tiendaAlojamiento.mostrarMediosAlojamiento();
                    break;
                case 3:
                    do {
                        System.out.println("Ingrese el RUT del cliente a buscar");
                        rut = Leer.dato();
                    } while (rut.isEmpty());
                    tiendaAlojamiento.mostrarDatosCliente(rut);
                    break;
                case 4:
                    tiendaAlojamiento.totalAdicional();
                    break;
                case 5:
                    tiendaAlojamiento.totalBonoDescuento();
                    break;
                case 6:
                    do {
                        System.out.println("Ingrese el Alojamiento a buscar (Carpa/Cabagna/Hotel)");
                        medioAlojamiento = Leer.dato();
                    } while (medioAlojamiento.isEmpty());
                    tiendaAlojamiento.cantidadMedioAlojamiento(medioAlojamiento);
                    break;
                case 7:
                    do {
                        System.out.println("Ingrese el RUT del Ciente");
                        rut = Leer.dato();
                    } while (rut.isEmpty());
                    tiendaAlojamiento.valorACancelar(rut);
                    break;
                case 8:
                    tiendaAlojamiento.aplicarIncrementoValorBase();
                    break;
                case 9:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("La opcion ingresada no es valida. Por favor ingrese una opcion del menu");
            }
        } while (opcion != 9);
    }

    //Menu:
    public static int menu() {
        System.out.println("------Sistema de Alojamiento------");
        System.out.println("----------------------------------");
        System.out.println("1.\tIngresar Medio de Alojamiento");
        System.out.println("2.\tMostrar Medios de Alojamiento");
        System.out.println("3.\tDatos de un Cliente");
        System.out.println("4.\tTotal Adicional");
        System.out.println("5.\tTotal Bono Descuento");
        System.out.println("6.\tCantidad Medios de Alojamiento");
        System.out.println("7.\tValor a Cancelar Por un Cliente");
        System.out.println("8.\tAplicar Incremento del Valor Base");
        System.out.println("9.\tSalir");
        System.out.println("----------------------------------");
        System.out.println("Favor ingrese una opcion para continuar...");
        return Leer.datoInt();
    }

    public static void nuevoAlojamiento() {
        String[] temporadas = {"Alta", "Media", "Baja"};
        boolean[] verdadero = {true, false};
        int alojamiento;
        int cantidadNoches;
        String nombreCliente;
        String rut;
        int cantidadPersonas = 0;
        int esFumador = 0;
        int conDesayuno = 0;
        int valorBaseNoche;
        int tipoTemporada;
        int capacidad = 0;
        int tieneChimenea = 0;

        do {
            System.out.println("Seleccione el tipo de Alojamiento");
            System.out.println("1. Carpa");
            System.out.println("2. Cabagna");
            System.out.println("3. Hotel");
            System.out.println("Ingrese el codigo del alojamiento (1/2/3)");
            alojamiento = Leer.datoInt();

            if (alojamiento == 1 || alojamiento == 2 || alojamiento == 3) {
                if (alojamientosAlmacenados.contains(String.valueOf(alojamiento))) {
                    System.out.println("El tipo de Alojamiento seleccionado ya se encuentra registrado en el sistema. Por favor registre uno diferente");
                    alojamiento = -1;
                } else alojamientosAlmacenados = alojamientosAlmacenados + alojamiento;
            } else {
                System.out.println("La opción seleccionada es incorrecta. Seleccione 1/2/3");
                alojamiento = -1;
            }
        } while (alojamiento == -1);

        do {
            System.out.println("Ingrese el Valor base Noche");
            valorBaseNoche = Leer.datoInt();
        } while (valorBaseNoche == -1);

        do {
            System.out.println("Ingrese el tipo de temporada (1.Alta/2.Media/3.Baja)");
            tipoTemporada = Leer.datoInt();
            if (tipoTemporada != 1 && tipoTemporada != 2 && tipoTemporada != 3) {
                System.out.println("La opción seleccionada es incorrecta. Seleccione 1/2/3");
                valorBaseNoche = -1;
            }
        } while (tipoTemporada == -1);

        if (alojamiento != 1) {
            capacidad = -1;
            do {
                System.out.println("Ingrese la capacidad del Alojamiento");
                capacidad = Leer.datoInt();
            } while (capacidad == -1);
        }

        if (alojamiento == 2) {
            tieneChimenea = -1;
            do {
                System.out.println("La Cabagna tiene chimenea? (1.Si/2.No)");
                tieneChimenea = Leer.datoInt();
            } while (tieneChimenea == -1);
        }

        do {
            System.out.println("Ingrese el nombre del Titular");
            nombreCliente = Leer.dato();
        } while (nombreCliente.isEmpty());

        do {
            System.out.println("Ingrese el RUT del Titular");
            rut = Leer.dato();
        } while (rut.isEmpty());

        do {
            System.out.println("Ingrese la cantidad de noches");
            cantidadNoches = Leer.datoInt();
        } while (cantidadNoches == -1);

        if (alojamiento == 1) {
            cantidadPersonas = -1;
            do {
                System.out.println("Ingrese la cantidad de huéspedes");
                cantidadPersonas = Leer.datoInt();
            } while (cantidadPersonas == -1);
        }

        if (alojamiento != 1) {
            esFumador = -1;
            do {
                System.out.println("Algun huesped es fumador? (1.Si/2.No)");
                esFumador = Leer.datoInt();
            } while (esFumador == -1);
        }

        if (alojamiento == 3) {
            conDesayuno = -1;
            do {
                System.out.println("Desea incluir desayuno? (1.Si/2.No)");
                conDesayuno = Leer.datoInt();
            } while (conDesayuno == -1);
        }

        DatosCliente cliente = new DatosCliente(nombreCliente, rut);

        switch (alojamiento) {
            case 1:
                Carpa carpa = new Carpa(cliente, valorBaseNoche, cantidadNoches, temporadas[tipoTemporada - 1], cantidadPersonas);
                tiendaAlojamiento.ingresarMedioDeAlojamientoCarpa(carpa);
                break;
            case 2:
                Cabagna cabagna = new Cabagna(cliente, valorBaseNoche, cantidadNoches, temporadas[tipoTemporada - 1], capacidad, verdadero[esFumador - 1], verdadero[tieneChimenea - 1]);
                tiendaAlojamiento.ingresarMedioDeAlojamientoCabagna(cabagna);
                break;
            case 3:
                Hotel hotel = new Hotel(cliente, valorBaseNoche, cantidadNoches, temporadas[tipoTemporada - 1], capacidad, verdadero[esFumador - 1], verdadero[conDesayuno - 1]);
                tiendaAlojamiento.ingresarMedioDeAlojamientoHotel(hotel);
        }
    }
}
