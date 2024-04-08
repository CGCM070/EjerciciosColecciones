package org.Ejercicio3;

import org.Ejercicio1.Aparcamiento;
import org.Ejercicio1.Camion;
import org.Ejercicio1.Vehiculos;

import java.util.*;

public class ConjuntoAparcamientos {
    private Map<Integer, Aparcamiento> listaAparcamientos;

    public ConjuntoAparcamientos() {
    }

    public void vaciarAparcamiento(Integer id) {
        Set<Integer> conjuntoClaves = listaAparcamientos.keySet();
        Iterator<Integer> it = conjuntoClaves.iterator();
        int idSiguiente = 0;
        while (it.hasNext()) {
            int valor = it.next();
            if (valor == id && it.hasNext()) {
                idSiguiente = it.next();
            }
        }
        Aparcamiento ap_actual = listaAparcamientos.get(id);
        Aparcamiento ap_siguiente = listaAparcamientos.get(idSiguiente);

        if (ap_siguiente.getCapacidad() >= ap_actual.getCapacidad() + ap_siguiente.getCapacidad()) {
            ap_siguiente.getListaVehiculos().addAll(ap_actual.getListaVehiculos());
        }
        ap_actual.getListaVehiculos().clear();

    }

    public void añadirAparcamiento(Integer id, Aparcamiento ap) {
        listaAparcamientos.put(id, ap);
    }

    //Este metodo devuelve un conjunto de camiones ordenados y borra de cada aparcamiento estos camiones.

    public Collection eliminarCamiones() {
        TreeSet<Camion> conjuntoCamiones = new TreeSet<>(new ComparadorCamiones());
        Set<Integer> conjuntoClaves = listaAparcamientos.keySet();
        Iterator<Integer> it = conjuntoClaves.iterator();
        while (it.hasNext()) {
            int id = it.next();
            Aparcamiento ap = listaAparcamientos.get(id);
            Iterator<Vehiculos> it1 = ap.getListaVehiculos().iterator();
            while (it1.hasNext()) {
                Vehiculos v0 = it1.next();
                if(v0 instanceof Camion){
                    conjuntoCamiones.add((Camion) v0);
                    ap.getListaVehiculos().iterator().remove();
                    /*
                     * deberia de eliminar el iterador que contiene los vehiculos
                     * el segundo iterador , en este caso : it1.remove() y no ;
                     * ap.getListaVehiculos().iterator().remove();
                     * caso contratio eliminariamos el primer vehiculo que encuentra
                     * */
                }
            }
        }
        return conjuntoCamiones;
    }

    public Map<Integer, Aparcamiento> getListaAparcamientos() {
        return listaAparcamientos;
    }
    public void setListaAparcamientos(Map<Integer, Aparcamiento> listaAparcamientos) {this.listaAparcamientos = listaAparcamientos;
    }
}

