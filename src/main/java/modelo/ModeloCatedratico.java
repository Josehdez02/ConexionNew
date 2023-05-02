package modelo;

public class ModeloCatedratico {
    private String rfc;
    private String nombre;

    public ModeloCatedratico() {
    }

    public ModeloCatedratico(String rfc, String nombre) {
        this.rfc = rfc;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }


    @Override
    public String toString() {return this.nombre; };
    }
