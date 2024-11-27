package modelo;

public class Carpa extends MedioDeAlojamiento {
    //Atributo
    private int cantidadPersonas; // 4

    public Carpa(DatosCliente datosCliente, int valorBaseNoche, int cantidadDeNoches, String tipoTemporada, int cantidadPersonas) {
        super(datosCliente, valorBaseNoche, cantidadDeNoches, tipoTemporada);
        this.cantidadPersonas = cantidadPersonas;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }
}
