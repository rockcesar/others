/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonbuilderamt;

/**
 *
 * @author alberto
 */
public class JsonBuilderAMT {
    private String valores;

    public JsonBuilderAMT() {
        this.valores = new String();
    }
    
   //Método para agregar los nodos del JSON
   public void agregar(String nombre, String nombres[], String valores[], boolean valores_array)
   {
       //Arreglo de nombre:valor
       if(valores.length == 1)
       {
           //Hago un Try Catch para verificar si es un entero, y así no colocarle las comillas
           //Si no es integer, le coloco las comillas.
           try {
                int valor = Integer.parseInt(valores[0]);
                this.valores += "\"" + nombre + "\":" + valor + ",";
           }catch (Exception e) {
                this.valores += "\"" + nombre + "\":\"" + valores[0] + "\",";
           }
       }
       else
       {
           //Si valores_array es true, construyo el array
           if(valores_array)
           {
                String cadena = "";
                for(int i = 0; i < valores.length; i++)
                {
                    //Hago un Try Catch para verificar si es un entero, y así no colocarle las comillas
                    //Si no es integer, le coloco las comillas.
                    try {
                        int valor = Integer.parseInt(valores[i]);
                        cadena += valor + ",";
                    } catch (Exception e) {
                        cadena += "\"" + valores[i] + "\",";
                    }
                }
                //Le quito la coma
                if(cadena.length() > 0)
                {
                      cadena = cadena.substring(0, cadena.length()-1);
                }
                cadena = "[" + cadena + "]";
                this.valores += "\"" + nombre + "\":" + cadena + ",";
           }else
           {
               // Si no es un arreglo, sino que es un JSON dentro de un JSON.
                String cadena = "";
                for(int i = 0; i < valores.length; i++)
                {
                    cadena += "\"" + nombres[i] + "\":\"" + valores[i] + "\",";
                }
                if(cadena.length() > 0)
                {
                      cadena = cadena.substring(0, cadena.length()-1);
                }
                cadena = "{" + cadena + "}";
                this.valores += "\"" + nombre + "\":" + cadena + ",";
           }
       }
   }
   
   //Método que obtiene el JSON
   public String getAMTJson()
   {
       String valores_1 = "";
       //Le quita la última coma al body
       if(this.valores.length() > 0)
       {
            valores_1 = this.valores.substring(0, this.valores.length()-1);
       }
       return "{" + valores_1 + "}";
   }
   
   //Método para buscar un value dentro del JSON, por un name dado.
   public String getValor(String name)
   {
       //Cambiamos el TokenString por una búsqueda manual, usando for e if.
       //Obtengo el JSON quitándole la primera llave y la última llave.
       String body = this.valores.substring(1, this.valores.length()-1);
       String nombre = "";
       String valor = "";
       boolean get_name = true;
       
       for(int i = 0; i < body.length(); i++)
       {
           //Recorro el String. Si está en get_name==true, entonces busca el name.
           //name significa el lado izquierdo de clave valor en JSON
           //"name":"valor"
           //Busca el caracter que sea diferente a ':', ',' ó '"'. 
           //Mientras sea diferente a esos caracteres
           //significa que es el name.
           if(get_name)
           {
               if(body.charAt(i) != ':' && body.charAt(i) != ',' && body.charAt(i) != '"')
               {
                   nombre += body.charAt(i);
               }else if(body.charAt(i) == ':')
               {
                   get_name = false;
               }
           }else
           {
               //Sino si get_name==false, busco entonces el valor.
               if(body.charAt(i) != ':' && body.charAt(i) != ',' && body.charAt(i) != '"')
               {
                   //Si buscamos un JSON dentro del JSON
                   if(body.charAt(i) == '{')
                   {
                       int j = i;
                       while(j < body.length() && body.charAt(j) != '}')
                       {
                           valor += body.charAt(j);
                           j++;
                       }
                       valor = valor + "}";
                       i = j;
                       if(nombre.equals(name))
                       {
                            return valor;
                       }
                   //Si buscamos un Arreglo dentro del JSON
                   }else if(body.charAt(i) == '[')
                   {
                       int j = i;
                       while(j < body.length() && body.charAt(j) != ']')
                       {
                           valor += body.charAt(j);
                           j++;
                       }
                       valor = valor + "]";
                       i = j;
                       if(nombre.equals(name))
                       {
                            return valor;
                       }
                   }else //Si es un cualquier otro valor
                   {
                       valor += body.charAt(i);
                   }
               }
           }
           
           //Si la coma se encuentra, significa que encontró un par clave:valor.
           //Si la clave es igual a name, retorna el valor.
           if(body.charAt(i) == ',')
           {
               get_name = true;
               if(nombre.equals(name))
               {
                    return valor;
               }
               nombre = "";
               valor = "";
           }
       }
       return "";
   }
}
