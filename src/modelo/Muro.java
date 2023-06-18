/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Muro {
    private ArrayList<Publicacion> pubs;

    public Muro() {
        pubs = new ArrayList<Publicacion>();
    }
    
    public ArrayList<Publicacion> getPubs() {
        return pubs;
    }
    public void setPubs(ArrayList<Publicacion> pubs) {
        this.pubs = pubs;
    }

    public void agregarPublicacion(Publicacion pub){
        pubs.add(pub);
    }
    
}
