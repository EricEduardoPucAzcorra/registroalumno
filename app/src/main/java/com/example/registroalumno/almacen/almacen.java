package com.example.registroalumno.almacen;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class almacen {
//parte de almacen que trabaja e memoria ram.
    private static almacen instanciaUnica;
    //variable para el has table
    private static Hashtable <Integer, List> lista=null;

    private Enumeration indices;

    //logica para insetar un hastable
    public static synchronized almacen getInstanciaAlmacen(){
        if (instanciaUnica == null) {
            instanciaUnica = new almacen();
            lista = new Hashtable<Integer, List>();
        }
        return instanciaUnica;
    }


    //para que me retorne un registro.
    public void setRegistro(Integer num, List row ){
        lista.put(num,row);
    }


    public ArrayList <String> getRegistros(){
     ArrayList filas = new ArrayList();
     indices = lista.keys();

     String listado="";
     while (indices.hasMoreElements()){
         Integer index = (Integer) indices.nextElement();
         listado += "ID[" + lista.get(index).get(0) + "]\n\r";
         listado += "Nombre: " + lista.get(index).get(1) + "\n\r";
         listado += "Naciemiento: " + lista.get(index).get(2) + "\n\r";
         listado += "Pais: " + lista.get(index).get(3) + "\n\r";
         listado += "Sexo: " + lista.get(index).get(4) + "\n\r";
         listado += "Habla ingles: " + lista.get(index).get(5) + "\n\r";
         filas.add(listado);
         listado="";
     }
     return  filas;
    }



    //Unidad 2-> logica para eliminar un registro.
    public void setEliminarRegistro(Integer index){
        lista.remove(index);
    }


}