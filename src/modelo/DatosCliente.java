package modelo;

public class DatosCliente {
    //Atributos
    protected DatosCliente datosCliente;
    protected String nombre;
    protected String rut;

    //new cliente {Pablo Perez,98998884}


    public DatosCliente(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}
