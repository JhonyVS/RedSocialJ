/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Integrante extends Miembro{
    private String codGrupo;
    private String codInt;
    public Integrante(String email, String nik, String nombre,String codGrupo) {
        super(email, nik, nombre);
        this.codGrupo=codGrupo;
    }

    public Integrante() {
    }
    
    public String getCodGrupo() {
        return codGrupo;
    }

    public String getCodInt() {
        return codInt;
    }

    public void setCodInt(String codInt) {
        this.codInt = codInt;
    }

    

    
}
