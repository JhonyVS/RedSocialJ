/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Contacto extends Miembro{
    
    private String codPerfil;
    private String codC;
    
    public Contacto(String email, String nik, String nombre,String codPe) {
        super(email, nik, nombre);
        this.codPerfil=codPe;
    }
    
    public Contacto(String email, String nik, String nombre) {
        super(email, nik, nombre);
    }
    
    public Contacto() {
    }

    public void setCodPerfil(String codPerfil) {
        this.codPerfil = codPerfil;
    }
    
    public String getCodC() {
        return codC;
    }

    public void setCodContacto(String codC) {
        this.codC = codC;
    }
    

    public String getCodPerfil() {
        return codPerfil;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
      
}
