/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Windows
 */
public class Jarron {
        
    private int capacidad;
    private int almacenado;

    public Jarron(int capacidad, int almacenado){
        this.capacidad = capacidad;
        this.almacenado = almacenado;
    }
    public Jarron(int capacidad){
        this.capacidad = capacidad;
        almacenado = 0;
    }
   
    public void llenarDeGrifo(){
        almacenado = capacidad;
    }
    
    public boolean estaVacio(){
        boolean vacio = true;
        if(almacenado != 0){
            vacio = false;
        }
        return vacio;
    }
    
    public boolean estaLleno(){
        boolean lleno = false;
        if(almacenado == capacidad){
            lleno = true;
        }
        return lleno;
    }
    
    public int vaciarAjarra(Jarron otroJ){
        int cap = otroJ.getCapacidad();
        int alm = otroJ.getAlmacenado();
        int suma = alm + almacenado;
        if(suma >= cap){
            setAlmacenado(almacenado - (cap-alm)) ;
            alm = capacidad;
            otroJ.setAlmacenado(cap);
        }
        else{
            alm = suma;
            otroJ.setAlmacenado(alm);
            setAlmacenado(0);
        }
        return 0;
    }
    
    public void vaciar(){
        almacenado = 0;
    }
    
     public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getAlmacenado() {
        return almacenado;
    }

    public void setAlmacenado(int almacenado) {
        this.almacenado = almacenado;
    }
 
}
