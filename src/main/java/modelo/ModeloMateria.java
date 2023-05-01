package modelo;

public class ModeloMateria {

    private int id;
    private String nombre;

    public ModeloMateria() {
    }

    public ModeloMateria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Materia{" + "id=" + id +
                ", nombre='" + nombre + '\'' +'}';
    }

    public void imprimir(){
        System.out.println(toString());
    }
}
//1d