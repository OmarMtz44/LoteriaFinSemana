/*
 Hallar la menor frecuencia de los valores en cada linea tomando en cuenta el limite k
 */
package loteria;

import java.io.*;
import java.util.*;

/**
 *
 * @author Omar_
 */
public class Loteria {
    
    
    
    public static void main(String[] args) {
        int [] count;
        int n=1;
        boolean primero;
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe los valores para n, c y k (Escribir 0 para terminar el programa):");
        while ((n =sc.nextInt())>0) //
        {           
            try {
            if(n > 10000)
            {
            System.out.println("No pueden haber mas de 10000 sorteos");
            System.exit(0);
            }
            int c=sc.nextInt();
            if(c>10)
            {
            System.out.println("No puede haber mas de 10 numeros por sorteo");
            System.exit(0);
            }
            int k=sc.nextInt();
            if(k>100)
            {
            System.out.println("No pueden salir numeros mayores a 100 en el sorteo");
            System.exit(0);
            }
            count = new int [101]; //Max k = 100
            for(int i=0; i<n ; i++)//For desde primer sorteo hasta el ultimo
            {
                System.out.println("Escribe los resultados del sorteo número " +(i+1) +":");
                for(int j=0 ; j<c ; j++)//For cantidad de numeros que puedes ingresar por sorteo
                {
                    
                    int x = sc.nextInt(); //Guardar el numero que se ingreso
                    if(x < 0 | x>k)
                    {
                    System.out.println("Ingresaste un numero invalido");
                    System.exit(0);
                    }
                    count[x]++; //Aumenta en uno el numero de veces que se ha repetido (count)
                }
            }
            int min = c;
            for (int i=1 ; i<= k ; i++) //Recorrer los valores de repeticion de todos los numeros posibles
            {
                if(count[i] < min)                
                    min = count[i]; //Guardar minimo que se repite un numero                         
            }
            primero = true;
            System.out.println("Los numeros que menos se repiten son: ");
            for(int i=1; i <=n ; i++)//For desde primer sorteo hasta el ultimo
            {
                if(count[i] == min)//Si el count de repeticiones es igual al minimo, entra al ciclo
                {
                    if(!primero)                    
                        System.out.print(" "); //Separar los que menos se repiten con un espacio si no es el primero a mostrar
                    primero = false;
                    System.out.print(i); //Imprimir el numero si es igual al minimo de veces que se repite alguno
                }
            }
            System.out.print("\n");
            System.out.println("Escribe los valores para n, c y k (Escribir 0 para terminar el programa):");
        }
        catch(Exception e){
        System.out.println("Ingresaste un caracter invalido, error: \n" +e);
        System.exit(0);
        }
        }
        System.out.println("Fin del programa");
    }
    
}
