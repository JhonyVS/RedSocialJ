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
public class Perfil {
    
    private String codigoPe;
    private String portada;
    private String avatar;
    private String icono;
    private String codU;
    private String estado;
    private String universidad;
    private String colegio;
    private String trabajo;
    private String religion;
    
    private Muro muro; 
    private ArrayList<Contacto> contactos;

    public Perfil(String portada, String avatar,String icono, String codU, String estado, String universidad, String colegio, String trabajo, String religion) {
        this.portada = portada;
        this.avatar = avatar;
        this.icono=icono;
        this.codU = codU;
        this.estado = estado;
        this.universidad = universidad;
        this.colegio = colegio;
        this.trabajo = trabajo;
        this.religion = religion;
        
        this.muro = new Muro();
        contactos = new ArrayList<Contacto>();
    }

    public Perfil(String codigoPe, String portada, String avatar, String icono, String codU, String estado, String universidad, String colegio, String trabajo, String religion) {
        this.codigoPe = codigoPe;
        this.portada = portada;
        this.avatar = avatar;
        this.icono = icono;
        this.codU = codU;
        this.estado = estado;
        this.universidad = universidad;
        this.colegio = colegio;
        this.trabajo = trabajo;
        this.religion = religion;
        
        this.muro = new Muro();
        this.contactos = new ArrayList<Contacto>();
    }
    
    
    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
    
    
    
    public String getColegio() {
        return colegio;
    }

    public String getReligion() {
        return religion;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public String getUniversidad() {
        return universidad;
    }


    public Perfil() {
        
    }

    public Muro getMuro() {
        return muro;
    }
    
    public void setCodigoPe(String codigoPe) {
        this.codigoPe = codigoPe;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getCodU() {
        return codU;
    }

    public String getCodigoPe() {
        return codigoPe;
    }

    public String getEstado() {
        return estado;
    }


    public String getPortada() {
        return portada;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }
    
    public void eliminarContacto(String email){
        int i=0;
        boolean encontre = false;
        while (i<contactos.size() || !encontre) {
            if(contactos.get(i).getEmail().equals(email)){
                contactos.remove(i);
                encontre = true;
            }
            i++;
        }
    }
    
}
