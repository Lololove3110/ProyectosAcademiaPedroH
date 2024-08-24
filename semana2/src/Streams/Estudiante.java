package Streams;

public class Estudiante {
	private String nombre;
    private int calificacionPeriodo1;
    private int calificacionPeriodo2;

    public Estudiante(String nombre, int calificacionPeriodo1, int calificacionPeriodo2) {
        this.nombre = nombre;
        this.calificacionPeriodo1 = calificacionPeriodo1;
        this.calificacionPeriodo2 = calificacionPeriodo2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCalificacionPeriodo1() {
        return calificacionPeriodo1;
    }

    public void setCalificacionPeriodo1(int calificacionPeriodo1) {
        this.calificacionPeriodo1 = calificacionPeriodo1;
    }

    public int getCalificacionPeriodo2() {
        return calificacionPeriodo2;
    }

    public void setCalificacionPeriodo2(int calificacionPeriodo2) {
        this.calificacionPeriodo2 = calificacionPeriodo2;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", calificacionPeriodo1=" + calificacionPeriodo1 +
                ", calificacionPeriodo2=" + calificacionPeriodo2 +
                '}';
    }
}
