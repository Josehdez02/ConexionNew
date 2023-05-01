package modelo;

public class ModeloCatedratico {
    public String RFC;
    public String nombre;

    public ModeloCatedratico() {
    }

    public ModeloCatedratico(String RFC, String nombre) {
        this.RFC = RFC;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }


    @Override
    public String toString() {
        return "Modelo Catedratico{" +
                "RFC=" + RFC +
                ", Nombre='" + nombre + '\'' +
                '}';
    }
}