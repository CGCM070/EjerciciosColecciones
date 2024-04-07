package Ejercicio1;

import java.util.ArrayList;
import java.util.Iterator;

public class Aparcamiento {

    private ArrayList<Vehiculos> listaVehiculos;
    private int capacidad;


    public void introducirVehiculo(Vehiculos v1) throws Exception {
        Exception mensaje = new Exception("Vehiculo ya en el aparcamiento");
        if(estaVehiculo(v1.getMatricula())){
            throw mensaje;
        }
        else{
            listaVehiculos.add(v1);
        }
    }

    //Este metodo nos imprime en pantalla cuanto es el importe a pagar.
    public void sacarVehiculo(String matricula) throws Exception {
        Exception mensaje = new Exception("No esta en el aparcamiento");
            if(estaVehiculo(matricula)){
                Iterator<Vehiculos> it = listaVehiculos.iterator();
                while (it.hasNext()){
                    Vehiculos v0 = it.next();
                    if(v0.getMatricula().equals(matricula)){
                        System.out.println("El importe a pagar es: "+v0.calcularImporte());
                        listaVehiculos.remove(v0);
                    }
                }
        }
            else{
                throw mensaje;
            }
    }



    private boolean estaVehiculo(String matricula) { //Funcion para comprobar si esta el vehiculo
        boolean resultado = false;
        Iterator<Vehiculos> it = listaVehiculos.iterator();
        while (it.hasNext()) {
            Vehiculos v0 = it.next();
            if (v0.getMatricula().equals(matricula)) {
                resultado = true;
            }
        }
        return resultado;
    }
}