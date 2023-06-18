/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


/**
 *
 * @author Usuario
 */
public class Comentario {
    private String codCom;
    private String codU;
    private String codPub;
    private String autor;
    private String fecha;
    private String detalle;

    public Comentario(String codU, String codPub, String autor, String fecha, String detalle) {

        this.codU = codU;
        this.codPub = codPub;
        this.autor = autor;
        this.fecha = fecha;
        this.detalle = detalle;
    }

    public void setCodCom(String codCom) {
        this.codCom = codCom;
    }

    public Comentario() {
    }

    public String getCodCom() {
        return codCom;
    }

    public String getCodPub() {
        return codPub;
    }

    public String getCodU() {
        return codU;
    }

    public String getAutor() {
        return autor;
    }

    public String getDetalle() {
        return detalle;
    }

    public String getFecha() {
        return fecha;
    }
    
}
