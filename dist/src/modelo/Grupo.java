/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Grupo {
    
    private String codG;
    private String nomG;
    private String descripcion;
    private String intereses;
    private String emailFundador;
    

    public Grupo(String nomG, String descripcion, String intereses, String emailFundador) {
        this.nomG = nomG;
        this.descripcion = descripcion;
        this.intereses = intereses;
        this.emailFundador = emailFundador;
    }

    public Grupo() {
        
    }

    public String getCodG() {
        return codG;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEmailFundador() {
        return emailFundador;
    }

    public String getIntereses() {
        return intereses;
    }

    public String getNomG() {
        return nomG;
    }

    public void setCodG(String codG) {
        this.codG = codG;
    }
    
}
