/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Usuario {
    private String nom; 
    private String ape;
    private String nik;
    private String password;
    private String email;
    private String pais;
    private String ciudad;
    private int fono;
    private String sexo;
    private String codU;
    
    private Perfil perfil;
    public Usuario(String nom, String ape, String nik, String password, String email, String pais, String ciudad, int fono, String sexo) {
        this.nom = nom;
        this.ape = ape;
        this.nik = nik;
        this.password = password;
        this.email = email;
        this.pais = pais;
        this.ciudad = ciudad;
        this.fono = fono;
        this.sexo = sexo;
        
        perfil = new Perfil();
    }
 
    public Usuario() {
        
    }

    public Perfil getPerfil() {
        return perfil;
    }
    

    public String getNom() {
        return nom;
    }

    public String getApe() {
        return ape;
    }

    public String getEmail() {
        return email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getFono() {
        return fono;
    }

    public String getPais() {
        return pais;
    }

    public String getPassword() {
        return password;
    }

    public String getNik() {
        return nik;
    }

    public String getSexo() {
        return sexo;
    }
    public void insertarCodigo(String cod){
        this.codU = cod;
    }
    
    public String getCodU() {
        return codU;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
    

    @Override
    public String toString() {
        return codU+": "+nom+" "+ape+" "+nik+" "+email+" "+fono+" "+sexo+" "+pais+" "+ciudad;
    }
    
    
    
    
    
}
