package modelo;

public class ModeloAlumno {
    private int numControl;
    private String nombre;
    private ModeloEspecialidad modeloEspecialidad;

    public ModeloAlumno() {
    }


    public ModeloAlumno(int numControl, String nombre, ModeloEspecialidad modeloEspecialidad) {
        this.numControl = numControl;
        this.nombre = nombre;
        this.modeloEspecialidad = modeloEspecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumControl() {
        return numControl;
    }

    public void setNumControl(int numControl) {
        this.numControl = numControl;
    }

    public ModeloEspecialidad getModeloEspecialidad() {
        return modeloEspecialidad;
    }

    public void setModeloEspecialidad(ModeloEspecialidad modeloEspecialidad) {
        this.modeloEspecialidad = modeloEspecialidad;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    public void imprmir() {
        System.out.println(toString());
    }

}
