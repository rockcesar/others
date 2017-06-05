/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationjsonbuilder;

import java.math.BigDecimal; 
import java.math.BigInteger; 
import java.time.LocalDateTime; 
import java.util.Objects; 
import javax.json.Json; 
import javax.json.JsonArrayBuilder; 
import javax.json.JsonObject; 
import javax.json.JsonObjectBuilder; 
import javax.json.JsonValue; 

/**
 *
 * @author rockcesar
 */
public class JavaApplicationJsonBuilder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Builder b = new Builder();
        
        String [] extra = {"data_1", "data_2"};
        JsonObject result = b.build("ID del reporte", "Título 1", "Subtitulo", "Descripción", extra);
        
        System.out.println(result.toString());
        
    }
}

class Builder
{
    JsonObject build(String ID_reporte, String titulo, String subtitulo, String descripcion, String [] extra)
    {
        JsonObjectBuilder report = Json.createObjectBuilder();
        
        for(int i=0; i < extra.length; i++)
        {
            report.add("extra_"+(i+1), extra[i]);
        }
        
        LocalDateTime created = LocalDateTime.now();
        
        Objects.requireNonNull( ID_reporte, "Sin ID de reporte" ); 
        Objects.requireNonNull( titulo, "Sin título" ); 
 
        JsonObjectBuilder b = Json.createObjectBuilder(). 
                add( "reporte", Json.createObjectBuilder(). 
                     add( "ID_reporte", ID_reporte ). 
                     add( "titulo", titulo ). 
                     add( "subtitulo", subtitulo ). 
                     add( "creado", created.toString() ). 
                     add( "descripcion", descripcion ). 
                     add( "data", report ) 
                );
 
        return b.build();
    }
}
