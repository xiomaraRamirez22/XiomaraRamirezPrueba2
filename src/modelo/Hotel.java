package modelo;

public class Hotel extends Hospederia {
    //Atributo
    private boolean conDesayuno;

    public Hotel(DatosCliente datosCliente, int valorBaseNoche, int cantidadDeNoches, String tipoTemporada, int capacidad, boolean esFumador, boolean conDesayuno) {
        super(datosCliente, valorBaseNoche, cantidadDeNoches, tipoTemporada, capacidad, esFumador);
        this.conDesayuno = conDesayuno;
    }

    public boolean isConDesayuno() {
        return conDesayuno;
    }

    public void setConDesayuno(boolean conDesayuno) {
        this.conDesayuno = conDesayuno;
    }

    //Metodo para calcular adicional

    public int valorAdicional() {
        if (esFumador() && isConDesayuno()) {
            return Math.round(subtotal() * 30 / 100);
        } else return 0;
    }

    @Override
    public int valorACancelar(){
        return subtotal() - bonoDescuento() + valorAdicional();
    }


}
