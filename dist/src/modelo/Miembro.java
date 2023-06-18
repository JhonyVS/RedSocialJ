/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Miembro {
    private String email;
    private String nik;
    private String nombre;

    public Miembro(String email, String nik, String nombre) {
        this.email = email;
        this.nik = nik;
        this.nombre = nombre;
    }

    public Miembro() {
    }

    
    public String getEmail() {
        return email;
    }


    public String getNik() {
        return nik;
    }

    public String getNombre() {
        return nombre;
    }
    public String toString(){
        return nombre+" "+nik+" "+email;
    }
    
}
