/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Publicacion {
    private String codPub;
    private String autor;
    private String fecha;
    private String detalle;
    private String codU;
    private String codPer;
    
    
    private ArrayList<Comentario> comentarios;
    /**
     * 
     * @param autor
     * @param fecha
     * @param detalle
     * @param codU
     * @param codPer 
     */
    public Publicacion(String autor, String fecha, String detalle, String codU, String codPer) {
        this.autor = autor;
        this.fecha = fecha;
        this.detalle = detalle;
        this.codU = codU;
        this.codPer = codPer;
        
        comentarios = new ArrayList<Comentario>();
        
    }

    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public void setCodPub(String codPub) {
        this.codPub = codPub;
    }
    
    public void agregarComentario(Comentario com){
        comentarios.add(com);
    }

    public String getCodPer() {
        return codPer;
    }

    public String getCodPub() {
        return codPub;
    }

    public String getCodU() {
        return codU;
    }

    public String getFecha() {
        return fecha;
    }
    
    public String getDetalle() {
        return detalle;
    }

    public String getAutor() {
        return autor;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public static void main(String[] arg){
        Date f = new Date();
        
        System.out.println(f);
    }
    
}
