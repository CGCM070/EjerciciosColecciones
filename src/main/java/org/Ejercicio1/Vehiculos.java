package org.Ejercicio1;

import java.util.Comparator;

public abstract class Vehiculos implements Comparable<Vehiculos> {
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

    abstract double calcularImporte();

    @Override
    public int compareTo(Vehiculos o) {
        return matricula.compareTo(o.matricula);
    }

    @Override
    public String toString() {
        return "Vehiculos{" +
                "matricula='" + matricula + '\'' +
                ", minutos=" + minutos +
                ", bono=" + bono +
                '}';
    }
}
