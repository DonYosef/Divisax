package com.mycompany.divisax;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Divisax {

    public static void main(String[] args) {
        
        ComunicacionAPI comunica = new ComunicacionAPI();
        ConversorDivisas conver = new ConversorDivisas();
        
        Scanner teclado = new Scanner(System.in);
        System.out.println(" -------  Ejemplo de divisas disponibles para conversión -------- \n"+
"		[\"USD\",\"United States Dollar\"],\n" +
"		[\"CLP\",\"Chilean Peso\"],\n" +
"		[\"BRL\",\"Brazilian Real\"],\n" +
"		[\"ANG\",\"Netherlands Antillian Guilder\"],\n" +
"		[\"AOA\",\"Angolan Kwanza\"],\n" +
"		[\"ARS\",\"Argentine Peso\"],\n" +
"		[\"BBD\",\"Barbados Dollar\"] etc. etc. ");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Ingrese divisa que desea convetir.. ");
        System.out.println("De:  ");
        String base = teclado.nextLine();
        System.out.println("Hacía divisa: ");
        String target = teclado.nextLine();
        System.out.println("Ingrese cantidad a convertir: ");
        int cantidadAConvertir = teclado.nextInt();
        
            Divisa resultado = comunica.informacionDivisas(base, target);
            System.out.println("La tasa de conversion aplicada es: "+resultado);
            
            Double result = conver.convercionDeMoneda(resultado.conversion_rate(),cantidadAConvertir);
            BigDecimal redondeado = BigDecimal.valueOf(result).setScale(2, RoundingMode.HALF_UP);
            
            System.out.println(redondeado); 


        

        
    }
}
