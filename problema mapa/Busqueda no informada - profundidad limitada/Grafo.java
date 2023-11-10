import java.util.*;

class Grafo {
  private ArrayList <Nodo> nodos;
  private ArrayList <Arista> aristas;
  private String[] color = new String[5];

  Grafo() {
    aristas = new ArrayList<Arista>();
    nodos = new ArrayList<Nodo>();
    this.color[0] = "negro";       //sin color (negro)
    this.color[1] = "azul";     //color 1 (azul)
    this.color[2] = "rojo";     //color 2 (rojo)
    this.color[3] = "verde";     //color 3 (verde)
    this.color[4] = "amarillo";  //color 4 (amarillo)
  }

  //agregar un nodo al grafo
  public void addNodo(Nodo n) {
    for (int i=0; i<nodos.size(); i++) {
      if (n.y <= nodos.get(i).y) {
        nodos.add(i, n);
        return;
      }
    } 
    nodos.add(n);
  }

  //agregar una arista al grafo y ordenarlas por su coordenada y  
  public void addArista(Nodo a, Nodo b) {
    aristas.add(a.agregarVecino(b));
  }

  //mostrar el grafo
  public void mostrar() {
    for (Arista a : aristas) {
      a.mostrar();
    }
    for (Nodo n : nodos) {
      if (!n.mostrado) {
        n.mostrar();
      }
    }
  }

  //colorear el grafo
  public void colorear() {
    for (Nodo n : nodos) {
      int edoColores[] = new int[5]; 
      for (Nodo v : n.vecinos) {
        if (v.getColor() == c[0])   //si el vecino no tiene color
          edoColores[0]++;
        if (v.getColor() == c[1])  //si un vecino tiene el color 1;
          edoColores[1]++;
        if (v.getColor() == c[2])  //si un vecino tiene el color 2;
          edoColores[2]++;
        if (v.getColor() == c[3])  //si un vecino tiene el color 3;
          edoColores[3]++;
        if (v.getColor() == c[4])  //si un vecino tiene el color 4;
          edoColores[4]++;
      }
 
      //Si nungun vecino tiene color, colorear este nodo del color 1
      if (edoColores[0] == n.vecinos.size()) {   
        n.setColor(c[1]);
        continue;
      }
      if (edoColores[1] == 0) {   
        n.setColor(c[1]);
        continue;
      }
      //Si algun vecino ya es azul pintamos de rojo
      if(edoColores[2] == 0){
        n.setColor(c[2]);
        continue;
      }
      //Si algun vecino ya es rojo pintamos de verde
      if(edoColores[3] == 0){
        n.setColor(c[3]);
        continue;
      }
      //Si algun vecino ya es verde pintamos de amarillo
      if(edoColores[4] == 0){
        n.setColor(c[4]);
        continue;
      }
      if(edoColores[4] > 0){
        System.out.println("NO es un grafo planar!\n");
        n.setColor(c[0]);
        return;
      }
    }
   // print("Los nodos negros no deberian de ir");
  }
}