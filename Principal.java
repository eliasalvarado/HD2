/**
 * Clase Main. Sera la clase que conecte el programa con el usuario.
 * @author Elías Alvarado | 21808
 * Fecha: 19 de febrero del 2022
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Principal
{
    /** 
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String ruta = "";
        boolean bucle = true;
        String linea = "";

        CalculadoraErick calculadora = new CalculadoraErick();
        //Calculadora calculadora = new Calculadora();

        System.out.println("\nBienvenido, este programa simulara una calculadora para expresiones Postfix manejando lectura de datos de\nun archivo de texto (.txt).");
        while(bucle)
        {
            System.out.println("\nPor favor, ingrese la ruta de su archivo de tipo texto.");
            ruta = scanner.nextLine();
            ruta = ruta + "\\datos.txt";
            try {
                File texto = new File(ruta);
                Scanner lectura = new Scanner(texto);
                System.out.println("\nNo. linea\tExpresion\t\tResultado");
                int i = 1;
                while(lectura.hasNextLine())
                {
                    try {
                        linea = lectura.nextLine();
                        System.out.println(i + ".\t\t" + linea + "\t\t" + calculadora.Evaluate(linea));
                    } catch (Exception e) {
                        System.out.println(i + ".\t\t" + linea + "\t\tLa expresion no esta escrita correctamente.");
                    }
                    i++;
                }
                bucle = false;
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("\nNo se pudo leer el documento. Por favor, asegurese que la ruta sea la correcta.");
                if(pregunta("\n¿Desea intentar de nuevo?\n1. Si.\n2. No.\nRepuesta:", 2) == 1) bucle = true;
                else bucle = false;
            }
        }        
    }

    /** 
     * @param pregunta
    * @param opciones
    * @return int
    */
    public static int pregunta(String pregunta, int opciones)
    {
        boolean bucle = true;
        int respuesta = 0;
        Scanner scanner = new Scanner(System.in);
        try 
        {
            while(bucle)
            {
                System.out.println(pregunta);
                respuesta = scanner.nextInt();
                scanner.nextLine();
                if(respuesta > 0 && respuesta <= opciones) bucle = false;
                else System.out.println("\nRepuesta no valida.\n");
            }    
        } catch (Exception e) {
            System.out.println("\nRepuesta no valida. Ingrese solamente numeros.\n");
            respuesta = pregunta(pregunta, opciones);
        }
        return respuesta;
    }   
}