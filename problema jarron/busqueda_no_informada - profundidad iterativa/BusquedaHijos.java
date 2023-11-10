/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;

/**
 *
 * @author Windows
 */
public class BusquedaHijos {
    private int iteracionM = 5;
    private int maximo = 50;
    private int inicio = 1;
    ListaEstados estadosGlobales = new ListaEstados();
    private int objetivo = 1;
    private boolean encontrado = false;
    Jarron jarra1;
    Jarron jarra2;
    Jarron jarra3;
    
    public BusquedaHijos(Jarron jarraA, Jarron jarraB, Jarron jarraC, int objetivo){
        jarra1 = jarraA;//esta idea es para tratar de encontrar con jarras desordenadas respecto a su cap maxima
        jarra2 = jarraB;
        jarra3 = jarraC;
        this.objetivo = objetivo;
        Estado estadoBase = new Estado(jarra1.getAlmacenado(), jarra2.getAlmacenado(), jarra3.getAlmacenado(), "iniciamos con los jarrones vacios");
        buscarSol(estadoBase, 1);
    }
    
    public boolean buscarSol(Estado estadoBase, int iteracion){
        
        
        
        if(iteracion<iteracionM){
            ListaEstados lista = new ListaEstados();
            
            if(verificar(estadoBase)){
                encontrado = verificar(estadoBase);
                //System.out.println(estadoBase.getAlmJ1()+" "+estadoBase.getAlmJ2()+" "+estadoBase.getAlmJ3()+" "+estadoBase.getPaso());
                    
            }
            if(encontrado==false){
                if(estadoBase.getAlmJ1()==0 && estadoBase.getAlmJ2()==0 && estadoBase.getAlmJ3()==0){
                    int tmp = jarra1.getCapacidad();
                    almacenarEstado(tmp, 0,0,"LLenamos la jarra 1 con agua del grifo", lista);
                    tmp = jarra2.getCapacidad();
                    almacenarEstado(0,tmp,0,"LLenamos la jarra 2 con agua del grifo",lista);
                    tmp = jarra3.getCapacidad();
                    almacenarEstado(0,0,tmp,"LLenamos la jarra 3 con agua del grifo",lista);

                }

                if(estadoBase.getAlmJ1()==jarra1.getCapacidad() && estadoBase.getAlmJ2()==jarra2.getCapacidad() && estadoBase.getAlmJ3()==jarra3.getCapacidad()){
                    
                    almacenarEstado(0, estadoBase.getAlmJ2(), estadoBase.getAlmJ3(),"Vaciamos la jarra 1 en el suelo",lista);
                    
                    almacenarEstado(estadoBase.getAlmJ1(), 0, estadoBase.getAlmJ3(),"Vaciamos la jarra 2 en el suelo",lista);
                    
                    almacenarEstado(estadoBase.getAlmJ1(), estadoBase.getAlmJ2(), 0, "Vaciamos la jarra 3 en el suelo",lista);
                }              
                if((estadoBase.getAlmJ1()-jarra2.getCapacidad())==objetivo && estadoBase.getAlmJ2()!=0){
                    almacenarEstado(estadoBase.getAlmJ1(), 0, jarra3.getAlmacenado(), "Vaciamos la jarra 2 en el suelo",lista);
                    
                }
                if((estadoBase.getAlmJ1()-jarra3.getCapacidad())==objetivo && estadoBase.getAlmJ3()!=0){
                    
                    almacenarEstado(estadoBase.getAlmJ1(), estadoBase.getAlmJ2(), 0,"Vaciamos la jarra 3 en el suelo",lista);
                    
                }
                if((estadoBase.getAlmJ2()-jarra3.getCapacidad())==objetivo && estadoBase.getAlmJ3()!=0){
                    
                    almacenarEstado(estadoBase.getAlmJ1(),estadoBase.getAlmJ2(), 0, "Vaciamos la jarra 3 en el suelo",lista);
                    
                }
                if((estadoBase.getAlmJ2()-jarra1.getCapacidad())==objetivo && estadoBase.getAlmJ1()!=0){
                    
                    almacenarEstado(0, estadoBase.getAlmJ2(), estadoBase.getAlmJ3(), "Vaciamos la jarra 1 en el suelo",lista);
                    
                }
                
                if((estadoBase.getAlmJ3()-jarra1.getCapacidad())==objetivo && estadoBase.getAlmJ1()!=0){
                    
                    almacenarEstado(0,estadoBase.getAlmJ2(), estadoBase.getAlmJ3(), "Vaciamos la jarra 1 en el suelo",lista);
                    
                }
                if((estadoBase.getAlmJ3()-jarra2.getCapacidad())==objetivo && estadoBase.getAlmJ2()!=0){
                    
                    almacenarEstado(estadoBase.getAlmJ1(), 0, estadoBase.getAlmJ3(), "Vaciamos la jarra 2 en el suelo",lista);
                    
                }
                
                if(estadoBase.getAlmJ2()!= 0 && estadoBase.getAlmJ3() != 0 && estadoBase.getAlmJ1()==0){
                    
                    almacenarEstado(jarra1.getCapacidad(), estadoBase.getAlmJ2(), estadoBase.getAlmJ3(),"LLenamos la jarra 1 con agua del grifo",lista);
                    
                }
                if(estadoBase.getAlmJ1()!= 0 && estadoBase.getAlmJ3() != 0 && estadoBase.getAlmJ2()==0){
                    
                    almacenarEstado(estadoBase.getAlmJ1(), jarra2.getCapacidad(), estadoBase.getAlmJ3(), "LLenamos la jarra 2 con agua del grifo",lista);
                    
                }
                if(estadoBase.getAlmJ1()!= 0 && estadoBase.getAlmJ2() != 0 && estadoBase.getAlmJ3()==0){
                    
                    almacenarEstado(estadoBase.getAlmJ1(),estadoBase.getAlmJ2(), jarra3.getCapacidad() ,"LLenamos la jarra 3 con agua del grifo",lista);
                    
                }
                if(estadoBase.getAlmJ1()<jarra1.getCapacidad() && estadoBase.getAlmJ2()!=0){
                    int tmp1 = estadoBase.getAlmJ1();
                    int tmp2 = estadoBase.getAlmJ2();
                    vaciarAjarra(jarra1, estadoBase.getAlmJ1() , jarra2, estadoBase.getAlmJ2());
                    almacenarEstado(jarra1.getAlmacenado(),jarra2.getAlmacenado(), estadoBase.getAlmJ3(), "vaciamos la jarra 2 en la jarra 1", lista);
                    if(encontrado ==false){
                        encontrado = verificar(jarra1.getAlmacenado(), jarra2.getAlmacenado(), estadoBase.getAlmJ3());
                    }
                    
                    estadoBase.setAlmJ1(tmp1);
                    estadoBase.setAlmJ2(tmp2);
                    
                }
                if(estadoBase.getAlmJ1()<jarra1.getCapacidad() && estadoBase.getAlmJ3()!=0){
                    int tmp1 = estadoBase.getAlmJ1();
                    int tmp2 = estadoBase.getAlmJ3();
                    vaciarAjarra(jarra1, estadoBase.getAlmJ1(), jarra3, estadoBase.getAlmJ3());
                    almacenarEstado(jarra1.getAlmacenado(), estadoBase.getAlmJ2(), jarra3.getAlmacenado(), "vaciamos la jarra 3 en la jarra 1", lista);
                    if(encontrado ==false){
                        encontrado = verificar(jarra1.getAlmacenado(), estadoBase.getAlmJ2(), jarra3.getAlmacenado());
                    }
                    estadoBase.setAlmJ1(tmp1);
                    estadoBase.setAlmJ3(tmp2);
                }
                if(estadoBase.getAlmJ2()<jarra2.getCapacidad() && estadoBase.getAlmJ1()!=0){
                    int tmp1 = estadoBase.getAlmJ2();
                    int tmp2 = estadoBase.getAlmJ1();
                    vaciarAjarra(jarra2, estadoBase.getAlmJ2(), jarra1, estadoBase.getAlmJ1());
                    almacenarEstado(jarra1.getAlmacenado(),jarra2.getAlmacenado(), estadoBase.getAlmJ3(), "vaciamos la jarra 1 en la jarra 2", lista);
                    estadoBase.setAlmJ2(tmp1);
                    estadoBase.setAlmJ1(tmp2);
                }
                if(estadoBase.getAlmJ2()<jarra2.getCapacidad() && estadoBase.getAlmJ3()!=0){
                    int tmp1 = estadoBase.getAlmJ2();
                    int tmp2 = estadoBase.getAlmJ3();
                    vaciarAjarra(jarra2, estadoBase.getAlmJ2(),jarra3, estadoBase.getAlmJ3());
                    almacenarEstado(estadoBase.getAlmJ1(),jarra2.getAlmacenado(), jarra3.getAlmacenado(), "vaciamos la jarra 3 en la jarra 2", lista);
                    estadoBase.setAlmJ2(tmp1);
                    estadoBase.setAlmJ3(tmp2);
                }
                if(estadoBase.getAlmJ3()<jarra3.getCapacidad() && estadoBase.getAlmJ1()!=0){
                    int tmp1 = estadoBase.getAlmJ3();
                    int tmp2 = estadoBase.getAlmJ1();
                    vaciarAjarra(jarra3, estadoBase.getAlmJ3(),jarra1, estadoBase.getAlmJ1());
                    almacenarEstado(jarra1.getAlmacenado(),estadoBase.getAlmJ2(), jarra3.getAlmacenado(), "vaciamos la jarra 1 en la jarra 3", lista);
                    estadoBase.setAlmJ3(tmp1);
                    estadoBase.setAlmJ1(tmp2);
                }
                if(estadoBase.getAlmJ3()<jarra3.getCapacidad() && estadoBase.getAlmJ2()!=0){
                    int tmp1 = estadoBase.getAlmJ3();
                    int tmp2 = estadoBase.getAlmJ2();
                    vaciarAjarra(jarra3, estadoBase.getAlmJ3(),jarra2, estadoBase.getAlmJ2());
                    almacenarEstado(estadoBase.getAlmJ1(),jarra2.getAlmacenado(), jarra3.getAlmacenado(), "vaciamos la jarra 2 en la jarra 3", lista);
                    estadoBase.setAlmJ3(tmp1);
                    estadoBase.setAlmJ2(tmp2);
                }
                for(int i = 0; i<lista.getMiLista().size(); i++){
                    boolean sol = buscarSol(lista.getMiLista().get(i), iteracion+1);
                    if(sol){
                        Estado camino = lista.getMiLista().get(i);
                        System.out.println(camino.getAlmJ1()+" "+camino.getAlmJ2()+" "+camino.getAlmJ3()+" "+ camino.getPaso());
                        break;
                    }
                }
            }
            if(iteracionM<maximo){
                iteracionM=iteracionM+5;
            }
            
        }
        return encontrado;
    }
    
    public boolean verificar(){//metodo para ver si llegamos a la meta
        boolean cumplido = false;
        if (jarra1.getAlmacenado()==objetivo || jarra2.getAlmacenado()==objetivo || jarra3.getAlmacenado()==objetivo ){
            cumplido = true;
        }
        return cumplido;
    }
    public boolean verificar(Estado estado){
        boolean cumplido = false;
        if(estado.getAlmJ1()==objetivo || estado.getAlmJ2() == objetivo || estado.getAlmJ3() == objetivo){
            cumplido = true;
        }
        return cumplido;
    }
    public boolean verificar(int alm1, int alm2, int alm3){
        boolean cumplido = false;
        if(alm1 == objetivo || alm2 == objetivo || alm3 == objetivo){
            cumplido = true;
        }
        return cumplido;
    }
    public void almacenarEstado(int alm1, int alm2, int alm3,String paso, ListaEstados lista){
        Estado estado = new Estado( alm1, alm2, alm3, paso);
        if(estadosGlobales.buscarEstado(estado)==false){
            lista.aniadirEstado(estado);
            estadosGlobales.aniadirEstado(estado);
        }
        else{
            System.out.println("estado repetido");
        }
        
    }
    public void almacenarEstado(Estado estado, ListaEstados lista){
        lista.aniadirEstado(estado);
    }
    
    public int vaciarAjarra(Jarron jarronA, int alm1, Jarron jarronB, int alm2){//jarron A es el jarron que recibira agua B es el que le dara
        int capA = jarronA.getCapacidad();
        int almA = alm1;
        int capB = jarronB.getCapacidad();
        int almB = alm2;
        int suma = almA + almB;
        if(suma >= capA){
            jarronA.setAlmacenado(capA) ;
            almB = almB-(capA-almA);
            jarronB.setAlmacenado(almB);
        }
        else{
            jarronA.setAlmacenado(suma);
            jarronB.setAlmacenado(0);
        }
        return 0;
    }
}
