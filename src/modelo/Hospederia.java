package modelo;

public class Hospederia extends MedioDeAlojamiento {
    //Atributos
    protected int capacidad; // 4
    protected boolean esFumador; // false o true

    public Hospederia(DatosCliente datosCliente, int valorBaseNoche, int cantidadDeNoches, String tipoTemporada, int capacidad, boolean esFumador) {
        super(datosCliente, valorBaseNoche, cantidadDeNoches, tipoTemporada);
        this.capacidad = capacidad;
        this.esFumador = esFumador;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean esFumador() {
        return esFumador;
    }

    public void setEsFumador(boolean esFumador) {
        this.esFumador = esFumador;
    }
}
