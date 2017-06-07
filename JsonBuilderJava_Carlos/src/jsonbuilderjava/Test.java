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
        CFJson json = new CFJson();
        
        // Un sólo string
        String s[][] = new String[1][1];
        s[0][0] = "Ana";
        json.add("nombre", s);
        
        // Un JSON dentro del JSON
        s = new String[2][2];
        s[0][0] = "Primer apellido";
        s[0][1] = "Tribiani";
        s[1][0] = "Segundo apellido";
        s[1][1] = "Quevedo";
        json.add("apellidos", s);
        
        // Un sólo de int
        int integer[] = new int[1];
        integer[0] = 10;
        json.addInteger("edad", integer);
        integer[0] = 80;
        json.addInteger("peso", integer);
        
        // Un arreglo de int
        integer = new int[3];
        integer[0] = 20;
        integer[1] = 15;
        integer[2] = 18;
        json.addInteger("notas", integer);
        
        // Un arreglo de string
        String libros[] = new String[2];
        libros[0] = "Base de datos";
        libros[1] = "Java";
        json.addString("libros", libros);
        
        //Imprime AJson
        System.out.println(json.getCFJson());
        System.out.println(json.getValueByName("edad"));
        System.out.println(json.getValueByName("nombre"));
        System.out.println(json.getValueByName("peso"));
        System.out.println(json.getValueByName("apellidos"));
        System.out.println(json.getValueByName("notas"));
        System.out.println(json.getValueByName("libros"));
    }
    
}
