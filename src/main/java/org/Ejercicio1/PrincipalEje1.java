package org.Ejercicio1;

import java.util.ArrayList;
import java.util.Arrays;

public class PrincipalEje1 {

    //Creamos varios Automoviles

    public static void main(String[] args) {

        //Creamos varios Automoviles

        Automovil a1 = new Automovil(Automovil.Tipo.TURISMO);
        a1.setMinutos(100);
        a1.setBono(true);
        a1.setMatricula("A123");


        Automovil a2 = new Automovil(Automovil.Tipo.FURGONETA);
        a2.setMinutos(200);
        a2.setMatricula("B123");


        Automovil a3 = new Automovil(Automovil.Tipo.FURGONETA);
        a3.setMinutos(200);
        a3.setMatricula("C123");


        Automovil a4 = new Automovil(Automovil.Tipo.TODOTERRENO);
        a4.setMinutos(400);
        a4.setBono(true);
        a4.setMatricula("D123");


        //Creamos Varios Camiones

        Camion c1 = new Camion(3);
        c1.setMatricula("E123");
        c1.setMinutos(200);
        System.out.println(c1);

        Camion c2 = new Camion(5);
        c2.setMatricula("T123");
        c2.setMinutos(300);
        c2.setBono(true);
        System.out.println(c2);

        //Creamos un Aparcamiento, para eso metemos todos los vehiculos en una lista
        ArrayList<Vehiculos> aV = new ArrayList<Vehiculos>();
        aV.add(a1);
        aV.add(a2);
        aV.add(a3);
        aV.add(a4);
        aV.add(c1);
        aV.add(c2);

        Aparcamiento ap = new Aparcamiento(aV,6);
        //Creamos un Vehiculo nuevo y otro que tenga la misma matricula qe uno ya añadido

        Camion c3 = new Camion(7);
        c2.setMatricula("R123");
        c2.setMinutos(100);

        Camion c4 = new Camion(3);
        c4.setMatricula("E123");
        c4.setMinutos(100);

        //Intentamos añadirlo para comprobar que al estar lleno no te deja meter mas

        try{
            ap.introducirVehiculo(c3);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        //Eliminamos el camion c2 obteniendo el importe

        try{
            ap.sacarVehiculo(c2.getMatricula());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(aV.size());
        //Ahora introducimo uno con matricula repetida
        try{
            ap.introducirVehiculo(c4);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
