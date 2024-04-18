package com.mycompany.divisax;
import java.util.Scanner;

public class Divisax {

    public static void main(String[] args) {
        
        ComunicacionAPI comunica = new ComunicacionAPI();
        ConversorDivisas conver = new ConversorDivisas();
        
        try{
                    Scanner teclado = new Scanner(System.in);
        System.out.println("""
                            -------  Ejemplo de divisas disponibles para conversi\u00f3n -------- 
                           \t\t["USD","United States Dollar"],
                           \t\t["CLP","Chilean Peso"],
                           \t\t["BRL","Brazilian Real"],
                           \t\t["ARS","Argentine Peso""");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Ingrese divisa que desea convetir.. ");
        System.out.println("De:  ");
        String base = teclado.nextLine();
        System.out.println("Hacía divisa: ");
        String target = teclado.nextLine();
        System.out.println("Ingrese cantidad a convertir: ");
        Double cantidadAConvertir = teclado.nextDouble();
        
            Divisa resultado = comunica.informacionDivisas(base, target);            
            Double resultadoDecimal = conver.convercionDeMoneda(resultado.conversion_rate(), cantidadAConvertir);
            
            System.out.println(resultadoDecimal);
        }catch(NullPointerException e){
            System.out.println("Por favor ingrese un moneda valida a convertir siguiendo el formato indicado");
        }
            

        

        
    }
}
