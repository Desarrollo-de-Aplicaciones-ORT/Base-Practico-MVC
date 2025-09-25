/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ort.da.mvc.facturas.modelo;

/**
 *
 * @author magda
 */
public class Cliente {
    
    private String nombre;
    private String cedula;
    private String email;

    public Cliente() {
        
    }

    public Cliente(String cedula, String nombre, String email) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getCedula() {
        return cedula;
    }

    public String getEmail() {
        return email;
    }
    
    public boolean setCedula(String unaCedula) {
       if(verificarCedula(unaCedula)){
            cedula = unaCedula;
            return true;
       }return false;
       
    }
    
    public boolean verificarCedula(String cedula){
        boolean ok = false;
        if (cedula !=null){
            int digitos = cedula.length();
            String numeros = "0123456789";
            boolean soloNumeros = true;
            cedula = cedula.toLowerCase();
            for (int x=0;x<cedula.length()&&soloNumeros;x++){
                String d = cedula.charAt(x)+"";
                if (!numeros.contains(d)){
                    soloNumeros = false;
                }
            }
           
            if (soloNumeros && digitos>=6&&digitos<=8){
                ok = true;
            }    
        }
        return ok;        
    
    }
    
    public boolean verificarNombre(){
          return this.getNombre()!=null && !this.getNombre().trim().equals("");
    }
     public boolean verificarEmail(){
          return this.getEmail()!=null && !this.getEmail().trim().equals("") 
                  && this.getEmail().contains("@") && this.getEmail().contains(".");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", cedula=" + cedula + '}';
    }

    public boolean validar() {
        return verificarCedula(cedula) && verificarNombre() && verificarEmail();
    }

   
    
   

   
    
}
