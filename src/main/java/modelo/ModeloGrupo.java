package modelo;

public class ModeloGrupo {
    private String hora;
    private int clave, salon;
    private ModeloCatedratico modeloCatedratico;
    private ModeloAlumno modeloAlumno;
    private ModeloMateria modeloMateria;
    public ModeloGrupo() {
    }

    public ModeloGrupo(int clave, String hora, int salon,
                       ModeloCatedratico modeloCatedratico,
                       ModeloAlumno modeloAlumno,
                       ModeloMateria modeloMateria) {
        this.clave = clave;
        this.hora = hora;
        this.salon = salon;
        this.modeloCatedratico = modeloCatedratico;
        this.modeloAlumno = modeloAlumno;
        this.modeloMateria = modeloMateria;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getSalon() {
        return salon;
    }

    public void setSalon(int salon) {
        this.salon = salon;
    }

    public ModeloCatedratico getModeloCatedratico() {
        return modeloCatedratico;
    }

    public void setModeloCatedratico(ModeloCatedratico modeloCatedratico) {
        this.modeloCatedratico = modeloCatedratico;
    }
    public ModeloAlumno getModeloAlumno() {
        return modeloAlumno;
    }

    public void setModeloAlumno(ModeloAlumno modeloAlumno) {
        this.modeloAlumno = modeloAlumno;
    }

    public ModeloMateria getModeloMateria() {
        return modeloMateria;
    }

    public void setModeloMateria(ModeloMateria modeloMateria) {
        this.modeloMateria = modeloMateria;
    }

    @Override
    public String toString() {
        return "ModeloGrupo{" +
                "Clave='" + clave + '\'' +
                ", Hora=" + hora +
                ", Salon=" + salon +
                '}';
    }

    public void imprmir() {
        System.out.println(toString());
    }

    }
