package controlador;


import modelo.MedioDeAlojamiento;

import java.util.ArrayList;

public class Alojamientos {
    //Atributo

    private ArrayList<MedioDeAlojamiento> alojamientos;

    //Metodos

    public Alojamientos(ArrayList<MedioDeAlojamiento> alojamientos) {
        Alojamientos = alojamientos;
    }

    public ArrayList<MedioDeAlojamiento> getAlojamientos() {
        return Alojamientos;
    }

    public void setAlojamientos(ArrayList<MedioDeAlojamiento> alojamientos) {
        Alojamientos = alojamientos;
    }
}
