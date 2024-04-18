package com.mycompany.divisax;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ComunicacionAPI {
    
    public Divisa informacionDivisas(String base, String target) {
        Divisa resultadoDivisa =  null;
        try{
        //Solicitud y respuesta a API exChange
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create("https://v6.exchangerate-api.com/v6/482bd76f99b196223709930e/pair/"+base+"/"+target);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        
        Gson gsn = new GsonBuilder().create();
         resultadoDivisa = gsn.fromJson(response.body(), Divisa.class);
         
        }catch(IOException | InterruptedException e){
            System.out.println(e);
        }
        
        return resultadoDivisa;
    }
    
}
