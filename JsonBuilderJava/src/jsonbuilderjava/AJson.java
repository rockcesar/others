/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonbuilderjava;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos Terán
 */
public class AJson {
    //Variable que contendrá todo el JSON, de tipo List
    private final List values = new ArrayList();
    
   //Método para agregar los nodos del JSON
   public void add(String name, String value)
   {
       //Arreglo de nombre:valor
       String [] node = new String[2];
       node[0] = name;
       node[1] = value;
       //Se agrega al nodo
       values.add(node);
   }
   
   //Método que obtiene el JSON
   public String getAJson()
   {
       //Variable para contener el cuerpo del JSON
       String body = "";
       //Arreglo de nombre:valor
       String [] json_values;
       //Recorre la variable values, de tipo List y va agregando los valores al cuerpo, parecido al ejemplo de la profesora
       for(int i = 0; i < this.values.size(); i++)
       {
           json_values = (String[])this.values.get(i);
           body += "\"" + json_values[0] + "\":\"" + json_values[1] + "\",";
       }
       
       //Le quita la última coma al body
       if(body.length() > 0)
       {
            body = body.substring(0, body.length()-1);
       }
       return "{" + body + "}";
   }
   
   //Método para buscar un value dentro del JSON, por un name dado.
   public String getValueByName(String name)
   {
       String [] json_values;
       /*Recorre la variable values, de tipo List
        * Si json_values[0] (name), es el pasado por parámetro, devuelve
        * json_values[1] (value)
        */
       for(int i = 0; i < this.values.size(); i++)
       {
           json_values = (String[])this.values.get(i);
           if(json_values[0].equals(name))
           {
                return json_values[1];
           }
       }
       return "";
   }
}
