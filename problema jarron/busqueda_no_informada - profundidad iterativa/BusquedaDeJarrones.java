/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.busquedadejarrones;

/**
 *
 * @author Windows
 */
public class BusquedaDeJarrones {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Jarron jarra1 = new Jarron(12,0);
        Jarron jarra2 = new Jarron(8,0);
        Jarron jarra3 = new Jarron(3,0);
        //jarra1.llenarDeGrifo();
        /*jarra1.vaciarAjarra(jarra2);
        System.out.println("jarra 1 tiene "+jarra1.getAlmacenado());
        System.out.println("jarra 2 tiene "+jarra2.getAlmacenado());*/
        BusquedaHijos buscar = new BusquedaHijos(jarra1,jarra2,jarra3,1);
        
    }
}
