# **Metodologías de Búsqueda**

Para la aplicación de las metodologías se tomo en cuenta los siguientes problemas:

## **_Requerimientos_**

- Java JDK (de preferencia versión 20)
- BlueJ u otro IDE para ejecutar código Java.

## **_Problema de los jarros_**

Tiene tres jarros, con capacidades 12 galones, ocho galones, y tres galones, y un grifo
de agua. Usted puede llenar los jarros o vaciarlos de uno a otro o en el suelo. Tiene
que obtener exactamente un galón.

### _Metodologías usadas_

#### **Búsqueda no informada - Límite iterativo**

Pasos para hacer correr el programa:
1. Abrir la carpeta `busqueda_no_informada - profundidad iterativa` con su IDE de preferencia.
2. Compilar el proyecto.
3. Ejecutar el archivo Main llamado `BusquedaDeJarrones.java`
   1.En caso de que quiera cambiar los valores de las jarras puede hacerlo cambiando los valores de su creacion en la clase Main. Ej: Jarron jarra1 = new Jarron(capacidadMaximaDelJarron,aguaAlmacenada);
   2. En caso de que quiera cambiar el valor del objetivo final puede cambiar la siguiente linea de codigo en la clase Main: BusquedaHijos buscar = new BusquedaHijos(jarra1,jarra2,jarra3,ObjetivoFinal);
4. El resultado de la busqueda se podra observar en la terminal.
**Observaciones**
-El resultado se imprimira desde el resultado final hasta el inicio.

#### **Búsqueda informada - A\***

Pasos para hacer correr el programa:

1. Abrir la carpeta `/problema jarron/busqueda informada - a estrella` con su IDE de preferencia.
2. Compilar el proyecto.
3. Ejecutar el archivo `Main`.
   1. Opcionalmente previo a ejecutar el archivo `Main` puede modificar el caso de prueba, para ello necesitará modificar el siguiente código:
      - Usar la clase `WaterJug` para indicar el contenido máximo del jarrón. Por ejemplo: `new WaterJug(3)` creará un jarron con 3 litros de agua como máximo.
      - Si desea agregar o quitar jarrones puede agregar o eliminar elementos de `List<WaterJug> waterJugs` que es una lista de jarrones.
      - Si desea modificar la cantidad objetivo que se busca tener en alguno de los jarrones debe modificar el valor de la variable `int goal`.
4. Observar los resultados impresos en la terminal.

**Observaciones**

- En caso de haber recorrido todos los estados posibles el programa le mostrará el mensaje de `No se puede resolver el problema!`.

## **_Problema del mapa coloreado_**

Coloree un mapa plano utilizando sólo cuatro colores, de tal modo que dos regiones adyacentes no tengan el mismo color.

### _Metodologías usadas_

#### **Búsqueda no informada - Profundidad limitada**

Pasos para hacer correr el programa:
1. Abrir la carpeta `/problema mapa/busqueda no  informada - profundidad limitada` con su IDE de preferencia.
2. Compilar el proyecto.
3. Ejecutar el archivo `Main`.
   1. Opcionalmente previo a ejecutar el archivo `Main` puede modificar el caso de prueba, para ello necesitará modificar el siguiente código:
      - Usar la clase `Grafo` para indicar la cantidad de espacios a colorear. Por ejemplo: `addNodo(6)` creará 6 espacios para colorear.
4. Observar los resultados impresos en la terminal.

**Observaciones**

- En caso de haber recorrido todos los estados posibles el programa le mostrará el mensaje de `NO es un grafo planar!`.

#### **Búsqueda informada - Avara**

Pasos para hacer correr el programa:
1. Abrir la carpeta `/problema mapa/Busqueda informada - Avara`
2. Compilar el proyecto
3. Ejecutar el archivo `PruebaMapa`
   - Se manda una lista de colores a la busqueda la cual determinara la cantidad de colores que se deben usar y
     los colores que se van a usar
   - Funciona para n colores
   - Funciona para cualquier cantidad de regiones
   - Si no se encuentra una solucion, se manda un mensaje de error diciendo que no se pudo pintar el mapa
5. Observar los resultados, se tiene el ejemplo de dos mapas representados en grafos y con las decisiones tomadas
   por la busqueda en funcion a la heuristica utilizada
