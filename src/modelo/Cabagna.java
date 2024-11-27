package modelo;

public class Cabagna extends Hospederia {
    //Atributo
    private boolean chimenea;

    public Cabagna(DatosCliente datosCliente, int valorBaseNoche, int cantidadDeNoches, String tipoTemporada, int capacidad, boolean esFumador, boolean chimenea) {
        super(datosCliente, valorBaseNoche, cantidadDeNoches, tipoTemporada, capacidad, esFumador);
        this.chimenea = chimenea;
    }

    public boolean isChimenea() {
        return chimenea;
    }

    public void setChimenea(boolean chimenea) {
        this.chimenea = chimenea;
    }
    //Metodo incrementaValorBase

    public void incrementaValorBase() {
        if (getCapacidad() > 5) {
            int valorBase = getValorBaseNoche() + Math.round(getValorBaseNoche() * 18 / 100);
            setValorBaseNoche(valorBase);
        }
    }
}
