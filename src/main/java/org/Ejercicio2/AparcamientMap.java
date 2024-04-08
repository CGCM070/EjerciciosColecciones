package org.Ejercicio2;

import org.Ejercicio1.Vehiculos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class AparcamientMap {

    private int identificador;
    private Map<String,Vehiculos> listaVehiculos;
    private int capacidad;


    public void introducirVehiculo(Vehiculos v1) throws Exception {
        Exception seEncuentra = new Exception("Vehiculo ya en el aparcamiento");
        Exception lleno = new Exception("Esta lleno el aparcamiento");
        if(estaVehiculo(v1.getMatricula())){
            throw seEncuentra;
        }
        else if(listaVehiculos.size()==capacidad){
            throw lleno;
        }
        else{
            listaVehiculos.put(v1.getMatricula(),v1);
        }
    }

    //Este metodo nos imprime en pantalla cuanto es el importe a pagar.
    public void sacarVehiculo(String matricula) throws Exception {
        Exception mensaje = new Exception("No esta en el aparcamiento");
        if(estaVehiculo(matricula)){
            System.out.println("El importe a pagar es: "+listaVehiculos.get(matricula).calcularImporte());
            listaVehiculos.remove(matricula);
                }
        else{
            throw mensaje;
        }
    }


    //Utilizamos este metodo para buscar si el conjunto tiene ya el Vehiculo
    private boolean estaVehiculo(String matricula) { //Funcion para comprobar si esta el vehiculo
        return listaVehiculos.containsKey(matricula);
    }


    public AparcamientMap(int identificador, Map<String, Vehiculos> listaVehiculos, int capacidad) {
        this.identificador = identificador;
        this.listaVehiculos = listaVehiculos;
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Aparcamiento{" +
                "listaVehiculos=" + listaVehiculos +
                ", capacidad=" + capacidad +
                '}';
    }
}

