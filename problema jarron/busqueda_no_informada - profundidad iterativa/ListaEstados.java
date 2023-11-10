/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.busquedadejarrones;

import java.util.ArrayList;

/**
 *
 * @author Windows
 */
public class ListaEstados {
    
    private ArrayList<Estado> miLista = new ArrayList<>();
    
    public void aniadirEstado(Estado estado){
        miLista.add(estado);
    }
    
    public void borrarTodo(){
        miLista.clear();
    }
    
    public void borrarUltimo(){
        int tamanio = miLista.size();
        miLista.remove(tamanio);
    }
    
    public boolean buscarEstado(Estado estado){
        int tamanio = miLista.size();
        boolean existe = false;
        for(int i = 0; i<tamanio; i++){
            existe = estado.compararEstado(miLista.get(i));
            if(existe == true){
                break;
            }
        }
        return existe;
    }
    
    public ArrayList<Estado> getMiLista() {
        return miLista;
    }
    
}
