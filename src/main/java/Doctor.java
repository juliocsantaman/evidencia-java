
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Julio Cesar Santaman Cruz.
 */
public class Doctor {
    // Atributos.
    private String nombre;
    private String especialidad;
    private Connection conexion;
    
    // Métodos.
    // Método que da de alta a un doctor con su nombre y especialidad.
    public void darAltaDoctor(String nombre, String especialidad) {
        try {
            // Establecer conexión.
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:db/administracion_citas.db");
            
            if(conexion != null) {
                System.out.println("Conectado.");
            }
            
            // Crear enunciado.
            Statement enunciado;
            enunciado = conexion.createStatement();
            
            // Insertar datos.
            enunciado.execute("INSERT INTO Doctores (nombre, especialidad) VALUES('"+nombre+"','"+especialidad+"');'");
            
            System.out.println("Se ha registrado un doctor correctamente.");
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
