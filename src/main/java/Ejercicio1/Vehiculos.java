package Ejercicio1;

import java.util.Comparator;

public abstract class Vehiculos implements Comparator<Vehiculos> {
    private String matricula;
    private int minutos;
    private boolean bono;

    public String getMatricula() {
        return matricula;
    }

    public int getMinutos() {
        return minutos;
    }

    public boolean isBono() {
        return bono;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public void setBono(boolean bono) {
        this.bono = bono;
    }

    @Override
    public int compare(Vehiculos o1, Vehiculos o2) {
        return o1.getMatricula().compareTo(o2.getMatricula());
    }
    abstract double calcularImporte();
}
