
public class PruebaMapa
{
    public static void main(String[] args){
        Mapa m1 = new Mapa(5);
        
        m1.agregarNodo("A");
        m1.agregarNodo("B");
        m1.agregarNodo("C");
        m1.agregarNodo("D"); 
        m1.agregarNodo("E"); 
 
        m1.agregarArista("A", "B", 1);
        m1.agregarArista("B", "C", 1);
        m1.agregarArista("C", "D", 1);        
        m1.agregarArista("D", "E", 1);        
        m1.agregarArista("E", "A", 1);
        
        String[] colores1 = {"rojo","rosa","morado"};
        m1.busquedaAvara(colores1);
        
        System.out.println("Siguiente grafo" + "\n");
        System.out.println("Este grafo no se puede pintar con los colores dados" + "\n");
        
        Mapa m2 = new Mapa(6);
        
        m2.agregarNodo("A");
        m2.agregarNodo("B");
        m2.agregarNodo("C");
        m2.agregarNodo("D"); 
        m2.agregarNodo("E"); 
        m2.agregarNodo("F");
    
        m2.agregarArista("A", "B", 1);
        m2.agregarArista("B", "C", 1);
        m2.agregarArista("C", "D", 1);        
        m2.agregarArista("D", "E", 1);        
        m2.agregarArista("E", "F", 1);
        m2.agregarArista("F", "A", 1);
        
        String[] colores2 = {"amarillo","verde"};
        m1.busquedaAvara(colores2);
    }
    public Mapa getGrafo(){
        Mapa m = new Mapa(6);
        
        m.agregarNodo("A");
        m.agregarNodo("B");
        m.agregarNodo("C");
        m.agregarNodo("D"); 
        m.agregarNodo("E"); 
        m.agregarNodo("F");
        
        m.agregarArista("A", "B", 1);
        m.agregarArista("B", "C", 1);
        m.agregarArista("C", "D", 1);        
        m.agregarArista("D", "E", 1);        
        m.agregarArista("E", "F", 1);
        m.agregarArista("F", "A", 1);
        return m;
    }
}
