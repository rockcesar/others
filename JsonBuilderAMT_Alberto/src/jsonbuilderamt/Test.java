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
public class Test {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Crea el objeto y va agregando los valores clave:valor
        JsonBuilderAMT json = new JsonBuilderAMT();
        String valor[] = new String[1];
        //String JSON
        valor[0] = "Alberto";
        //Si está el true es un array
        //Si está el false es un string o int
        json.agregar("nombre", new String[0], valor, false);
        
        //Integer de JSON
        valor[0] = "26";
        //Si está el true es un array
        //Si está el false es un string o int
        json.agregar("edad", new String[0], valor, false);
        
        //JSON dentro de un JSON
        String nombres[] = new String[2];
        valor = new String[2];
        nombres[0] = "direccion";
        valor[0] = "Calle 123";
        nombres[1] = "direccion";
        valor[1] = "Calle 456";
        //Si está el true es un array
        //Si está el false es un string o int
        json.agregar("direcciones", nombres, valor, false);
        
        //Array de Strings
        valor = new String[2];
        valor[0] = "Medicina";
        valor[1] = "Ingeniería";
        //Si está el true es un array
        //Si está el false es un string o int
        json.agregar("carreras", new String[0], valor, true);
        
        //Array y integer
        valor = new String[3];
        valor[0] = "5";
        valor[1] = "8";
        valor[2] = "10";
        //Si está el true es un array
        //Si está el false es un string o int
        json.agregar("horas_del_dia", new String[0], valor, true);   
        
        //Imprime AJson
        System.out.println(json.getAMTJson());
        System.out.println(json.getValor("edad"));
        System.out.println(json.getValor("nombre"));
        System.out.println(json.getValor("direcciones"));
        System.out.println(json.getValor("carreras"));
        System.out.println(json.getValor("horas_del_dia"));
        //System.out.println(json.getValor("estatura"));
    }
}
