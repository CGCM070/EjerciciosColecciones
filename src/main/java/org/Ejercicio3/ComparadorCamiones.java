package org.Ejercicio3;

import org.Ejercicio1.Camion;

import java.util.Comparator;

public class ComparadorCamiones implements Comparator<Camion> {
    @Override
    public int compare(Camion o1, Camion o2) {
        if(o1.getMatricula().equals(o2.getMatricula())){
            return Integer.compare(o1.getEjes(), o2.getEjes());
        }
        if(o1.getMatricula().compareTo(o2.getMatricula())>0){
            return -1;
        }
        else{
            return 1;
        }
    }
}
