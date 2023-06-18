/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

/**
 *
 * @author Jhony Veizaga Sanchez
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 



import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level; 
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Comentario;
import modelo.Contacto;
import modelo.GeneradorDB;
import modelo.Miembro;
import modelo.Perfil;
import modelo.Publicacion;
import modelo.Solicitud;
import modelo.Usuario;

/**
 *
 * @author Usuario
 */
public class JDBC {
    private static JDBC jdbc = null;
    
    //conector con la base de datos
    private Connection con = null; 
    //instancia este objeto a partir del conector con
    private Statement stat; 
    //contraseña a la base de datos si es que tuviera, si no se deja vacio
    private String password = "";
    //nombre de la base de datos Acces con extension *.mdb o *.accdb
    private String dbName = "DataBase/BD.accdb";
    //direccion de la base de datos
    private String bd = System.getProperty("user.dir") + "//" + dbName + ";PWD=" + password;
    //driver para base de datos Access 2000, 2003, 2007, 2010
    private String url = "jdbc:odbc:;DRIVER=Microsoft Access Driver (*.mdb, *.accdb);DBQ=" + bd;
 
    public JDBC(){
        establecerConexionBaseDeDatos();   
        /*
         * el metodo llenarBD crea usuarios aleatoriamente.
         */
        //llenarBD();
        //modificar();
    }
    public static JDBC getJDBC(){
        if(jdbc != null){
            return jdbc;
        }else {
            jdbc = new JDBC();
            return jdbc;
        }
    }
    /**
     * este metodo nos permite establcer nuestra coneccion con la base de datos
     * en nuestro caso usaremos una base de datos Acces
     */
    private void establecerConexionBaseDeDatos() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
            con = (Connection) DriverManager.getConnection(url);
        } catch (Exception ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        try { 
            stat = (Statement) con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
     * Cerrar la conexion con la base de datos
     * @throws Exception 
     */
    public void closeDB() throws Exception{
        try {
            con.close();
            System.out.println("Base de datos cerrada");
        } catch (Exception e) {
            throw new Exception("No se pudo cerrar la conexion con la BD");
        }
    }
    /**
     * todos loa parametros necesarios para ingresar a la Base de Datos
     * @param nom
     * @param ape
     * @param nik
     * @param pass
     * @param pais
     * @param ciudad
     * @param email
     * @param fono
     * @param sexo 
     */
    public void agregarEntrada(String nom, String ape, String nik, String pass, String pais, 
                                String ciudad, String email, int fono,String sexo){
        try {
            stat.executeUpdate("INSERT INTO Usuario (nomU,apeU,nik,pass,pais,ciudad,email,fono,sexo) "
                    + "        VALUES('"+nom+"','"+ape+"','"+nik+"','"+pass+"','"+pais+"',"
                    + "                     '"+ciudad+"','"+email+"','"+fono+"','"+sexo+"')");
            String codU = getCodigoUsuario(email);
            /*
             * unis y cols son arreglos que forman parte del auto llenado de la 
             * base de datos.
             * "+unis[new java.util.Random().nextInt(unis.length)]+"
             * "+cols[new java.util.Random().nextInt(cols.length)]+"
             */
            //String[] unis = {"Universidad Mayor de San Simon","UDABOL","Catolica","UPAL","UNIVALLE","Universidad Central","UNIFRANZ","UNITEP","UPB","","","",""};
            //String[] cols = {"Sucre","Liceo Bolivia","Elena Arze","AMERINTS","Gualberto Villaroel","Adventista","Club de Leones","AISB","California","Avaroa","Mejillones"};
            stat.executeUpdate("INSERT INTO Perfil (urlAvatar,urlPortada,urlIcono,codU,estado,universidad,colegio,trabajo,religion) "
                             + "VALUES('Avatares/07.jpg','Portadas/universe.jpg','iconos/000.jpg','"+codU+"','Soltero','','','','')");
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error email invalido...\n"+ex.getMessage());
        }
    }
    /**
     * Este metodo realiza una consulta personalizada.
     * @param SQL es la instruccion SQL
     * @return ResultSet 
     */
    public ResultSet consultaPersonalizada(String SQL){
        ResultSet rs = null;
        try {
            rs = stat.executeQuery(SQL);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en la consulta \n"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
            System.err.println("Error de sintaxis+\n"+e.getMessage());
        }
        return rs;
    }
    /**
     * 
     * @param email es el email introducido en el login
     * @return Usuario es la respuesta si es que existe un usuario con el mismo log.
     */
    public Usuario getLogin(String email){
        Usuario u = null;
        try {
            ResultSet rs = stat.executeQuery(" SELECT * "
                                           + " FROM Usuario "
                                           + " WHERE email = "+"'"+email+"'");
            rs.next();
            
            u = crearUsuario(rs);
            u.setPerfil(getPerfil(u.getCodU()));
            complementarPerfil(u.getPerfil());
            
            
        } catch (Exception e) {
            System.out.println("Sentencia SQL erronea : "+e.getMessage());
        }
        return u;
    }
    
    public static void main(String[] arg){
        new JDBC();
    }

    private Usuario crearUsuario(ResultSet rs) {
        Usuario u = null;
        try {
            //(String nom, String ape, String nik, String password, String email, String pais, String ciudad, int fono, String sexo)
            u = new Usuario(rs.getString("nomU"), rs.getString("apeU"), rs.getString("nik"), rs.getString("pass"), rs.getString("email"), 
                            rs.getString("pais"), rs.getString("ciudad"), rs.getInt("fono"), rs.getString("sexo"));
            u.insertarCodigo(rs.getInt("codU")+"");
        } catch (Exception e) {
            System.out.println("Error al crearUsuario(ResultSet rs)..\n"+e);
        }
        return u;
    }

    private Perfil getPerfil(String codigoUsuario) {
        Perfil res = null;
        try {
            ResultSet rs = stat.executeQuery(" SELECT * "
                                           + " FROM Perfil "
                                           + " WHERE codU = "+codigoUsuario);
            rs.next();
            res = crearPerfil(rs);
        } catch (Exception e) {
            System.out.println("Error en getPerfil(String codUsuario)\n"+e);
        }
        return res;
    }
    public ResultSet buscar(String atrib,String ref){
        ResultSet rs = null;
        try {
            //Nombre","Apellido","E-mail","Pais","Ciudad","Universidad","Colegio"
            rs = stat.executeQuery(" SELECT DISTINCT nomU,apeU,email,pais,ciudad,universidad,colegio "
                                 + " FROM Usuario u ,Perfil p"
                                 + " WHERE u.codU = p.codU and "
                                 + atrib +" LIKE "+"'%"+ref+"%'");
        } catch (Exception e) {
            System.out.println("(Buscar(atrib,ref))Error en la consulta....\n"+e.getMessage());
        }
        return rs;
    }

    private Perfil crearPerfil(ResultSet rs) {
        Perfil res = null;
        try {
            res = new Perfil(rs.getString("urlPortada"),rs.getString("urlAvatar"),rs.getString("urlIcono"),rs.getInt("codU")+"",rs.getString("estado"),
                              rs.getString("universidad"),rs.getString("colegio"),rs.getString("trabajo"),rs.getString("religion"));
            res.setCodigoPe(rs.getInt("codPe")+"");
           
        } catch (Exception e) {
            System.out.println("Error al crear Perfil "+e.getMessage());
        }
        return res;
    }
    /**
     * Este metodo complementara la informacion necesario para el Perfil 
     * cargando todas las publicacions y contactos.
     * @param perfil 
     */
    private void complementarPerfil(Perfil perfil) {
        
        
        ArrayList<Publicacion> pbs = perfil.getMuro().getPubs();
        ArrayList<Contacto> amigos = new ArrayList<Contacto>();
        ArrayList<Comentario> cmtrs = new ArrayList<Comentario>();
        
        /*
         * Primero cargaremos todas las publicacions junto a sus comentarios.
         */
        try {
            
            ResultSet rs = stat.executeQuery(" SELECT * "
                                           + " FROM Publicacion "
                                           + " WHERE codPe = "+perfil.getCodigoPe());

            while (rs.next()){
                
                Publicacion p = new Publicacion(rs.getString("autor"),rs.getString("fecha"),
                                rs.getString("detalle"),rs.getInt("codU")+"",rs.getInt("codPe")+"");
                p.setCodPub(rs.getInt("codPu")+"");
                //String autor, String fecha, String detalle, String codU, String codPer
                
                /**
                ResultSet rs2 = stat.executeQuery(" SELECT * "
                                                + " FROM Comentario "
                                                + " WHERE codPu = "+p.getCodPub());
                
                // aca complementamos todos los comentarios de cada publicaion.

                cmtrs = new ArrayList<Comentario>();
                while(rs2.next()){
                    //String codU, String codPub, String autor, String fecha, String detalle
                    Comentario come = new Comentario(rs2.getInt("codU")+"", rs2.getInt("codPu")+"", rs2.getString("autor"), 
                                                     rs2.getString("fecha"), rs2.getString("detalle"));
                    come.setCodCom(rs2.getInt("codC")+"");
                    cmtrs.add(come);
                    p.setComentarios(cmtrs);
                }
                */
                pbs.add(p);
            }
            
            
        } catch (Exception e) {
            System.out.println("Error al cargar Publicaciones: \n"+e.getMessage());
        }
        
        /*
         * Ahora cargaremos los contactos.
         */
        try {
            ResultSet rs3 = stat.executeQuery(" SELECT * "
                                            + " FROM Contacto "
                                            + " WHERE codPe = "+perfil.getCodigoPe());
            
            while (rs3.next()){
                //(String email, String nik, String nombre, String icono,,String avatar,String codPe)
                Contacto c = new Contacto(rs3.getString("email"),rs3.getString("nik"),rs3.getString("nombre"),rs3.getInt("codPe")+"");
                c.setCodContacto(rs3.getInt("cod")+"");
                amigos.add(c);
            }
        } catch (Exception ex) {
            System.out.println("Error al cargar Contactos: "+ex.getMessage());
        }
        perfil.setContactos(amigos);
    }

    private void modificar(){
        String icono;
        for (int i = 489; i < 587; i++) {
            int nro = new java.util.Random().nextInt(8)+1;
            String aux = nro > 9 ? "0" : "00";
            icono = "iconos\\"+aux+nro+".jpg";
            try {
            stat.executeUpdate(" UPDATE Perfil "
                             + " SET urlIcono = '"+icono+"'"
                             + " WHERE codPe = "+i);
            } catch (SQLException ex) {
             Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void llenarBD() {
        GeneradorDB gen = new GeneradorDB();
        for (int i = 0; i < 100; i++) {
            Usuario p = (Usuario)gen.getPerson(); 
            try {
                ResultSet rs = stat.executeQuery("SELECT *"
                                 + "FROM Usuario "
                                 + "WHERE email = "+"'"+p.getEmail()+"'");
            
                if(!(rs.next())){
                    agregarEntrada(p.getNom(),p.getApe(),p.getNik(),p.getPassword(),p.getPais(),p.getCiudad(),p.getEmail(),p.getFono(),p.getSexo());
                    System.out.println("Se agrego correctamente");
                }
            } catch (Exception e) {
                System.out.println("Error..");
            }
        }
    }
    public void actualizarPerfil(Perfil p){
        try {
            stat.executeUpdate(" UPDATE Perfil "
                             + " SET urlIcono = "+"'"+p.getIcono()+"',"
                             + " urlAvatar = "+"'"+p.getAvatar()+"',"
                             + " urlPortada = "+"'"+p.getPortada()+"',"
                             + " estado = "+"'"+p.getEstado()+"',"
                             + " colegio = "+"'"+p.getColegio()+"',"
                             + " trabajo = "+"'"+p.getTrabajo()+"',"
                             + " religion = "+"'"+p.getReligion()+"',"
                             + " universidad = "+"'"+p.getUniversidad()+"'"
                             + " WHERE codPe = "+p.getCodigoPe());
            System.out.println("Se actualizo los datos del Perfil correctamente.");
        } catch (Exception e) {
            System.out.println("Error al actualizar Perfil: "+e);
        }
    }
    /**
     * 
     * @param codPerfil es el Perfil al que se va almacenar el nuevo contacto
     * @param email es el nuevo contacto al que queremos agregar
     */ 
    public Contacto agregarContacto(String codPerfil , String email) {
        Contacto res = null;
        /*
         * primero creamos un nuevo contacto para depues almacernalo en la BD
         */
        try {
            
            ResultSet rs = stat.executeQuery(" SELECT nik,nomU,apeU "
                                           + " FROM Usuario u , Perfil p "
                                           + " WHERE u.codU = p.codU AND "
                                           + " email = "+"'"+email+"'");
            rs.next();
            
            Contacto conta = new Contacto(email,rs.getString("nik"),rs.getString("nomU")+" "+rs.getString("apeU"), codPerfil);
            stat.executeUpdate(" INSERT INTO Contacto (email,codPe,nik,nombre) "
                             + " VALUES ('"+email+"',"+codPerfil+",'"+conta.getNik() +"','"+conta.getNombre()+"')");
                             //+ " WHERE email NOT IN ( SELECT email FROM Contacto WHERE codPe = "+codPerfil+")");
            
            
            res = conta;
            
            System.out.println("Contacto agregado correctamente..");
        } catch (Exception e) {
            System.out.println("No se encontro el email, o es un usuario ya agregado \n"+e.getMessage());
        }
        return res;
    }
    
    public void agregarPublicacion(Publicacion p){
        try {
            stat.executeUpdate(" INSERT INTO Publicacion (detalle,fecha,codU,codPe,autor) "
                             + " VALUES ('"+p.getDetalle()+"','"+p.getFecha()+"','"+p.getCodU()+"','"
                             +p.getCodPer()+"','"+p.getAutor()+"')");
            System.out.println("Se agrego correctamente tu publicacion..");
        } catch (SQLException ex) {
            System.out.println("Error al agregar publicacion: "+ex);
        }
    }
    public void agregarComentario(Comentario c){
        try {
            stat.executeUpdate(" INSERT INTO Comentario (detalle,fecha,codU,codPu,autor)"
                             + " VALUES ('"+ c.getDetalle() +"','"+ c.getFecha()+ "','"+ c.getCodU() +"','"
                             + c.getCodPub() +"','"+ c.getAutor() +"')");
        } catch (SQLException ex) {
            System.out.println("Error al ingresar comentario: "+ex);
        }
    }
    public void agregarPerfil(Perfil p){
        try {
            stat.executeUpdate("INSERT INTO Perfil "
                             + "VALUES('"+ p.getCodigoPe() +"','"+ p.getPortada()+ "','"+ 
                                     p.getAvatar() +"','"
                             + p.getIcono() +"','"+ p.getCodU() +"','"+ p.getEstado() +"','"+ 
                                    p.getUniversidad() +"','"      
                             + p.getColegio()+ "','"+ p.getTrabajo()+"','"+ p.getReligion()+"')");
        } catch (SQLException ex) {
            System.out.println("Error al ingresar comentario...\n"+ex);
        }
    }
    
    public String getIconoPublicacion(String codigoUsuario){
        String res = "";
        try {
            ResultSet rs = stat.executeQuery(" SELECT urlIcono "
                                           + " FROM Usuario u, Perfil p "
                                           + " WHERE u.codU = p.codU AND u.codU = "+codigoUsuario);
            rs.next();
            res = rs.getString("urlIcono");
        } catch (Exception e) {
            System.out.println("Error al buscar Icono (Publicacion): "+e);
        }
        return res;
    }
    public String getIconoContacto(String email){
        String res = null;
        try {
            ResultSet rs = stat.executeQuery(" SELECT urlIcono "
                                           + " FROM Usuario u, Perfil p "
                                           + " WHERE u.codU = p.codU AND email = '"+email+"'");
            rs.next();
            res = rs.getString("urlIcono");
        } catch (Exception e) {
            System.out.println("Error al buscar Icono (Contacto): "+e);
        }
        return res;
    }
    

            
    public ImageIcon getIconoUsuario(String email){
        ImageIcon res = null;
        try {
            ResultSet rs = stat.executeQuery(" SELECT urlIcono "
                                           + " FROM Usuario u, Perfil p "
                                           + " WHERE u.codU = p.codU AND email = '"+email+"'");
            rs.next();
            URL imgURL = getClass().getResource("/img/"+rs.getString(1));
            res = new ImageIcon(imgURL);
            
        } catch (Exception e) {
            System.out.println("Error al buscar Icono (Usuario): "+e);
        }
        return res;
    }
    
    
    public String getAvatar(String email){
        String res = null;
        try {
            ResultSet rs = stat.executeQuery(" SELECT urlAvatar "
                                           + " FROM Usuario u, Perfil p "
                                           + " WHERE u.codU = p.codU AND email = '"+email+"'");
            rs.next();
            res = rs.getString("urlAvatar");
        } catch (Exception e) {
            System.out.println("Error al buscar avatar: "+e);
        }
        return res; 
    }
    public String getCodigoUsuario(String email) {
        String codU = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT codU FROM Usuario WHERE email = '"+email+"'");
            rs.next();
            codU = rs.getString("codU");
        } catch (Exception e) {
            System.out.println("Error en: getDodigoUsuario "+e.getMessage());
        }
        return codU;
    }
    public void borrarContacto(String codPerfil,String email){
        try {
            stat.executeUpdate(" DELETE "
                             + " FROM Contacto "
                             + " WHERE codPe = "+codPerfil+" AND "
                             + " email = '"+email+"'");
            System.out.println("Se elimino correctamente al contacto: "+email);
        } catch (Exception e) {
            System.out.println("No se pudo eliminar contacto: "+e.getMessage());
        }
    }
    public ArrayList<Contacto> getSugerencias(String codPerfil,String email){
        ArrayList<Contacto> res = new ArrayList<Contacto>();
        ResultSet rs = consultaPersonalizada (" SELECT email,nik,nomU,apeU "
                                            + " FROM Usuario "
                                            + " WHERE email <> '"+email+"' AND "
                                            + " email NOT IN ( SELECT email FROM Contacto WHERE codPe = "+codPerfil+" )");
        try {
            while(rs.next()){
                res.add(new Contacto(rs.getString(1),rs.getString(2),rs.getString(3)+" "+rs.getString(4)));
            }
        } catch (Exception e) {
            System.out.print("Error al cargar sugerencias: "+e);
        }
        while (res.size()>10) {            
            res.remove(new java.util.Random().nextInt(res.size()-1));
        }
        return res;
    }
    public ArrayList<Solicitud> getSolicitudes(String codPerfil){
        ArrayList<Solicitud> res = new ArrayList<Solicitud>(); 
        ResultSet rs = consultaPersonalizada(" SELECT * FROM Solicitud WHERE codPe = "+codPerfil);
        try {
            while(rs.next()){
                res.add(new Solicitud(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return res;
    }
    public void eliminarContactoMutuamente(String codPer,String emailContacto,String email){
        eliminarContacto(codPer, emailContacto);
        String codPerfilContacto = getCodigoPerfil(emailContacto);
        eliminarContacto(codPerfilContacto, email);
    }
    /**
     * 
     * @param codigoPe: es al perfil que pertenece
     * @param email :  es su email
     */
    public void eliminarContacto(String codigoPe, String email) {
        try {
            stat.executeUpdate(" DELETE FROM Contacto "
                             + " WHERE codPE = "+codigoPe+" AND "
                             + " email = '"+email+"'");
            System.out.println("Se elimino correctamente al contacto: "+email);
        } catch (Exception e) {
            System.out.println("Error al eliminar contacto: "+e);
        }
    }
    /**
     * 
     * @param miembro es el usuario que deseamos agregar.
     * @param codigoPe es el codigo de nuestro perfil 
     */
    public void agregarSolicitud(Usuario miembro, String email) {
        
        if(!miembro.getEmail().equals(email)){
            String codPerfil = getCodigoPerfil(email);
            try {
                stat.executeUpdate(" INSERT INTO Solicitud (codPe,emailSo,codPeSo,nombre,nik) "
                             + " VALUES ('"+codPerfil+"','"+miembro.getEmail()+"','"+miembro.getPerfil().getCodigoPe()+"','"+
                                    miembro.getNom()+" "+miembro.getApe()+"','"+miembro.getNik()+"') ");
                System.out.println("Se agrego correctamente la solicitud de amistad");
            } catch (Exception e) {
                System.out.println("Error al agregar solicitud: "+e);
            }
        }else
            System.out.println("No se puede agregar el mismo usuario.");
    }

    private String getCodigoPerfil(String email) {
        String res = null;
        String codU = getCodigoUsuario(email);
        ResultSet rs = consultaPersonalizada(" SELECT codPe FROM Perfil WHERE codU = "+codU);
        try {
            rs.next();
            res = rs.getString(1);
        } catch (Exception e) {
            System.out.println("Error al al obtener codigo perfil "+e);
        }
        return res;
    }

    public void removerSolicitud(String codSolicitud) {
        try {
            stat.executeUpdate("DELETE FROM Solicitud WHERE codSo = "+codSolicitud);
            System.out.println("Se elimino la solicitud");
        } catch (Exception e) {
            System.out.println("Error al remover solicitud: "+e);
        }
    }
    
    
}

