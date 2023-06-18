/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Solicitud {
    private String codSolicitud;
    private String codPerfil;
    private String email;
    private String codPerfilSo;
    private String nombre;
    private String nik;

    public Solicitud(String codSolicitud, String codPerfil, String email, String codPerfilSo, String nombre, String nik) {
        this.codSolicitud = codSolicitud;
        this.codPerfil = codPerfil;
        this.email = email;
        this.codPerfilSo = codPerfilSo;
        this.nombre = nombre;
        this.nik = nik;
    }

    public String getCodSolicitud() {
        return codSolicitud;
    }

    public String getNik() {
        return nik;
    }

    public String getNombre() {
        return nombre;
    }
    

    public String getCodPerfil() {
        return codPerfil;
    }

    public String getCodPerfilSo() {
        return codPerfilSo;
    }

    public String getEmail() {
        return email;
    }

    public void setCodPerfil(String codPerfil) {
        this.codPerfil = codPerfil;
    }

    public void setCodPerfilSo(String codPerfilSo) {
        this.codPerfilSo = codPerfilSo;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
