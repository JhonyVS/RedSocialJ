package modelo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.util.Random; 

/**
 *
 * @author Usuario
 */
public class GeneradorDB {
        //nombres masculinos
    private final String[] nombresM = {"Jose","Juan","Alfredo","Gustavo","Ramiro","Edson","Frabricio",
                             "Ricardo","Rafacel","Leonardo","Samuel","Alejandro","Mariano",   
                             "Vladimir","Cecilio","Paul","Carlos","Eduardo","Gabriel","Elio"};
        //nombres femeninos
    private final String[] nombresF = {"Carolina","Juana","Adriana","Gaby","Emilie","Carla","Fabiola",
                             "Estela","Raquel","Liliana","Samanta","Alejandra","Maria",   
                             "Viviana","Cecilia","Paola","Camila","Carmen","Eliana","Daniela"};
        
    private final String[] apellidos = {"Carbajal","Perez","Aldunate","Garcia","Fernandez","Pinto","Sanchez",
                             "Estrada","Ramires","Dusan","Choque","Paz","Maldonado","Toro","Arze",   
                             "Bilvao","Carter","Vargas","Cacerez","Molina","Ticona","Flores","Garcia",
                             "Quispe","Palma","Villaroel","Calvo","Costas","Miranda","Almanza","Cruz"};
    private final String[] cargos = {"Aseo","Seguridad","Operador","Recepcionista","Docente","Tecnico","Asistente",
                                    "Ejecutivo Ventas","Ejecutivo Marketing","Gerente","Vicepresidente","Presidente"};
    private final String[] ciudades = {"Cochabamba","Chuquisaca","Tarija","Beni","Pando","Santa Cruz","Oruro","La Paz","Potosi"};
    
    private final String[] carreras = {"Sistemas","Informatica","Electronica","Civil","Industrial","Quimica","Fisica"};
    private final String[] materiasInfo = {"Arquitectura","Programacion","Robotica","Redes","Elementos","Base de datos"};
    private final String[] materias = {"Estadistica","Eleectrotecnia","Logica","Algebra","Fisica","Calculo"};
    private final String[] nivel = {"A","B","D","E","F","G","H","I","J","K"};
    private final String[] nik = {"Jhon","Joel","Viz","Dan","Luna","Fire","Cat","Luk","Lee","Tom","Jack","Tron","Storm","Blue","Roses"};
    
    
    
        
    private Random azar;
        
    public GeneradorDB(){
        azar = new Random();
    }
    public Object getPerson(){
        Usuario u;
        String sexo = azar.nextBoolean() ? "Hombre" : "Mujer";
        //nro determina el cargo de la persona con relacion al sueldo
        int nro = azar.nextInt(cargos.length/2)+azar.nextInt(cargos.length/2);
        String nik = getNik();
        String ciudad = getCiudad();
        //(String nom, String ape, String nik, String password, String email, String pais, String ciudad, int fono, String sexo)
        u = new Usuario(getName(sexo),getApellido(),nik,nik,nik+"_"+azar.nextInt(999)+"@yahoo.com","Bolivia",ciudad,getFono(ciudad),sexo);
        return u;
    }
    private String getName(String sexo) {
        String[] array = sexo.equals("Hombre") ? nombresM : nombresF;
        return array[azar.nextInt(nombresM.length)];  
    }
    private String getApellido(){
        return apellidos[azar.nextInt(apellidos.length)]+" "+apellidos[azar.nextInt(apellidos.length)];
    }
    private int getFono(String c){
        int nro = 4;
        if(c.equals("La Paz")|| c.equals("Oruro")|| c.equals("Potosi")) {
            nro = 2;
        }
        else if(c.equals("Santa Cruz")|| c.equals("Beni")|| c.equals("Pando")) {
            nro = 3;
        }
        return nro*1000000+azar.nextInt(699999);
    }
    private String getCargo(int nro){
        return cargos[nro];
    }
    private int getSueldo(int nro){
        return 150*nro+1200;
    }
    private String getCiudad(){
        return ciudades[azar.nextInt(ciudades.length)];
    }
    private String getNik(){
        return nik[azar.nextInt(nik.length)];
    }
}
