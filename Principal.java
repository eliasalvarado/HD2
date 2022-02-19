/*
Clase Main. Sera la clase que conecte el programa con el usuario.
Autor2: Elías Alvarado | 21808
Fecha: 19 de febrero del 2022
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Principal
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String ruta = "";
        boolean buclePrincipal = true;
        boolean bucle = true;

        System.out.println("\nBienvenido, este programa simulara una calculadora para expresiones Postfix manejando lectura de datos de\nun archivo de texto (.txt).");

        while(bucle)
        {
            System.out.println("\nPor favor, ingrese la ruta de su archivo de tipo texto.");
            ruta = scanner.nextLine();
            ruta = ruta + "\\datos.txt";
            try {
                File texto = new File(ruta);
                Scanner lectura = new Scanner(texto);
                System.out.println("\nNo. Linea\tResultado");
                int i = 1;
                while(lectura.hasNextLine())
                {
                    System.out.println(i + "\t\t" + lectura.nextLine());
                    i++;
                }
                bucle = false;
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("\nNo se pudo leer el documento. Por favor, asegurese que la ruta sea la correcta.");
                bucle = true;
            }
        }
        
        
        
    }
    
}
