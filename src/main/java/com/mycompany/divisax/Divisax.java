package com.mycompany.divisax;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Divisax {

    public static void main(String[] args) {
        
        ComunicacionAPI comunica = new ComunicacionAPI();
        ConversorDivisas conver = new ConversorDivisas();
        Double resultadoFinal = 0.0;
        
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
            
            if(target.equalsIgnoreCase("USD")){
                resultadoFinal = conver.redondear(resultadoDecimal);
            }else{
                resultadoFinal = conver.redondearSinDecimal(resultadoDecimal);
            }
            
            System.out.println(resultadoFinal);
        }catch(NullPointerException e){
            System.out.println("Por favor ingrese un moneda valida a convertir siguiendo el formato indicado");
        }catch(InputMismatchException e){
            System.out.println("Por favor ingrese una cantidad valida en el formato, ejemplo: 10,22");
        }
            

        

        
    }
}
