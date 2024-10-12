import java.util.Locale;
import java.util.Scanner;

public class Funciones {
    Scanner sc = new Scanner(System.in);
    int filas;
    int columnas;
    public int[][] crearMatriz() {
        System.out.println("Consideraciones: \n *Matriz cuadrada \n *Filas y Columnas numeros impares \n *Tamaño números entre 3 y 15");
        System.out.println("Ingrese el valor entero para las Filas y para las Columnas");
        do {
            System.out.print("Filas:");
            filas = sc.nextInt();
            System.out.print("Columnas:");
            columnas = sc.nextInt();
            if (((filas <3) || (filas > 15)||(filas % 2 ==0)) && ((columnas <3) || (columnas > 15) || (columnas % 2 ==0)) || (columnas != filas)){
                System.out.println("Error uno o mas valores incorrectos");
            }
        } while (((filas <3) || (filas > 15)||(filas % 2 ==0)) && ((columnas <3) || (columnas > 15) || (columnas % 2 ==0)) || (columnas != filas));
        int[][] matriz = new int[filas][columnas];
        return matriz;
    }
    public void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + "\t");

            }
            System.out.println();
        }
    }
    public void cargarMatriz(int[][] matriz) {
        for (int i = 0; i < filas; i++) {
            do {
                System.out.println("Ingrese la pos " + "[" + filas + "]" + "[" + (i + 1) + "]");
                System.out.println("El numero tiene que ser mayor que 10 y menor que 90");
                matriz[filas - 1][i] = sc.nextInt();
                if ((matriz[filas - 1][i] < 10) || (matriz[filas - 1][i] > 90)) {
                    System.out.println("Número incorrecto vuelva a intentar");
                }
            } while ((matriz[filas - 1][i] < 10) || (matriz[filas - 1][i] > 90));
        }
        for (int j = 0; j < filas; j++) {
            for (int k = 0; k < columnas-1; k++) {
                matriz[k][j] = (int)(Math.random()*(90 -10)) +10 ;
                matriz[k][j] = (int)(Math.random()*(90 -10)) +10 ;
            }

        }
    }
    public int[] obtenerValoresCentrales(int[][]matriz) {
        int [] array = {(matriz[filas/2][columnas/2]),
                (matriz[(filas/2)-1][(columnas/2)-1]),
                (matriz[(filas/2)-1][(columnas/2)]),
                (matriz[(filas/2)-1][(columnas/2)+1]),
                (matriz[(filas/2)][(columnas/2)-1]),
                (matriz[(filas/2)][(columnas/2)+1]),
                (matriz[(filas/2)+1][(columnas/2)-1]),
                (matriz[(filas/2)+1][(columnas/2)]),
                (matriz[(filas/2)+1][(columnas/2)+1]),};
        return array;
    }
    public void mostrarArray(int [] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"\t");
        }
        System.out.println();
    }
    public static int[] metodoBurbuja(int[] cadena) {
        boolean intercambiado;
        do {
            intercambiado = false;
            for (int i = 1; i < cadena.length; i++) {
                if (cadena[i - 1] > cadena[i]) {
                    int aux = cadena[i - 1];
                    cadena[i - 1] = cadena[i];
                    cadena[i] = aux;
                    intercambiado = true;
                }
            }
        } while (intercambiado == true);
        return cadena;
    }
    public double calcularPromedioDeMatrices (int[][] matriz, int[] matrizValoresCentral){
        double sumaMatriz = 0;
        double sumaArray = 0;
        double promedioMatriz = 0;
        double promedioArray = 0;
        double promedioAmbas = 0;
        for(int i = 0; i < matrizValoresCentral.length; i++) {
            sumaArray += matrizValoresCentral[i];
        }
        promedioArray = sumaArray/(matrizValoresCentral.length);
        System.out.println("----------------CALCULOS ARRAY-------------------");
        System.out.println("Cantidad de elementos: " + matrizValoresCentral.length+ "\n"+"La suma total es: "+ sumaArray + "\n" + "El promedio es: " + promedioArray);
        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                sumaMatriz += matriz[i][j];
            }
        }
        promedioMatriz = sumaMatriz/(filas);
        System.out.println("---------------- CALCULOS MATRIZ-----------------");
        System.out.println("Cantidad de elementos: " + (filas*columnas)+ "\n"+"La suma total es: "+ sumaMatriz + "\n" + "El promedio es: " + promedioMatriz);
        promedioAmbas = (promedioArray+promedioMatriz)/2;
        return promedioAmbas;

    }
    public boolean terminarPrograma(){
        boolean condicion = false;
        System.out.println("Desea iniciar nuevamente la ejecución del programa? SI/NO");
        sc.nextLine();
        String respuesta = sc.nextLine().toLowerCase();
        if (respuesta.equals("si")) {
           condicion = true;
        }
        return condicion;
    }


}
