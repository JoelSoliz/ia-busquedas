import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Mapa{
    private ArrayList<Nodo>[] listaAdy;
    private String[] nodos;
    private int cantNodos;
    
    public Mapa(int n){
        listaAdy = new ArrayList[n];
        nodos = new String[n];
        cantNodos = 0;
        inicializar();
    }
    
    private void inicializar(){
        for(int i = 0; i < listaAdy.length; i++){
            listaAdy[i] = new ArrayList();
        }
    }
    
    public void agregarNodo(String n){
        if(cantNodos < listaAdy.length){
            if(posNodo(n) == -1){
                nodos[cantNodos] = n;
                cantNodos++;
            }
        }
    }
    
    public void agregarArista(String o, String d, int costo){
        int posOri = posNodo(o);
        int posDes = posNodo(d);
        if((posOri != -1) && (posDes != -1)){
            listaAdy[posOri].add(new Nodo(costo, d));
            listaAdy[posDes].add(new Nodo(costo, o));
        }
    }

    private int posNodo(String n){
        int pos = -1;
        boolean encontrado = false;
        for(int i = 0; i < cantNodos && !encontrado; i++){
            if(nodos[i].equals(n)){
                pos = i;
                encontrado = true;
            }
        }
        return pos;
    } 

    private int gradoNodo(String n){
        int grado = -1;
        int posNodo = posNodo(n);
        if(posNodo != -1){
            grado = 0;
            grado += listaAdy[posNodo].size();
        } 
        return grado;
    }
    
    public String[] busquedaAvara(String[] colores) {
        boolean[] visitados = new boolean[cantNodos];
        String[] etiquetas = new String[cantNodos];
        Queue<String> cola = new LinkedList<>();
        etiquetas[posNodo(nodos[0])] = colores[0];
        cola.add(nodos[0]);
        String actual;
        int mejorColor;
    
        while (!cola.isEmpty()) {
            actual = cola.poll();
            int posActual = posNodo(actual);
            visitados[posActual] = true;
            ArrayList<Nodo> vecinos = listaAdy[posActual];
            ArrayList<String> etiVecinos = new ArrayList<>();

            for (Nodo vecino : vecinos) {
                int posVecino = posNodo(vecino.getDestino());
                if (!visitados[posVecino]) {
                    cola.add(vecino.getDestino());
                } else {
                    etiVecinos.add(etiquetas[posVecino]);
                }
            }
    
            // Agregar información de heurística y decisión tomada
            System.out.println("Actual: " + actual);
            System.out.println("Vecinos: " + etiVecinos.toString());
            
            mejorColor = menorValorHeuristica(colores, etiquetas, etiVecinos);
            etiquetas[posActual] = colores[mejorColor];
    
            // Imprimir la decisión tomada
            System.out.println("Mejor color para " + actual + ": " + etiquetas[posActual]);
            System.out.println("------------------------------");
        }
    
        return etiquetas;
    }
    
    private int menorValorHeuristica(String[] colores, String[] etiqs, ArrayList<String> etiVec) throws RuntimeException {
        int valorActu, valorMenor, res;
        valorMenor = Integer.MAX_VALUE;
        res = -1;
    
        for (int i = 0; i < colores.length; i++) {
            int cant = 0;
            if (etiVec.contains(colores[i])) {
                cant = Integer.MAX_VALUE;
            } else {
                for (String c : colores) {
                    if (usaColor(c, etiqs) || colores[i].equals(c)) {
                        cant += 1;
                    }
                }
            }
    
            valorActu = Math.abs(colores.length - cant);
    
            // Agregar información de heurística
            System.out.println("Color " + colores[i] + " - Valor de heurística: " + valorActu);
    
            if (valorActu < valorMenor) {
                valorMenor = valorActu;
                res = i;
            }
        }
    
        if (res == -1 || valorMenor >= (Integer.MAX_VALUE - colores.length)) {
            throw new RuntimeException("No se puede terminar de colorear el mapa");
        }
    
        return res;
    }
    
    private boolean usaColor(String color, String[] etiquetas){
        boolean usa = false;
        for(int i = 0; i < etiquetas.length && !usa; i++){
            if(etiquetas[i] != null){
                if(etiquetas[i].equals(color)){
                    usa = true;
                }
            }
        }
        return usa;
    }
    
    public void mostrar(){
        for(int i = 0; i < cantNodos; i++){
            System.out.println(nodos[i] + " -> " + listaAdy[i].toString());
        } 
    }
}