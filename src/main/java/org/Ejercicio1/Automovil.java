package org.Ejercicio1;

public class Automovil extends Vehiculos {

    //Usamos una enum para obligar que los objetos de esta clase sean o bien Turismo,Todoterreno o Furgoneta.

    public enum Tipo {
        TURISMO, TODOTERRENO, FURGONETA
    }

    private Tipo tipo;

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    double calcularImporte() {
        double importe;
        if (getTipo().equals(Tipo.TURISMO)) {
            importe = getMinutos() * 1.5 / 60;
        } else if (getTipo().equals(Tipo.TODOTERRENO)) {
            importe = getMinutos() * 2.5 / 60;
        } else {
            importe = getMinutos() * 3.5 / 60;
        }

        if(isBono());//Si tiene bono entonces reducimos el importe final
        importe *= 0.6;
        return importe;
    }

    public Automovil(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Automovil{" +
                "tipo=" + tipo +
                "} " + super.toString();
    }
}
