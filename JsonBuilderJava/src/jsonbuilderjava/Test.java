/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonbuilderjava;

/**
 *
 * @author Carlos Terán
 */
public class Test {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Crea el objeto y va agregando los valores clave:valor
        AJson json = new AJson();
        json.add("nombre", "Ana");
        json.add("edad", "10");
        
        //Imprime AJson
        System.out.println(json.getAJson());
        System.out.println(json.getValueByName("edad"));
        System.out.println(json.getValueByName("nombre"));
    }
    
}
