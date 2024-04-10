package org.Ejercicio1;

import org.Ejercicio3.ConjuntoAparcamientos;

import java.util.*;

public class PrincipalEje1 {
    // holandaaa
    //Creamos varios Automoviles

    public static void main(String[] args) {

        //Creamos varios Automoviles

        Automovil a1 = new Automovil(Automovil.Tipo.TURISMO);
        a1.setMinutos(100);
        a1.setBono(true);
        a1.setMatricula("Z123");


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
        ArrayList<Vehiculos> aV = new ArrayList<>();
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
        //Ahora introducimo uno con matricula repetida
        try{
            ap.introducirVehiculo(c4);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        Collections.sort(aV);//Ordenamos la lista antes de imprimirla.
        ap.setCapacidad(100);
        System.out.println(ap);


        //Vamos a generar cinco aparcamientos con sus respectivos 3 vehiculos cada uno y los meteremos en un mapa para
        //usar nuestra clase ConjuntoAparcamientos

        Map<Integer,Aparcamiento> mapa = new HashMap<>();//Nuestro mapa
        for(int i=0;i<5;i++){//Iteramos 6 veces
            ArrayList<Vehiculos> nuevaLista = new ArrayList<>();
            int cantidad = (int)(Math.random()*5)+3;
            Aparcamiento apar = new Aparcamiento(nuevaLista,cantidad);
            mapa.put(i,apar);
            for(int j=0;j<3;j++){
                int tipoVehiculo = (int) (Math.random()*2);//Generamos random para diferenciar entre camion/vehiculo
                if(tipoVehiculo==1){
                    Automovil auto = new Automovil(Automovil.Tipo.TURISMO);
                    int minAleatorio = (int)(Math.random()*200);
                    auto.setMinutos(minAleatorio);
                    if((i+j)%2==0){
                        auto.setBono(true);
                    }
                    auto.setMatricula(i+j+"ABC");
                    int tipoAutomovil = (int) (Math.random()*3);
                    switch(tipoAutomovil){
                        case 0:
                            auto.setTipo(Automovil.Tipo.TURISMO);
                            break;
                        case 1:
                            auto.setTipo(Automovil.Tipo.FURGONETA);
                            break;
                        case 2:
                            auto.setTipo(Automovil.Tipo.TODOTERRENO);
                    }
                    mapa.get(i).getListaVehiculos().add(auto);
                }
                else{
                    int numeroEjesAleat = (int) (Math.random()*6)+2;
                    Camion camionaso = new Camion(numeroEjesAleat);
                    int minAleatorio = (int)(Math.random()*200);
                    camionaso.setMinutos(minAleatorio);
                    if((i+j)%2==0){
                        camionaso.setBono(true);
                    }
                    camionaso.setMatricula(i+j+"SoyCamion");
                    mapa.get(i).getListaVehiculos().add(camionaso);
                }
            }
        }// En este bucle creamos el mapa con 6 aparcamientos y cada uno tiene 3 vehiculos
        ConjuntoAparcamientos cap = new ConjuntoAparcamientos();
        cap.setListaAparcamientos(mapa);
        System.out.println(cap);
        System.out.println(cap.eliminarCamiones());
        System.out.println(cap);


    }

}
