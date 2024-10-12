public class Main {
    public static void main(String[] args) {
        boolean cierre = false;
        do {
           Funciones clases = new Funciones();
           int [][] matriz = clases.crearMatriz();
           clases.cargarMatriz(matriz);
            System.out.println("----------------MATRIZ--------------------------");
           clases.mostrarMatriz(matriz);
           int [] array = clases.obtenerValoresCentrales(matriz);
           System.out.println("----------------ARRAY DESORDENADO----------------");
           clases.mostrarArray(array);
           clases.metodoBurbuja(array);
           System.out.println("-----------------ARRAY ORDENADO------------------");
           clases.mostrarArray(array);
           double promedio = clases.calcularPromedioDeMatrices(matriz,array);
            System.out.println("--------------------------------------------------");
           System.out.println("El promedio de ambas matrices es:  " + promedio);
            System.out.println("--------------------------------------------------");
           cierre = clases.terminarPrograma();
       }while(cierre);
    }
}
