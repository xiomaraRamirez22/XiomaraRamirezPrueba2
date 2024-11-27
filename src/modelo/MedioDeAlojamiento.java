package modelo;

public abstract class MedioDeAlojamiento {
    //Atributos
    protected DatosCliente datosCliente; // {Pablo Perez,98998884}
    protected int valorBaseNoche; // 10000
    protected int cantidadDeNoches; // 3
    protected String tipoTemporada; // alta, media, baja

    public MedioDeAlojamiento(DatosCliente datosCliente, int valorBaseNoche, int cantidadDeNoches, String tipoTemporada) {
        this.datosCliente = datosCliente;
        this.valorBaseNoche = valorBaseNoche;
        this.cantidadDeNoches = cantidadDeNoches;
        this.tipoTemporada = tipoTemporada;
    }

    public DatosCliente getDatosCliente() {
        return datosCliente;
    }

    public void setDatosCliente(DatosCliente datosCliente) {
        this.datosCliente = datosCliente;
    }

    public int getValorBaseNoche() {
        return valorBaseNoche;
    }

    public void setValorBaseNoche(int valorBaseNoche) {
        this.valorBaseNoche = valorBaseNoche;
    }

    public int getCantidadDeNoches() {
        return cantidadDeNoches;
    }

    public void setCantidadDeNoches(int cantidadDeNoches) {
        this.cantidadDeNoches = cantidadDeNoches;
    }

    public String getTipoTemporada() {
        return tipoTemporada;
    }

    public void setTipoTemporada(String tipoTemporada) {
        this.tipoTemporada = tipoTemporada;
    }
    // Metodo subtotal: devolverá el subtotal a cancelar el cual será cantidad de noches por el valorBaseNoche

    public int subtotal() {
        return cantidadDeNoches * valorBaseNoche;
    }

    // bonoDescuento:
    public int bonoDescuento() {
        if (getTipoTemporada().equalsIgnoreCase("baja")) {
            return Math.round(subtotal() * 25 / 100);
        } else if (getTipoTemporada().equalsIgnoreCase("media")) {
            return (int) Math.round(subtotal() * 12.5 / 100);
        }
        return 0;
    }
    //Metodo valorACancelar

    public int valorACancelar() {
        return subtotal() - bonoDescuento();
    }


}
